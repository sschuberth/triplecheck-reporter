/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-14T00:00:00Z
 *
 * LicenseName: EUPL-1.1-without-appendix
 *
 * FileName: TagValue.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> A simple holder for Tag/Value pairs of data </text> 
 */

package spdxlib;

import definitions.is;

public class TagValue {
    public String
            title,
            raw; // the raw contents of this data
    private String
            value;
    // other settings like line number where this tag is located
    public boolean
            isMultiLine = false;
    
    public boolean
            wasModified = false; // has any of these values changed?
    
    public int
            linePosition;
    

    /**
     * The raw value as read from the text file
     * @return the unformatted text captured from the text file
     */
    public String getValue() {
        return value;
    }

    /**
     * Provides a version of the value that is ready for displaying
     * on the text screen.
     * @return A printable output of the value for this tag
     */
    @Override
    public String toString() {
        String temp = value;
        // remove text quotes if the text is multi Line
        if(isMultiLine){
            temp = removeTextTags(temp);
        }
        // remove the unwanted chars
        temp = removeUnwantedChars(temp);
        // all done
        return temp;
    }

    
    public void setValue(String value) {
        this.value = value;
    }
    
    
    /**
     * Remove the <text> and </text> tags from the text
     */
    String removeTextTags(final String input){
        String result = input.replace(is.textStart, "");
        result = result.replace(is.textEnd, "");
        // remove strange spaces on the beginning and end of text lines
        char test1 = result.charAt(0);
        if(Character.isWhitespace(test1)){
            result = result.substring(1);
        }
        char test2 = result.charAt(result.length()-1);
        if(Character.isWhitespace(test2)){
            result = result.substring(0, result.length()-2);
        }
        
        return result;
    }
    
    /**
    * Remove the typical \r\n from text lines
    */
    String removeUnwantedChars(String input){
        String result = input.replace("\r", "");
        result = result.replace("\n", "");
        // some weird characters that are not really needed here
        result = result.replace("�", " ");
        return result;
    }
    
    
}
