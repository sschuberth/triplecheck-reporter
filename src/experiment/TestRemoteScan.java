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
import output.formats.HTML.OutputSPDXToHTML;
import output.formats.OutputToConsole;
import spdxlib.DocumentCreate;
import spdxlib.RefactorSPDX;
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
    
    private RunningAnalysis analysis = null;
    
    private SPDXfile spdx = null;
    private ExchangePackage exchangeOutput = null;
    
    public TestRemoteScan(final File folder){
        folderSource = folder;
        // prepare the new folder where we store the results
        folderOutput = new File("sandbox", "test-analysis-cached");
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
        loadSPDX();
        // prepare the exchange package with the analysis results
        createExchangePackage();
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
        log.write(is.COMPLETED, "Finished writing SPDX document");
    }

    
    private void loadSPDX(){
        // get the object so that we can merge matches
        spdx = new SPDXfile(fileSPDX);
    }
    
    /**
     * Launches the new analysis (this is a time consuming process)
     * @throws Exception 
     */
    private void launchAnalysis() throws Exception {
        // connect to our remote (or local) analysis server
        ExchangeClient client = new ExchangeClient("localhost", 2048);    
        analysis = new RunningAnalysis(spdx);
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
     * Writes a new SPDX document to disk after adding the results from the 
     * comparison analysis
     */
    private void writeNewSPDX() {
        System.out.println("Writing the new SPDX with merged results");
        // time to merge the results
        analysis.mergeResults();
        // save the SPDX memory object downto an SPDX document file on disk
        RefactorSPDX refactor = new RefactorSPDX(spdx);
        refactor.output(fileSPDX);
    }

    /**
     * Creates the HTML output that will contain the result for this analysis
     */
    private void createReportHTML() {
        System.out.println("Creating HTML report at " + folderOutput.getAbsolutePath());
        OutputSPDXToHTML outputHTML = new OutputSPDXToHTML(folderOutput, spdx);
        outputHTML.doOutput();
        
        // do a console output
        OutputToConsole console = new OutputToConsole(exchangeOutput);
        console.create();
        
        // do the JSON output
//        ConvertSPDXtoJSON json = new ConvertSPDXtoJSON(spdx);
//        String result = json.getMatchesBinary().toString();
//        System.out.println("-----------------");
//        System.out.println(result);
    }    
    
    public static void main(String[] args) throws Exception{
        File folder = new File("samples");
        // launch the scanning operation
        TestRemoteScan scan = new TestRemoteScan(folder);
        scan.start();
    }

    
}
