/*
 * SPDXVersion: SPDX-1.1
 * Person: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Person: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-08-29T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: FileInfo.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Holds all info collected about each individual
 *  file of the package </text> 
 */

package spdxlib;

import definitions.is;
import java.io.File;
import java.util.ArrayList;
import main.core;
import script.FileExtension;
import script.log;


public class FileInfo {

    public TagValue 
            tagFileName, // full path and name of the file, mandatory, one
            tagFiletype, // kind of file that is referenced here
            tagFileChecksumSHA1,
            tagLicenseConcluded; // result of audit, mandatory, one
    
    public ArrayList<TagValue> 
            // list all the licenses collected from the files included
            licenseInfoInFile = new ArrayList(); // mandatory, one or many        
   
    public TagValue 
            tagLicenseComments, // other info about the origin, optional, one
            tagFileCopyrightText, // copyright text found in file, mandatory, one
            tagArtifactOfProjectName, // identify origin of file, optional, one
            tagArtifactOfProjectHomePage, // identify origin of file, optional, one
            tagArtifactOfProjectURI, // direct link to file, optional, one
            tagComment; // generic comment about file, optional, one
    
    
    // non-standard tags
     public TagValue 
            tagFilePath,
            tagFileSize,
            tagFileLOC,
            tagFileChecksumSHA256,
            tagFileChecksumSSDEEP,
            tagFileChecksumMD5;
    
   
     private SPDXfile spdx = null; // where does this object comes from?
     
     // non tag related
    public FileCategory fileCategory = FileCategory.UNKNOWN;
     
    
    public FileInfo(SPDXfile thisSPDX){
        spdx = thisSPDX;
    }
    
     /**
      * Prints the data from this object for debugging the result
      */
     public void print(){
         System.out.println(""
                 + "---" + add("Filename", tagFileName)
                 + add("LOC", tagFileLOC)
                 + add("Size", tagFileSize)
                 + "-----------------"
                 );
     }
     
     String add(String title, TagValue tag){
         String result = "";
         if(tag !=null){
             result = title + ":" + tag.toString() + "\n";
         }
         return result;
     }
     
    /**
     * Each file can have one or more trigger applicable.
     * This method adds them up as needed.
     * @param tag
     */
    public void addLicense(TagValue tag){
        licenseInfoInFile.add(tag);
    }
 
    @Override
    public String toString(){
        String fileName = getName();
       
        String licenseText = getLicense();
        
        if(licenseText.isEmpty() == false){
            fileName += " (" + licenseText + ")";
        }

        // output the final result
        return fileName;
    }
    
    /**
     * Returns the file name without unwanted chars
     * @return the file name of this object
     */
    public String getName(){
        // get the name in un-processed state (still with slashes)
        String fileName = tagFileName.toString();
        // remove slashes from the file name
        if(fileName.contains("/")){
            return fileName.substring(fileName.lastIndexOf("/")+1);
        }
        
        // all done
        return fileName;
    }
    
    
    
    
    /**
     * How many lines of code has this file?
     * @return the number of lines (approximation)
     */
    public int getLOC(){
        // no need to continue if fully empty
        if(tagFileLOC == null){
            return 0;
        }
        
        
        int result = 0;
        try{
        result = utils.text.justNumbers(tagFileLOC.getValue());
        }catch (Exception e){
            System.err.println("Error reading LOC");
        }
        return result;
    }
    
     
    /**
     * This method will pick on a given FileInfo object and extract the relevant
     * licensing details.
     * @return A string text with a list of licenses when available. If no
     * trigger was found, it will return null
     */
    public String getLicense(){
        // where we store the results from this analysis
        String licenseOutput = "";
        
     // priority is the case where a human concludes a trigger
        if((this.tagLicenseConcluded != null)
                &&(tagLicenseConcluded.toString().equals("NOASSERTION")!=true)){
            // no need to proceed
            return tagLicenseConcluded.toString();
        }
        
           
        // second priority are licenses detected inside the code
        if(licenseInfoInFile.size()>0){
            // we need to count the valid licenses
            int counterLicense = 0;
            // go through all licenses listed
             for(TagValue tag : licenseInfoInFile){
                // should this trigger be ignored?
                if(tag.toString().equalsIgnoreCase("none")){
                    continue;
                }
                // valid trigger, increase the counter
                counterLicense++;
                // add the trigger to the printable text viewed by user
                licenseOutput =  licenseOutput.concat(", " + tag.toString());
            }
            // don't display text if no trigger was accounted
            if(counterLicense == 0){
                licenseOutput = "";
            }else{
                // remove the first comma added throught our loop
                licenseOutput = licenseOutput.substring(2);
            }
        }
        return licenseOutput;
    }

    
    /**
     * When given a file, this method checks if it has either a reported or
     * concluded trigger. The method is necessary since sometimes one of these
     * fields is present using infomation like "NOASSERTION" which really
     * becomes a problem to normalize.
     * @param file A FileInfo object with the information that we will analyze
     * @return 
     */
    public int countLicensesDeclared(){
        int result = 0;
        // are there any licenses inside this file?
        for(TagValue licenseTag : licenseInfoInFile){
            String licenseText = licenseTag.toString();
            // excluse the cases that shouldn't count for this metric
            if(licenseText.equals("NONE")){
                continue;
            }
            if(licenseText.equals("NOASSERTION")){
                continue;
            }
            // we just need to find one trigger to make our day happy! :-)
            result++;
        }
          // no licenses, let's leave
        return result;
    }
    
    
    
