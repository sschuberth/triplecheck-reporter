/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: ExtensionControl.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Ensures that we can read all the available file 
 * extensions and generate optimized ways of processing their information.
 * </text> 
 */

package FileExtension;

import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import main.core;
import script.FileExtension;
import script.log;
import spdxlib.ContentType;


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ExtensionControl {

    public static HashMap<String, FileExtension>
            list = new HashMap();
    
    // the public list of extensions that can be read as source code files
    private String 
            textList = "",
            ignoreList = "",
            fullList = "";
            ;
    
    
    /**
     * Public constructor
     */
    public ExtensionControl(){
        //addExtensions();
    }

    /**
     * Add a single extension to our list
     */
    public void add(FileExtension extension){
        list.put(extension.getIdentifierShort(), extension);
    }
    
    /**
     * Add up all the extensions that we have available on disk
     */
    public void addExtensions() {
        // clear up the list to avoid duplicates
        list.clear();
        File folder = core.getExtensionsFolder();
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".java", 2);
        for(File file : files){
            core.script.runJava(file, null, is.extension);
        }
        // output some statistics about the number of extensions registered
        log.write(is.INFO, "Extensions recognized: %1", "" + list.size());
        //TODO we are still listing the template class as a file type.
    
        buildTextList();
    }

    /**
     * Create a list of acceptable file extensions to be read as text files
     */
    private void buildTextList() {
        String 
                tempTextList = "",
                tempIgnoreList = "",
                tempFullList = "";
                
        // iterate throught the list of extensions, get the text ones
        for(FileExtension extension : list.values()){
            if(extension.getContentType() == ContentType.TEXT){
                tempTextList += ">"+extension.getIdentifierShort();
                continue;
            }else {
                tempIgnoreList += ">"+extension.getIdentifierShort();
            }
            tempFullList += ">"+extension.getIdentifierShort();
        }
        // write back our changes
        textList = tempTextList + ">";
        ignoreList = tempIgnoreList + ">";
        fullList = tempFullList + ">";
    }
    
    
    /**
     * Verifies if we have a given extension in our list
     * @param extension
     * @return 
     */
    public Boolean has(String extension){
        return list.containsKey(extension);
    }
    
    public FileExtension get(String extension){
        return list.get(extension);
    }
    
    
    public Boolean isIgnored(String extension){
        if(list.containsKey(extension)==false){
            return true;
        }  
        
        if(list.get(extension).getContentType() == ContentType.TEXT)
        return false;
        
        return true;
    }
    
    
}
