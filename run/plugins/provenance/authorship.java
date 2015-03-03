/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-01T23:50:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: authorship.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows details about the authorship of a project </text> 
 */

package provenance;

import GUI.swingUtils;
import definitions.is;
import exchange.ExchangeClient;
import exchange.ExchangePackage;
import experiment.RunningAnalysis;
import java.io.File;
import main.engine;
import main.script.log;
import script.Plugin;
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
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // we only expect to be called from the treeview
       if(request.requestOrigin != RequestOrigin.GUI_tree){
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
         // step 3: start the client, say hello
        ExchangeClient client = new ExchangeClient("localhost", 2048);
        
        // only allow to proceed when we are online
        if(client.isConnected() == false){
            log.write(is.ERROR, "Error AS93: Unable to connect with remote server");
            request.setTemplate("originality_error_online.html");
            request.closeTemplate();
            return;
        }
        
        
        // no previous analysis running, let's then create one
        analysis = new RunningAnalysis();
        analysis.setExchangeClient(client);
        analysis.setSPDX(spdx);
        analysis.setSourceFolder(folder);
        
        analysis.launch();
        
        // place this analysis in memory
        engine.temp.put(id, analysis);
        
        // divert to the status result
        outputAnalysisResult(request);
//        
//        // run the packageToAnalyse program, adding a folder
//        ExchangePackage packageToAnalyse = new ExchangePackage();
//        packageToAnalyse.setTitle(spdx.getId());
//        packageToAnalyse.addFolder(folder);
//        final String output = packageToAnalyse.objectToString();
//       
//        
//        // step 4: send the text file
//        client.startAnalysis(output);
//        
//        // is the server processing data?
//        final boolean processing = client.shouldWaitForResults();
//        // do the verification
//        if(processing == false){
//            log.write(is.ERROR, "Error AS115: Unable to dispatch our request");
//            request.setTemplate("originality_error_online.html");
//            request.closeTemplate();
//            return;
//        }else{
//            System.out.println("Remote server processing: " + client.shouldWaitForResults());
//        }
//       
//        request.setTemplate("originality_progress.html");
//        request.closeTemplate();
        
    }
    
    
    public void status(WebRequest request){
        // break the loop if something 
        if(engine.temp.containsKey(id) == false){
            request.setAnswer("");
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
        
        // show the progress of the analysis
        request.setTemplate("originality_progress.html");
        
        // set the message
        request.changeTemplate("%firstMessage%", analysis.getMessage());
        
        // make changes as we see fit
        request.changeTemplate("%actions%","");
        
        request.closeTemplate();
    }
    
    public void stop(WebRequest request){
        engine.temp.remove(id);
        log.write(is.STOPPED, "Stopped processing the analysis");
        request.setAnswer("Stopped the processing");
    }
    
    
}
