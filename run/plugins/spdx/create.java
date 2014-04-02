/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: pluginCreateSPDX.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This is the class that creates SPDX documents </text> 
 */

package spdx;

import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import main.param;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.rauschig.jarchivelib.CompressionType;
import script.DownloadBigFile;
import script.Plugin;
import script.RunningTask;
import script.log;
import spdxlib.DocumentCreate;
import utils.html;
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
            LastFolderNewSPDX = "LastFolderNewSPDX";
            
    final String acceptedExtension = 
            ".tar.gz"
            + ">>"
            + "zip",
            templateFolderHTML = "spdxFolder.html";
    
    
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
        
        addChildNode("from web", "application-dock-270.png", "mainWeb");
        addChildNode("from folder", "folder-smiley.png", "mainFolder");
        
    }
    
    /**
     * Displays the menu for creating new SPDX documents
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       request.setPage("spdxMain.html");
//        String result = "<html>\n" +
////            "<head>\n" +
////            "<style type=\"text/css\">body {font-family:verdana,arial,"
////                + "sans-serif;font-size:10pt;margin:30px;}</style>"
////                + "</head>\n" +
////            "\n" +
//            "<body>"
//                + ""
//                + "Testing stuff!"
//                + ""
//                + "</body>"
//                + "</html>";
//        request.setAnswer(result);
    }

    
    public void mainWeb(WebRequest request){
       request.setPage("spdxDialog.html");
    }

    
    public void mainZip(WebRequest request){
        //request.setPage("spdxDialog.html");
        String result = "Hello there Zip!";
        request.setAnswer(result);
    }

 
    /**
     * Dialog for creating a new SPDX document from a folder on disk
     * @param request 
     */
    public void mainFolder(WebRequest request){
        
        // load our template
         request.setTemplate(templateFolderHTML);
         
        
        // get the value used before
        String selectedFolder = settings.read(LastFolderNewSPDX, "");
        
        // if nothign is chosen, just show it as "none"
        if(selectedFolder.isEmpty()){
            selectedFolder = "NONE";
        }
        
        // add the value of our directory
        request.changeTemplate("none-template", selectedFolder);
        // all done
        request.closeTemplate();
        
        
    }

    
    
    /**
     * Chooses a folder to be used as source for creating a new SPDX
     * @param request 
     */
    public void foldercreate(WebRequest request){
        // what should we use as source?
        String selectedFolder = settings.read(LastFolderNewSPDX);
        // start our action
        log.write(is.INFO, "Creating an SPDX document using as source: %1", 
               selectedFolder );
        
        // transform the thing into a file pointer
        final File source = new File(selectedFolder);
        
        if(source.exists() == false){
            // we have a problem, exit here
            log.write(is.ERROR, "SPDX create - Source folder doesn't exist: %1",
                    source.getAbsolutePath());
            request.setAnswer("<br>Sorry but the source folder doesn't exist: <br>" 
                    + source.getAbsolutePath());
            return;
        }
        
        final WebRequest what = request;
        
        RunningTask task = new RunningTask(){
            @Override
            public void doTask(){
                setTitle("Creating report");
               

                  // start the SPDX class
        final DocumentCreate newSPDX = new DocumentCreate();
        
         // launch a small thread to keep the progress updated
               Thread thread = new Thread(){
                   @Override
                   public void run(){
                       // wait a little bit for things to start
                       utils.time.wait(4);
                       // keep repearing while things are being processed
                       while(newSPDX.isProcessing){
                            utils.time.wait(4);
                            setStatus("%1 files processed out of %1", 
                                    "" + newSPDX.filesProcessed, 
                                    "" + newSPDX.files.size());
                       }
                   }
               };
               thread.start();
        
        
                
                
               // third step, create the SPDX document from the extracted files
               String result = createDocument(source, this, newSPDX);
               
               // all done here, explain where the SPDX document can be found
               nextStep = 
                         html.link("See report", 
                        "/spdx/show?x=summary&"
                        + param.spdx + "=" + result)
                       + " | " +
                       html.link("Show in text mode", 
                        "/spdx/show?x=full&"
                        + param.spdx + "=" + result)
                       ;
               
             }
        };
        task.launch();
        
        //request.setAnswer("Process launched as " + task.getUID());
        request.setAnswer(utils.html.redirect("/basic/status"
                + "?ID=" + task.getUID(), 0, ""));
        
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
        
        // do we want an older located defined?
        String selectedFolder = settings.read(LastFolderNewSPDX);
        
        
        // show the dialog
        File result = swingUtils.chooseFolder(new File(selectedFolder));
        
        // place the result in our settings
        if(result != null){
            settings.write(LastFolderNewSPDX, result.getAbsolutePath());
            log.write(is.ACCEPTED, "Folder %1 was chosen as source for the SPDX "
                + "document", result.getAbsolutePath());
        }

        // all done, let's go back
        String output = html.redirect("/spdx/create?x=mainFolder", 0, 
                       " Returning to previous page..");
        
        request.setAnswer(output);
        
    }
  
    
    /**
     * The part where we create the SPDX document
     * @param request 
     */
    public void start(WebRequest request){
        
        final WebRequest what = request;
        
        RunningTask task = new RunningTask(){
            @Override
            public void doTask(){
                setTitle("Creating an SPDX document");
                // first step, download our file from the Internet (or wherever)
                File downloadedFile = downloadFile(what, this);
                if(downloadedFile == null){
                    return;
                }
                
                // second step, decompress the downloaded archive
                File extractedFolder = extractFile(downloadedFile, this);
                if(extractedFolder == null){
                   return;
               }

                
              final DocumentCreate newSPDX = new DocumentCreate();

               // third step, create the SPDX document from the extracted files
               String result = createDocument(extractedFolder, this, newSPDX);
               
             }
        };
        task.launch();
        
        
        //request.setAnswer("Process launched as " + task.getUID());
        request.setAnswer(utils.html.redirect("/basic/status"
                + "?ID=" + task.getUID(), 0, ""));
        
    }

    /**
     * Creates the SPDX document from the folder of extracted source code files
     * @param extractedFolder The folder where source code files are located
     * @param task the running task that will hold the status update
     */
    private String createDocument(File extractedFolder, RunningTask task, 
            DocumentCreate newSPDX){
        task.setStatus("Creating the SPDX document");
        
        String result = "";
        
        try{
        // do all the heavy work
        result = newSPDX.create(extractedFolder);
        }catch (Exception e){
            log.write(is.ERROR, "CR01- Exception occurred when creating SPDX");
        }
        // count the time it took to run this task
        long time = System.currentTimeMillis() - task.getUID();
        String timeCount = utils.time.timeNumberToHumanReadable(time) + " were "
                + "necessary to complete this task";
        task.setStatus(timeCount);
        
        // something went wrong, raise a flag
        if(result.isEmpty()){
            task.setStatus("Exception occurred when creating SPDX!");
            task.setPercentageComplete(100);
            return "";                    
        }
        
        // all done
        task.setPercentageComplete(100);
        task.setStatus("All done!");
        
        
        // all done here, explain where the SPDX document can be found
               task.nextStep = 
                         html.link("SPDX summary", 
                        "/spdx/show?x=summary&"
                        + param.spdx + "=" + result)
                       + " | " +
                       html.link("Show full text", 
                        "/spdx/show?x=full&"
                        + param.spdx + "=" + result)
                       ;
               // when all things said and done
               concludeCreation(newSPDX);
        
        return result;
    }
    
     private File extractFile(File downloadedFile, RunningTask task){
         String fileName = downloadedFile.getName().toLowerCase();
         task.setStatus("Extracting files from %1", downloadedFile.getName());
         // create an output folder
         File mainFolder = new File(downloadedFile.getParentFile(), "extracted");
         // create the specific folder for this file
         File destination = new File(mainFolder, fileName);
         utils.files.mkdirs(destination);
         
         // get the name portion
         Archiver archiver = null;
         
         // handle different compressed files
         if(fileName.endsWith(".tar.gz"))
            archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, 
                    CompressionType.GZIP);
        
         if(fileName.endsWith("zip"))
            archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
        
         if(fileName.endsWith("jar"))
            archiver = ArchiverFactory.createArchiver(ArchiveFormat.JAR);
            
        if(archiver == null){
            task.setIsProcessing(false);
            task.setStatus("File %1 is not recognized as something that "
                    + "we can decompress");
            return null;
        }    
            
            
        try {
            // do the extraction of this file
            archiver.extract(downloadedFile, destination);
            archiver = null;
        } catch (IOException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // all done
        task.setStatus("All files from %1 have been extracted", 
                downloadedFile.getName());
        task.setPercentageComplete(20);
        return destination;
     }
    /**
     * Downloads the file in case it hasn't been downloaded in the past
     * @param request 
     */
    private File downloadFile(WebRequest request, RunningTask task){
        // get whatever we are supposed to download
        String sourceURL = request.getParameter("source");
        
        if(sourceURL == null){
            return null;
        }
        
        
        File downloadFolder = new File(core.getWorkFolder(), "downloads");
        // we might need to create this folder
        if(downloadFolder.exists() == false){
            utils.files.mkdirs(downloadFolder);
        }
        
        // now, get the filename portion of this file
        int lastSlash = sourceURL.lastIndexOf("/");
        
        String targetFilename = sourceURL.substring(lastSlash + 1);
        // we need files to have an extension
        if(targetFilename.contains(".")==false){
            // nothing else to do, just leave
            task.setIsProcessing(false);
            task.setStatus("Download file is not valid: %1", sourceURL);
            return null;
        }
        
        // where will this downloaded file be placed?
        File targetFile = new File(downloadFolder, targetFilename);
   
        // get the big file
        task.setStatus("Downloading the file from %1", sourceURL);
        final DownloadBigFile download = new DownloadBigFile(sourceURL, targetFile);
//        Thread thread = new Thread(){
//                @Override
//                public void run(){
                    download.getFile();
//                    }
//                };
//                thread.start();
//        
//        // just wait while things are being downloaded
//        while(download.getIsDownloading()){
//            utils.time.wait(5);
//            String targetSize = utils.files.humanReadableSize(targetFile.length());
//            task.setStatus("Downloading %1, %2 have been downloaded",
//                    targetFilename, targetSize);
//        }
//        
        // get the file size
        String targetSize = utils.files.humanReadableSize(targetFile.length());
        task.setStatus("File was downloaded as \"%1\" with an approximate"
                + " size of %2"
                ,targetFilename, targetSize);
       
        // download part is done, increase to 10% of overall task
        task.setPercentageComplete(10);
        return targetFile;
    }
    
    
