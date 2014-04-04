package image;

import java.io.File;
import script.FileExtension;
import spdxlib.ContentType;
import spdxlib.FileCategory;import spdxlib.FileLanguage;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2013-11-16T14:49:01Z
 * LicenseName: CC-BY-3.0
 * FileName: ai.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright © 2013, Nuno Brito </text>
 * FileComment: <text> This class provides details about files that have
 * the extension of type ai. Extensions tend to represent a specific type
 * of file structure from where we can extract information. In some cases, the
 * same type of file is used for representing different types of data from 
 * different types of applications. We make no specific arrangement to handle
 * these cases, albeit this class should be able of distinguishing each one of
 * them and then provide a suited answer. For example, NFO files are both used
 * as text files with information or used as binay files by a different tool.
 * 
 * The extension handler should be able of distinguishing these cases.
 * </text> 
 */


/**
 *
 * @author Nuno Brito
 */
public class ai extends FileExtension{
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
     * The normal designation for these kind of files.
     */
    @Override
    public String getIdentifierLong(){
        return "Adobe Illustrator Artwork";
    }

    /**
     * A short text explaining what this file type is all about
     */
    @Override
    public String getDescription() {
        return null; // file type description
    }
    
    /**
     * To which kind of language does this file relates the most?
     */
    @Override
    public FileLanguage getLanguage(){
        return null; // to which language is the file more related?
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
        return "ai";
    }
    
    /**
     * Who has the copyright over this file? Sometimes this is information that
     * can be extracted from the meta-data inside the data contents. When
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
     * Returns information is this file has a binary or text based structure.
     * This is later used by the "isApplicable()" methods to speed up the
     * processing of each file
     * @return the type of content expected inside the file
     */
    @Override
    public ContentType getContentType() {
        return ContentType.BINARY;
    }

    /**
     * We can typically group data structures inside files to a few categories.
     * Albeit not perfect, it does help to sort out files into groups.
     * @return the category generally associated with this file type
     */
    @Override
    public FileCategory getCategory() {
        return FileCategory.IMAGE;
    }

 
    
}
