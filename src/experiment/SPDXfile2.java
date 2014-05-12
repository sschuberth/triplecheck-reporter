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

package experiment;

import definitions.is;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import spdxlib.FileCategory;
import utils.files;


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
    
    // temporary values only used during the initial processing
    FileInfo2 tempInfo;
    // used for tags with multiple lines, such as:
    // FileCopyrightText -> COPYRIGHT
    enum mTypes {COPYRIGHT};
    boolean isMultiple = false;
    // when "isMultiple" is true, then lastTag needs to be defined
    mTypes lastTag;
    // this line keeps the continuation of multiple lines, separated by \n
    private String lastLine;
    
    /**
     * First test trying to digest somewhat larger files
     */
    public void test(){
        // get the pointer to a 20Mb spdx document
        File file = new File (core.getMiscFolder(), "linux-coreos.spdx");
        readSPDXfile(file);
        System.err.println("All done!");
        //System.err.println(file.getAbsolutePath());
    }

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
    private void readLines(File file){
        // iterate through all lines
        int linePosition = 1;
          
      try {
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String line;
            while ((line = reader.readLine()) != null) {
             
                try {
                    // read the tag/value information
                    processFileLine(line, linePosition);
                } catch (Exception ex) {
                    System.err.println("Error when reading line: " + linePosition
                            + " of file: " + file.getAbsolutePath());
                    // no need to stop, continue to the next item
                    continue;
                }
                // increase the line counter
                linePosition++;
            }
          
      } catch (IOException ex) {
          Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
          // this is a critical error, let's stop here to reflect
          System.err.println("Error when reading line: " + linePosition
                  + " of file: " + file.getAbsolutePath());
          System.exit(6751);
      }
      System.out.println("SP92 - Finished SPDX " + file.getName()
              + " with " + linePosition + " lines");
     
      printFeedback();
    }

    
    /**
     * Add this piece of data onto our object being formed
     * @param line  the text line to be processed
     * @param linePosition  At which position of the text file is this line?
     */
    private void processFileLine(String line, int linePosition) {
        // multiple lines take precedence and need to be processed first
        // was any license found inside this file?
        if(tagStartsWith(is.tagFileCopyrightText, line)){
            isMultiple = true;
            lastTag = mTypes.COPYRIGHT;
            lastLine = "";
            //lastLine = tagGetValue(is.tagFileCopyrightText, line);
        }
        
        // is this line a continuation of a previous multiple line?
        if(isMultiple){
            // add this new line, plus a break line
            lastLine = lastLine.concat(line + "\n");
             // can we stop accounting these lines as multiple?
            if(line.endsWith(is.textFinal)){
                isMultiple = false;
                // now write the appropriate key holder
                switch(lastTag){
                    case COPYRIGHT:
                        tempInfo.setFileCopyrightText(lastLine);
                        break;
                }
            }
        }else
        // start the block to process all other file tags 
        // have we found a file?
        if(tagStartsWith(is.tagFileName, line)){
            // create the new file object
            FileInfo2 fileInfo = new FileInfo2();
            // add the respective file name
            fileInfo.setFileName(tagGetValue(is.tagFileName, line));
            // set the file line position
            fileInfo.setLinePosition(linePosition);
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
            tempInfo.setFileType(FileCategory.valueOf(temp));
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
            tempInfo.addLicenseInfoInFile(temp);
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
    private void printFeedback(){
         System.out.println(fileCounter + " files processed");
         System.out.println(files.get(0).getFileName());
         
         int counter = 0;
         int counterLOC = 0;
         long counterSize = 0;
         for(FileInfo2 fileInfo : files){
             if(fileInfo.getFileType() == FileCategory.SOURCE){
                 counter++;
                 counterLOC += fileInfo.getFileLOC();
                 counterSize += fileInfo.getFileSize();
             }
         }
         System.out.println("Source files: " + counter);
         System.out.println("Total LOC: " + counterLOC);
         System.out.println("Total Size: " + utils.files.humanReadableSize(counterSize));
    }
  
}
