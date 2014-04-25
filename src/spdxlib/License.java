/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-25T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: License.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the template for License files </text> 
 */

package spdxlib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import main.core;


/**
 *
 * @author Nuno Brito, 25th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class License {

    /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    public Boolean approvedOSI(){
        return false; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    public String getId(){
        return ""; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    public String getTitle(){
        return ""; // full text title
    }
    
    /**
     * Save this license on disk using a template
     * @param folder the Folder where this file will be stored
     */
    public void writeToDisk(File folder){
        File template = new File(core.getLicensesFolder(), "template.java");
        // no need to continue if it does not exist
        if(template.exists() == false){
            return;
        }
        
        // read the template content
        String content = utils.files.readAsString(template);
        
        // do the replacements as needed
        String term1 = "return \"\"; // short and unique id";
        String term2 = "\"\"; // full text title";
        
        // short id
        content = content.replace(term1, "return \""
                + getId()
                + "\"; // short and unique id");

        // text title
        String cleanTitle = getTitle().replace("\"", "\\\"");
        content = content.replace(term2, "\""
                + cleanTitle
                + "\"; // full text title");
        
        
        // prepare the file name that we will write
        String filename = safeText(getId());
        
        File file = new File(folder, filename + ".java");
        
        // final modifications
        content = "package SPDXLL;\n\n" + content;
        // add class name
        content = content.replace("class template extends License{", 
                "class "+ filename +" extends License{");
        // add date creation details
        content = content.replace("#DATE#", DocumentCreate.getDateSPDX());
        content = content.replace("#EXT#", file.getName());
        // get the year value for the copyright value
        Date date = new Date();
        String person = System.getProperty("user.name");
        SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");
        String year = simpleDateformat.format(date);
        content = content.replace("#COPYRIGHT#", "Copyright (c) "
                + year
                + ", "
                + person);
        // add the person
        content = content.replace("#PERSON#", person);
        
        
        System.out.println("Writing file: " + file.getAbsolutePath());
        // save everything on disk
        utils.files.SaveStringToFile(file, content);
        
    }
    
    
    /**
     * Useful for creating file names
     * @param input
     * @return 
     */
    String safeText(String input){
        String result = input;
        
        result = result.replace(".", "_");
        result = result.replace("-", "_");
        result = result.replace("+", "_");
        
        return result;
    }
    
}
