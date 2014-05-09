/*
 * SPDXVersion: SPDX-1.1
 * DocumentCreate: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * DocumentCreate: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: DocumentCreate.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Creates an SPDX document from a given source </text> 
 */

package spdxlib;

import definitions.definition;
import definitions.id;
import definitions.is;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import main.core;
import script.FileExtension;
import script.Trigger;
import script.log;
import ssdeep.ssdeep;


/**
 *
 * @author Nuno Brito, 1st of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class DocumentCreate {

    public boolean showDebugMessages = false;
    
    // settings to be changed when necessary
    public String 
            versionSPDX = "SPDX-1.2",
            licensePackage = "CC-BY-4.0",
            creatorSPDX = "TripleCheck " + core.version;
    
    
    public String 
            // official field names
            PackageName = null,
            PackageLicenseConcluded = "NOASSERTION",
            packageDownloadLocation = "NOASSERTION",
            // other things
            output // where we store the content written to a text file
            ;
    
    
    
    boolean isOk = false;
   
    public ArrayList<File> files;
    
    public boolean isProcessing;
    public int 
            filesToProcess = 0, 
            filesProcessed = 0,
            lastCounter = 0;
    
    public File file;
    
     /**
     * Has this document been correctly generated?
     * @return Yes or No
     */
    public Boolean isOk(){
        return isOk;
    }
    
    /**
     * Creates a new SPDX document based on a given source code folder
     * @param folderSourceCode  where the source code files are located
     * @return the name of the resulting SPDX document. Null is this fails.
     */
    public String create(File folderSourceCode){
        // signal our work start
        isProcessing = true;
        isOk = false;
        // preflight checks
        if(folderSourceCode == null){
            System.err.println("ND01 - No folder defined as source for SPDX");
            isProcessing = false;
            return null;
        }
        
        debug("Folder to use: " + folderSourceCode.getAbsolutePath());
        
        // get the files from the target source code folder
        files = utils.files.findFiles(folderSourceCode);
        // no need to continue if no files were found
        if((files == null) || (files.isEmpty())){
            System.err.println("ND96 - No files were found for creating SPDX");
            isProcessing = false;
            return "";
        }  
        // update our counter
        filesToProcess = files.size();
        
        debug("Number of files to process: " + files.size());
        
        
        // where we shall store this SPDX document 
        File folderProduct = core.getProductsFolder();
        // assign the PackageName for this document
        String filename = folderSourceCode.getName();
        if(PackageName != null){
            filename = PackageName;
        }
        
        String textDate = getDateSPDX();
        
        
        filename = filename + ".spdx";
        
        output =  
                  addParagraph("SPDX Document Information")
                + addText("SPDXVersion: " + versionSPDX)
                + addText("DataLicense: " + licensePackage)
                + "\n"
                
                + addParagraph("Creation Information")
                + addText("Creator: " + System.getProperty("user.name"))
                + addText("Creator: Tool: " + creatorSPDX)
                + addText("Created: " + textDate)
                + "\n"
                
                + addParagraph("Package Information")
                + "PackageName: "  + folderSourceCode.getName()
                + "\nPackageFileName: " + folderSourceCode.getName()
                + "\nPackageDownloadLocation: " + packageDownloadLocation
                + "\nPackageLicenseConcluded: " + PackageLicenseConcluded
                + "\n"
                + "\n"
                + addParagraph("File Information")
                ;
        
        
        log.write(is.INFO, "Preparing to process %1 files", "" + files.size());
        
        // iterate through each file
        for(File thisFile : files){
            // compute our SSDEEP hashes
            ssdeep test = new ssdeep();
            String ssdeep;
            try {
                ssdeep = test.fuzzy_hash_file(thisFile);
            } catch (IOException ex) {
                ssdeep = "NOASSERTION";
            }
            
            // path of this file
            String filePath = thisFile.getAbsolutePath();
            filePath = filePath.replace(folderSourceCode.getAbsolutePath(), "");
            filePath = filePath.replace("\\", "/");
            filePath = "." + filePath.replace(thisFile.getName(), "");
            
            // the size of this file
            String fileSize = utils.files.humanReadableSize(thisFile.length());
            
            // only add up this info when making the size human readable
            if(thisFile.length() > 1000){
                   fileSize +=  " ("+ thisFile.length() +" bytes)";
            }
            
            // do the file identification
            String LOC = "";
            FileId fileId = new FileId();
            Boolean fileWasAnalysed = fileId.analyze(thisFile);
            // get the value for lines of COD
            if(fileWasAnalysed){
                if(fileId.LOC > 0){
                    LOC = "FileLOC: " + fileId.LOC;
                }
            }
            
            
            
            // add the licenseInfoInFile information in file
            String triggerInfoInFile = "";
            if((fileWasAnalysed)&&(fileId.licenseInfoInFile.size()>0)){

                // iterate through each trigger or any other trigger needed
                for(Trigger triggerInfo : fileId.licenseInfoInFile)
                triggerInfoInFile += addText(""
                        + triggerInfo.getResult()
                        );
            }
            
            //TODO There is no OS independent way to get date of file creation
            // at least one Windows and Linux should be added when available
           // String fileModified = utils.time.getTimeFromLong(file.lastModified());
            
            String temp =
                     // addSection("File: " + thisFile.getName())
                    //+ 
                    "\n"
                    + addText("FileName: "
                            // in my conscience, path has no place on file name
                            // and only makes difficult to identify the name
                            // uncomment for strict compatibility with SPDX
                            + filePath + thisFile.getName()
                            //+ thisFile.getName()
                    )
                    // not needed if standard is followed
                    //+ addText("FilePath: " + filePath)
                    + addText("FileType: " 
                        + doFileType(fileId))
                    + addText("FileChecksum: SHA1: "
                        + utils.Checksum.generateFileChecksum("SHA-1", thisFile))
                    + addText("FileChecksum: SHA256: " 
                        + utils.Checksum.generateFileChecksum("SHA-256", thisFile))
                    + addText("FileChecksum: MD5: "
                        + utils.Checksum.generateFileChecksum("MD5", thisFile))
                    + addText("FileChecksum: SSDEEP: " + ssdeep)
                    + addText("FileSize: " + fileSize)
//                    + addText("FileModified: " + getFileDateSPDX(thisFile))
                    
                    + addText(LOC)
                    //+ addText("FileLastModified: " + fileModified)
                    + triggerInfoInFile
                    //+ "\nLicenseConcluded: NOASSERTION"
                    //+ "\nLicenseInfoInFile: NONE"
                    //+ "\nFileCopyrightText: NONE"
                    ;
            
            output = output + temp;
            // increase the counter
            filesProcessed++;
        }
        
        // create the file pointer
        File document = new File(folderProduct, filename);
        utils.files.SaveStringToFile(document, output);
        
        debug("Saved result to file: " + document.getAbsolutePath());
        
        file = document; // keep this around for future reference

        // save the location of the source code for this document
        core.settings.write(id.SOURCEFOLDER + file.getName(), 
                folderSourceCode.getAbsolutePath());
        
        // all done
        doFinish();
        return filename;
    }
    
    
    /**
     * This method returns the expected value for "FileType" inside an SPDX
     * document.
     */
    private String doFileType(FileId fileId){
        /**
         * Purpose: This field provides information about the type of file
         * identified. This information can be determinative of license
         * compliance requirements. The options to populate this field are
         * limited to:
         *
         * (a) SOURCE if the file is human readable source code
         *       (.c, .html, etc.);
         * (b) BINARY if the file is a compiled object or binary executable
         *       (.o, .a, etc.);
         * (c) ARCHIVE if the file represents an archive (.tar, .jar, etc.); or
         * (d) OTHER if the file doesn't fit into the above categories
         *       (pictures, audio, data files, etc.)
         */
        
        // assign the default value as "OTHER"
        String result = "OTHER";
       
        // get the extension
        FileExtension extension = fileId.getExtension();
        
        
        // preflight check
        if(extension == null){
            return result;
        }
        
        FileCategory target = extension.getCategory();
        
        // safety check
        if(target == null){
            return result;
        }
        
        // if this is a script or source code file, we mark as "SOURCE"
        if(target == FileCategory.SOURCE 
                || target ==FileCategory.SCRIPT
                || target ==FileCategory.INTERNET
                ){
            return "SOURCE";
        }
        
        // if this is a binary file, we mark as "BINARY"
        if(target == FileCategory.BINARY
                || target ==FileCategory.EXECUTABLE){
            return "BINARY";
        }
        
        // if this is a binary file, we mark as "BINARY"
        if(target == FileCategory.ARCHIVE){
            return "ARCHIVE";
        }
        
        return result;
    }
    
    
    /**
     * Complete the last actions before we can conclude the SPDX creation
     */
    private void doFinish(){
        // write some info about this document
        isProcessing = false;
        isOk = true;
        debug("Done!");
    }
    
    
    /**
     * Provides an ASCII paragraph
     * @param title the header text of the title
     * @return the ASCII text to be included on the final output
     */
    private String addParagraph(String title){
        return    "##-------------------------\n"
                + "## " + title + "\n"
                + "##-------------------------\n"
                + "\n";
                
    }
    
    private String addSection(String title){
        return    "\n"
                + "## " + title + "\n"
                + "\n"
                ;
                
    }
    
    /**
     * Adds a simple line of text with a carriage return at the end
     * @param text the text to be included
     * @return a formatted string ready to be written at an ASCII file
     */
    private String addText(String text){
        if(text.isEmpty()){
            return "";
        }
        return text + "\n";
    }

    
    /**
     * Get the current time and date in SPDX format
     * @return the properly formatted SPDX time format
     */
    public static String getDateSPDX() {
       // do the time calculation such as 2012-09-03T13:32:12Z
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String textDate = dateFormat.format(date);
        //TODO for some reason "T" and "Z" are not accepted as parameters
        return textDate.replace(" ", "T") + "Z";
    }
    
    
     /**
     * Get the current time and date in SPDX format from a file
     * @param file the file from where we want the date
     * @return the properly formatted SPDX time format
     */
    public static String getFileDateSPDX(File file) {
       // do the time calculation such as 2012-09-03T13:32:12Z
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(file.lastModified());
        String textDate = dateFormat.format(date);
        //TODO for some reason "T" and "Z" are not accepted as parameters
        return textDate.replace(" ", "T") + "Z";
    }
    
    
    /**
     * A simple way of knowing in detail what is happening
     */
    void debug(String message){
        // shall we show messages or not?
        if(showDebugMessages == false){
            return;
        }
        // output the message
        System.out.println(message);
    }
    
    /**
     * Provide the UID that will be listed for this document
     * @return 
     */
    public String getUID(){
        return ">> "
                + file.getName()
                + " >> "
                + definition.nodeSoftware + " ";
    }
    
}