/**
 * Do the things that are necessary after creating a new SPDX document, such as
 * updating the tree view
 */
private void concludeCreation(DocumentCreate newSPDX){
    String UID = newSPDX.UID;
    // refresh the tree
    swingUtils.refreshAll(core.studio.getTree(), UID);
}
    
}




//    
//    /**
//     * Opens the choose a folder dialog
//     */
//    public void chooseFolderNewSPDX(){
//        String folderName = core.settings.read(LastFolderNewSPDX, "");
//        File folder = null;
//        if(folderName != null){
//            folder = new File (folderName);
//        }
//        // open the folder choosing dialog
//        File result = swingUtils.chooseFolder(folder);
//        // was some folder selected?
//        if(result == null){
//            return;
//        }
//        // all done, let's write things up and then exit
//        core.settings.write(LastFolderNewSPDX, result.getAbsolutePath());
//        swingUtils.refreshTextBox();
//    }
//    
//    
//    /**
//     * All set and done, let's create a new SPDX document!
//     */
//    public void doCreateSPDX(){
//        final String folderName = core.settings.read(LastFolderNewSPDX, "");
//        // is a folder selected?      
//        if(folderName.length() == 0){
//            swingUtils.showMessage("You need to select a folder to use as source");
//            return;
//        }
//        
//        
//        Thread thread = new Thread(){
//        
//        //@Override
//        public void run(){
//            
//            //  create the new SPDX object
//            final File newDocument = new File(folderName);
//            final DocumentCreate newSPDX = new spdx.DocumentCreate();
//            Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    newSPDX.create(newDocument);
//
//                    }
//                };
//                thread.start();
//                utils.time.wait(1);
//                while(newSPDX.isProcessing){
//                    // write our progress
//                    doProgressScreen(newSPDX);
//                    utils.time.wait(interval);
//                }
//                
//            // all done
//            String UID = newSPDX.UID;
//            // if things have worked, reload all the scripts
//            if(newSPDX.isOk()){
//                //swingUtils.showMessage("Success, your document is found at " 
//                //    + newSPDX.file.getAbsolutePath());
//                swingUtils.refreshAll(core.studio.getTree(), UID);
//                //swingUtils.setSelectedNode(UID);
//            }else{
//                swingUtils.showMessage("Sorry, something went wrong."); 
//            }
//        
//        }
//
//          
//        };
//        thread.start();
//    }
//    
//    /**
//     * Writes a nice HTML screen with output of current progress
//     * @param newSPDX 
//     */
//      private void doProgressScreen(DocumentCreate newSPDX) {
//          
//          String textValue = "";
//          
//          // don't show progress if nothing was done yet
//          if(newSPDX.filesToProcess != 0){
//              
//              int rate = newSPDX.filesProcessed - newSPDX.lastCounter;
//                rate = rate / interval;
//                
//                String textRate = ""
//                        + html.getIcon("stickman-run.png")
//                        + "Running at a speed of " + rate + " files per second";
//                // handle cases of zero
//                if(rate == 0){
//                    textRate = ""
//                            + html.getIcon("stickman-smiley-angry.png")
//                            + "Turbulence. We're stuck on something"
//                            ;
//                }
//                
//                if(rate > 150){
//                    textRate = ""
//                            + html.getIcon("stickman-smiley-love.png")
//                            + " Looking good at over " + rate + " files per second"
//                            ;
//                }
//                
//                
//                
//                // how long?
////              int estimation = 
////                      (newSPDX.filesToProcess - newSPDX.filesProcessed) / rate;  
//                textValue = ""
//                        + html.getIcon("application-monitor.png")
//                    + " Processed "
//                    + newSPDX.filesProcessed
//                    + " out of "
//                    + newSPDX.filesToProcess
//                    + " files"
//                    + html.br
//                    + textRate
////                    + html.br
////                    + html.getIcon("stickman-smiley-question.png")    
////                    + "We estimate this it take some " 
////                        + estimation 
////                        + " seconds"
//                        ;
//                // update the counter
//                newSPDX.lastCounter = newSPDX.filesProcessed;
//          }
//          
//    // Do the message
//            String inProgress = ""
//                    + html.div()
//                    + "<h2>"
//                    + html.getIcon("wand.png")
//                    + "In progress!</h2>"
//                    + ""
//                    + "Your SPDX document will be ready soon, please wait.."
//                    + html.br
//                    + html.br
//                    //+ html.getIcon("stickman-run.png")
//                    + textValue
//                    + html._div;
//            
//            // update the text box
//            core.studio.editorPane(is.contentHTML, false, 0, inProgress);
//            }
//}


  
        //request.setAnswer("All done");
