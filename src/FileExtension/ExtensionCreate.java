/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ExtensionCreate.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Automatically create a class with relevant information
 * about a given extension. For this to happen, information is collected across
 * the Internet.</text> 
 */

package FileExtension;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import main.engine;
import script.FileExtension;


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class ExtensionCreate {
    
    
    public String 
            sourceURL = "http://www.filesuffix.com/en/extension/",
            descriptionText,
            descriptionURL,
            descriptionCopyright = "FileSuffix.com (c)" 
                + utils.time.getCurrentYear();
    
    /**
     * An automated way of getting information for new file names.
     * It is not an easy task to catalog file names, some web sites
     * indicate automatically much automatically >5000 file extensions 
     * and deviations so we will try to get some info from them and give
     * credits where credits are due.
     * @param extension the unrecognized extension
     * @param overWrite
     */
    public void automatically(String extension, boolean overWrite) {
        File template = new File(engine.getExtensionsFolder(), "template.java");
        // preflight check
//        String safeExt =
//                utils.text.findRegEx( extension,"[a-zA-Z]+$", 0);
        // if the extension was just numbers, we need to make this compatible
//        if(safeExt.isEmpty()){
        String safeExt = "ext_" 
                   + utils.text.findRegEx( extension,"[a-zA-Z0-9_]+$", 0);
//        }
        
        File newExtension = new File(engine.getExtensionsUnknown(), 
                safeExt + ".java");
        // don't overwrite already existent unknown files
        if(overWrite == false){
            // don't add a registered extension
            for(FileExtension thisExtension : engine.extensions.getList()){
                if(utils.text.equals(thisExtension.getIdentifierShort(), extension))
                    return;
                }
            // don't overwrite files in "unknown" folder
            if(newExtension.exists()){
                return;
            }
        }     
        // we can't proceed without a template
        if(template.exists() == false){
            System.err.println("FI005 - Cannot find template.java to cre"
                    + "ate a new file extension");
            return;
        }
        // all done, let's create a new template
        String text = utils.files.readAsString(template);
        
        // edit that are necessary
        text = "package unknown;\n\n" + text;
        text = text.replace("class template", "class " + safeExt);
        text = text.replace("#EXT#", extension);
        // add the person name
        String person = System.getProperty("user.name");
        text = text.replace("#PERSON#", person);
        text = text.replace("LicenseName: NOASSERTION", 
                "LicenseName: CC-BY-4.0");
        text = text.replace("#DATE#", utils.time.getDateSPDX());
        // get the year value for the copyright value
        Date date = new Date();
        SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");
        String year = simpleDateformat.format(date);
        text = text.replace("#COPYRIGHT#", "Copyright (c) "
                + year
                + ", "
                + person);
        
        // now save it automatically new file
        utils.files.SaveStringToFile(newExtension, text);
   
        System.out.println("EC134 - Added extension: " + safeExt);
    }

    
    
    /**
     * Get information automatically from the web in regards to this file
     * extension
     * @param extension the extension to find info about
     */
    private void getWebInformation(String extension) {
        String www = sourceURL + extension;
        String webContent = utils.internet.getTextFile(www);
        if(webContent.isEmpty()){
            // nothing much to do, we just got an empty result
        }
        // processing the page contents
        extractWebDescription(webContent);
        descriptionURL = www;
    }

    /**
     * Gets the short info about the file description
     * @param webContent 
     */
    private void extractWebDescription(String webContent) {
        String id1 = "<span>Description:</span><br/>";
        String id2 = "</div>";
        int lineStart = webContent.indexOf(id1) + id1.length();
        descriptionText = webContent.substring(lineStart);
        int lineEnd = descriptionText.indexOf(id2);
       descriptionText = descriptionText.substring(0, lineEnd);
       
       // do the regEx filtering to get what we want
       descriptionText = descriptionText.replaceAll("[a-zA-Z0-9-_@\\.]+$", "");
       descriptionText = descriptionText.replaceAll("<[^>]*>", "");
       descriptionText = descriptionText.replaceAll("  ", "");
       descriptionText = descriptionText.replaceAll("[\\n\\t]", "");
       
       System.out.println(webContent);
      }

    
    /**
     * Breaks long lines of text after a given number of chars
     */
    private String doPrettyJavaText(int desiredLength, String text){
        String temp = text;
        String result = "";
        int jump = desiredLength;
        
        while(temp.length() > jump){
//            // reset the counter
//            jump = desiredLength;
//            // get the upcoming line to be found
//            String findWord = temp.substring(0, desiredLength);
//            // if not empty, get the last space
//            if(findWord.length() > 0){
//                int lastSpace = findWord.lastIndexOf(" ");
//                // shall we shorten our jump?
//                if(lastSpace > 0){
//                    jump = lastSpace;
//                }
//            }
//            
//            
            result += "\n\t\t+ \"" + temp.substring(0, jump) + "\"";
            temp = temp.substring(jump);
        }
        
        
        // add the ending part
        if(temp.length() > 0){
            result += "\n\t\t+ \"" + temp + "\"";
        }
        // clean up the beginning
        result = "\t " + result.substring(4);      
        
        
        return result;
    }
    
}
