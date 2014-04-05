/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-12-11T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: show.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The class that shows details about a given SPDX document
available on our archive our shows all the available SPDX documents when no
specific document is mentioned.
 * </text> 
 */

package spdx;

import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import main.core;
import main.param;
import script.Plugin;
import script.log;
import spdxlib.FileInfo;
import spdxlib.FileLanguage;
import spdxlib.SPDXfile;
import spdxlib.tools;
import utils.Graphs;
import utils.html;
import www.RequestOrigin;
import www.Table;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 11th of December 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class show extends Plugin{
   
    
    String showSPDX = "showSPDX";
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.RefreshSPDX, thisFile, "refreshCache");
    }
    
    /**
     * Cache our front page to speed up loading time when clicked by end user
     */
    void refreshCache(){
        log.write(is.ACCEPTED, "Re-doing our cache again");
    }
    
    /**
     * Shows a summary of details about the selected package
     * @param request
     */
    @Override
    public void main(WebRequest request) {
        int 
                counterFiles = 0,
                counterCreators = 0,
                counterLicensesDeclared = 0
                ;
        
        // no reports found..
        if(core.reports==null){
            String result = ""
                    + html.div()
                    + html.br
                    + "It seems that no SPDX files were yet added."
                    + html.br
                    + html.br
                    + "Would you like to "
                    + html.link("create one", "/spdx/create")
                    + " right now?"
                    + html._div;
            request.setAnswer(result);
            return;
        }
        
        // get some statistical data
        for(Object object : core.reports){
            SPDXfile spdx = (SPDXfile) object;
            counterFiles += spdx.fileSection.files.size();
            counterCreators += spdx.creatorSection.people.size();
            counterLicensesDeclared += spdx.getStatsLicensesDeclared();
        }
        
        String reviewerList = "";
        // just one reviewer
        if(counterCreators == 1){
            reviewerList = counterCreators + " reviewer" + html.br;
        }
        if(counterCreators > 1){
            reviewerList = counterCreators + " reviewers" + html.br;
        }
        
        
        // calculate percentage of files with a license declared
//        String percentage = 
//                  " ("
//                + (counterLicensesDeclared * 100)/counterFiles
//                + "% in total)" + html.br; 
                
        
        String warnings = "";
        
        // we don't like SPDX documents without declared licenses
        if(counterLicensesDeclared == 00){
            warnings = ""
                    + html.getIcon("exclamation.png", request)
                    + "No licenses declared";
        }
        
        
        // handle the number of documents
        String documentText = "";
        if(core.reports.size() == 1){
            documentText = "1 document" + html.br;
        }
        if(core.reports.size() > 1){
            documentText = core.reports.size() + " documents" + html.br;
        }
        
        
        String summary = 
                "<h2>"
                + "Summary"
                + "</h2>"
                + html._div
                + html.div(20)
                + warnings
                + documentText
                //+ " containing "
                //+ html.getCommonFolderIcon("calculator.png")
                + counterLicensesDeclared + " files with declared licenses" 
                + html.br
                + counterFiles + " files in total" 
                + html.br
                //+ percentage
                //+ html.getCommonFolderIcon("stickman.png")
                + reviewerList
                + html.br
                ;
        
        // generate the nice graph
        String[] titles = new String[]{"No license declared", "License declared"};
        int noLicenses = counterFiles - counterLicensesDeclared;
        int[] values = new int[]{noLicenses, counterLicensesDeclared};
        // do the graph file
        File graphFile = Graphs.generate(thisFolder, titles, values);
        
        String[] header = new String[]{summary, 
              html.br
            + html.getIcon("chart.png", request)};
        values = new int[]{270, 180};
        
        summary = Table.alignedTable(header, values);
        
        String result = 
                html.div(20)
                + summary
                + html.h2("List of documents")
                + listFilesSPDX(request)
                //+ html.br
                + html._div
                + html.br
                + "";
        
        // provide an answer
        request.setAnswer(result);
    }
 
    /**
     * List all the files that are on the disk
     */
    private String listFilesSPDX(WebRequest request){
        
//        String[] line = new String[]{"SPDX", "Last modified"};
        
//        Table table = new Table(line);
        
        String result = "";
//        for(SPDXfile product : core.reports){
//            String lastModified = utils.time.getTimeFromLong
//                (product.file.lastModified());
//            
//            line = new String[]{product.getId(), lastModified};
//            table.add(line);
////        }
        
        result = findFiles(core.getProductsFolder(), 25, request);
        
        return result;           
    }
  
    
    
    
    /**
     * Find all files in a given folder and respective subfolders
     * @param where A file object of the start folder
     * @param maxDeep How deep is the crawl allowed to proceed
     * @param request
     * @return An array containing all the found files, returns null if none is
     * found
     */
    public String findFiles(File where, int maxDeep, WebRequest request){

    File[] files = where.listFiles();
    String result = "";
    
    int[] sizes = new int[]{10,200};
    
    if(files != null)
    for (File file : files) {
      if (file.isFile()){
         String filePath = file.getAbsolutePath();
         // we only want .spdx files
         if(filePath.endsWith("spdx")){
             
            // remove the local disk path with a generic one
             String filteredPath = "." 
                     + file.getAbsolutePath().replace(core.getProductsFolder()
                             .getAbsolutePath(), "");
             
             //filteredPath = filteredPath.replace(" ", "%20");
           
             String fileLink = html.link(file.getName(), 
                             "?x=summary&spdx="
                             + filteredPath
                             + "");
             
             //System.err.println("MSG SH23 - " + fileLink);
             
           result +=  Table.alignedTable(new String[]{
                 html.getIcon("document-text.png", request), 
                 fileLink},
                 sizes);
             
            
      }
         
      }
      else
      if ( (file.isDirectory())
         &&( maxDeep-1 > 0 ) ){
            String folderName = file.getName();
            // do the recursive crawling
            String temp = findFiles(file, maxDeep-1, request);
            // we don't need empty folders
            if(temp.length() == 0){
                continue;
            }
            
            String folderText = Table.alignedTable(new String[]{
                 html.getIcon("folder-horizontal-open.png", request), 
                 folderName},
                 sizes);
            
            String current = 
                    html.div()
                    + folderText
                    //+ html.br
                    + html.div()
                    + temp
                    + html._div
                    + html._div;

            // add a pretty paragraph
            if(maxDeep == 25){
                current = html.br + current;
            }
            
            result += current;
            
            
      }
    
    }
    
    return result;
    }
    
    
    /**
     * Shows the full text of an SPDX document
     * @param request
     */
    public void full(WebRequest request) {
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File file = tools.getFile(spdxTarget, request);
        if(file == null){
            return;
        }
        // read the whole file
        String result = utils.files.readAsString(file);
        
        
        
        // what happens when we want to see this file from a browser?
        if(request.requestOrigin == RequestOrigin.BROWSER){
        // we have to make it web-ready, replace break lines with BR tags
        result = 
                "<p>" 
                + result.replace("\n", "<br>")
                + "</p>";
        // output the file
        request.setAnswer(result);
        return;
        }
        
        // now do this properly on our desktop interface
        request.setAnswer("Loading text..");
        // we just want to just this on the GUI
        core.studio.editorPane(is.contentText, false, 0, result);
        
    }
    
    
    
    
    
    
    
    /**
     * Show the summary for a given SPDX document
     * @param request
     */
    public void summary(WebRequest request) {
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File file = tools.getFile(spdxTarget, request);
        if(file == null){
            return;
        }
        
//        String cache = (String) core.temp.get(showSPDX);
//        if(cache != null){
//            log.write(is.COMPLETED, "Using the cached version of show SPDX");
//            request.setAnswer(cache);
//            return;
//        }
        
        
        // get the SPDX file from the root node
        SPDXfile spdx = new SPDXfile(file);
        // compute some of our useful statistics about the SPDX document
        int counterLicensesDeclared = spdx.getStatsLicensesDeclared();
        int counterFiles = spdx.fileSection.files.size();
            
       
        String searchEngines = 
                html.div(10)
                + html.linkToSearchGoogle(spdx.getId())
//                + html.divider
//                + html.linkToSearchAntepedia(node.id)
                + html.divider
                + html.linkToSearchGitHub(spdx.getId())
                + html._div
                ;
        
        String evaluation = doEvaluation(spdx);
        
        // prepare our list of warnings about things we don't particularly enjoy
        String warnings = "";
        // we don't like SPDX documents without declared licenses
        if(counterLicensesDeclared == 00){
            warnings = ""
                    + html.br
                    + html.br
                    + Table.simple(
                            html.getIcon("exclamation.png", request), 10,
                            "No licenses declared", 150)
                    ;
        }
        
        
        // get the lines of code (LOC)
        int countLOC = 0;
        long overallSize = 0;
        for(FileInfo fileInfo : spdx.fileSection.files){
            countLOC += fileInfo.getLOC();
            overallSize += fileInfo.getSize();
        }
        
        // add the thousands separator
        
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        
        String textLOC = myFormatter.format(countLOC);
        String textOverallSize = utils.files.humanReadableSize(overallSize);
        
        
        // the header when showing summary about a specific SPDX file
        String summary = 
                html.h2(
                       // html.getIcon("wooden-box-label.png", request)
                        spdx.getId())
                + textLOC + " lines of code (LOC)"
                + html.br
                + counterFiles + " files (" 
                + counterLicensesDeclared + " declared licenses)"
                + html.br
                + textOverallSize + " in size"
                + html.br
                + spdx.getLanguageEvaluation()
                + html.br
                //+ html.getCommonFolderIcon("calculator.png")
                
                //+ percentage
                + warnings
                + evaluation
                + html.br
                ;
        
        // generate the nice graph
        String[] titles = new String[]{"No license declared", "License declared"};
        int noLicenses = counterFiles - counterLicensesDeclared;
        int[] values = new int[]{noLicenses, counterLicensesDeclared};
        // do the graph file
        File graphFile = Graphs.generate(thisFolder, titles, values);
        
        String[] header = new String[]{summary, 
              html.br
            + html.getIcon("chart.png", request)};
        values = new int[]{270, 180};
        
        summary = Table.alignedTable(header, values);
        
        // if we are on Windows, permit to open the folder
        String openFolder = "";
        if(isWindows()){
            openFolder = 
                    html.br
                    + html.link("Open folder in Windows explorer", 
                        "?x=openFolder&"
                        + param.file + "=" + file.getAbsolutePath()
                        + param.spdx + "=" + spdxTarget)
                    + html.br
                    ;
//            try {
//                Desktop.getDesktop().open(file);
//            } catch (IOException ex) {
//            }
        }
        
        // prepare the answer
        String result = ""
                //swingUtils.getBreadcrumb(node)
                + html.div(20)
                + summary
                + html._div
                
                
                + html.div()
                + openFolder
                    
                + html.br
                + swingUtils.addIfNotEmpty(""
                        //html.getCommonFolderIcon("magnifier-zoom-fit.png")
                        + "Look around the web"
                        , searchEngines)
                + html._div
                
                + html.div()
                + "<b>" + "Other actions" + "</b>" + html.br
                + html._div
                + html.div(20)
                //+ html.getCommonFolderIcon("receipt--pencil.png")
                + html.link("Show full text", 
                        "?x=full&"
                        + param.spdx + "=" + spdxTarget)
                + html._div
                + html.br
                //+ html.br
                
                + html.div()
                + "<b>" + "List files" + "</b>" + html.br
                + html._div
                + html.div(20)
                //+ html.getCommonFolderIcon("folder-smiley-sad.png")
                //+ html.linkScript("Without a license", thisFile, "showFilesWithoutLicense")
                + html.link("Without license specified", "?x=list&"
                        + param.filter + "=nolicense&" 
                        + param.spdx + "=" + spdxTarget)
                
                + html.br
                //+ html.getCommonFolderIcon("folder-smiley.png")
                //+ html.linkScript("With a license reported", thisFile, "showFilesWithLicense")
                + html.link("With license", "?x=list&"
                        + param.filter + "=withlicense&"
                        + param.spdx + "=" + spdxTarget)
                + html._div
                + "";
        
        // save our cache for next time
        core.temp.put(showSPDX, result);
        
        // write everything on our UI text area
        request.setAnswer(result);
    }
    
    //           
    
    /**
     * The web link to show the folder where the SPDX document is located.
     * @param request 
     */
    public void openFolder(WebRequest request) {
        String paramString = request.getParameter("file");
        File file = new File(paramString);
         try {
                Desktop.getDesktop().open(file.getParentFile());
            } catch (IOException ex) {
            }
         
//         String output = "A window showing the folder where the SPDX documents"
//                 + "are placed should now be visible. "
//                 + html.br
//                 + "Press the back button "
//                 + "to return on the previous page.";
        
//         request.setAnswer(utils.html.redirect("/spdx/show"
//                + "?x=summary&"  
//                 + param.spdx + "=" 
//                 + request.getParameter(param.spdx)
//                 , 0, ""));
         
         String output = "Opening the folder on Windows explorer";
         
//         
//                 "?x=openFolder&"
//                        + paramString.file + "=" + file.getAbsolutePath()
//                        + paramString.spdx + "=" + spdxTarget)
                 
                 
        request.setAnswer(output);
    }
    
     /**
     * list some information according to a filter
     * @param request
     */
    public void list(WebRequest request) {
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File file = tools.getFile(spdxTarget, request);
        if(file == null){
            return;
        }
        // get what we want to show
        String thisFilter = request.getParameter(param.filter);
        // value can't be empty
        if(thisFilter == null){
            request.setAnswer("No filter specified");
            return;
        }
        
        
        // start the processing
        SPDXfile spdx = new SPDXfile(file);
        // create the place holder for the results
        ArrayList<FileInfo> list = new ArrayList();
        
        // get only the files without a declared license
        if(thisFilter.equalsIgnoreCase(param.noLicense)){
             // iterate through all files
            for(FileInfo fileInfo : spdx.fileSection.files){
            // if there is a license, no need to continue
            if(fileInfo.countLicensesDeclared()>0){
                continue;
            }
            list.add(fileInfo);
            }
        }
        // get the unlicensed files
        if(thisFilter.equalsIgnoreCase(param.withLicense)){
            // iterate through all files
            for(FileInfo fileInfo : spdx.fileSection.files){
            // if there is a license, no need to continue
            if(fileInfo.countLicensesDeclared()==0){
                continue;
            }
            list.add(fileInfo);
            }
        }
        
        // create the HTML data where our info will be placed
        String[] columns = new String[]{"File name", "", "Path"};
        Table table = new Table(columns);
        
        
        // iterate through all files
        for(FileInfo fileInfo : list){
            // create a column with our file information
            String[] column = new String[]{
//                utils.text.shortText(fileInfo.toString(), 25),
//                utils.text.shortText(fileInfo.tagFilePath.toString(), 30),
                fileInfo.toString(),
                html.link("Detail", "?x=specific&"
                        + param.spdx + "=" + spdxTarget + "&"
                        + param.file + "=" + fileInfo.getName()
                ),
                    fileInfo.tagFilePath.toString()
            };
            table.add(column);
        }
                
        // do the output that is displayed to the end-user
        String result = "" //swingUtils.getBreadcrumb(node)
                + html.div(20)
                + html.h2(spdx.getId())
                //+ this.doFileSummary(spdx)
                + doEvaluation(spdx)
                + "Showing " + list.size() + " files from a total of " 
                + spdx.fileSection.files.size() + " files"
                + "" + html.br+ html.br
                + table.output()
                + html._div
                ;
        
        request.setAnswer(result);
    }
   
    
    
   
    
    

   
    /**
     * Provides an evaluation if the SPDX file has quality or not
     * @param spdx an object from where we will read all data
     * @return A string used for the HTML output
     */
    private String doEvaluation(SPDXfile spdx) {
        String result = "";
      
        
        if(spdx.hasVersioningFilesPresent()){
            result = html.br
                    + html.h2(""
                            //html.getCommonFolderIcon("exclamation.png") 
                            + "Suggestions"
                            + "")
                    + "Source code has versioning files that could be removed from the"
                    + " distribution"
                    + html.br
                    + html.br
                    ;
        }
        
        return result;
    }


    /**
     * Are we running under a Windows machine or not?
     */
    public boolean isWindows(){
            String os = System.getProperty("os.name").toLowerCase();
            //windows
        return (os.indexOf( "win" ) >= 0);
    }
    
}
