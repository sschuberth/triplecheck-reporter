/*
 * SPDXVersion: SPDX-1.1
 * Person: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Person: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-08-29T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: FileInfo.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Holds all info collected about each individual
 *  file of the package </text> 
 */

package spdxlib;

import java.util.ArrayList;


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
    
   
     // non tag related
     public FileCategory fileCategory = FileCategory.UNKNOWN;
     
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
     * Each file can have one or more license applicable.
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
     * license was found, it will return null
     */
    public String getLicense(){
        // where we store the results from this analysis
        String licenseOutput = "";
        
     // priority is the case where a human concludes a license
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
                // should this license be ignored?
                if(tag.toString().equalsIgnoreCase("none")){
                    continue;
                }
                // valid license, increase the counter
                counterLicense++;
                // add the license to the printable text viewed by user
                licenseOutput =  licenseOutput.concat(", " + tag.toString());
            }
            // don't display text if no license was accounted
            if(counterLicense == 0){
                licenseOutput = "";
            }else{
                // remove the first comma added throught our loop
                licenseOutput = licenseOutput.substring(2);
            }
        }
        return licenseOutput;
    }
//     String licenseOutput = "";
//        // priority is the case where a human concludes a license
//        if((tagLicenseConcluded != null)
//                &&(tagLicenseConcluded.toString().equals("NOASSERTION")!=true)){
//            // no need to proceed
//            return 
//                    //file.tagFileName.toString() 
//                    //+ " ("+ 
//                    tagLicenseConcluded.toString() 
//                    //+")"
//                    ;
//        }
//        
//        // second priority are licenses detected inside the code
//        if(licenseInfoInFile.size()>0){
//            
//            for(TagValue tag : licenseInfoInFile){
//                licenseOutput =  licenseOutput.concat(", " + tag.toString());
//            }
//            // remove the first comma added throught our loop
//            licenseOutput = " (" + licenseOutput.substring(2) + ")";
//        }
//        return licenseOutput;
//    }
    
    
    /**
     * When given a file, this method checks if it has either a reported or
     * concluded license. The method is necessary since sometimes one of these
     * fields is present using infomation like "NOASSERTION" which really
     * becomes a problem to normalize.
     * @param file A FileInfo object with the information that we will analyze
     * @return 
     */
    public Boolean hasLicense(){
        
        // do we have a license concluded for this file?
        if(tagLicenseConcluded != null){
            // get the text from the license that was concluded
            String licenseText = tagLicenseConcluded.toString();
            // a lot of trouble, but necessary to find out what is happening
            if( (licenseText.equals("NONE")== false) 
             && (licenseText.equals("NOASSERTION")== false)){
                // we have at least one license concluded. Good enough
                return true;
            }
        }
        
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
            // we just need to find one license to make our day happy! :-)
            return true;
        }
          // no licenses, let's leave
        return false;
    }
    
    
}
