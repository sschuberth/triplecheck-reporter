/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-08T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: pluginSearch.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This plugin takes care of the search operations made
 * by the user on the standard User Interface.</text> 
 */

package basic;

import GUI.SearchType;
import GUI.webUtils;
import definitions.Messages;
import definitions.definition;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import main.controller;
import main.coreGUI;
import main.engine;
import script.Plugin;
import main.script.log;
import spdxlib.FileInfo;
import spdxlib.SPDXfile;
import utils.hashing.ssdeep.SpamSumSignature;
import utils.hashing.ssdeep.ssdeep;
import utils.www.Table;
import utils.www.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 8th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class pluginSearch extends Plugin{

    // to add an HTML like break
    int resultCounter = 0;
    // what we will place on the search box
    String output = "";
        
    
    @Override
    public void startup(){
        
        log.hooks.addAction(SearchType.Files.getHook(),
               thisFile, "doKeyPress");

        log.hooks.addAction(Messages.SearchBoxPressedKey,
               thisFile, "doKeyPress");
        
        // whenever a search happens, trigger this method
        log.hooks.addAction("Search: %1",
               thisFile, "launchNewSearch");
        
        // prepare a smart feature that we love!
//        prepareFileLauncher();
        
    }
    
   
    /**
     * We use the search bar to launch our internal pages. Might seem hard
     * to understand what is the fuzz but we love to type something like
     * "server" and see it in front of us right away.
     */
    private void prepareFileLauncher(){
        // get all the java files that we are ready to launch if needed
        ArrayList<File> files = utils.files.findFilesFiltered(engine.getPluginsFolder(), 
                ".java", 25);
        
        // we need some filtering
        HashMap list = new HashMap();
        // go through all the files we found
        for(File file : files){
            String name = file.getName();
            // avoid cases like .java.old
            if(name.endsWith(".java")){
                // remove the .java portion, transform to lower case
                name = name.replace(".java", "").toLowerCase();
                // put it on our list, if duplicate just overwrite we don't care
                list.put(name, file);
            }
        }
        
        // place the list available for the future
        engine.temp.put(definition.searchList, list);
    }
    
    /**
     * Reacts to the case when users press the ENTER key
     */
    void doKeyPress(){
        String searchTerm = coreGUI.studio.getSearch().getText();
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }
        // do the search thing
        doSearch(searchTerm);
    }

    /**
     * The method that conducts the bulk of our search mechanism. You need to
     * specify the textBox instead of using the one at the default UI window so
     * that we use this feature in other places where needed in the future
     * 
     * @param searchTerm The term that we want to look for
     * @param textBox Where the results will be displayed
     */
    private void doSearch(String searchTerm) {
        // initial message to give some feedback
        log.write(is.INFO, "Performing a search: %1", searchTerm);
        // set our counter back to zero again
        resultCounter = 0;
        output = "";
//        long timeStart = System.currentTimeMillis();
        
         
        // check for internal commands like "help", or else do a normal search
        if(internalCommand(searchTerm)==false){
            // start by looking at the components
//            String matchComponentName =
//                searchListSPDX(engine.components, searchTerm, "Library");
            
            // add the grey text with a short summary
            output = 
                      html.div() 
                    + html.br
                    + html.textGrey("Looking for \"" + searchTerm +"\"..") 
                    + html._div
                    + output;
        // do the final output, everything done
        coreGUI.studio.editorPane(is.contentHTML, false, 0, output);
            
        try{    
            // look in reports now
            String matchProductName =
                searchListSPDX(searchTerm, definition.nodeReports);
            
                    // compile all the results together
            output =  //matchComponentName
                     matchProductName;
        }catch (Exception e){
            e.printStackTrace();
        }
            
        }
       

        
        String lastMessage = "No results for \"" + searchTerm + "\"";
        
        if(resultCounter > 1){
            lastMessage = resultCounter + " results found";
        }
//            long timeFinish = System.currentTimeMillis();
//            long timeElapsed = timeFinish - timeStart;
            
            
            
            // add the grey text with a short summary
            output = 
                      html.div() 
                    + html.br
                    + html.textGrey(lastMessage) 
                    + html._div
                    + output;
        // do the final output, everything done
        coreGUI.studio.editorPane(is.contentHTML, false, 0, output);
    }
    
   
    
     /**
     * Allows to perform the list on a specific list of
     * SPDX array files. This is intended to make the distinction
     * between the components and reports
     * @param searchTerm
     * @param title
     * @return 
     */
    public String searchListSPDX(String searchTerm,  String title){
        String result = ""; 
        String keyword = searchTerm.toLowerCase();
        // create the icons that might be displayed on the results
        String iconPackage = webUtils.getCommonFolderIcon("box.png");
        final String iconFile = webUtils.getCommonFolderIcon("document-number.png");
           
        if(engine.reports.getList().isEmpty()){
            System.err.println("PluginSearch198: No reports to search");
            return "";
        }
               
        
        for(SPDXfile spdx : engine.reports.getList()){
            String matchTitle = "";
        // first search, find components we have with the same name
            String spdxId = spdx.getId().toLowerCase();
           if(spdxId.contains(keyword)){
               matchTitle = "<i>(Title match)</i>";
                       resultCounter++;
           }
           
           // now look inside the files
           ArrayList fileList = processFilters(spdx, searchTerm);
           int fileCounter = fileList.size();
           
           // do we have any files to report?
           if(fileCounter > 0){
               String fileText = "";
               int[] size = new int[]{18, 300}; 
               
               // create the file list
               for(Object fileObject : fileList){
                   FileInfo file = (FileInfo) fileObject;
                   // do the details about this file
                   String fileDetails = "";
               
                   // add the file size on the details
                   if(file.getFileSize() != 0){
                       String fileSize = utils.files.humanReadableSize(file.getFileSize());
                        fileDetails =  fileDetails.concat(fileSize);
//                       if(fileSize.contains("(")){
//                           fileSize = fileSize.substring(0, 
//                                   fileSize.indexOf("(")-1);
//                           fileDetails =  fileDetails + fileSize;
//                       }
                   }
                       
                   // add the LOC when available
                   if(file.getFileLOC() !=0){
                       fileDetails = fileDetails 
                               + ", "
                               + file.getFileLOC() + " LOC"; 
                   }
                   
                   if(fileDetails.length()>0){
                       fileDetails = " (" + fileDetails + ")";
                   }
                       
                   
                   
                   // the internal hyperlink to readLines more details
                   // get the UID
                   String linkFileUID = file.getUID();
                   
                   String[] params = new String[]{iconFile, 
                       html.linkNode(
                               file.getName(),
                               linkFileUID)
                           + fileDetails
                   };
                   
                   
                   fileText = fileText.concat(
                           Table.alignedTable(params, size)
//                           iconFile
//                           + html.linkNode(
//                           file.tagFileName.toString(),
//                           linkFileUID)
                           
                                   
                           + "<code>" + file.getFilePath() + "</code>"
                           + html.br
                           + html.br
                   );
                   
                  // file.print();
               }
               
               // use correct grammar
               String fileDesc = "files";
               if(fileCounter == 1){
                   fileDesc = "file";
               }
               
               
               // the internal hyperlink to readLines more details
                   String linkPackageUID = 
                           html.linkNode(
                           spdx.getId(),
                             ">> "
                           + spdx.getId()
                           + " >> "
                           + title
                           + " "
                           );
               
               // write out the text for the files
               result = result.concat(
                       iconPackage 
                       + linkPackageUID
                       //+ spdx.getId() 
                       + " <i>(" 
                       + fileCounter 
                       + " "
                       +fileDesc
                       +")</i> "
                       + matchTitle
                       + html.br
                       + html.br
                       + "<div style=\"margin-left: 10px;\">"
                       //+ "<ul>"
                       + fileText
                       //+ "</ul>"
                       + "</div>"
                       + html.br
                       );
               }
        }
        
        // add the title of our search
        if(result.length() > 0){
            result = html.div()
                    + "<h2>" 
                    + title 
                    + "</h2>" 
                    //+ html.br 
                    + result 
                    + html.br
                    + html._div
                    ;
        }
        
    return result;
    }
    
    
    /**
     * We want to launch a new search and find files that match a given type 
     * of signature. We use this method to start the initial decision process
     * about how the search expression should be treated. For example, if we can
     * identify that the search is related to an MD5 signature then we launch
     * the technique to find files with an MD5 signature.
     */
    void launchNewSearch(){
        // update the search box
        coreGUI.studio.getSearch().setText(coreGUI.searchTerm);
        coreGUI.studio.getSearch().setCaretPosition(0);
        // do the hard work now
        doSearch(coreGUI.searchTerm);
    }

  
    
    /**
     * Do the most interesting part of the search
     * @param spdx
     * @return 
     */
    ArrayList processFilters(SPDXfile spdx, String originalKeyword){
        String keyword = originalKeyword.toLowerCase();
        ArrayList result = new ArrayList();
        
        
        // look for names that match the keyword
        if(keyword.startsWith("sha1:")){   
            // process the SHA1 term
            String what = keyword.replace("sha1: ", "");
            what = what.replace("sha1:", "");
           for(Object fileObject : spdx.getFiles()){
               FileInfo file = (FileInfo) fileObject;
               String test = file.getTagFileChecksumSHA1();
               if(test.contains(what)){
                   result.add(file);
                   resultCounter++;
               }
           }
           return result;
        }
            
   
        // look for names that match the keyword
        if(keyword.startsWith("ssdeep:")){   
            // process the ssdeep term
            String what = originalKeyword.replace("SSDEEP: ", "");
            what = what.replace("SSDEEP:", "");
            // lowercasetes
            what = what.replace("ssdeep:", "");
            what = what.replace("ssdeep: ", "");
           
            for(Object fileObject : spdx.getFiles()){
               FileInfo file = (FileInfo) fileObject;
               // SSDEEP might not be present on this data object
               if(file.getTagFileChecksumTLSH() == null){
                   continue;
               }
               // get the SSDEEP signature from this file
               String signature = file.getTagFileChecksumTLSH() ;
               signature = signature.replace("FileChecksum: SSDEEP: ", "");
               // comparing the two signatures
               ssdeep test = new ssdeep();
               int match = test.Compare(new SpamSumSignature(signature), 
                       new SpamSumSignature(what));

               // we have a threshold of 50% to match the other file
               if(match > 50){
                   result.add(file);
               }
           }
            return result;
        }
        
        // simply look for names that match the keyword
           for(Object fileObject : spdx.getFiles()){
               FileInfo file = (FileInfo) fileObject;
               String fileName = file.getFileName().toLowerCase();
               if(fileName.contains(keyword)){
                   result.add(file);
                   resultCounter++;
               }
           }
         
        
        return result;
    }

    /**
     * Check if this is an internal command or not, in case it is then we write
     * the global variable "output" with the result from this query
     * @param searchTerm
     * @return 
     */
    private boolean internalCommand(String searchTerm) {
        if(searchTerm.equalsIgnoreCase("help")){
            File helpFile = new File(thisFolder, "help.html");
            System.out.println(helpFile.getAbsoluteFile());
            output = utils.files.readAsString(helpFile);
            //System.out.println(output);
            return true;
        }
        // check for internal pages we can run
        HashMap list = 
                (HashMap) engine.temp.get(definition.searchList);

        // no need to continue if empty
        if(list == null){
            return false;
        }
        
        // files matching this search? let's process
        if(list.containsKey(searchTerm)){
            File file = (File) list.get(searchTerm);
            System.err.println("Matched " + searchTerm);
            // an action happened and needs a reply
            WebRequest request = new WebRequest();
            // signal that this request is coming from the user interface
            request.requestOrigin = RequestOrigin.GUI;
            request.BaseFolder = file.getParentFile();
            request.scriptFile = file;
            request.scriptMethod = is.methodDefault;
            // submit the request to be executed
            controller.process(request);
            // all done, hope for the best.. :-)
            return true;
        }
        
        
        
        return false;
    }
    
    
  
    
  
}
