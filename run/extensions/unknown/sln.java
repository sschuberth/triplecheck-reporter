package unknown;

import java.io.File;
import script.FileExtension;
import spdxlib.ContentType;
import spdxlib.FileCategory;
import spdxlib.FileLanguage;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-01-25T15:22:24Z
 * LicenseName: CC-BY-4.0
 * FileName: sln.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright © 2014, nuno </text>
 * FileComment: <text> This class provides details about the files that make 
 * use of the "sln" extension. When possible, the file provenance author
 * includes details such as date when this extension first began to be used.
 * There are cases where different data structures use the same file extension,
 * when this happens then the author needs to accomodate code to accurately
 * detect which type of file is being analysed.
 * </text> 
 */


/**
 *
 * @file provenance by Nuno Brito
 */
public class sln extends FileExtension{
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
     * To which kind of language does this file relates the most?
     */
    @Override
    public FileLanguage getLanguage(){
        return FileLanguage.UNSORTED; // to which language is the file more related?
    }

    /**
     * Typically, this is the three letter identifier of the file extension.
     * We use everything in lower case to speed the processing performance.
     * @return the unique identifier for this file type
     */
    @Override
    public String getIdentifierShort() {
        return "sln";
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
    
}
