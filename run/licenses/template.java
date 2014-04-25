import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: #PERSON#
 * Created: #DATE#
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: #EXT#.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> #COPYRIGHT# </text>
 * FileComment: <text> This class provides details about the files that make 
 * use of the "#EXT#" extension. When possible, the file provenance author
 * includes details such as date when this extension first began to be used.
 * There are cases where different data structures use the same file extension,
 * when this happens then the author needs to accomodate code to accurately
 * detect which type of file is being analysed.
 * </text> 
 */


/**
 *
 * @file provenance by #PERSON#
 */
public class template extends License{
   /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    @Override
    public Boolean approvedOSI(){
        return false; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    @Override
    public String getId(){
        return ""; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return ""; // full text title
    }
}
