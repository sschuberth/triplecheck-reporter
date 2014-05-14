/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
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
import main.core;
import script.FileExtension;
import script.log;


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ExtensionControl {

    private final ArrayList<FileExtension> list = new ArrayList();
    
    /**
     * Public constructor
     */
    public ExtensionControl(){
        addExtensions();
    }

    /**
     * Add a single extension to our list
     * @param extension A class extension
     */
    public void add(FileExtension extension){
        if(extension == null){
            return;
        }
        list.add(extension);
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
            FileExtension result = (FileExtension) script.exec.runJava(file, "FileExtension");
            if(result != null){
                list.add(result);
            }
        }
        // output some statistics about the number of extensions registered
        log.write(is.INFO, "Extensions recognized: %1", "" + list.size());
    }
  
    /**
     * Verifies if we have a given extension in our list
     * @param extension
     * @return 
     */
    public Boolean has(final String extension){
        for(FileExtension ext : list){
            final String shortId = ext.getIdentifierShort();
            if(utils.text.equals(shortId, extension)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Provide back the extension object that we have on our list
     * @param extension The short identifier for the file extension
     * @return          The class associated with this extension
     */
    public FileExtension get(String extension){
        for(FileExtension ext : list){
            final String shortId = ext.getIdentifierShort();
            if(utils.text.equals(shortId, extension)){
                return ext;
            }
        }
        return null;
    }
    
    
    /**
     * Given a file, return the associated extension object
     * @param file  the file on disk
     * @return      null if we don't know the file, or the object when recognized
     */
    public FileExtension get(File file){
        // preflight check
        if(file == null){
            return null;
        }
        String extension = file.getName();
        if(extension.contains(".")==false){
            return null;
        }
        // get the last string after the dot
        extension = extension.substring(extension.lastIndexOf(".")+1).toLowerCase();
        // return the type of extension object
        return get(extension);
    }

    public ArrayList<FileExtension> getList() {
        return list;
    }
    
    
    
    
}
