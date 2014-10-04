/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
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
import utils_deprecated.html;


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
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    public String getTerms(){
        return ""; // the license text
    }
    

    /**
     * An HTML pretty version of the text from this license. This method
     * is used when listing licenses
     * @param title   The formal title of this license
     * @param url     If necessary for outside browsing
     * @return          HTML code for display to end-user
     */
    public String getPrettyText(String title, String url){
        // get the pretty text for this license
        String result = getTitle()
                + html.textGrey(" (" + getId() + ")");
        // only add a URL link when desired
        if(title.isEmpty() == false){
            result += " " + html.link(title, url);
        }
        // add a break line
        result+= html.br;
        // all done
        return result;
    }
    
    /**
     * Save this license on disk using a template
     * @param folder the Folder where this file will be stored
     */
    public void writeToDisk(File folder){
        File template = new File(core.getLicensesFolder(), "LicenseTemplate.java");
        // no need to continue if it does not exist
        if(template.exists() == false){
            return;
        }
        
        // read the template content
        String content = utils_deprecated.files.readAsString(template);
        
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
        
        // OSI approved or not?
        term1 = "false; // was this license OSI approved or not?";
        content = content.replace(term1, ""
                + approvedOSI()
                + "; // was this license OSI approved or not?");
        
        // do we have license terms to write about?
        term1 = "return \"\"; // the license text";
        content = content.replace(term1, "return "
                //+ "\""
                + getTerms()
                //+ "\""
                + "; // the license text");
        
        
        // prepare the file name that we will write
        String filename = safeText(getId());
        
        File file = new File(folder, filename + ".java");
        
        // final modifications
        content = "package SPDXLL;\n\n" + content;
        // add class name
        content = content.replace("class LicenseTemplate extends License{", 
                "class "+ filename +" extends License{");
        // add date creation details
        content = content.replace("#DATE#", utils_deprecated.time.getDateSPDX());
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
        
        // for debug
        //System.out.println("Writing file: " + file.getAbsolutePath());
        // save everything on disk
        utils_deprecated.files.SaveStringToFile(file, content);
        
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
        result = result.replace("+", "_plus");
        
        return result;
    }

    /**
     * Provides some basic information about the license, applicable terms
     * and other notes that might be relevant
     * @return 
     */
    public String getSummaryHTML() {
        String result = "";
        // add the title
        result += html.h2(getTitle());
        
        result += "OSI Approved: " + approvedOSI().toString();
        
        final String terms = getTerms().replace("\n", "<br>");
        
        if(terms.isEmpty() == false){
            result += html.br
                    + html.br
                    + html.h2("License terms")
                    + "<tt>"
                    + terms
                    + "</tt>";
        }
        
        result = html.div()
                + result
                + html._div;
        
        return result;
    }
    
}
