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
import java.io.IOException;
import java.util.ArrayList;
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
import spdxlib.DocumentCreate2;
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
            //LastFolderNewSPDX = "LastFolderNewSPDX",
            myFolder = "target",
            batchFolder = "BatchFolderSPDX"
            ;
            
    final String acceptedExtension = 
            ".tar.gz"
            + ">>"
            + "zip",
            templateFolderHTML = "spdxFolder.html",
            templateBatchHTML = "spdxBatch.html"
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
        
        addChildNode("from web", "application-dock-270.png", "mainWeb");
        addChildNode("from folder", "folder-smiley.png", "mainFolder");
        addChildNode("batch mode", "blue-document-node.png", "mainBatch");
        
    }
    
    /**
     * Displays the menu for creating new SPDX documents
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       request.setPage("spdxMain.html");
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
     * Dialog to create a series of SPDX based on the sub-folders from a
     * selected directory location
     * @param request 
     */
    public void mainBatch(WebRequest request){
        // load our template
         request.setTemplate(templateBatchHTML);
        // get the value used before
        String selectedFolder = settings.read(batchFolder, "");
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
     * Chooses a folder to be used as source for creating a new SPDX
     * @param request 
     */
    public void foldercreate(WebRequest request){
        // what should we use as source?
        String selectedFolder = settings.read(myFolder);
        // start our action
        log.write(is.INFO, "Creating an SPDX document using as source: %1", 
               selectedFolder );
        
        // transform the thing into a file pointer
        File temp = new File(selectedFolder);
        
        // test to see how many files are within the first folder
        File[] list = temp.listFiles();
        // only one? Reduce complications, use that folder as root
        if(list.length == 1){
            temp = list[0];
            System.err.println("CR163 - Using folder as default: " 
                    + temp.getAbsolutePath());
        }
        
        // all done, close it now
        final File source = temp;
        
        if(source.exists() == false){
            // we have a problem, exit here
            log.write(is.ERROR, "SPDX create - Source folder doesn't exist: %1",
                    source.getAbsolutePath());
            request.setAnswer("<br>Sorry but the source folder doesn't exist: <br>" 
                    + source.getAbsolutePath());
            return;
        }
       
        // save the selected folder for the next time
        //settings.write(LastFolderNewSPDX, source.getAbsolutePath());
        
        RunningTask task = new RunningTask(){
            @Override
            public void doTask(){
                setTitle("Creating report");
               

                  // start the SPDX class
        final DocumentCreate2 newSPDX = new DocumentCreate2();
        
         // launch a small thread to keep the progress updated
               Thread thread = new Thread(){
                   @Override
                   public void run(){
                       // wait a little bit for things to start
                       utils.time.wait(3);
                       // keep repearing while things are being processed
                       while(newSPDX.isProcessing()){
                            utils.time.wait(3);
                            setStatus("%1 files processed", 
                                    "" + newSPDX.getFilesProcessed());
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
             //  swingUtils.doRequest(result);
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
    public void batchcreate(WebRequest request){
        // what should we use as source?
        String selectedFolder = settings.read(batchFolder);
        // start our action
        log.write(is.INFO, "Creating a batch of SPDX documents using as source: %1", 
               selectedFolder );
        
        // transform the thing into a file pointer
        final File sourceBatch = new File(selectedFolder);
        
        if(sourceBatch.exists() == false){
            // we have a problem, exit here
            log.write(is.ERROR, "SPDX batch create - Source folder doesn't exist: %1",
                    sourceBatch.getAbsolutePath());
            request.setAnswer("<br>Sorry but the source folder doesn't exist: <br>" 
                    + sourceBatch.getAbsolutePath());
            return;
        }
       
       
            
        // save the selected folder for the next time
        //settings.write(LastFolderNewSPDX, source.getAbsolutePath());
        
        RunningTask task = new RunningTask(){
            @Override
            public void doTask(){
                setTitle("Creating reports");
                // get a list of the folders to index
                ArrayList<File> folderList = utils.files.findFolders(sourceBatch, 2);
                int counter = 0;
                for(File source : folderList){
                    // go through each one
                    counter++;
                    setStatus("Processing %1 (%2)", source.getAbsolutePath(),
                    counter + "/" + folderList.size());
                    DocumentCreate2 newSPDX = new DocumentCreate2();
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
             }
        };
        task.launch();
//                  // start the SPDX class
//            final DocumentCreate newSPDX = new DocumentCreate();
//        
//            // launch a small thread to keep the progress updated
//               Thread thread = new Thread(){
//                   @Override
//                   public void run(){
//                       // wait a little bit for things to start
//                       utils.time.wait(4);
////                       // keep repearing while things are being processed
////                       while(newSPDX.isProcessing){
////                            utils.time.wait(4);
////                            setStatus("%1 files processed out of %2", 
////                                    "" + newSPDX.filesProcessed, 
////                                    "" + newSPDX.files.size());
////                       }
//                   }
//               };
//               thread.start();
//        
//            // third step, create the SPDX document from the extracted files
//               String result = createDocument(source, this, newSPDX);
//               
//               // all done here, explain where the SPDX document can be found
//               nextStep = 
//                         html.link("See report", 
//                        "/spdx/show?x=summary&"
//                        + param.spdx + "=" + result)
//                       + " | " +
//                       html.link("Show in text mode", 
//                        "/spdx/show?x=full&"
//                        + param.spdx + "=" + result)
//                       ;

//        //System.out.println("-> " + folder.getAbsolutePath());
//        }
        
        //request.setAnswer("Process launched as " + task.getUID());
//                + "?ID=" + task.getUID(), 0, ""));
//        request.setAnswer(utils.html.redirect("/basic/status"
//                + "?ID=" + task.getUID(), 0, ""));
        
//    }
//        request.setAnswer(utils.html.redirect("/basic/status", 0, ""));
        
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
        
        // do we want an older location defined?
        String selectedFolder = settings.read(myFolder);

        // do we want to use the default location or do we have an older choice?
        File startFolder = core.getWorkFolder();
        if(selectedFolder != null){
            startFolder = new File(selectedFolder);
        }
        
        // show the dialog
        File result = swingUtils.chooseFolder(startFolder, myFolder);
        
        
        // place the result in our settings
//        if(result != null){
//            //final String newPath = result.getAbsolutePath();
//            settings.write(myFolder, result.getAbsolutePath());
//            log.write(is.ACCEPTED, "Folder %1 was chosen as source for the SPDX "
//                + "document", result.getAbsolutePath());
//        }

        // all done, let's go back
        String output = html.redirect("/spdx/create?x=mainFolder", 0, 
                       " Returning to previous page..");
        
        request.setAnswer(output);
        
    }
  
    /**
     * Chooses a folder to be used as source for creating a new SPDX
     * @param request 
     */
    public void folderBatch(WebRequest request){
        // no support for requests from the browser
        if(request.requestOrigin == RequestOrigin.BROWSER){
            log.write(is.ERROR, "Support to SPDX creation from folder on disk "
                    + "is not yet implemented");
            request.setAnswer("Not supported from browser");
            return;
        }
        
        // do we want an older location defined?
        String selectedFolder = settings.read(batchFolder);

        // do we want to use the default location or do we have an older choice?
        File startFolder = core.getWorkFolder();
        if(selectedFolder != null){
            startFolder = new File(selectedFolder);
        }
        
        // show the dialog
        File result = swingUtils.chooseFolder(startFolder, myFolder);
        
        
        // place the result in our settings
        if(result != null){
            final String newPath = result.getAbsolutePath();
            settings.write(batchFolder, newPath + "");
            log.write(is.ACCEPTED, "Folder %1 was chosen as source for the SPDX "
                + "document", result.getAbsolutePath());
        }

        // all done, let's go back
        String output = html.redirect("/spdx/create?x=mainBatch", 0, 
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

                
              final DocumentCreate2 newSPDX = new DocumentCreate2();

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
            DocumentCreate2 newSPDX){
        //task.setStatus("Processing " + extractedFolder.getAbsolutePath());
        
        //String result = "";
        
        try{
        // do all the heavy work
        //result = 
                //newSPDX.create(extractedFolder);
                System.err.println("CR479 - Create folder from GUI not yet implemented");
        }catch (Exception e){
            log.write(is.ERROR, "CR301- Exception occurred when creating SPDX"
                    + ": %1",e.toString());
            e.printStackTrace();
        }
        // count the time it took to run this task
        long time = System.currentTimeMillis() - task.getUID();
        String timeCount = utils.time.timeNumberToHumanReadable(time) + " were "
                + "necessary to complete this task";
        task.setStatus(timeCount);
        
        // something went wrong, raise a flag
//        if(result.isEmpty()){
//            task.setStatus("Exception occurred when creating SPDX!");
//            task.setPercentageComplete(100);
//            return "";                    
//        }
        
        // all done
        task.setPercentageComplete(100);
        task.setStatus("All done!");
        
        
        // all done here, explain where the SPDX document can be found
               task.nextStep = "";
               System.err.println("CR505 - No next steps implemented yet");
//                         html.link("SPDX summary", 
//                        "/spdx/show?x=summary&"
//                        + param.spdx + "=" + result
//                         )
//                       + " | " +
//                       html.link("Show full text", 
//                        "/spdx/show?x=full&"
//                        + param.spdx + "=" + result)
//                       + html.redirect(
//                               "/spdx/show?x=summary&"
//                                + param.spdx + "=" + result
//                               , 
//                               2
//                               , "Redirecting..")
                       ;
               
               
               
               // when all things said and done
               concludeCreation(newSPDX);
        
        return "";
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
         
         int lastDot = fileName.lastIndexOf(".");
         String extension = fileName.toLowerCase();
//fileName.substring(lastDot).toLowerCase();
         // clean up specific cases
//         if(extension.contains("#")){
//             lastDot = extension.indexOf("#");
//             extension = extension.substring(0, lastDot);
//         }
         
         // handle different compressed files
         if(extension.contains(".tar.gz"))
            archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, 
                    CompressionType.GZIP);
        
         if(extension.contains(".zip"))
            archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
        
         if(extension.contains(".jar"))
            archiver = ArchiverFactory.createArchiver(ArchiveFormat.JAR);
            
        if(archiver == null){
            task.setIsProcessing(false);
            task.setStatus("File extension not recognized: %1", extension);
            return null;
        }    
            
            
        try {
            // do the extraction of this file
            archiver.extract(downloadedFile, destination);
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
        
        // remove unwanted characters from 
        
        
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

                    download.getFile();
        
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
private void concludeCreation(DocumentCreate2 newSPDX){
    System.err.println("CR641 - Missing to implement SPDX conclude creation");
   // String UID = newSPDX.getUID();
    // refresh the tree
//    TreeviewUtils.spdxAddOrUpdate(UID, newSPDX.file);
}
    
}

