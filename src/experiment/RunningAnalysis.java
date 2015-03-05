/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2015-03-03T16:03:00Z
 * LicenseName: EUPL-1.1-without-appendix
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
import spdxlib.SPDXfile;

/**
 *
 * @author Nuno Brito, 3rd of March 2015 in Darmstadt, Germany
 */
public class RunningAnalysis {

    private ExchangeClient client = null;
    private File folder = null;
    private ExchangePackage 
                packageToAnalyse = null,
                output = null;
    private String 
            message = "",
            title = "Analysis";
    
    private boolean analysisReady = false;
    
    public RunningAnalysis() {
        message = "Starting a new analysis, please wait..";
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
        output = client.getOutput();
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
        return output;
    }

    /**
     * We had enough processing, let's stop
     */
    public void askToStop() {
        client.askToStop();
    }
    
    
    
}
