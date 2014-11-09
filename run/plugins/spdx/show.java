/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-12-11T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: show.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The class that shows details about a given SPDX document
available on our archive our shows all the available SPDX documents when no
specific document is mentioned.
 * </text> 
 */

package spdx;

import GUI.webUtils;
import definitions.Messages;
import definitions.is;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import main.engine;
import main.param;
import script.Plugin;
import script.log;
import spdxlib.EvaluateLicensingQuality;
import spdxlib.FileInfo2;
import spdxlib.SPDXfile2;
import utils.Graphs;
import utils.www.html;
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
        if(engine.reports==null){
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
        
        ArrayList<SPDXfile2> spdxList = engine.reports.getList();
        
        // get some statistical data
        for(Object object : spdxList){
            SPDXfile2 spdx = (SPDXfile2) object;
            counterFiles += spdx.getFiles().size();
//            counterCreators += spdx.creatorSection.people.size();
            counterLicensesDeclared += spdx.getLicensesDeclaredCount();
                    
        }
        
        String reviewerList = "";
        // just one reviewer
        if(counterCreators == 1){
            reviewerList = counterCreators + " reviewer" + html.br;
        }
        if(counterCreators > 1){
            reviewerList = counterCreators + " reviewers" + html.br;
        }
        
        
        // calculate percentage of files with a trigger declared
//        String percentage = 
//                  " ("
//                + (counterLicensesDeclared * 100)/counterFiles
//                + "% in total)" + html.br; 
                
        
        String warnings = "";
        
        // we don't like SPDX documents without declared triggers
        if(counterLicensesDeclared == 00){
            warnings = ""
                    + webUtils.getIcon("exclamation.png", request)
                    + "No licenses declared";
        }
        
        
        // handle the number of documents
        String documentText = "";
        if(spdxList.size() == 1){
            documentText = "1 document" + html.br;
        }
        if(spdxList.size() > 1){
            documentText = spdxList.size() + " documents" + html.br;
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
            + webUtils.getIcon("chart.png", request)};
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
        String result = findFiles(engine.getProductsFolder(), 25, request);
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
                         + file.getAbsolutePath().replace(engine.getProductsFolder()
                                 .getAbsolutePath(), "");

                 //filteredPath = filteredPath.replace(" ", "%20");

                 String fileLink = html.link(file.getName(), 
                                 "?x=summary&spdx="
                                 + filteredPath
                                 + "");

                 //System.err.println("MSG SH23 - " + fileLink);

               result +=  Table.alignedTable(new String[]{
                     webUtils.getIcon("document-text.png", request), 
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
                     webUtils.getIcon("folder-horizontal-open.png", request), 
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
     * Show the summary for a given SPDX document
     * @param request
     */
    public void summary(WebRequest request) {
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File file = getFile(spdxTarget, request);
        if(file == null){
            return;
        }
      
        // get the canonical form
        String fileCanonical = utils.files.getCanonical(file);
        file = new File(fileCanonical);
        
        // get the SPDX file from the root node
        SPDXfile2 spdx = engine.reports.get(file);
        
        if(spdx == null){
            log.write(is.ERROR, "SH295 - Didn't found %1", file.getAbsolutePath());
            request.setAnswer("SH300 - File not found");
            return;
        }
        
        // compute some of our useful statistics about the SPDX document
        int counterLicensesDeclared = spdx.getLicensesDeclaredCount();
        int counterFiles = spdx.getFiles().size();
            
        // get the lines of code (LOC) and size
        int countLOC = spdx.getCountLOC();
        long overallSize = spdx.getCountSize();
        
        // add the pretty text with a thousands separator
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String textLOC = myFormatter.format(countLOC);
        String textOverallSize = utils.files.humanReadableSize(overallSize);
        
        // generate the nice graph
        String[] titles = new String[]{"No license declared", "License declared"};
        int noLicenses = counterFiles - counterLicensesDeclared;
        int[] values = new int[]{noLicenses, counterLicensesDeclared};
        // do the graph file
        File graphFile = Graphs.generate(thisFolder, titles, values);

        
        // get quality evaluation
        EvaluateLicensingQuality qualityTest = new EvaluateLicensingQuality();
        qualityTest.process(file);
        
        String qualityResult = qualityTest.getResultHTML();
        
        String column1 = ""
                + html.h2(spdx.getId())
                + spdx.getLanguageEvaluation()
                + html.br
                + html.h3("Score")
                + qualityResult;
        
        String column2 = ""
                + webUtils.getIcon("chart.png", request)
                + html.br
                + html.br
                + textLOC + " lines of code"
                + html.br
                + counterFiles + " files in total"
//                + " (" 
//                + counterLicensesDeclared + " declared licenses)"
                + html.br
                + textOverallSize + " in size"
                + html.br
                + html.br
                + spdx.summaryConcludedLicenses()
                
                //+ html.br
                //+ html.getCommonFolderIcon("calculator.png")
                
                //+ percentage
                //+ warnings
                //+ evaluation
                //+ html.br
                ;
        
        
        String[] header = new String[]{column1, column2};
        values = new int[]{180, 180};
        
        column1 = Table.alignedTable(header, values);
        
        // if we are on Windows, permit to open the folder
        String openFolder = "";
        if(utils.misc.isWindows()){
            openFolder = ""
                    //+ html.br
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
                + column1
                 //+ html.br
                + html._div
                
                + html.br
                + spdx.getCopyrightEvaluation()
                + html.br
                ;
        
        // save our cache for next time
        engine.temp.put(showSPDX, result);
        
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
         
        String output = "Opening the folder on Windows explorer";
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
        File file = getFile(spdxTarget, request);
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
        //System.err.println("DBG-S569 Reading SPDX");
        SPDXfile2 spdx = engine.reports.get(file);
        // create the place holder for the results
        ArrayList<FileInfo2> list = new ArrayList();
        
        // get only the files without a declared trigger
        if(thisFilter.equalsIgnoreCase(param.noLicense)){
             // iterate through all files
            for(FileInfo2 fileInfo : spdx.getFiles()){
            // if there is a trigger, no need to continue
            if(fileInfo.getLicenseInfoInFileCounter()>0){
                continue;
            }
            list.add(fileInfo);
            }
        }
        // get the unlicensed files
        if(thisFilter.equalsIgnoreCase(param.withLicense)){
            // iterate through all files
            for(FileInfo2 fileInfo : spdx.getFiles()){
            // if there is a trigger, no need to continue
            if(fileInfo.getLicenseInfoInFileCounter() == 0){
                continue;
            }
            list.add(fileInfo);
            }
        }
        
        // create the HTML data where our info will be placed
        String[] columns = new String[]{"File name", "", "Path"};
        Table table = new Table(columns);
        
        
        // iterate through all files
        for(FileInfo2 fileInfo : list){
            // create a column with our file information
            String[] column = new String[]{
                fileInfo.toString(),
                html.link("Detail", "?x=specific&"
                        + param.spdx + "=" + spdxTarget + "&"
                        + param.file + "=" + fileInfo.getFileName()
                ),
                    fileInfo.getFilePath()
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
                + spdx.getFiles().size() + " files"
                + "" + html.br+ html.br
                + table.output()
                + html._div
                ;
        
        request.setAnswer(result);
    }
   
    
   /**
* Verifies if a given SPDX document exists inside our archive or or not
* @param spdxTarget The file inside the SPDX Archive
* @param request
* @return null if the file does not exists, otherwise return a pointer
*/
    public static File getFile(String spdxTarget, WebRequest request){
         if(spdxTarget == null){
            request.setAnswer("No file specified");
            return null;
        }
        // does this file exists?
        File file = new File(engine.getProductsFolder(), spdxTarget);
        // this file needs to exist
        if((file.exists() == false) || (file.isDirectory())){
            request.setAnswer("Sorry, the file was not found: " + spdxTarget);
            return null;
        }
        // all done
        return file;
    } 
   
    
    

   
    /**
     * Provides an evaluation if the SPDX file has quality or not
     * @param spdx an object from where we will readLines all data
     * @return A string used for the HTML output
     */
    private String doEvaluation(SPDXfile2 spdx) {
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



}
