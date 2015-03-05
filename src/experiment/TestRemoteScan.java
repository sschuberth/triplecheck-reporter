/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2015-03-05T14:23:01Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileCopyrightText: <text> Copyright (c) 2015 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package experiment;

import definitions.is;
import exchange.ExchangeClient;
import exchange.ExchangePackage;
import java.io.File;
import main.script.log;
import spdxlib.DocumentCreate;
import spdxlib.SPDXfile;

/**
 *
 * @author Nuno Brito, 5th of March 2015 in Darmstadt, Germany
 */
public class TestRemoteScan {
    
    private final File 
            folderSource,
            folderOutput,
            fileSPDX,
            fileCachedExchange;
    
    private SPDXfile spdx = null;
    private ExchangePackage exchangeOutput = null;
    
    public TestRemoteScan(final File folder){
        this.folderSource = folder;
        // prepare the new folder where we store the results
        folderOutput = new File("test-analysis");
        createOutputFolder();
        // define the files
        fileSPDX = new File(folderOutput, "output.spdx");
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
    }
    
    public static void main(String[] args) throws Exception{
        File folder = new File("samples", "files_java");
        // launch the scanning operation
        TestRemoteScan scan = new TestRemoteScan(folder);
        scan.start();
    }

    /**
     * Creates an SPDX document that we will use as example
     */
    private void createSPDX() {
        log.write(is.INFO, "Creating SPDX document at %1", fileSPDX.getAbsolutePath());
        DocumentCreate createSPDX = new DocumentCreate();
        createSPDX.create(folderSource, fileSPDX);
        // get the object so that we can merge matches
        spdx = createSPDX.getSpdx();
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
            log.write(is.CONFLICT, "Launch was not started");
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

    private void createExchangePackage() throws Exception {
        // if no cache exists, launch it
        if(fileCachedExchange.exists()== false){
            launchAnalysis();
        }else{
            final String readFile = utils.files.readAsString(fileCachedExchange);
             exchangeOutput = ExchangePackage.stringToObject(readFile);
             // when something went wrong, do the analysis all over again
             if(exchangeOutput == null){
                 launchAnalysis();
             }
        }
    }

    
}