//        // initially, we don't have a folder selected
//        String folderLocation = ""
//                + html.div()
//                + html.linkScript("Choose", thisFile, 
//                    "chooseFolderNewSPDX")
//                + " a folder to use as source"
//                //+ html.getIcon("folder-horizontal-open.png")
//                + html._div
//                ;
//        // if we already have a previously selected folder, choose it here
//        if(core.settings.hasKey(LastFolderNewSPDX)){
//            folderLocation = ""
//                    + folderLocation
//                    + html.div(20)
//                    + " "
//                    + "<i>"
//                    + core.settings.read(LastFolderNewSPDX)
//                    + "</i>"
//                    + html._div
//                    //+ html.br
//                    ;
//        }
//        
//        
//       String description = "This tool allows you to create a new"
//               + " SPDX document that will be available inside your"
//               + " Products folder. The only required setting is"
//               + " the folder where your source code files are"
//               + " located";
//        
//        String result = ""
//                + html.div()
//                + "<h2>"
//                + html.getIcon("wooden-box-label.png")
//                + "Create a new SPDX</h2>"
//                + description
//                + html.br
//                //+ "<b>"
//               // + "Folder to use as source"
//                //+ "</b>"
//                + html.br
//                + folderLocation
//                + html.br
//                + html.br
//                + "Ready? After clicking on the link below you should"
//                + " see available the new SPDX on the product list tree view "
//                + html.br
//                + html.br
//                + html.getIcon("wand.png")
//                + html.linkScript("Create SPDX", thisFile, "doCreateSPDX")
//                + html._div
//                + "";
        
        // all done
//        request.setAnswer(result);