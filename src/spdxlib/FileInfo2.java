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

package spdxlib;

import GUI.TreeNodeSPDX;
import GUI.TreeviewUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import main.core;
import script.FileExtension;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class FileInfo2 implements Serializable{
    // file name declared
    private String fileName;
    private String filePath;    // the path portion without the file name
    private String name;        // the name portion of the file without the path
    private String extension;   // the extension portion path nor name
    
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
    private String licenseInfoInFileSummary = "";
    private boolean licenseInfoInFileAvailable = false;
     
    // was a license concluded for this file?
    private String licenseConcluded;
    private boolean licenseConcludedAvailable = false;
    
    // was copyright text found for this file?
    private String fileCopyrightText;
    
    // to which SPDX object is this file related?
    private final SPDXfile2 spdx;
    
    
    // the node that will be displayed on the treeview
    private TreeNodeSPDX node;
    private String toString; // we add use this for the node label
    
    
    
    public FileInfo2(final SPDXfile2 spdx){
        this.spdx = spdx;
    }
    
    // setters and getters
    public void setFileName(final String fileName) {
        this.fileName = fileName;
        computeFileNamePortions();
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
        // add this license to the summary
        if(this.licenseInfoInFile.isEmpty()){
            licenseInfoInFileSummary 
                    = licenseInfoInFileSummary.concat(licenseInfoInFile);
        }else{
            // for the case when exists more than a single license
            licenseInfoInFileSummary 
                    = licenseInfoInFileSummary.concat(", " + licenseInfoInFile);
        }
        // add it up
        this.licenseInfoInFile.add(licenseInfoInFile);
        // do the summary of licenses + name
        toString = getName() + " (" + licenseInfoInFileSummary + ")";
        licenseInfoInFileAvailable = true;
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
        licenseConcludedAvailable = true;
    }

    
    
    /**
     * Has this file a license concluded?
     * @return true if a license was defined for this file object
     */
    public boolean hasLicenseConcluded() {
        return licenseConcludedAvailable;
    }
    
    /**
     * Has this file a license concluded?
     * @return true if a license was defined for this file object
     */
    public boolean hasLicenseInfoInFile() {
        return licenseInfoInFileAvailable;
    }
    
    /**
     * Returns the file name with the path part
     * @return the file name of this object
     */
    public String getFileName(){
        // get the name in un-processed state (still with slashes)
        String result = fileName;
        // remove slashes from the file name
//        if(result != null){
//            if (result.contains("/")) {
//                return result.substring(result.lastIndexOf("/")+1);
//            }
//        }
        
        // all done
        return result;
    }
 
    /**
     * Returns the file name without the path part
     * @return the file name of this object
     */
    public String getName(){
        return name;
    }

    public String getExtension() {
        return extension;
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
    public FileExtension getExtensionObject(){
        //System.err.println(name + "-->Extension: " + extension);
        FileExtension result = core.extensions.get(extension);
        return result;
    }
   
    public SPDXfile2 getSPDX() {
        return spdx;
   }

    /**
     * This method should only be called when the FileName is modified. It's
     * goal is place on a single location the calculations needed for splitting
     * the differents portions of a filename as used by SPDX
     */
    private void computeFileNamePortions(){
        // there is a path available, let's get it
        final int index = fileName.lastIndexOf("/");
        filePath = fileName.substring(0, index);
        name = fileName.substring(index + 1);
        // set the initial value for toString()
        toString = name;
        // get the extension
        final int lastDot = name.lastIndexOf(".");
        extension = name.substring(lastDot+1).toLowerCase();
    }
    
    /**
     * Create the node to be placed on the treeview
     * @param nodeFiles     The root node from where all files are found
     */
    void computeNode(final TreeNodeSPDX nodeFiles) {
        final String thisFileName = fileName;
        node = TreeviewUtils.mkdirNodes(nodeFiles, thisFileName);
        node.setUserObject(this);
    }
     
   
    /**
     * If the report was created on this machine, it might be possible to
     * be able of finding this file on its original location.
     * @return 
     */
    public File getFile(){
        // what is the relative path?
        String relativePath = getFileName();
        // get our target file
        File targetFile = new File(spdx.getSourceFolder(), relativePath);
        // doesn't exist? No need to continue
        if(targetFile.exists() == false){
            System.err.println("FI342, getFile(): Didn't found: " + targetFile.getAbsolutePath());
            return null;
        }
        System.err.println("FI344 - GetFile: " + targetFile.getAbsolutePath());
        // all done
        return targetFile;
    }
        
    /**
     * This is a handy method that reflects how the node should be converted 
     * to a string format. In this specific case, we want to show the name
     * plus the applicable license when available.
     * @return  The name of the node plus applicable licenses.
     */
    @Override
    public String toString(){
        return toString;
    }

    public String getLicenseInfoInFileSummary() {
        return licenseInfoInFileSummary;
    }
    
    
}
