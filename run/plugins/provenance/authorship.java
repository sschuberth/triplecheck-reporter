/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-01T23:50:00Z
 * LicenseName: AGPL-3.0+
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows details about the authorship of a project </text> 
 */

package provenance;

import GUI.swingUtils;
import definitions.is;
import exchange.ExchangeClient;
import originality.RunningAnalysis;
import java.io.File;
import main.engine;
import main.script.log;
import script.Plugin;
import spdxlib.RefactorSPDX;
import spdxlib.SPDXfile;
import spdxlib.swing.TreeNodeSPDX;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darmstadt, Germany
 */
public class authorship extends Plugin{
     
    final String id = "analysis1";
    final String
         idServerLocation = "originality_server_location",
         idServerPort = "originality_server_port";   
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // we only expect to be called from the treeview
       if(request.requestOrigin != RequestOrigin.GUI_tree 
               && request.requestOrigin != RequestOrigin.GUI){
           log.write(is.ERROR, "AS46 error: Unexpected request for main script");
           return;
       }
       
       // get the SPDX node
       TreeNodeSPDX node = (TreeNodeSPDX) swingUtils.getSelectedNode().getParent();
       File spdxFile = (File) node.getUserObject();
       SPDXfile spdx = engine.reports.get(spdxFile);
       // get the summary of authorship out of this spdx object
       String output = spdx.computeAuthorship();

       // load the template from disk
       request.setTemplate("fileAuthorship.html");
       
       // the replacements
       request.changeTemplate("%original%", spdx.getFilesAuthored() + "");
       request.changeTemplate("%3rdparty%", spdx.getFilesExternal() + "");
       request.changeTemplate("%modded3rdparty%", spdx.getFilesModified() + "");
       request.changeTemplate("%automated%", spdx.getFilesAutomated() + "");
       request.changeTemplate("%automixed%", spdx.getFilesAutomixed() + "");
       request.changeTemplate("%unknown%", spdx.getFilesUnknown() + "");
        
       // all done
       request.closeTemplate();
    }

    /**
     * Call for a remote analysis
     * @param request
     * @throws Exception 
     */
    public void start(WebRequest request) throws Exception {
        // define where the analysis take place
        RunningAnalysis analysis;
        
        // do we have an analysis running?
        if(engine.temp.containsKey(id)){
            log.write(is.INFO, "An analysis is already running");
            analysis = (RunningAnalysis) engine.temp.get(id);
            outputAnalysisResult(request);
            return;
        }
        
       // get the SPDX node
        TreeNodeSPDX node = (TreeNodeSPDX) swingUtils.getSelectedNode().getParent();
        File spdxFile = (File) node.getUserObject();
        final SPDXfile spdx = engine.reports.get(spdxFile);
        
        // get the work folder
        File folder = spdx.getSourceFolder();
        // did we got a good answer?
        if(folder == null){
            log.write(is.ERROR, "Error AS82: Need to define a folder with source code files");
            request.setTemplate("originality_error_folder.html");
            request.closeTemplate();
            return;
        }
        
        log.write(is.INFO, "Analysing files on folder: %1", folder.getAbsolutePath());
        
        // read where we want our originality server to be contacted
        final String serverLocation = settings.read(idServerLocation, "localhost");
        final int serverPort = settings.readNumber(idServerPort, 2048);
        log.write(is.INFO, "Contacting originality server at %1:%2", 
                serverLocation, serverPort + "");

        // step 3: start the client, say hello
        ExchangeClient client = new ExchangeClient(serverLocation, serverPort);
        
        // only allow to proceed when we are online
        if(client.isConnected() == false){
            log.write(is.ERROR, "Error AS93: Unable to connect with remote server");
            request.setTemplate("originality_error_online.html");
            request.closeTemplate();
            return;
        }
        
        
        // no previous analysis running, let's then create one
        analysis = new RunningAnalysis(spdx);
        analysis.setExchangeClient(client);
        analysis.setSourceFolder(folder);
        
        // place this analysis in memory
        engine.temp.put(id, analysis);
        
        // launch the remote analysis
        analysis.launch();
        
        // divert to the status result
        //outputAnalysisResult(request);
        // show the progress of theNothing here analysis
        request.setTemplate("originality_progress.html");
        // set the message
        request.changeTemplate("%firstMessage%", analysis.getMessage());
        // make changes as we see fit
        request.changeTemplate("%actions%","");
        request.closeTemplate();
    }
    
    /**
     * Is any analysis taking place?
     * @param request 
     */
    public void status(WebRequest request){
        // break the loop if something 
        if(engine.temp.containsKey(id) == false){
            request.redirect("/provenance/authorship?x=main");
            log.write(is.DEBUG, "Showing the status window");
            return;
        }
        // divert to the status result
        outputAnalysisResult(request);
    }

    /**
     * We already have an analysis running. Let's check how things are going.
     * @param request
     * @param analysis 
     */
    private void outputAnalysisResult(WebRequest request) {
        // get the object being analysed
        RunningAnalysis analysis = (RunningAnalysis) engine.temp.get(id);
        
        // are we finally ready?
        if(analysis != null && analysis.isReady()){
            // merge the results with our SPDX
            mergeResultsWithOurSPDX(analysis);
            // conclude the analysis that was ongoing
            concludeAnalysis(request, analysis);
            return;
        }
        
        if(analysis == null){
            log.write(is.ERROR, "AS160 error: Not expecting a null analysis object");
            return;
        }
        
        // show the progress of the analysis
        request.setTemplate("originality_progress.html");
        // set the message
        request.changeTemplate("%firstMessage%", analysis.getMessage());
        // make changes as we see fit
        request.changeTemplate("%actions%","");
        request.closeTemplate();
    }
    
    /**
     * This method gets called when the analysis was concluded and is time
     * for processing the output.
     * @param request
     * @param analysis 
     */
    private void concludeAnalysis(WebRequest request, RunningAnalysis analysis){
        // ask the processing thread to stop
        if(analysis != null){
            analysis.askToStop();
        }
        
        engine.temp.remove(id);
        log.write(is.INFO, "Removed analysis result from memory");
         // show the progress of the analysis
        request.setTemplate("originality_complete.html");
        // set the message
        request.changeTemplate("%firstMessage%", analysis.getMessage());
        // make changes as we see fit
        request.changeTemplate("%actions%","");
        request.closeTemplate();
        
        analysis = null;
    }
    
    /**
     * Stop the ongoing analysis
     * @param request 
     */
    public void stop(WebRequest request){
        // try to get the running analysis
        RunningAnalysis analysis = (RunningAnalysis) engine.temp.get(id);
        if(analysis != null){
            // see if it can be stopped
            analysis.askToStop();
        }
        engine.temp.remove(id);
        log.write(is.STOPPED, "Stopped processing the analysis");
        request.setAnswer("Stopped the processing");
    }
    
    /**
     * After the analysis was completed, provide the option for the end-user
     * to see an HTML report.
     * @param request 
     */
    public void viewHTML(WebRequest request){
        request.setAnswer("Launching the browser");
    }

    /**
     * With this code we include inside the original SPDX document the results
     * from an originality test.
     * @param analysis 
     */
    private void mergeResultsWithOurSPDX(RunningAnalysis analysis) {
        analysis.mergeResults();
        SPDXfile spdx = analysis.getSPDX();
        // save the SPDX memory object downto an SPDX document file on disk
        RefactorSPDX refactor = new RefactorSPDX(spdx);
        refactor.output(spdx.getFile());
    }
}
