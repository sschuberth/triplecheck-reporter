/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-05-15T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GetLicenses.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Crawls the official SPDX License List (LL) page
 * to generate an enum that is optimized for performance </text>
 */

package spdxlib.generators;

import java.io.File;
import java.util.ArrayList;
import main.core;
import spdxlib.License;


/**
 *
 * @author Nuno Brito, 25th of April 2014 in Darmstadt, Germany
 */
public class GetLicensesEnum {

    static final String 
            addressLL = "http://spdx.org/licenses/",
            addressGit = "http://git.spdx.org/?p=license-list.git;a=blob_plain;f=";
    
    
    static ArrayList<License> licenses = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listLicenses();
        System.exit(1981);
    }


    /**
     * Visits the official SPDX website to list all the available triggers
     */
    private static void listLicenses() {
        // first thing, get the webpage
        String content = utils_deprecated.internet.webget(addressLL);
        
        if((content == null) || (content.isEmpty())){
            System.err.println("Failed to access website at " + addressLL);
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
            licenses.add(license);
//            // time to write this license to disk
//            writeLicenseToEnum(license);
//            System.out.println(license.getId() + " -> " + license.getTitle());
        }
        
        // now create the enum text
        generateEnumText();
        
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
              <td><a href="./CDDL-1.0" rel="rdf:_41">
              Common Development and Distribution License 1.0</a></td>
              <td about="./CDDL-1.0" typeof="spdx:License">
              <code property="spdx:licenseId">CDDL-1.0</code></td>
              <td align="center">Y</td>
              <td><a href="./CDDL-1.0#licenseText">License Text</a></td>
            </tr>  
        */
        
        // is it approved by the OSI?
        final Boolean approvedOSI = item.contains("<td align=\"center\">Y</td>");
        
        // get the license title
        int i3 = item.indexOf(m3);
        String t1 = item.substring(i3);
        int i4 = t1.indexOf(">") + 1;
        int i5 = t1.indexOf("</a>");
        t1 = t1.substring(i4, i5);
        t1 = utils_deprecated.html.decodeEntities(t1);
        final String licenseTitle = t1;
     
        
        // get the license short Id
        int i1 = item.indexOf(m1);
        String temp = item.substring(i1); // remove initial text up to m1
        int i2 = temp.indexOf(m2); // get the last part
        final String licenseId = temp.substring(12, i2); // get the SPDX id for this item

        // uncomment when you need to debug this method
//         if("PHP-3.01 > CC-BY-NC-3.0 > AGPL-3.0".contains(licenseId)==false){
//             return null;
//        }
        
        // get the license text
        String test = "";
//        try{
//            // let's test to see if the license terms can be read
//            test = getLicenseTerms(licenseId);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        final String licenseTerms = test;
        
        
        
        // create the license object
        License license = new License(){
            @Override
            public Boolean approvedOSI(){
                return approvedOSI; // was this license OSI approved or not?
            }
            @Override
            public String getId(){
                return licenseId; // short and unique id
            }
            @Override
            public String getTitle(){
                return licenseTitle; // full text title
            }
            @Override
            public String getTerms(){
                return licenseTerms; // full text title
            }
            
            
        };
        
        // write the license on disk
//        writeLicenseToDisk(license);
//        System.out.println(license.getId() + " -> " + license.getTitle());
        
        // all done
        return license;
    }

    
    /**
     * Adds a new line to our source code being translated from a text file
     * @param line  The line to translate
     * @return      A line ready to be added on the source code
     */
    private static String addLine(String line, String extra){
        String result = line;
        result = result.replace("\n", "");
        result = result.replace("\t", "");
        result = result.replace("\r", "");
        
        result = "        + \"" 
                + result.replace("\"", "\\\"") 
                + extra + "\"\n";
        return result;
    }
    
    /**
     * This method will retrieve the text version of the license terms as
     * available on SPDX.org
     * @return 
     */
    private static String getLicenseTerms(String Id){
        
        
        String address = addressGit + Id + ".txt";
        // preflight checks
        address = address.replace("+", "%2B"); // plus is not accepted on the URL
        
        // get the text file
        String result = utils_deprecated.internet.getTextFile(address);
        
        //System.out.println("GL188: " + address);
        
        //final String nextLine = "\\n\"\n        + \"";
        
        // do a nice wrap effect to allow users to read the terms on the code
        String[] lines = result.split("\n");
        String output = "";
        int limit = 80;
        // iterate through each line
        for(String line : lines){
            // when it is too big, time to break into smaller lines
            if(line.length() > limit){
                // while the line is bigger than what we want, cut it further
                while(line.length() > limit){
                    // add a broken line
                    output += addLine(line.substring(0, limit), "");
                            //line.substring(0, limit).replace("\"", "\\\"")
                            //+ nextLine;
                    
                    // iterate for the next line
                    if(line.length() > limit){
                        line = line.substring(limit);
                    }
                }
                // add whatever was left from the cutting operation
                output += addLine(line, "\\n");
                        //line.replace("\"", "\\\"") + nextLine;
            }else{
                // just add the normal line
                output += addLine(line, "\\n");
                //line.replace("\"", "\\\"") + nextLine;
            }
        }
        
        result = output.substring(10);
        return result;
    }
    
    
    
    
    
