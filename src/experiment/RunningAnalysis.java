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
    private SPDXfile spdx = null;
    private File folder = null;
    private ExchangePackage packageToAnalyse = null;
    private String message = "";
    
    public RunningAnalysis() {
        message = "Starting a new analysis, please wait..";
    }

    public void setExchangeClient(ExchangeClient client) {
        this.client = client;
    }

    public void setSPDX(SPDXfile spdx) {
        this.spdx = spdx;
    }

    public void setSourceFolder(File folder) {
        this.folder = folder;
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
        // run the packageToAnalyse program, adding a folder
        packageToAnalyse = new ExchangePackage();
        packageToAnalyse.setTitle(spdx.getId());
        packageToAnalyse.addFolder(folder);
        final String output = packageToAnalyse.objectToString();
       
        // step 4: send the text file
        client.startAnalysis(output);
        
        // is the server processing data?
        final boolean processing = client.shouldWaitForResults();
        // do the verification
        if(processing == false){
            message = "Error AS115: Unable to dispatch our request";
            log.write(is.ERROR, message);
            return;
        }else{
            message = "Remote server processing: " + client.shouldWaitForResults();
            log.write(is.INFO, message);
        }
    }

    public String getMessage() {
        return message;
    }

}
