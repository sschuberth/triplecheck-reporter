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
 * FileName: ReadMultipleLine.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> Allows to handle blocks of text separated across 
 * different lines such as this comment. </text> 
 */

package spdxlib;


public class ReadMultipleLine {

    public readStatus 
            status = readStatus.NOTREAD; // indicates if everything was valid or not
    
    public int
            lineCount = 0; // how big is this block of text?

    public String 
            output = "";
    
    // non-changing definitions
    private final String
            textStart = "<text>",
            textEnd = "</text>";
    
    public enum readStatus {
        NOTREAD, INCOMPLETE, NOSTART, NOEND, INVALID, OK;  //; is optional
    }
    
   /**
     * Gets the full text of sections that are using the <text> and </text> tag
     * @param lines The array containing all lines of the file
     * @param startLine From where the text block begins
     * @return 
     */
    public void getMultipleLine(String[] lines, int startLine){
        // preflight check
        if(lines[startLine].contains(textStart) == false){
            // no point in continuing, file was not valid
            status = readStatus.NOSTART;
            return;
        }
        
        // get size of whole text file
        int numberOfLinesInFile = lines.length;
        
        // go throught each line
        for(int i = startLine; i < numberOfLinesInFile; i++){
            // always increase the counter
            lineCount++;
            // get the current line to do some work
            String line = lines[i];
            //String line = removeLineBreaks(lines[i]);
            output += line + "\n";
            
            // finish the blow
            if(line.contains(textEnd)){
                // all done
                status = readStatus.OK;
                //multipleLine = removeTextTags(line);
                break;
            }
        }
        // nothing more to do, just leave
    }
      
   
    /**
     * Remove the typical \r\n from text lines
     */
    String removeLineBreaks(String input){
        String result = "";
//        result = input.replace("\r", "");
//        result = result.replace("\n", "");
        // some weird characters that are not really needed here
        result = result.replace("�", " ");
        
        return result;
    }
    
}
