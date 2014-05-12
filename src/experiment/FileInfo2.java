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

import java.io.Serializable;
import java.util.ArrayList;
import spdxlib.FileCategory;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class FileInfo2 implements Serializable{
    // file name declared
    private String fileName;
    
    // source, archive, binary or unknown?
    private FileCategory fileType;
    
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
    
    // was copyright text found for this file?
    private String fileCopyrightText;
    
    // setters and getters
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
    public final String getFileName() {
        return fileName;
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
    
    
    
}
