/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2015-03-05T14:23:01Z
 * LicenseName: AGPL-3.0+
 * FileCopyrightText: <text> Copyright (c) 2015 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package experiment;

import definitions.is;
import exchange.ExchangeClient;
import exchange.ExchangePackage;
import java.io.File;
import main.script.log;
import output.formats.HTML.OutputToHTML;
import spdxlib.ChecksumFile;
import spdxlib.DocumentCreate;
import spdxlib.FileInfo;
import spdxlib.FileOrigin;
import spdxlib.RefactorSPDX;
import spdxlib.SPDXfile;
import tokenizator.SourceCodeFile;

/**
 *
 * @author Nuno Brito, 5th of March 2015 in Darmstadt, Germany
 */
public class TestRemoteScan {
    
    private final File 
            folderSource,
            folderOutput,
            fileSPDX,
            fileFinalSPDX,
            fileCachedExchange;
    
    private SPDXfile spdx = null;
    private ExchangePackage exchangeOutput = null;
    
    public TestRemoteScan(final File folder){
        folderSource = folder;
        // prepare the new folder where we store the results
        folderOutput = new File("sandbox", "test-analysis-cached");
        createOutputFolder();
        // define the files
        fileSPDX = new File(folderOutput, "output.spdx");
        fileFinalSPDX = new File(folderOutput, "output-final.spdx");
        fileCachedExchange = new File(folderOutput, "exchange.bin");
    }
    
    /**
     * Create the folder where we keep the work files
     */
    private void createOutputFolder() {
        // delete the previous files
        //utils.files.deleteDir(folderOutput);
        // now create the empty folder
        if(folderOutput.exists() == false){
            utils.files.mkdirs(folderOutput);
        }
    }

    /**
     * Create an SPDX, run the analysis
     * @throws Exception 
     */
    public void start() throws Exception{
        // first step, create an SPDX
        createSPDX();
        // prepare the exchange package with the analysis results
        createExchangePackage();
        // time to merge the results
        mergeResults();
        // changes added, write them do disk
        writeNewSPDX();
        // create the pretty HTML reports
        createReportHTML();
    }

    /**
     * Creates an SPDX document that we will use as example
     */
    private void createSPDX() {
        log.write(is.INFO, "Creating SPDX document at %1", fileSPDX.getAbsolutePath());
        DocumentCreate createSPDX = new DocumentCreate();
        createSPDX.create(folderSource, fileSPDX);
        // get the object so that we can merge matches
        spdx = new SPDXfile(fileSPDX);
        log.write(is.COMPLETED, "Finished writing SPDX document");
    }

    /**
     * Launches the new analysis (this is a time consuming process)
     * @throws Exception 
     */
    private void launchAnalysis() throws Exception {
        // connect to our remote (or local) analysis server
        ExchangeClient client = new ExchangeClient("localhost", 2048);    
        RunningAnalysis analysis = new RunningAnalysis();
        analysis.setExchangeClient(client);
        analysis.setSourceFolder(folderSource);
        
        // run the program, adding a folderSource
        ExchangePackage packageToAnalyse = new ExchangePackage();
        packageToAnalyse.setTitle(folderSource.getName());
        packageToAnalyse.addFolder(folderSource);
        final String textOutput = packageToAnalyse.objectToString();
       
        // step 4: send the text file
        boolean launch = client.startAnalysis(textOutput);
        
        if(launch == false){
            log.write(is.ERROR, "Launch was not started");
            return;
        }
        
        // wait for the analysis to complete
        while(client.shouldWaitForResults()){
            utils.time.wait(5);
            System.out.println(utils.time.getDateTimeISO() + " Analysis in progress..");
        }
        
        exchangeOutput = client.getOutput();
        log.write(is.COMPLETED, "Analysis concluded!");
        
        // save this object for future cache speedup
        final String text = exchangeOutput.objectToString();
        utils.files.SaveStringToFile(fileCachedExchange, text);
    }

    /**
     * Either reads a cached package from disk or starts a new analysis
     * @throws Exception 
     */
    private void createExchangePackage() throws Exception {
        // if no cache exists, launch a new remote analysis
        if(fileCachedExchange.exists()== false){
            launchAnalysis();
        }else{
            // otherwise use what we already have
            final String readFile = utils.files.readAsString(fileCachedExchange);
            exchangeOutput = ExchangePackage.stringToObject(readFile);
            // when something went wrong, do the analysis all over again
            if(exchangeOutput == null){
                launchAnalysis();
            }
        }
    }

    /**
     * Takes the results from a license analysis into an SPDX document. This is
     * still experimental, so: "dragons beware".
     */
    private void mergeResults() {
        System.out.println("Merging binary matches with SPDX");
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
     * Writes a new SPDX document to disk after adding the results from the 
     * comparison analysis
     */
    private void writeNewSPDX() {
        System.out.println("Writing the new SPDX with merged results");
        RefactorSPDX refactor = new RefactorSPDX(spdx);
        refactor.output(fileFinalSPDX);
    }

    /**
     * Creates the HTML output that will contain the result for this analysis
     */
    private void createReportHTML() {
        System.out.println("Creating HTML report at " + folderOutput.getAbsolutePath());
        OutputToHTML outputHTML = new OutputToHTML(exchangeOutput, folderOutput, spdx);
        outputHTML.setBaseFolder(folderSource);
        outputHTML.create();
    }    
    
    public static void main(String[] args) throws Exception{
        File folder = new File("sandbox", "test-samples");
        // launch the scanning operation
        TestRemoteScan scan = new TestRemoteScan(folder);
        scan.start();
    }

    
}
