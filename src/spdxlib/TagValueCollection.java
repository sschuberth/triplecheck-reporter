/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TagValueFile.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows to read the tag/values data inside 
 * a specific text file </text> 
 */

package spdxlib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TagValueCollection {
    
    public File 
            tagFile;
    
    public ArrayList<TagValue> 
            tags = new ArrayList(); 
    
    public int linesOfCode = 0;
    
    public TagValueCollection(){
    }

    /**
     * Does a full printing of all indexed tags
     */
    public void printAll(){
        System.out.println("------\n" + this.tagFile.getAbsolutePath() + "\n");
        for(TagValue tag: tags){
            System.out.println(tag.title + " = " + tag);
        }
    }
    
    
    /**
     * Read the tags inside a document
     * @param lines
     * @param spdx 
     */
    public void read(ArrayList<String[]>  lines, SPDXfile_old spdx){
        List<String> output = new ArrayList<String>();
        // first, add the original values
        for(String[] lineArray : lines){
            output.add(lineArray[0]);
        }
       // second, convert back to static array and process
        String[] processLines = output.toArray(new String[0]);
        read(processLines, spdx);
    }
    
   
    /**
     * The objective of this method is to go throught each line on a given
     * text file and extract every possible information in regards to tag/value
     * data. The result is an arraylist of tags that contain in sequential order
     * all the tag/value entries that were found.
     * 
     * @param lines the SPDX text content to be parsed 
     * @param spdx 
     */
    public void read(String[] lines, SPDXfile_old spdx){
        System.err.println("TVC80-old - Reading SPDX: " + spdx.file.getName());
        // break this into individual lines
        //String[] lines = fullText.split("\n");
        linesOfCode = lines.length;
        // start parsing each line
        for(int i = 0; i < linesOfCode; i++){
            String line = lines[i];
            int linePosition = i;
            TagValue tag = new TagValue(spdx);
            
            // interpret multiple lines of text
            if(line.contains("<text>")){
                ReadMultipleLine multiple = new ReadMultipleLine();
                multiple.getMultipleLine(lines, i);
                i += multiple.lineCount - 1;
                if(multiple.status != ReadMultipleLine.readStatus.OK){
                    // if there was an error, avoid adding up this value
                    continue;
                }
                // add the text as a single line.
                line = multiple.output;
                tag.isMultiLine = true;
            }
            
            // we care about lines with tags
            if(line.contains(":")== false){
               continue;
            }
           
            // find the initial title delimiter
            int limiter = line.indexOf(":");
            tag.linePosition = linePosition;
            // get the title name, remove empty spaces
            tag.title = line.substring(0, limiter).trim();
            // get the full content
            tag.raw = line + "\n";
            // get the associated value
            tag.setValue(line.substring(limiter + 2));
            // avoid the bad "created" tag that contains fake :
            if(   //TODO this could be replaced with a nice RegEx rule one day..
                    (tag.title.equalsIgnoreCase("Created")==false)
                  &&(tag.title.equalsIgnoreCase("ReviewDate")==false)
                    )
            // there are cases of sub-tags that need to be processed
            while(tag.getValue().contains(":")){
                limiter = tag.getValue().indexOf(":");
                // solve cases of people adding ":" inside the <text> tags
                if(tag.getValue().contains("<text>")){
                    int limiterEnd = tag.getValue().indexOf("<text>");
                    if(limiter > limiterEnd){
                        break;
                    }
                }
                
                // add the sub-tag, iterate to the next value
                String newTag = tag.getValue().substring(0, limiter).trim();
                tag.title = tag.title + "->" + newTag;
                tag.setValue(tag.getValue().substring(limiter + 2));
            }
            // all done
            tags.add(tag);
        }
    }

    
    
    
}
