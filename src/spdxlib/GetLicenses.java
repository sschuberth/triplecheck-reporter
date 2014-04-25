/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GetLicenses.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Crawls the official SPDX License List (LL) page
 * to generate a new set of templates. </text>
 */

package spdxlib;

import java.io.File;
import main.core;


/**
 *
 * @author Nuno Brito, 25th of April 2014 in Darmstadt, Germany
 */
public class GetLicenses {

    static final String address = "http://spdx.org/licenses/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listLicenses();
    }


    /**
     * Visits the official SPDX website to list all the available triggers
     */
    private static void listLicenses() {
        // first thing, get the webpage
        String content = utils.internet.webget(address);
        
        if((content == null) || (content.isEmpty())){
            System.err.println("Failed to access website at " + address);
            return;
        }
        
        // define the initial and final pointers to remove redundant information
        String pointerInitial = "<tbody>";
        String pointerFinal = "</tbody>";
        String breakLine = "</tr>";
        
        // get the origin where 
        int pos1 = content.indexOf(pointerInitial);
        int pos2 = content.indexOf(pointerFinal);
        
        // now create the raw items for processing
        String[] rawItems = content.substring(pos1, pos2).split(breakLine);
        
        // now iterate through each item to be processed
        for(String item : rawItems){
            License license = processItem(item);
            // no need to continue if empty
            if(license == null){
                continue;
            }
            // time to write this license to disk
            writeLicense(license);
        }
        
        
    }

    /**
     * Given the raw contents of an item 
     * @param item      the original item from the web page
     */
    private static License processItem(String item) {
        
        
        String m1 = ":licenseId";
        String m2 = "</code>";
        String m3 = "rel=\"rdf:";
        
        // no need to continue if it has no needed keywords
        if(item.contains(m1)== false){
            return null;
        }
                   
        /**
         * Example of what we are expecting to process
            <tr>
            <td><a href="./ClArtistic" rel="rdf:_37">Clarified Artistic License</a></td>
            <td about="./ClArtistic" typeof="spdx:License">
            <code property="spdx:licenseId">ClArtistic</code></td>
            <td align="center"></td>
            <td><a href="./ClArtistic#licenseText">License Text</a></td>
            </tr>       
        */
        
        // get the license title
        int i3 = item.indexOf(m3);
        String t1 = item.substring(i3);
        int i4 = t1.indexOf(">") + 1;
        int i5 = t1.indexOf("</a>");
        t1 = t1.substring(i4, i5);
        t1 = utils.html.decodeEntities(t1);
        final String licenseTitle = t1;
     
        
        // get the license short Id
        int i1 = item.indexOf(m1);
        String temp = item.substring(i1); // remove initial text up to m1
        int i2 = temp.indexOf(m2); // get the last part
        final String licenseId = temp.substring(12, i2); // get the SPDX id for this item

        // create the license object
        License license = new License(){
            @Override
            public Boolean approvedOSI(){
                return false; // was this license OSI approved or not?
            }
            @Override
            public String getId(){
                return licenseId; // short and unique id
            }
            @Override
            public String getTitle(){
                return licenseTitle; // full text title
            }
        };
        
        // write the license on disk
        writeLicense(license);
        //System.out.println(license.getId() + " -> " + license.getTitle());
        // all done
        return license;
    }

    /**
     * Saves this specific license to disk
     * @param license 
     */
    private static void writeLicense(License license) {
        // get the license list folder
        File folder = new File(core.getLicensesFolder(), 
                definitions.folder.spdxLL);
        
        // write this license to disk
        license.writeToDisk(folder);
    }
    
}