    public long getSize(){
        long result = 0;
        
        // add the file size on the details
        if(tagFileSize != null){
            String fileSize = tagFileSize.getValue().replace(" bytes", "");
            if(fileSize.contains("(")){
                int pos1 = fileSize.indexOf("(") +1;
                int pos2 = fileSize.indexOf(")") ;
                fileSize = fileSize.substring(pos1, pos2);
            }

            // convert the string onto a valid number that we can use
                try{
                    result = Long.parseLong(fileSize);
                }catch (Exception e){
                    log.write(is.ERROR, "FI259 - Error while trying to parse the "
                        + "size of %1->", toString(), fileSize);
                }
        }
        // all done
        return result;
    }
    
    
    /**
     * What is the extension of this file?
     * @return the acronym that pertains to this file
     */
    public String getExtensionString(){
        // only accept extensions with dots, otherwise it is not an extension
        String extension = tagFileName.getValue();
        if(extension.contains(".")==false){
            return null;
        }
        // we have an extension, get it here
        extension = extension.substring(extension.lastIndexOf(".")+1).toLowerCase();
        // all done
        return extension;
    }
    
    
     /**
     * What is the extension of this file?
     * @return the extension object with more info about this specific filetype
     */
    public FileExtension getExtension(){
        FileExtension result = core.extensions.get(getExtensionString());
        return result;
    }
    
    /**
     * When given a file name, discover the type of file that we have here
     * @param fileName a normal 8.3 file name
     * @return a type of category
     */
    public FileCategory findCategory(){
        // assign a default value
        FileCategory result = FileCategory.UNKNOWN;
        
        // first test, needs to have a dot as separator
        String extension = getExtensionString();
        
        // extension is not recognized, let's just go away
        if(core.extensions.has(extension) == false){
            return result;
        }
        // get the extension that we need
        FileExtension ext = core.extensions.get(extension);
        
        // define the new type of extension for this specific file
        result = ext.getCategory();
        
    return result;
    }

    /**
     * Provides back the SPDX document that gave origin to this FileInfo tidybit
     * @return 
     */
    public SPDXfile getSPDX() {
        return spdx;
    }
   
       /**
     * Returns the path portion from a given FileInfo object
     * @return 
     */
    public String getRelativeLocation(){
        
        // or else, the path is found inside the FileName tag
        String fileName = tagFileName.getValue();
        
        // if we have a FilePath tag available, use it as default
        if(tagFilePath != null){
            String filePath = tagFilePath.getValue();
            fileName = filePath + fileName;
        }
        
        // if no path is available, just mention it as root
        if(fileName.contains("/")==false){
            return "./";
        }
        // there is a path available, let's get it
        String result = fileName;//.substring(0, fileName.lastIndexOf("/"));
        
        return result;
    }
    
    
    public File getFileName(){
        // what is the relative path?
        String relativePath = getRelativeLocation();
        // get our target file
        File targetFile = new File(spdx.getSourceFolder(), relativePath);
        // doesn't exist? No need to continue
        if(targetFile.exists() == false){
            return null;
        }
        // all done
        return targetFile;
    }
   
    
    /**
     * Gets the copyright text on this file when available
     * @return  A list with the copyright holders
     */
    public String getCopyright(){
        if(tagFileCopyrightText == null){
            return "";
        }
        
        String result = tagFileCopyrightText.withoutTextTags();
        //result = tagFileCopyrightText.removeTextTags(result);
        //System.out.println(result);
        return result;
    }
    
}
