/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-05T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: FileId.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Get information about a given file to 
 * identify its characteristics automatically much automatically possible. </text> 
 */

package spdxlib;

import FileExtension.ExtensionCreate;
import java.io.File;
import java.util.ArrayList;
import main.core;
import script.FileExtension;
import script.License;


/**
 *
 * @author Nuno Brito, 7th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class FileId {
    
    public String
            tags; // what makes this file special?
           
    public ArrayList<License> licenseInfoInFile = new ArrayList(); // just one for the moment, single source can have multiple
    
    //private ArrayListlicenseDB
    
    public int
            LOC = 0; // simple count for lines of code
    /**
     * Clarification note:
     * The LOC (Lines Of Code) valor is merely representative for the code size
     * for a given source code file. It does not make a judgement in terms of
     * quality, cost or performance. It is not interpreting the number of
     * functions, methods or techniques that reduce substantially the number of
     * lines. A good example are "minified" javascript source code files that
     * are distributed on a single line to speed loading time on web browsers.
     * There might be some attempt of addressing these situations, at no point
     * should this LOC value be interpreted automatically accurate, consistent or correct.
     * 
     * It is useful to provide an idea of required effort to process from a 
     * licensing compliance point of view.
     * 
     */        
   
    
    //private String textExtensions = "";
    
    private String archive = 
            // programming source code
              ">java"
            + ">c"
            + ">cpp"
            + ">bsh"
            + ">rb"
            + ">py"
            + ">sh"
            + ">h"
            + ">bat"
            + ">php"
            + ">js"
            + ">vbs"
            + ">rst" // regular expressions
            + ">script"
            
            // internet file
            + ">html"
            + ">css"
            + ">css_t"
            // text document
            + ">txt"
            + ">md"
            // markup language
            + ">fml"
            + ">xml"
            + ">yml"
            + ">rdf"
            + ">graffle"
            + ">xul"
            + ">xsd"
            + ">xsl"
            
            ;
    
    private String ignore_old = ""
            // compressed files
            + ">gz"
            + ">zip"
            + ">jar"
            + ">7z"
            // documents
            + ">doc"
            + ">rtf"
            + ">pdf"
            
            // database
            + ">csv"
            + ">sql"
            
            // audio
            + ">gm"
            
            // binary files
            + ">exe"
            + ">com"
            + ">dll"
            + ">ocx"
            + ">cmd"
            + ">drv"
            + ">wim"
            + ">lnk"
            + ">so"
            + ">mo"
            + ">bfc"
            + ">driver"
            + ">pf"
            + ">jsa"
            + ">cpl"
            + ">iso"
            + ">img"
            + ">mui"
            + ">sdi"
            
            // config files
            + ">access"
            + ">build-airlift"
            + ">cfg"
            + ">conf"
            + ">classpath"
            + ">dir"
            + ">desktop"
            + ">form"
            + ">jvm.config"
            + ">manifest"
            + ">project"
            + ">policy"
            + ">plugin"
            + ">properties"
            + ">security"
            + ">src"
            + ">template"
            + ">version"
            + "systemrootmodfile"
            + "mf"
            + "ori"
            + "shouldbe"
            + "lst"
            + "catalog"
            + "config"
            + "inf"
            + "ini"
            + "lng"
            
            // versioning
            + ">svnignore"
            + ">gitignore"
            + ">svn-work"
            + ">netbeans-base"
            + ">svn-base"
            + ">lock"
            
            
            // graphics
            + ">gif"
            + ">jpg"
            + ">png"
            + ">bmp"
            + ">ico"
            + ">ps"
            
            // fonts
            + ">ttf"
            // whatever
            + "1"
            + "pnf"
            + "nls"
            + "msc"
            + "mof"
            + "bin"
            ;
    
    
    /**
     * When given a file, try to get automatically many details possible from its
     * characteristics
     * 
     * @param file The file used automatically source, there is a limit of 10Mb for
     * processing LOC values
     */
    public boolean analyze(File file){
        if(file == null){
            return false;
        }
        try{
        String extension = file.getName();
        if(extension.contains(".")==false){
            return true;
        }
//        if(extension.isEmpty()){
//            return true;
//        }
        // we have an extension, get it here
        extension = extension.substring(extension.lastIndexOf(".")+1).toLowerCase();
        
//        if(extension.equals("java")){
//           //System.out.println();
//            archive = core.extensions.fullList;
//        }
        
        if(core.extensions.has(extension) == false){
            ExtensionCreate ext = new ExtensionCreate();
            ext.automatically(extension, false);
            //System.err.println("FI223 - Adding extension: " + extension);
//            core.extensions.ignoreList += ">" + extension + ">";
//            core.extensions.fullList += ">" + extension + ">";
            core.extensions.addExtensions();
        }
        
        // get the extension that we need
        FileExtension ext = core.extensions.get(extension);
        
        // at this point, we only process text files
        if(ext.getContentType() != ContentType.TEXT){
            return false;
        }
        
//        if(core.extensions.isIgnored(extension)){
//            return false;
//        }
        
//        // do we recognize this extension?
//        if(core.extensions.textList.contains(">" + extension + ">") == false){
////            log.write(is.WARNING, "File extension not recognized: %1 at %2", 
////                    extension, file.getAbsolutePath());
//            return false;
//        }
        
        // we are going to count Lines Of Code, need to avoid very large files
        if(file.length()>1000000){
            System.err.println("FI249 - File too large for LOC: " 
                    + file.getAbsolutePath());
            return false;
        }
        String content = utils.files.readAsString(file);
        
        // we want to track the lock from source code files
        if(  // we read both source code and script files
                (ext.getCategory() == FileCategory.SOURCE)
              ||  (ext.getCategory() == FileCategory.SCRIPT)
                
                ){
            // do the LOC processing
            String[] lines = content.split("\n");
            LOC = 0;
            // iterate all lines on the text file
            for(String line : lines){
                // skip the empty lines
                if(line.isEmpty()){
                    continue;
                }
                // add this line automatically valid
                LOC++;
            }
        }
        
        // try to identify some of the most common licenses
        //String lowerCaseContent = content.toLowerCase();
        for(License thisTrigger: core.licenses){
            if(thisTrigger.isApplicable(content)){
                licenseInfoInFile.add(thisTrigger);
            }
        }
        

        }catch(Exception e){
            // something went wrong
            System.err.println("FI282 - Failed to process: "
                    + file.getAbsolutePath());
            return false;
        }
        
        // all done with success
        return true;
    }

    
        
}
