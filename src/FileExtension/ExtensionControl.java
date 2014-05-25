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
import spdxlib.ContentType;
import spdxlib.FileCategory;
import spdxlib.FileLanguage;


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ExtensionControl {

    private final ArrayList<FileExtension> list = new ArrayList();
    private final DefaultExtension unknownExtension = new DefaultExtension();
    
    
    private final ArrayList<String> listIndexes = new ArrayList();
    
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
        listIndexes.add(extension.getIdentifierShort());
    }
    
    /**
     * Add up all the extensions that we have available on disk
     */
    public void addExtensions() {
        // clear up the list to avoid duplicates
        list.clear();
        listIndexes.clear();
        File folder = core.getExtensionsFolder();
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".java", 2);
        for(File file : files){
            if(file.getParentFile().getName().contains("unknown")){
                continue;
            }
            FileExtension result = (FileExtension) script.exec.runJava(file, "FileExtension");
            if(result != null){
                list.add(result);
                listIndexes.add(result.getIdentifierShort());
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
        for(String ext : listIndexes){
            if(utils.text.equals(ext, extension)){
                return true;
            }
        }
//       for(FileExtension ext : list){
//            final String shortId = ext.getIdentifierShort();
//            if(utils.text.equals(shortId, extension)){
//                return true;
//            }
//        }
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
        return unknownExtension;
    }
    
    public FileExtension get(int extensionIndex){
        return list.get(extensionIndex);
    }

    public FileExtension getUnknownExtension() {
        return unknownExtension;
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

    /**
     * Returns the index number where this extension is placed inside our array.
     * Otherwise returns -1 when the extension was not found
     * @param extension     The string extension (without the dot) that we want
     * to find
     * @return              The number where the extension object is placed in
     * our internal array
     */
    public int getIndex(String extension) {
        return listIndexes.indexOf(extension);
    }
}


/**
 *  This class is the one provided whenever we stumble on a file extension
 * that is not present in our list.
 */
class DefaultExtension extends FileExtension{
     @Override
    public Boolean isApplicable(File binaryFile) {
        return true;
    }
    @Override
    public Boolean isApplicable(String textFile) {
        return true;
    }
    @Override
    public String getDescription() {
        return null; // file type description
    }
    @Override
    public FileLanguage getLanguage(){
        return FileLanguage.UNSORTED; // to which language is the file more related?
    }
    @Override
    public String getIdentifierShort() {
        return "";
    }
   @Override
    public ContentType getContentType() {
        return ContentType.UNKNOWN; // is it a binary or text file?
    }
    @Override
    public FileCategory getCategory() {
        return FileCategory.UNKNOWN; // does it group under a category?
    }
    
}