/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-16T00:00:00Z
 *
 * LicenseName: EUPL-1.1-without-appendix
 *
 * FileName: SectionFiles.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> Allows to handle an array of files that were
 *  reported on the SPDX document </text> 
 */

package old;

import old.TagValue;
import old.SPDXfile_old;
import old.FileInfo_old;
import java.io.Serializable;
import java.util.ArrayList;


public class SectionFiles implements Serializable {

     public ArrayList<FileInfo_old>
             files = new ArrayList();
     
     public ArrayList<TagValue>
             unknown = new ArrayList();
     
     
     SPDXfile_old spdx = null;
     
     public SectionFiles(SPDXfile_old thisSPDX){
         spdx = thisSPDX;
     }
     
    /**
     * Parse the file tags section of the document
     */
    public boolean parseTag(TagValue tag) {
        
        // start a new entry
        if(tag.title.equalsIgnoreCase("FileName")){
            FileInfo_old file = new FileInfo_old(spdx);
            file.tagFileName = tag;
            
            // what kind of file do we have here?
            file.fileCategory = file.findCategory();
            
            // add a backtrack feature
            
            
            files.add(file);
            return true;
        }

        if(tag.title.equalsIgnoreCase("FileType")){
            FileInfo_old file = getLastAddedFile();
            file.tagFiletype = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileChecksum->SHA1")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileChecksumSHA1 = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("LicenseConcluded")){
            FileInfo_old file = getLastAddedFile();
            file.tagLicenseConcluded = tag;
            return true;
        }
        
        // add licenseInfoInFile handling here
        if(tag.title.equalsIgnoreCase("LicenseInfoInFile")){
            FileInfo_old file = getLastAddedFile();
            file.addLicense(tag);
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("LicenseComments")){
            FileInfo_old file = getLastAddedFile();
            file.tagLicenseComments = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileCopyrightText")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileCopyrightText = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("ArtifactOfProjectName")){
            FileInfo_old file = getLastAddedFile();
            file.tagArtifactOfProjectName = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("ArtifactOfProjectHomePage")){
            FileInfo_old file = getLastAddedFile();
            file.tagArtifactOfProjectHomePage = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("ArtifactOfProjectURI")){
            FileInfo_old file = getLastAddedFile();
            file.tagArtifactOfProjectURI = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("ArtifactOfProjectURI")){
            FileInfo_old file = getLastAddedFile();
            file.tagArtifactOfProjectURI = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("Comment")){
            FileInfo_old file = getLastAddedFile();
            file.tagComment = tag;
            return true;
        }
        
        // non-standard tags
        
        if(tag.title.equalsIgnoreCase("FilePath")){
            FileInfo_old file = getLastAddedFile();
            file.tagFilePath = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileOrigin")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileOrigin = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileSize")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileSize = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileLOC")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileLOC = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileChecksum->SHA256")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileChecksumSHA256 = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("FileChecksum->MD5")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileChecksumMD5 = tag;
            return true;
        }
        
        if(tag.title.contains("FileChecksum->SSDEEP")){
            FileInfo_old file = getLastAddedFile();
            file.tagFileChecksumSSDEEP = tag;
            return true;
        }
        
        
        // if not recognized, add it up
        addUnknownTag(tag);
        return false;
        
    }

    /*
     * Provides the last added file object on our array
     */
    private FileInfo_old getLastAddedFile() {
        FileInfo_old result;
        if(files.size()>0){
            result = files.get(files.size()-1);
        }else{
            result = new FileInfo_old(spdx);
            files.add(result);
        }
        return result;  
    }

    /**
     * Add up all unknown tags, they might be later
     * proven as useful.
     * @param tag 
     */
    private void addUnknownTag(TagValue tag) {
        System.out.println("<files> Unknown tag: "
                + tag.title + " = " + tag.getValue());
        unknown.add(tag);
    }
    
    
   
    
}
