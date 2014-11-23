/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: pluginCreateSPDX.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This is the class that creates SPDX documents </text> 
 */

package spdx;

import GUI.TreeviewUtils;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import java.io.File;
import main.engine;
import main.param;
import script.Plugin;
import script.log;
import spdxlib.DocumentCreate;
import spdxlib.SPDXfile;
import utils.www.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class create extends Plugin{
    
    final String 
            id = "Create SPDX",
            myFolder = "target",
            batchFolder = "BatchFolderSPDX"
            ;
            
    final String acceptedExtension = 
            ".tar.gz"
            + ">>"
            + "zip",
            templateFolderHTML = "spdxFolder.html",
            templateBatchHTML = "spdxBatch.html",
            templateProgressSPDX = "webpage_spdx_progress.html"
            ;
    
    
    int interval = 3;
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode(id, "box--plus.png", "main");
    }
 
    /**
     * Dialog for creating a new SPDX document from a folder on disk
     * @param request 
     */
    @Override
    public void main(WebRequest request){
        // if we are already creating an SPDX, then jump to the progress page
        if(engine.temp.containsKey(id)){
            foldercreate(request);
            return;
        }
        
        // load our initial template that permits creating an SPDX
        request.setTemplate(templateFolderHTML);
        // get the value used before
        String selectedFolder = settings.read(myFolder, "");
        // if nothign is chosen, just show it as "none"
        if(selectedFolder.isEmpty()){
            selectedFolder = "";
        }
        // add the value of our directory
        request.changeTemplate("none-template", selectedFolder);
        // all done
        request.closeTemplate();
    }

    /**
     * The method that the end-user calls when the "create SPDX" button is
     * pressed on the user interface.
     * @param request 
     */
    public void foldercreate(WebRequest request){
        // create the SPDX pointer
        DocumentCreate newSPDX;
        
        // was it created previously?
        if(engine.temp.containsKey(id)){
            // get the previously created object
            newSPDX = (DocumentCreate) engine.temp.get(id);
        }else{
            // launch the creation of a new one
            newSPDX = launchNewSPDX();
            // put it in memory
            engine.temp.put(id, newSPDX);
        }
        String actions = "";
        
        // has the processing already terminated?
        if(newSPDX.isProcessing() == false){
            // remove this process from memory
            engine.temp.remove(id);
            // load the report
            concludeCreation(request, newSPDX);
            return;
        }
        
        // show the number of files processed so far (in a human readable number)
        String filesProcessed = utils.text.convertToHumanNumbers(newSPDX.getFilesProcessed());        
        
        // load the template
        request.setTemplate(templateProgressSPDX);
        
        request.changeTemplate("%s%", filesProcessed);
        request.changeTemplate("%actions%", actions);
        
        request.closeTemplate();
    }
    
    /**
     * Do the things that are necessary after creating a new SPDX document, such as
     * updating the tree view
     */
    private void concludeCreation(WebRequest request, DocumentCreate newSPDX){
        // read the newly generated document
        SPDXfile spdx = new SPDXfile(newSPDX.getOutputFile());
        // add this on our list of documents available
        engine.reports.add(spdx.file, spdx);
        // make sure it will show on the treeview
        TreeviewUtils.refreshAll(spdx.getUID(), false);
        
        // save these settings to open the source files
        final String title = definitions.id.SOURCEFOLDER 
               + spdx.getFile().getName() + ".spdx";
        engine.settings.write(title, spdx.getFile().getAbsolutePath());
        
        // create the link to open the new document
        String link = "/spdx/show?x=summary&" + param.spdx + "=" 
                + spdx.getRelativePath();
        // add the redirect meta tag on the HTML page
        String output = html.redirect(link, 0, "");
        request.setAnswer(output);
    }
    
    /**
     * Launch the thread that will be creating a new SPDX document
     * @param newSPDX 
     */
    private DocumentCreate launchNewSPDX(){
        final DocumentCreate spdx = new DocumentCreate();
        // launch a thread to create the document
        Thread thread = new Thread(){
            @Override
            public void run(){
                String selectedFolder = settings.read(myFolder);
                File sourceCodeFolder = new File(selectedFolder);
                // start our action
                log.write(is.INFO, "Creating SPDX document: %1", selectedFolder );
                // launch the creation
                spdx.create(sourceCodeFolder);
                // done
                log.write(is.INFO, "SPDX document created: %1", selectedFolder );
           }
       };
        thread.start();
        utils.time.wait(1);
        // all done
        return spdx;
    }

    
   /**
     * Chooses a folder to be used as source for creating a new SPDX
     * @param request 
     */
    public void folder(WebRequest request){
        // no support for requests from the browser
        if(request.requestOrigin == RequestOrigin.BROWSER){
            log.write(is.ERROR, "Support to SPDX creation from folder on disk "
                    + "is not yet implemented");
            request.setAnswer("Not supported from browser");
            return;
        }
        
        // do we want an older location defined?
        String selectedFolder = settings.read(myFolder);

        // do we want to use the default location or do we have an older choice?
        File startFolder = engine.getWorkFolder();
        if(selectedFolder != null){
            startFolder = new File(selectedFolder);
        }
        
        // show the dialog
        File result = swingUtils.chooseFolder(startFolder, myFolder);
        
        // all done, let's go back
        String output = html.redirect("/spdx/create?x=main", 0, 
                       " Returning to previous page..");
        
        request.setAnswer(output);
    }
    
}

