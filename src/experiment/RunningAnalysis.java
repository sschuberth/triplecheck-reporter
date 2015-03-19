/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2015-03-03T16:03:00Z
 * LicenseName: AGPL-3.0+
 * FileCopyrightText: <text> Copyright (c) 2015 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Encapsulate a running analysis with a remote server </text> 
 */

package experiment;

import definitions.is;
import exchange.ExchangeClient;
import exchange.ExchangePackage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.script.log;
import spdxlib.ChecksumFile;
import spdxlib.FileInfo;
import spdxlib.FileOrigin;
import spdxlib.SPDXfile;
import tokenizator.SourceCodeFile;

/**
 *
 * @author Nuno Brito, 3rd of March 2015 in Darmstadt, Germany
 */
public class RunningAnalysis {

    private ExchangeClient client = null;
    private File folder = null;
    private ExchangePackage 
                packageToAnalyse = null,
                exchangeOutput = null;
    private String 
            message = "",
            title = "Analysis";
    
    private final SPDXfile spdx;
    
    private boolean analysisReady = false;
    
    public RunningAnalysis(SPDXfile associatedSPDX) {
        message = "Starting a new analysis, please wait..";
        spdx = associatedSPDX;
    }

    public void setExchangeClient(ExchangeClient client) {
        this.client = client;
    }

    public void setSourceFolder(File folder) {
        this.folder = folder;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Launches a thread that will prepare and dispatch the analysis
     */
    public void launch(){
        // launch a thread to launch the processing
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    launchInternally();
                } catch (Exception ex) {
                    Logger.getLogger(RunningAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }
    
    private void launchInternally() throws Exception{
        // run the program, adding a folder
        packageToAnalyse = new ExchangePackage();
        packageToAnalyse.setTitle(title);
        packageToAnalyse.addFolder(folder);
        final String textOutput = packageToAnalyse.objectToString();
       
        // step 4: send the text file
        client.startAnalysis(textOutput);
        
        // is the server processing data?
        final boolean processing = client.shouldWaitForResults();
        // do the verification
        if(processing == false){
            message = "Error AS115: Unable to dispatch our request";
            log.write(is.ERROR, message);
        }else{
            message = "Remote server processing: " + client.shouldWaitForResults();
            log.write(is.INFO, message);
        }
    }

    public String getMessage() {
        // we need to be connected
        if(client.isConnected() == false){
            message = "I'm not connected to the server any longer, please fix";
            return message;
        }
        // all done
        return message;
    }

    /**
     * Last steps to perform when the analysis was performed
     */
    private void concludeAnalysis(){
        // the analysis is over, we can retrieve the result
        exchangeOutput = client.getOutput();
        message = "Analysis concluded!";
        log.write(is.INFO, message);
        analysisReady = true;
    }

    /**
     * The timed check to see if we are ready or not
     * @return 
     */
    public boolean isReady() {
        // should we keep waiting
        if(client.shouldWaitForResults()){
            message = "Analysing, please wait..";
        }else{
            // no more waiting, we have fresh results ready!
            concludeAnalysis();
        }
        // all done
        return analysisReady;
    }

    /**
     * After the analysis was signalled as ready, call this method to get
     * the results.
     * @return 
     */
    public ExchangePackage getOutput() {
        return exchangeOutput;
    }

    /**
     * We had enough processing, let's stop
     */
    public void askToStop() {
        client.askToStop();
    }
    
    /**
     * Takes the results from a license analysis into an SPDX document. This is
     * still experimental, so: "dragons beware".
     * 
     * Changes made on the SPDX are only available in memory. It later needs
     * to be written back on disk.
     */
    public void mergeResults() {
        log.write(is.INFO, "Merging binary matches with SPDX");
        // see what is new on the analysis
        for(ChecksumFile checksumFile : exchangeOutput.getBinaryFiles()){
            // did we got any matches? If no, continue to the next file
            if(checksumFile.getMatches().isEmpty()){
                continue;
            }
            // good, we have a match
            addBinaryMatch(checksumFile, spdx);
        }
        
        System.out.println("Merging code matches with SPDX");
        // iterate the source code files
        for(SourceCodeFile sourceCodeFile : exchangeOutput.getSourceCodeFiles()){
            if(sourceCodeFile.getNumberOfSnippetsMatched() == 0){
                continue;
            }
            // add this code match
            addCodeMatch(sourceCodeFile, spdx);
        }
    }
    
    /**
     * One of the files inside the SPDX document was identified as non-original.
     * This doesn't necessarily mean that *this* file is NOT the original one, 
     * it means that several copies were found around the Internet and that
     * this kind of fact should be brought up to attention somewhere.
     * @param checksumFile
     * @param spdx 
     */
    private void addBinaryMatch(ChecksumFile checksumFile, SPDXfile spdx) {
        // iterate each file on the SPDX, find the applicable matches
        for(FileInfo fileInfo : spdx.getFiles()){
            // we only care for files that share the same SHA1 checksum
            if(fileInfo.getTagFileChecksumSHA1().contains(checksumFile.SHA1)==false){
                continue;
            }
            // add the information about this match
            fileInfo.addMatchBinaries(checksumFile.getMatches());
            // at this point we can assume the file is NOT original
            // if YOU are indeed the original author, this needs manual adjust
            fileInfo.setFileOrigin(FileOrigin.EXTERNAL);
        }
    }

    /**
     * Adds a snippet match to a source code file on our SPDX report
     * @param sourceCodeFile
     * @param spdx 
     */
    private void addCodeMatch(SourceCodeFile sourceCodeFile, SPDXfile spdx) {
        // iterate each file on the SPDX, find the applicable matches
        for(FileInfo fileInfo : spdx.getFiles()){
            // we only care for files that share the same SHA1 checksum
            if(fileInfo.getTagFileChecksumSHA1()
                    .contains(sourceCodeFile.getIdentifierHash())==false){
                continue;
            }
            // ignore auto-generated files, they don't hold copyright typically
            // because a machine generates them and exist too many copies.
            // exceptions are bound to exist, this works best if a human verified
            // the auto-generated status manually, before the code originality
            // analysis took place.
            if(fileInfo.getFileOrigin() == FileOrigin.AUTOGENERATED){
                continue;
            }
            
            // add the information about this match
            fileInfo.addMatchSnippets(sourceCodeFile.getSnippetsMatched());
            // assume that these snippets were not original
            // we assume MODIFIED as applicable origin. This is not perfect
            // but represents a third-party snippet code that found its way
            // to a file from your project that should be original. A result
            // here doesn't automatically translate to its rightful owner. It
            // just means that somewhere around the world we have found similar
            // code and provide a reference where you can see it.
            // we don't mark the file as EXTERNAL because the binary filter
            // has likely trimmed the majority of results and if the file was
            // not caught by the binary filter then this might file can contain
            // authored code in addition to the external code.
            fileInfo.setFileOrigin(FileOrigin.MODIFIED);
        }
    }

    /**
     * Returns the associated SPDX object that was used for this analysis.
     * @return no excuses, this SPDX object needs to be valid or you should go home
     */
    public SPDXfile getSPDX() {
        return spdx;
    }
}
