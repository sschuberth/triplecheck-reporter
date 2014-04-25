import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: #PERSON#
 * Created: #DATE#
 * LicenseName: Apache-2.0
 * FileName: #EXT# 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> #COPYRIGHT# </text>
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
