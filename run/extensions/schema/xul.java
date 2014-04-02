package unknown;

import java.io.File;
import java.util.Date;
import script.FileExtension;
import spdxlib.ContentType;
import spdxlib.FileCategory;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2013-11-30T21:19:15Z
 * LicenseName: CC-BY-3.0
 * TemplateVersion: TC-2013-11-16
 * FileName: xul.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright © 2013, nuno </text>
 * FileComment: <text> This class provides details about the files that make 
 * use of the "xul" extension. When possible, the file provenance author
 * includes details such as date when this extension first began to be used.
 * There are cases where different data structures use the same file extension,
 * when this happens then the author needs to accomodate code to accurately
 * detect which type of file is being analysed.
 * </text> 
 */


/**
 *
 * @file provenance by nuno
 */
public class xul extends FileExtension{
    /**
     * How can we confirm that this file extension is appliable to this file?
     * This method analyses the binary contents of a file to get the answer.
     * @param binaryFile the pointer to a file on disk
     * @return True if file matches the data structure reported by the extension
     */
    @Override
    public Boolean isApplicable(File binaryFile) {
        return true;
    }
  
    /**
     * How can we confirm that this file extension is appliable to this file?
     * This method analyses the text of a file to get the answer. You can either
     * specify a file or the text. The advantage of using this method is that
     * you will not need to read the text from the file for each extension test.
     * This brings significant performance improvements when analyzing
     * thousands of files.
     * @param textFile The content of a text file
     * @return True if file matches the data structure reported by the extension
     */
    @Override
    public Boolean isApplicable(String textFile) {
        return true;
    }

    /**
     * A short text explaining what this file type is all about
     */
    @Override
    public String getDescription() {
        return null; // file type description
    }
    
    /**
     * Are we collecting this description information from somewhere else?
     */
    @Override
    public String getDescriptionURL(){
        return null; // where the original page can be reached
    }
    /**
     * Who is the owner for description that was provided?
     * What are the applicable license terms?
     */
    @Override
    public String getDescriptionCredits(){
        return null; //author of description
    }

    /**
     * Typically, this is the three letter identifier of the file extension.
     * We use everything in lower case to speed the processing performance.
     * @return the unique identifier for this file type
     */
    @Override
    public String getIdentifierShort() {
        return "xul";
    }
    
    /**
     * Who has the copyright over this extension? This is information that
     * might be extracted from the meta-data inside the data contents. When
     * available, this information is available using this method.
     * @return A string with with copyright text extracted from the file
     */
    @Override
    public String getCopyright() {
        return null;
    }

     /**
     * What is the version for this file? Sometimes this is information that
     * can be extracted from the meta-data inside the data contents. When
     * available, this information is available using this method.
     * @return A string with with version text extracted from the file
     */
    @Override
    public String getVersion() {
        return null;
    }

    /**
     * How old is the oldest file that we have found of this kind?
     */
    @Override
    public Date earliestKnownRecord(){
        // syntax example that you can use for recording the date
        // Date result = utils.time.getDate(1999, 01, 01);
        return null;
    }
    
    /**
     * What are the MIME types registered for this file?
     */
    @Override
    public String getMIME(){
        return null;
    }
    
    /**
     * Returns information is this file has a binary or text based structure.
     * This is later used by the "isApplicable()" methods to speed up the
     * processing of each file
     * @return the type of content expected inside the file
     */
    @Override
    public ContentType getContentType() {
        return ContentType.TEXT; // is it a binary or text file?
    }

    /**
     * We can typically group data structures inside files to a few categories.
     * Albeit not perfect, it does help to sort out files into groups.
     * @return the category generally associated with this file type
     */
    @Override
    public FileCategory getCategory() {
        return FileCategory.UNKNOWN; // does it group under a category?
    }

    /**
     * The normal designation for these kind of files.
     */
    @Override
    public String getIdentifierLong(){
        return null; // how is this file
    }

    
}
