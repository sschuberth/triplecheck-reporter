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
    

    private final SPDXfile spdx; // where this tag belongs to
    
    public TagValue(SPDXfile spdxFather){
        spdx = spdxFather;
    }
    
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

    
    /**
     * Used only when reading the SPDX for the first time, not meant to be
     * called afterwards
     * @param value 
     */
    public void setValue(String value) {
        this.value = value;
    }
    
  
    
    
    /**
     * Returns the tag value text without having the [text][/text] tags
     * @return 
     */
    public String withoutTextTags(){
        
        String result = "";
        
        try{
            result = removeTextTags(value);
        } catch (Exception e){
            return "";
        }
        
        return result;
    }
    
    /**
     * Remove the text> and /text> tags from the text
     * @param input
     * @return 
     */
    public String removeTextTags(final String input){
        // preflight check
//        if(input == null){
//            return "";
//        }
//        
//        if(input.length() == 0){
//            return "";
//        }
         
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
    
    
       /**
     * Changes the value of an existing tag and writes back to disk the changes
     * @param newValue 
     */
    public void writeNewValue(String newValue) {
        
        String newRaw = raw.replace(value + "\n", newValue);
        
        this.value = newValue;
        //spdx.changeTag(this, oldRaw, newRaw);
        spdx.lines[linePosition] = newRaw;
        
       // very slow on multiple write operations 
       // spdx.commitChanges();
    }
    
}
