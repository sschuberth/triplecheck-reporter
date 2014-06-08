/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-07T22:51:14Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: CompSummary.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Provides a summary about the components that are used
 * inside an SPDX document.</text> 
 */

package spdxlib.summary;

import comp.Component;
import java.util.HashMap;
import java.util.Map;
import main.core;
import spdxlib.FileInfo2;
import spdxlib.SPDXfile2;
import utils.html;


/**
 *
 * @author Nuno Brito, 7th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class CompSummary {

    private SPDXfile2 spdx;
    private final int max = 10;
    
    public CompSummary(SPDXfile2 input){
        spdx = input;
    }
    
    /**
     * Goes throught all the file nodes on this document and output a list
     * of components and respective files
     * @return  An HTML report ready for end-users
     */
    public String getComponentSummary() {
        String result = "";
        HashMap<String, Integer> components = new HashMap();
        int counterNull = 0;
        // iterate all files
        for(FileInfo2 fileInfo : spdx.getFiles()){
            // get the component name
            String component = fileInfo.getFileComponent();
            // avoid the files without a component specified
            if(component == null){
                // increase the counter to later use this value
                counterNull++;
                continue;
            }
            // process all the rest, have we already indexed this component?
            if(components.containsKey(component)){
                // then just increase its value
                int value = components.get(component);
                value++;
                components.put(component, value);
            }else{
            // first time doing this, add a new one
                components.put(component, 1);
            }
        }
        
        // now do the output messages
        result += html.h2("Components used in " + spdx.getId());
       
        if(counterNull == spdx.getFiles().size()){
        // no components were found
            result = html.div()
                    + result
                    + html.textGreyAligned("No files associated to any components (yet)")
                    + html._div;
            return result;
        }
        // add the group of non-categorized files
//        if(counterNull > 0){
//            components.put("Not associated to component", counterNull);
//        }
        
        
        
        // sort these groups according to their size 
        Map<String, Integer> map = ThirdParty.MiscMethods.sortByComparator(components);
        
        // now iterate each group
        for(String componentID : map.keySet()){
            
            int count = map.get(componentID);
            
            Component component = core.components.get(componentID);
            
            // what happens if the component was not found?
            if(component == null){
                System.err.println("SP1055 - Null component: " + componentID);
                continue;
            }
            
            // initialize the file tracking
            String fileList = "";
            int thisCounter = 0;
            
            // iterate through all files in our spdx
            for(FileInfo2 fileInfo : spdx.getFiles()){
                // if it belongs to our component
                if(utils.text.equals(fileInfo.getFileComponent(), componentID)){
                    thisCounter++;
                    if(thisCounter < max){
                        // add it to our list
                        fileList = fileList.concat(
                                "<i>" 
                                + fileInfo.getFileName()
                                + "</i>"
                                + html.br);
                    }
                }
            }
            // were more than 10 files found?
            if(thisCounter >= max){
                fileList = fileList.concat(
                                "<i> ..more " 
                                + utils.text.pluralize(thisCounter - max, "file")
                                + " on this list.."
                                + "</i>"
                                + html.br);
            } 
            
            if(count==1){
                fileList = "File: " + fileList;
            }else
                if(count > 1){
                     fileList = "Files: " + html.br + fileList;
                }
            
            
            // all good
            result += ""
                    + html.h2(component.getTitle() 
                        + " (" 
                        + utils.text.pluralize(count, "file")
                        + ")")
                    + addIfNotEmpty("Description", component.getDesc(), true)
                    + addIfNotEmpty("Declared license", component.getLic(), false)
                    + addIfNotEmpty("Main author(s)", component.getAuthors(), false)
                    + addLinkIfNotEmpty("Reference URL", component.getReferenceURL())
                    + addLinkIfNotEmpty("Download URL", component.getDownloadURL())
                    + fileList
                    + html.br
                    + html.line
                    ;
        }
        
        
        // give a short report about non-assigned files
        if(counterNull > 0){
            result += getListNonAssignedFiles();
        }
        
        // add the spacing
        result = html.div()
                + result
                + html._div;
        
        
        return result;
    }
  
    /**
     * Provides an HTML list of the files that are NOT associated to a component
     * @return An HTML portion of text ready for display to end-user
     */
    private String getListNonAssignedFiles(){
        int counterNull= 0;
        String fileList = "";
            
        // iterate all files to find the ones without a component assigned
        for(FileInfo2 fileInfo : spdx.getFiles()){
            // get the component name
            String component = fileInfo.getFileComponent();
            // avoid the files without a component specified
            if(component == null){
                // increase the counter to later use this value
                counterNull++;
                // add new names while the list is short
                if(counterNull < max){
                        // add it to our list
                        fileList = fileList.concat(
                                "<i>" 
                                + fileInfo.getFileName()
                                + "</i>"
                                + html.br);
                    }
                // all done, move to the next
                continue;
            }
        }
    
        // were more than 10 files found?
            if(counterNull >= max){
                fileList = fileList.concat(
                                "<i> ..more " 
                                + utils.text.pluralize(counterNull - max, "file")
                                + " on this list.."
                                + "</i>"
                                + html.br);
            } 
            
            // now do the pretty output
            if(counterNull==1){
                fileList = "File: " + fileList;
            }else
                if(counterNull > 1){
                     fileList = "Files: " + html.br + fileList;
                }
        
            
         String result =  html.h2("Uncategorized files: " + counterNull);
            
        // all done
        return result + fileList
                + html.br
                + html.br;
    }
    
    
    /**
     * Add the key/value text when the value is not empty (or null)
     * @param key       The title
     * @param value     The value
     */
    private String addIfNotEmpty(final String key, final String value, boolean italic){
        if(value == null || value.isEmpty()){
            return "";
        }else{
            String result = value;
            if(italic){
                result = "<i>" + value + "</i>";
            }
            return key + ": " + result + html.br;
        }
    }

    /**
     * Add the key/value text when the value is not empty (or null)
     * @param key       The title
     * @param value     The value
     */
    private String addLinkIfNotEmpty(final String key, final String value){
        if(value == null || value.isEmpty()){
            return "";
        }else{
            return key + ": " + html.link(value, value) + html.br;
        }
    }

    
}
