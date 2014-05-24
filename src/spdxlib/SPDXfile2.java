/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-12T09:29:20Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SPDXfile2.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class aims to provide a more compact and faster
 * way of processing SPDX documents than its predecessor. The basic principles
 * of functioning are:
 *  - No text files saved in memory
 *  - Be aggressive in avoiding strings, adopt types whenever possible
 *  - Reading and writing operations can be only be done internally</text> 
 */

package spdxlib;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import definitions.id;
import definitions.is;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import script.FileExtension;
import script.log;
import utils.files;
import utils.html;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class SPDXfile2 implements Serializable{
 
    // how many files have we indexed?
    int fileCounter = 0;
    
    // what is the information within?
    ArrayList<FileInfo2> files = new ArrayList();

    // which file was used for reading this document?
    public File file;
    
    // the node where all info about files is stored
    private TreeNodeSPDX nodeFiles = new TreeNodeSPDX("Files");
    
    // temporary values only used during the initial processing
    FileInfo2 tempInfo;
    int charPosition = 1;
    private boolean hasComputedStats = false; // were stats calculated already?
        
    // statistical variables
    private int 
        countLicensesDeclared = 0,
        countLicensesConcluded = 0,
        countFilesWithCopyright = 0,
        countLOC = 0,
        countSize = 0;

    // variables used for the language calculation
    private boolean languagesWereNotEvaluated = true;
    final private HashMap<FileLanguage, Integer> countMainLanguages = new HashMap();
    // this list keeps files where multiple languages apply
    final private ArrayList<FileInfo2> secondList = new ArrayList();
    
    // default constructor, we need a file to proceed
    public SPDXfile2(File canonicalFile) {
        this.file = canonicalFile;
        readSPDXfile(file);
    }
    
    /**
     * Refresh the internal variables when we change some values inside the spdx
     */
    public void refresh(){
        files = new ArrayList();
        nodeFiles = new TreeNodeSPDX("Files");
        charPosition = 1;
        tempInfo = null;
        fileCounter = 0;
    }
    
    /**
     * A constructor without arguments. This method is not public to permit
     * only the other classes on this package to access.
     */
    SPDXfile2() {
    }

    /**
     * The name for this SPDX document
     * @return  The name of this SPDX document without the .SPDX extension
     */
    public final String getId() {
        return file.getName().replace(".spdx", "");
    }

    // used for tags with multiple lines, such as:
    // FileCopyrightText -> COPYRIGHT
    enum mTypes {COPYRIGHT};
    boolean isMultiple = false;
    // when "isMultiple" is true, then lastTag needs to be defined
    mTypes lastTag;
    // this line keeps the continuation of multiple lines, separated by \n
    private String lastLine;
    

    /**
     * Reads the data inside an SPDX tag/value document onto this object
     * @param file  an SPDX file on disk
     */
    private void readSPDXfile(File file) {
        // go through all the lines of this text file
        readLines(file);
    }
    
    /**
     * The objective of this method is to go throught each line on a given
     * text file and extract every possible information in regards to tag/value
     * data. The result is an arraylist of tags that contain in sequential order
     * all the tag/value entries that were found.
     */
    private void readLines(final File file){
        // iterate through all lines
        charPosition = 0;  
      try {
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String line;
            while ((line = reader.readLine()) != null) {
               try {
                    // read the tag/value information
                    processFileLine(line, charPosition);
                
               } catch (Exception ex) {
                    log.write(is.ERROR, "Error reading line: %1 of file %2"
                            ,charPosition + "", file.getAbsolutePath());
                    // no need to stop, continue to the next item
                    continue;
                }
                // increase the line counter
                charPosition+= line.length() + 1;
            }
            reader.close();
            // small tidybits that were left to fix up
            postProcessing();
      } catch (IOException ex) {
          Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
          // something went wrong
          log.write(is.ERROR, "Error when reading line: %1 of file %2"
                  ,charPosition + "", file.getAbsolutePath());
      }
    }

    /**
     * This method checks if a given line has the </text> tag which represents
     * the end of a multiple line. When this happens, we collect the result
     * and write back the value.
     * @param line  The line to be processed
     */
    void doMultipleLineCheck(final String line){
        // can we stop accounting these lines as multiple?
        if(line.endsWith(is.textFinal)){
                    isMultiple = false;
                    // now write the appropriate key holder
                    switch(lastTag){
                        // for the moment, only copyright tags use multiple text
                        case COPYRIGHT:
                            final String temp = lastLine
                                    .substring(is.tagFileCopyrightText.length());
                            tempInfo.setFileCopyrightText(temp);
                            break;
                    }
        }
    }
    
    /**
     * Add this piece of data onto our object being formed
     * @param line  the text line to be processed
     * @param charPosition  At which position of the text file is this line?
     */
    private void processFileLine(String line, int linePosition) {
        // multiple lines take precedence and need to be processed first
        // was any license found inside this file?
        if(tagStartsWith(is.tagFileCopyrightText, line)){
            isMultiple = true;
            lastTag = mTypes.COPYRIGHT;
            lastLine = "";
        }
        // is this line a continuation of a previous multiple line?
        if(isMultiple){
            // add this new line, plus a break line
            lastLine = lastLine.concat(line + "\n");
            doMultipleLineCheck(line);
        }else
        // start the block to process all other file tags 
        // have we found a file?
        if(tagStartsWith(is.tagFileName, line)){
            final String fileName = tagGetValue(is.tagFileName, line);
            // create the new file object
            FileInfo2 fileInfo = new FileInfo2(this);
            // add the respective file name
            fileInfo.setFileName(fileName);
            // set the file line position
            fileInfo.setLinePosition(linePosition);
            // compute the file node
            fileInfo.computeNode(nodeFiles);
            // set this file as the last one we have indexed
            tempInfo = fileInfo;
            // add it up to our general counter
            files.add(fileInfo);
            // increase the file counter
            fileCounter++;
        }else
        // Now proceed to find the file type
        if(tagStartsWith(is.tagFileType, line)){
            final String temp = tagGetValue(is.tagFileType, line);
            tempInfo.setFileType(FileType.valueOf(temp));
        }else
        // was a checksum reported?
        if(tagStartsWith(is.tagFileChecksum, line)){
            processChecksumLine(line.substring(
                    is.tagFileChecksum.length()+1));
        }else
        // is a LOC value ready?
        if(tagStartsWith(is.tagFileLOC, line)){
           final String temp = tagGetValue(is.tagFileLOC, line);
           tempInfo.setFileLOC(Integer.parseInt(temp)); 
        }else
        // is a file size value available?
        if(tagStartsWith(is.tagFileSize, line)){
           processFileSizeLine(line.substring(
                    is.tagFileSize.length()+1));
        }else
        // was any license found inside this file?
        if(tagStartsWith(is.tagLicenseInfoInFile, line)){
           final String temp = tagGetValue(is.tagLicenseInfoInFile, line);
            tempInfo.addLicenseInfoInFile(LicenseType.convertToEnum(temp));
         }else
        // Was an origin defined for this file?
        if(tagStartsWith(is.tagFileOrigin, line)){
            final String temp = tagGetValue(is.tagFileOrigin, line);
            tempInfo.setFileOrigin(FileOrigin.valueOf(temp));
        }
        else
        // Is a license defined for this file?
        if(tagStartsWith(is.tagLicenseConcluded, line)){
            final String temp = tagGetValue(is.tagLicenseConcluded, line);
            tempInfo.setLicenseConcluded(LicenseType.convertToEnum(temp));
        }
    }
    
    /**
     * This method process the lines related to the checksum of a given
     * file object. 
     */
    private void processChecksumLine(final String line){
      // was a checksum reported?
        if(tagStartsWith(is.tagFileChecksumSHA1, line)){
            final String temp = tagGetValue(is.tagFileChecksumSHA1, line);
            tempInfo.setTagFileChecksumSHA1(temp);
        }else
        if(tagStartsWith(is.tagFileChecksumSHA256, line)){
            final String temp = tagGetValue(is.tagFileChecksumSHA256, line);
            tempInfo.setTagFileChecksumSHA256(temp);
        }else
        if(tagStartsWith(is.tagFileChecksumMD5, line)){
            final String temp = tagGetValue(is.tagFileChecksumMD5, line);
            tempInfo.setTagFileChecksumMD5(temp);
        }else
        if(tagStartsWith(is.tagFileChecksumSSDEEP, line)){
            final String temp = tagGetValue(is.tagFileChecksumSSDEEP, line);
            tempInfo.setTagFileChecksumSSDEEP(temp);
        }
    }
    
    /**
     * Translates the string from a human-readable value onto
     * a long number that can be processed
     * @param substring 
     */
    private void processFileSizeLine(final String value) {
        // find the "(" char which is represented by "40" in ASCII
        final int index = value.indexOf(40);
        if(index==-1){
            // find the space character
            final int space = value.indexOf(32);
            final String size = value.substring(0, space);
            tempInfo.setFileSize(Long.parseLong(size));
        }else{
            // exclude the " bytes)" portions which is sized in 7 bytes
            final String size = value.substring(index+1, value.length()-7);
            tempInfo.setFileSize(Long.parseLong(size));
        }
    }
      
    
    /**
     * Does a given line starts with a given tag name? This is a method
     * optimized for perfomance
     * @param tagName   The tag to find
     * @param line      The line where the tag might be located
     * @return 
     */
    private boolean tagStartsWith(final String tagName, final String line){
        return (line.length() > tagName.length()
                && line.substring(0,tagName.length()).equals(tagName));
    }
    
    /**
     * Returns the value of a given tag
     * @param tagName   The tag to find
     * @param line      The line where the tag might be located
     * @return 
     */
    private String tagGetValue(final String tagName, final String line){
        return line.substring(tagName.length() + 1);
    }
  
    /**
     * Print some feedback about this object
     */
    public void printFeedback(){
              
        System.out.println("SP284 - SPDX: " + file.getName()
              + " with " + charPosition + " characters");
        
        System.out.println(fileCounter + " files processed");
        
        System.out.println(files.get(0).getFileName());
        int counter = 0;
        int counterLOC = 0;
        long counterSize = 0;
        for(FileInfo2 fileInfo : files){
            if(fileInfo.getFileType() == FileType.SOURCE){
                counter++;
                counterLOC += fileInfo.getFileLOC();
                counterSize += fileInfo.getFileSize();
             }
         }
         System.out.println("Source files: " + counter);
         System.out.println("Total LOC: " + counterLOC);
         System.out.println("Total Size: " + utils.files.humanReadableSize(counterSize));
    }

    /**
     * Gets the list of files that were indexed
     * @return  An array with all the related FileInfo objects
     */
    public ArrayList<FileInfo2> getFiles() {
        return files;
    }
  
    /**
     * When available, gives back the location where we can find the source code
     * files that were used when creating this document.
     * @return A pointer to the folder where the source code files are located
     */
    public File getSourceFolder() {
        if(file== null){
            return null;
        }
        // get the title
        String title = id.SOURCEFOLDER + file.getName();
        
        if(core.settings.hasKey(title)==false){
            System.err.println("SPDXfile344: Didn't found " + title);
            return null;
        }
        // create the folder pointer
        File folder = new File(core.settings.read(title));
        
        // doesn't exist?
        if(folder.exists() == false){
            return null;
        }
        // all done!
        return folder;
    }
    
    /**
     * How many licenses were declared inside this document?
     * @return  The sum of licenses inside the source code
     */
    public int getLicensesDeclaredCount() {
        int counter = 0;
        for(FileInfo2 fileInfo : files){
            counter += fileInfo.getLicenseInfoInFileCounter();
        }
        return counter;
    }
    
    /**
     * Get the summary for the languages adopted across this project
     * @return      An HTML string with the summay of adopted languages
     */
    public String getLanguageEvaluation() {
        if(languagesWereNotEvaluated){
            evaluateLanguages();
        }
        
        // where we will store the results
        String result = "";
        
        // create a list sorted according to biggest on top
        Map<FileLanguage,Integer> map = ThirdParty.MiscMethods.sortByComparator(countMainLanguages);
        
        // how many files do we have in total?
        int total = 0;
        for(Integer value : map.values()){
            total += value;
        }
        
        for(FileLanguage language : map.keySet()){
            int value = countMainLanguages.get(language);
            result += value + " " 
                    + language.toString() 
                    + " files"
                    + " ("
                    + utils.misc.getPercentage(value, total) + "%"
                    + ")"
                    + html.br;
        }
        
        
        //System.err.println("Missing to implement Language evaluation");
        return result;
    }

    
    /**
     * Runs the code for evaluating the type of languages being used
     * inside the project files
     */
    private void evaluateLanguages(){
        // the main loop
        for(FileInfo2 fileInfo : files){
            computeLanguages(fileInfo);
        }
        
        // now process the languages on the second list
        computeLanguageSecondList();
        
        
        // set the marker that we have evaluated the languages
        languagesWereNotEvaluated = false;
    }
    
    
    /**
     * Process the files that we are not certain about which
     * type of language is applicable since they are sometimes
     * used by different programming languages
     */
    private void computeLanguageSecondList(){
        // now go through the second list, try to discover where the files
        // applicable to multiple languages belong
        // iterate through all these files
        for(FileInfo2 fileInfo : secondList){
           // get the respective extension
            FileExtension extension = fileInfo.getExtensionObject();
           // let's do some ranking
            int highestCount = 0;
            FileLanguage top = null;
            // go through each indexed language
            for(FileLanguage thisLang : countMainLanguages.keySet()){
                // we only want the possible candidates
                if(extension.getLanguages().contains(thisLang)==false){
                    continue;
                }
                
                int thisCount = countMainLanguages.get(thisLang);
                if(thisCount > highestCount){
                    // we have a possible value
                    top = thisLang;
                }
            }
            // now we have the top ranked candidate
            if(top != null){
                int count = countMainLanguages.get(top);
                    count++;
                    countMainLanguages.put(top, count);
            }
        }
        // now delete the second list elements to save memory
        secondList.clear();
    }
    
    
    /**
     * Outputs a summary of the licenses that were both both concluded as
     * applicable to files inside the project, as the licenses found inside
     * within the source code.
     * @return 
     */
    public String summaryConcludedLicenses() {
        // compute the number of licenses declared if not done before
        //computeStats();
        
        String result = ""
                + countFilesWithCopyright
                + " files copyright declared" 
                + html.br
                + countLicensesDeclared
                + " files with declared licenses" 
                + html.br
                + countLicensesConcluded
                + " files with concluded licenses" 
                + html.br
                ;
        
        return result;
    }
     
    
    /**
     * We use this method for doing a single loop that aggregates all
     * the stats that we need about this project.
     */
    private void computeStats(){
        // already done the stats? no need to continue
        if(hasComputedStats){
            return;
        }
        
        // the main loop
        for(FileInfo2 fileInfo : files){
            computeLicenses(fileInfo);
            //computeLanguages(fileInfo);
        }
        
        hasComputedStats = true;
    }

    
    
    /**
     * Calculate the language related statistics.
     * @param fileInfo      the file object being calculated    
     */
    private void computeLanguages(FileInfo2 fileInfo){
        // get the language object or just "unknown" if not indexed before
        FileLanguage thisLanguage = 
                fileInfo.getExtensionObject().getLanguage();
        

        // we only want files with a specified language
        if(thisLanguage == FileLanguage.UNSORTED){
            return;
        }
        
        // if the file is used by multiple languages, then we place it
        // on a post-processing list to discover how it is being used.
        if(thisLanguage == FileLanguage.MULTIPLE){
            secondList.add(fileInfo);
            // no need to proceed, skip to next file
            return;
        }


        // was this language indexed before?
        if(countMainLanguages.containsKey(thisLanguage)){
            int counter = countMainLanguages.get(thisLanguage);
            counter++;
            countMainLanguages.put(thisLanguage, counter);
        }else{
        // wasn't indexed before, add it up
            countMainLanguages.put(thisLanguage, 1);
        }
    }
    
    /**
     * During the compute loop, calculate the value for the licenses
     * @param fileInfo  A fileInfo object
     */
    private void computeLicenses(FileInfo2 fileInfo){
        // get the lines of code and size of file
        countLOC += fileInfo.getFileLOC();
        countSize += fileInfo.getFileSize();
        // have we been through this file to mark licenses?
        if(fileInfo.hasLicenseConcluded()){
            countLicensesConcluded++;
        }
        // where licenses declared?
        if(fileInfo.hasLicenseInfoInFile()){
            countLicensesDeclared++;
        }
        // count the copyright assignments
        final String copyrights = fileInfo.getFileCopyrightText();
        if((copyrights != null)&&(copyrights.isEmpty() == false)){
            countFilesWithCopyright++;
        }
    }
    
    
    public int getCountLicensesDeclared() {
        return countLicensesDeclared;
    }

    public int getCountLicensesConcluded() {
        return countLicensesConcluded;
    }

    public int getCountFilesWithCopyright() {
        return countFilesWithCopyright;
    }

    public int getCountLOC() {
        return countLOC;
    }

    public int getCountSize() {
        return countSize;
    }
    
    
    
    public String getCopyrightEvaluation() {
        System.err.println("Missing to implement Copyright evaluation");
        return "";
    }

    public TreeNodeSPDX getNodeFiles() {
        return nodeFiles;
    }

    public boolean hasVersioningFilesPresent() {
        System.err.println("Missing to implement VersioningFilesPresent");
        return false;
    }

    /**
     * Correct small tidybit that are left to process. This avoids the need
     * for IF conditions during processing
     */
    private void postProcessing() {
        nodeFiles = (TreeNodeSPDX) nodeFiles.getFirstChild();
        nodeFiles.nodeType = NodeType.sectionFile;
        nodeFiles.id = "./";
        nodeFiles.icon = core.iconFiles;
        // set the title
        if(fileCounter > 1){
            nodeFiles.setTitle("Files (" + fileCounter + ")");
        }else{
            nodeFiles.setTitle("Files");
        }
        // get the stats done
        computeStats();
    }

    
    
    /**
     * This method will get a list of given fileInfo object and write back the
     * changes as needed.
     * @param fileInfoList  A list with fileInfo objects 
     * @param tagId         The tag type that is our target to overwrite
     * @param tagValue      The value for the new (or overwritten) tag 
     * @param overwrite     If true, writes on existing value. Otherwise, 
     * adds another key/value
     */
    public void writeLines(ArrayList<FileInfo2> fileInfoList,
            final String tagId, final String tagValue, Boolean overwrite){
        System.err.println("SP434 - Writing in " + file.getName());
        // first we need to sort theses values according to line position    
        Map<FileInfo2, Integer> originalList = new HashMap();
        for(FileInfo2 fileInfo : fileInfoList){
            // we place the items on the array with the line position value
            originalList.put(fileInfo, fileInfo.getLinePosition());
        }
        // With a map we can now we sort them accordingly
        Map<FileInfo2, Integer> sortedList = ThirdParty.MiscMethods.
                sortByComparatorSmallerFirst(originalList);
       
        // now we end up sorting them again to plain ArrayList
        ArrayList<FileInfo2> list = new ArrayList();
        for(FileInfo2 fileInfo : sortedList.keySet()){
            list.add(fileInfo);
        }
        // now do our magic
        // create an output file in the same folder
        File outputFile = new File(file.getParentFile(), "temp.txt");
        try{
            // where we write the lines
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter writer = new BufferedWriter(fileWriter, 8192);
            // from where we read the lines
            BufferedReader reader = new BufferedReader(new FileReader(file));
            // where we store the current line
            String line;
            int itemCounter = 0;
            boolean hasMoreToProcess = true;
            boolean skipNextLine = false;
            // get the first key to process
            String id = is.tagFileName + is.space + list.get(itemCounter).getFileName();
            // go trought each line
            line = reader.readLine();
            //while ((line = reader.readLine()) != null) {
            while (line != null) {
                
                if(skipNextLine){
                    skipNextLine = false;
                }else
                // write the line as seen on the original file
                writer.append(line + is.lineBreak);
                // check if should think about adding a line or not
                if(hasMoreToProcess){
                    // verify if this line is what we want to write after
                    if(utils.text.equals(id, line)){
                        
                        // if we should overwrite, we need use special code
                        if(overwrite == true){
                            int maxLines = 20;
                            int lineCounter = 0;
                            ArrayList<String> lines = new ArrayList();
                            // go through the next 20 lines of text
                            while (((line = reader.readLine()) != null)
                                    &&(lineCounter < maxLines)){
                                // if we started into the next entry, stop here
                                if(tagStartsWith(is.tagFileName, line)){
                                    // add the next line (for the next entry)
                                    lines.add(line);
                                    // break the cycle
                                    break;
                                }
                                lines.add(line);
                                lineCounter++;
                            }
                            
                            // now prepare a modified list of strings
                            ArrayList<String> linesModified = new ArrayList();
                            boolean wasOverwritten = false;
                            // iterate through each line
                            for(String thisLine : lines){
                                // do we have a match?
                                if(wasOverwritten ==false && tagStartsWith(tagId, thisLine)){
                                    // overwrite the entry
                                    thisLine = tagId + is.space + tagValue;
                                    // signal that we did changes here
                                    wasOverwritten = true;
                                }
                                // add the modified (or not) line to our list
                                linesModified.add(thisLine);
                            }
                            
                            // have we overwritten this value?
                            if(wasOverwritten == false){
                                // insert our lines after the second entry
                                linesModified.add(1, tagId + is.space + tagValue);
                            }
                            
                            // now write everything back to disk
                            for(String thisLine : linesModified){
                                 writer.append(thisLine + is.lineBreak);
                                 // write back our changes on the main line
                                 line = thisLine;
                            }
                            
                        }
                        // just add a new line if we don't care about overwrite
                        else{
                           // add up the new line
                            writer.append(tagId + is.space + tagValue + is.lineBreak);
                        }
                        
                        
                        // last phase, increase the counter
                        // increase the counter
                        itemCounter++;
                        skipNextLine = true;
                         // did we found all lines already?
                        if(itemCounter == list.size()){
                            // set this flag as false to speed up processing
                            hasMoreToProcess = false;
                        }else{
                            // get the new item
                            id = is.tagFileName + is.space + list.get(itemCounter).getFileName();
                        }
                    }// if the line equals to our id
                } // if we have more to process
                // read the next line
                if(skipNextLine == false){
                    line = reader.readLine();
                }
            }
            // finished reading and writing
            writer.close();
            reader.close();
            // now replace the original file
            boolean fileDeleted = file.delete();
            // was the file really deleted?
            if(fileDeleted){
                 outputFile.renameTo(file);
            }else{
                System.err.println("SP565 - Failed to delete: " + file.getName());
            }
            // delete the generated file
            outputFile.delete();
            System.err.println("SP559 - Finished writing in " + file.getName());
        }catch(IOException e){
            System.err.println("SP562 - Exception occurred " + e.getMessage());
        }    
    }
}
