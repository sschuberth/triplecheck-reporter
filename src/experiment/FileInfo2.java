/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-12T10:13:05Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: FileInfo2.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Stores the relevant informations about files contained
 * inside an SPDX document.</text> 
 */

package experiment;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import main.core;
import script.FileExtension;
import spdxlib.FileCategory;
import spdxlib.FileOrigin;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class FileInfo2 implements Serializable{
    // file name declared
    private String fileName;
    private String filePath; // the path portion without the file name
    
    // source, archive, binary or unknown?
    private FileCategory fileType;
    private FileOrigin fileOrigin;
    
    // in which line of the text file is this file placed?
    private int linePosition;

    // checksums
    private String tagFileChecksumSHA1;
    private String tagFileChecksumSHA256;
    private String tagFileChecksumMD5;
    private String tagFileChecksumSSDEEP;
    
    // how many lines of code has this file? (when applicable)
    private int fileLOC = 0;
    
    // what is the size of this file?
    private long fileSize = 0;
    
    // what are the licenses present on this file?
    private final ArrayList<String> licenseInfoInFile = new ArrayList();
     
    // was a license concluded for this file?
    private String licenseConcluded;
    
    // was copyright text found for this file?
    private String fileCopyrightText;
    
    // to which SPDX object is this file related?
    private final SPDXfile2 spdx;
    
    
    public FileInfo2(SPDXfile2 spdx){
        this.spdx = spdx;
    }
    
    // setters and getters
    public void setFileName(final String fileName) {
        this.fileName = fileName;
        computeFilePath();
    }
    public FileCategory getFileType() {
        return fileType;
    }
    public void setFileType(final FileCategory fileType) {
        this.fileType = fileType;
    }

    public int getLinePosition() {
        return linePosition;
    }

    public void setLinePosition(final int linePosition) {
        this.linePosition = linePosition;
    }

    public String getTagFileChecksumSHA1() {
        return tagFileChecksumSHA1;
    }

    public void setTagFileChecksumSHA1(final String tagFileChecksumSHA1) {
        this.tagFileChecksumSHA1 = tagFileChecksumSHA1;
    }

    public String getTagFileChecksumMD5() {
        return tagFileChecksumMD5;
    }

    public void setTagFileChecksumMD5(final String tagFileChecksumMD5) {
        this.tagFileChecksumMD5 = tagFileChecksumMD5;
    }

    public String getTagFileChecksumSHA256() {
        return tagFileChecksumSHA256;
    }

    public void setTagFileChecksumSHA256(final String tagFileChecksumSHA256) {
        this.tagFileChecksumSHA256 = tagFileChecksumSHA256;
    }

    public String getTagFileChecksumSSDEEP() {
        return tagFileChecksumSSDEEP;
    }

    public void setTagFileChecksumSSDEEP(final String tagFileChecksumSSDEEP) {
        this.tagFileChecksumSSDEEP = tagFileChecksumSSDEEP;
    }

    public int getFileLOC() {
        return fileLOC;
    }

    public void setFileLOC(final int fileLOC) {
        this.fileLOC = fileLOC;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(final long fileSize) {
        this.fileSize = fileSize;
    }

    public ArrayList<String> getLicenseInfoInFile() {
        return licenseInfoInFile;
    }

    public void addLicenseInfoInFile(final String licenseInfoInFile) {
        this.licenseInfoInFile.add(licenseInfoInFile);
    }

    public String getFileCopyrightText() {
        return fileCopyrightText;
    }

    public void setFileCopyrightText(final String fileCopyrightText) {
        this.fileCopyrightText = fileCopyrightText;
    }

    public FileOrigin getFileOrigin() {
        return fileOrigin;
    }

    public void setFileOrigin(FileOrigin fileOrigin) {
        this.fileOrigin = fileOrigin;
    }

    public String getLicenseConcluded() {
        return licenseConcluded;
    }

    public void setLicenseConcluded(String licenseConcluded) {
        this.licenseConcluded = licenseConcluded;
    }

    
    
    /**
     * Has this file a license concluded?
     * @return true if a license was defined for this file object
     */
    public boolean hasLicenseConcluded() {
        return licenseConcluded != null;
    }
    
    /**
     * Returns the file name with the path part
     * @return the file name of this object
     */
    public String getFileName(){
        // get the name in un-processed state (still with slashes)
        String result = fileName;
        // remove slashes from the file name
        if(result != null){
            if (result.contains("/")) {
                return result.substring(result.lastIndexOf("/")+1);
            }
        }
        
        // all done
        return result;
    }
 
    /**
     * Returns the file name without the path part
     * @return the file name of this object
     */
    public String getName(){
        // get the name in un-processed state (still with slashes)
        String result = fileName;
        // remove slashes from the file name
        if(result != null){
            if (result.contains("/")) {
                return result.substring(result.lastIndexOf("/")+1);
            }
        }
        
        // all done
        return result;
    }
    /**
     * This method returns a more advanced type of file category than FileType
     * @return 
     */
    public FileCategory getFileCategory() {
        //TODO needs to be improved in the future
        return fileType;
    }
    
    /**
     * Returns the path portion from a given FileInfo object
     * @return  The path portion of the file (no file name included)
     */
    public String getFilePath(){
        return filePath;
    }
    
    /**
     * This method should only be called when the FileName is modified
     */
    private void computeFilePath(){
//        // if no path is available, just mention it as root
//        if((fileName.contains("/")==false)){
//            return "./";
//        }
        // there is a path available, let's get it
        final String result = fileName.substring(0, fileName.lastIndexOf("/"));
        filePath = result;
    }
    
    /**
     * Calculate the UID for this item
     * @param spdx      The spdx file where this object is placed
     * @return          The UID to find this item inside a tree view
     */
    public String getUID(SPDXfile2 spdx) {
        String result = ">> " 
                + getFileName()
                ;
        
        String path = this.getFilePath();
        // iterate to build the path id
        while(path.contains("/")){
            // get the path
            result += " >> "
                    + path;
            // remove one of the path indicators
            int pos = path.lastIndexOf("/");
            path = path.substring(0, pos);
        }
        
        result += " >> ./ >> "
                + spdx.getId() + ".spdx >> Reports "
                ;
        
        return result;
    }

    /**
     * If the SPDX was generated on the local machine, we can get a pointer
     * to the real file on disk. This method attempts to retrieve that file.
     * @param spdx  The SPDX object where the file was indexed
     * @return      The pointer to a file on disk if found or null if not found.
     */
    public File getFile(SPDXfile2 spdx){
        // get our target file
        File targetFile = new File(spdx.getSourceFolder(), fileName);
        // doesn't exist? No need to continue
        if(targetFile.exists() == false){
            System.err.println("FI363, getFileName(): Didn't found: " + targetFile.getAbsolutePath());
            return null;
        }
        // all done
        return targetFile;
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
     * What is the extension of this file?
     * @return the acronym that pertains to this file
     */
    public String getExtensionString(){
        // only accept extensions with dots, otherwise it is not an extension
        if(fileName.contains(".")==false){
            return null;
        }
        // we have an extension, get it here
        final String extension = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
        // all done
        return extension;
    }
    
    public SPDXfile2 getSPDX() {
        return spdx;
   }
     
    
}
