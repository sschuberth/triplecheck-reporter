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
import main.engine;
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

    // complete list with the recognized extensions
    private final ArrayList<FileExtension> list = new ArrayList();
    // very-light list to speed up extension recognition
    private final ArrayList<String> listIndexes = new ArrayList();
    
    // available when we don't know what extension is applicable
    private final DefaultExtension unknownExtension = new DefaultExtension();
    
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
        // now add this to our indexes
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
        
             
        File folder = engine.getExtensionsFolder();
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".java", 2);
        for(File file : files){   
            // ignore the extensions inside the "unknown" folder
            if(file.getParentFile().getName().contains("unknown")){
                continue;
            }
            
            if(file.getName().equals("template.java")){
                continue;
            }
            
            // get the extension interpreted
            FileExtension temp = (FileExtension) utils.bytecode.getObject(file);
            
            // no need for null values
            if(temp == null){
                continue;
            }
            
            // add it up to our lists
            add(temp);
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
    
    
    
//    /**
//     * Convert from a Formal Extension object to JSON
//     * @param fileExtension The formal extension object
//     * @return              The converted JSON object
//     */
//    private ExtensionType convertToJSON(final FileExtension fileExtension){
//        ExtensionType ext = new ExtensionType();
//        ext.idLong = fileExtension.getIdentifierLong();
//        ext.idShort = fileExtension.getIdentifierShort();
//        ext.language = fileExtension.getLanguage();
//        ext.languages = fileExtension.getLanguages();
//        ext.contentType = fileExtension.getContentType();
//        ext.category = fileExtension.getCategory();
//        ext.description = fileExtension.getDescription();
//        return ext;    
//     }
//   
//    
//    /**
//     * Converts a JSON object onto a more formal extension object
//     * @param input An ExtensionType object
//     * @return      An FileExtension object
//     */
//    private FileExtension convertFromJSON(final ExtensionType input){
//        return new FileExtension(){
//                @Override
//                public Boolean isApplicable(File binaryFile) {
//                    return true;
//                }
//                @Override
//                public Boolean isApplicable(String textFile) {
//                    return true;
//                }
//                @Override
//                public String getDescription() {
//                    return input.description; // file type description
//                }
//                @Override
//                public FileLanguage getLanguage(){
//                    return input.language; // to which language is the file more related?
//                }
//                @Override
//                public String getIdentifierShort() {
//                    return input.idShort;
//                }
//               @Override
//                public ContentType getContentType() {
//                    return input.contentType; // is it a binary or text file?
//                }
//                @Override
//                public FileCategory getCategory() {
//                    return input.category; // does it group under a category?
//                }
//            };
//    }
//    
//    /**
//     * This method reads the available JSON files with the file extension
//     * definitions
//     * @param targetFolder  The folder where *.json files are found
//     */    
//    private void readJsonFiles(File targetFolder) {
//        Gson gson = new Gson();
//        // get all files to read
//        ArrayList<File> files = utils.files.findFilesFiltered(targetFolder, ".json", 10);
//        // interpret them
//        for(File file : files){
//            final String output = utils.files.readAsString(file);
//            final ExtensionType result = gson.fromJson(output, ExtensionType.class);
//            FileExtension extension = convertFromJSON(result);
//            // add this extension to our list
//            add(extension);
//        }
//    }
//    
//    /**
//     * This method generates JSON files from the fileExtension scripts found
//     * in our install. This method is useful to avoid loading these fileExtension
//     * classes using Beanshell.
//     * @param targetFolder      The folder where the *.json files are located
//     */
//    public void generateJsonFiles(File targetFolder) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        int counter = 0;
//        for(FileExtension fileExtension : engine.extensions.getList()){
//            final String Id = fileExtension.getIdentifierShort();
//            // avoid the template
//            if(Id.contains("#")){
//                continue;
//            }
//            // convert the object
//            ExtensionType ext = convertToJSON(fileExtension);
//            // get the string
//            String json = gson.toJson(ext);
//            File file = new File(targetFolder, Id + ".json");
//            utils.files.SaveStringToFile(file, json);
//            counter++;
//        }
//        System.out.println("Processed " + counter + " files");
//    }
//    
//    
    
    
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