//    /**
//     * Saves this specific license to disk
//     * @param license 
//     */
//    private static void writeLicenseToDisk(License license) {
//        // get the license list folder
//        File folder = new File(core.getLicensesFolder(), 
//                definitions.folder.spdxLL);
//        
//        // write this license to disk
//        license.writeToDisk(folder);
//    }
    
    /**
     * Saves this specific license to disk
     * @param license 
     */
    private static void writeLicenseToEnum(License license) {
        // get the license list folder
        File folder = new File(core.getLicensesFolder(), 
                definitions.folder.spdxLL);
        
        String enumID = convertToEnum(license.getId());
        
        // write this license to disk
    }

    /**
     * Convert the SPDX identifier of a license into an ENUM
     * @param id
     * @return 
     */
    private static String convertToEnum(String id) {
        String result = id;
        result = result.replace("-", "_");
        result = result.replace(".", "_");
        result = result.replace("+", "_plus");
        return result;
    }

    private static void generateEnumText() {
        String enumTypes = "";
        String enumTitles = "";
        String enumIds = "";
        String enumOSI = ""; // OSI Approved or not?
        
        
        String enumLast = "";
        // iterate all information that we have
        String template = 
                  "          "
                + "          "
                + "          "
                + "          "
                ;
        for(License license: licenses){
            String id = convertToEnum(license.getId());
            String padding = template.substring(id.length());
            // do the enum types
            enumLast = "\n\t" + id +","+ padding + "// " + license.getTitle();
            enumTypes +=  enumLast;
            // get the translation to titles
            enumTitles += "\n\tcase " + id + ": return \""
                    + license.getTitle().replace("\"", "\\\"")
                    + "\";";
            // get the small identifiers
            enumIds += "\n\tcase " + id + ": return \""
                    + license.getId()
                    + "\";";
            // OSI approved?
            enumOSI += "\n\tcase " + id + ": return "
                    + license.approvedOSI().toString()
                    + ";";
        }
        
        
        // do some correction for the last item
        String correctedText = enumLast.replace(",", ";");
        enumTypes = enumTypes.replace(enumLast, correctedText);
        
         // enum types
        enumTypes = 
                  "public enum LicenseType {\n"
                + "\t" + enumTypes.substring(2) + "\n";
        // titles
        enumTypes +=
                  "\n\n\tpublic String toTitle(){\n"
                + "        switch(this){"
                + enumTitles
                + "\n\tdefault: return \"Not recognized\";\n\t\t}\n\t}";
        
        // ids
        enumTypes +=
                  "\n\n\tpublic String toId(){\n"
                + "        switch(this){"
                + enumIds
                + "\n\tdefault: return \"Not recognized\";\n\t\t}\n\t}";
        
        // Was this license OSI approved?
        enumTypes +=
                  "\n\n\tpublic boolean isApprovedOSI(){\n"
                + "        switch(this){"
                + enumOSI
                + "\n\tdefault: return false;\n\t\t}\n\t}";
        
        
        enumTypes += "\n}";
        
        String header = 
                "/*\n" +
                " * SPDXVersion: SPDX-1.1\n" +
                " * Creator: Person: Nuno Brito\n" +
                " * Created: "+utils_deprecated.time.getDateSPDX()+"\n" +
                " * LicenseName: EUPL-1.1-without-appendix\n" +
                " * FileName: LicenseType.java \n" +
                " * FileCategory: SOURCE\n" +
                " * FileCopyrightText: <text> Copyright (c) "
                + utils_deprecated.time.getCurrentYear()+", Nuno Brito </text>\n" +
                " */\n\n";
        
        // add up our header
        enumTypes = header + enumTypes;
        
        System.out.println(enumTypes);
        File output = new File(core.getMiscFolder(), "LicenseType.java");
        utils_deprecated.files.SaveStringToFile(output, enumTypes);
        
    }
    
}
