/*
 * SPDXVersion: SPDX-1.1
 * DocumentCreate: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * DocumentCreate: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-14T11:02:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: DocumentCreate2.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Creates an SPDX document from a given source </text> 
 */


package spdxlib;

import FileExtension.ExtensionCreate;
import definitions.is;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import script.FileExtension;
import script.Trigger;
import ssdeep.ssdeep;

/**
 *
 * @author Nuno Brito, 1st of November 2013 in Darmstadt, Germany.
 * nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class DocumentCreate2 {
    
    // in which folder are our files located?
    File folderSource;
    int folderSourceLength;
    
    // the object for the new SPDX document
    SPDXfile2 spdx = new SPDXfile2();
    
    // are we processing a new document right now?
    private boolean processing = false;

    // how many files have been processed, how many missing?
    private int
            filesProcessed,
            filesTotal;
    
    private File
            outputFile;
    
    // misc variables
    
    // the generic file writer (where we store the results on disk)
    BufferedWriter out;
    FileInfo2 tempInfo;
   
    
    public boolean isProcessing() {
        return processing;
    }

    public int getFilesProcessed() {
        return filesProcessed;
    }

    public int getFilesTotal() {
        return filesTotal;
    }

    public File getOutputFile() {
        return outputFile;
    }
    
    
    /**
     * From a given folder on disk, create an SPDX report
     * @param folderToAnalyze   The folder on disk
     * @return  True if the report was created with success, false otherwise
     */ 
    public boolean create(final File folderToAnalyze) {
        String filename = folderToAnalyze.getName() + ".spdx";
        // create the file pointer
        outputFile = new File(core.getProductsFolder(), filename);
        return create(folderToAnalyze, outputFile);
    }
    /**
     * From a given folder on disk, create an SPDX report
     * @param folderToAnalyze   The folder where files to analyze are located
     * @param resultFile        The file where the SPDX data will be written
     * @return                  true if everything went as planned
     */
    public boolean create(final File folderToAnalyze, final File resultFile) {
        
        try {
            // get rid of dots and shortcuts, we want the real path
            final String canonicalPath = folderToAnalyze.getCanonicalPath();
            // setup the real path
            folderSource = new File(canonicalPath);
        } catch (IOException ex) {
            Logger.getLogger(DocumentCreate2.class.getName()).log(Level.SEVERE, null, ex);
            // something failed, no problem. We can recover
            folderSource = folderToAnalyze;
        }
        // keep on processing
        folderSourceLength = folderSource.getAbsolutePath().length();
        processing = true;
        // open our file for writing the new information
        try {
            out = new BufferedWriter(new FileWriter(resultFile));
            // do the header
            createHeader(folderSource);
            // get down to business
            processFiles(folderSource, 25);
            out.close();
        } catch (IOException e){
                System.err.println("Error: " + e.getMessage());
                processing = false;
                return false;
            }
        // all done
        processing = false;
        // we are expected to return the pointer to the new report on disk
        return true;
    }

/**
 * Find all files in a given folder and respective subfolders to
 * start indexing them.
 * @param where A file object of the start folder
 * @param maxDeep How deep is the crawl allowed to proceed
 * @throws java.io.IOException
 */
 private void processFiles(File where, int maxDeep) throws IOException{
    File[] files = where.listFiles();
    if(files != null)
        for (File file : files) {
        if (file.isFile())
            processFile(file);
        else
            if ( (file.isDirectory())
                    &&( maxDeep-1 > 0 ) ){
                // do the recursive crawling
                processFiles(file, maxDeep-1);
            }
        }
 }

 

 /**
  * Process a given file to extract the information relevant to SPDX
  * @param file     A file on disk
  */
 private void processFile(File file) throws IOException {
     
     final String fileName = "." + file.getAbsolutePath()
             .substring(folderSourceLength).replace("\\", "/");
     
     // create the fileInfo pointer
     tempInfo = new FileInfo2(spdx);
     
     // write the file name
     tempInfo.setFileName(fileName);
     final String tagFileName = is.tagFileName.concat(" " + fileName + "\n");

     // what kind of file are we dealing here?
     final FileExtension tagFileExtension = tempInfo.getExtensionObject();
     // process the file type
     final String tagFileType = getFileType(tagFileExtension);
     // now process the checksums
     final String tagChecksum = getChecksums(file);
     // now calculate the metrics
     final String tagSize= getFileSize(file);
     // get the Lines of Code, licensing and copyright information
     final String tagCodeInsight = getCodeInsight(file);
     
     //final String temp = (tagFileExtension != null ? "": "");
     
     final String result = tagFileName + tagFileType + tagChecksum 
             + tagSize + tagCodeInsight + "\n";
     
//     System.out.println(tagFileName + tagFileType + tagChecksum 
//             + tagSize + tagCodeInsight);
     out.write(result);
     // increase the counter
     filesProcessed++;
 }

    public SPDXfile2 getSpdx() {
        return spdx;
    }
    
 
 
     /**
     * Returns the SSDEEP checksum for a given file
     * @param file  A file on disk
     * @return      A string with the hash representation of the file
     */
    private String getSSDEEP(File file){
    // compute our SSDEEP hashes
        ssdeep test = new ssdeep();
        try {
            return test.fuzzy_hash_file(file);
        } catch (IOException ex) {
            return "NOASSERTION";
        }
    }

 
    /**
     * Returns if a given file type is SOURCE, ARCHIVE and OTHER
     * @param fileInfo      The file info to be processed
     * @return              A string ready to be written on the SPDX document
     */
    private String getFileType(final FileExtension tagFileExtension){
        // preflight, when null just output the default value
        if(tagFileExtension == null){
            // when the extension doesn't exist, we can create a template
            // for indexing this kind of extension in the future
            createExtension();
            // save the information into our file object
            tempInfo.setFileType(FileType.OTHER);
            return is.tagFileType.concat(" OTHER\n");
        }
        // get the respective category for this file type
        FileCategory category = tagFileExtension.getCategory();
        // now process accordingly
        switch(category){
            case INTERNET:
            case SCRIPT:
            case SOURCE: 
                tempInfo.setFileType(FileType.SOURCE);
                return is.tagFileType.concat(" SOURCE\n");
            case BINARY:
            case EXECUTABLE: 
                tempInfo.setFileType(FileType.BINARY);
                return is.tagFileType.concat(" BINARY\n");
            case ARCHIVE: 
                tempInfo.setFileType(FileType.ARCHIVE);
                return is.tagFileType.concat(" ARCHIVE\n");
            default: 
                tempInfo.setFileType(FileType.OTHER);
                return is.tagFileType.concat(" OTHER\n");    
        }
    }

    /**
     * This methods gets the most popular checksums available for indexing.
     * At the same time, it will update fileInfo with the relevant data.
     * @param file      A file on disk
     * @return          The text ready to be written on the SPDX document
     */
    private String getChecksums(final File file) {
        // compute the checksums
        final String SSDEEP = is.tagFileChecksum
                .concat(" ".concat(is.tagFileChecksumSSDEEP
                        .concat(" ".concat(
                                getSSDEEP(file) 
                                .concat("\n")
                        )
                )));

        final String SHA1 = is.tagFileChecksum
                .concat(" ".concat(is.tagFileChecksumSHA1
                        .concat(" ".concat(
                                utils.Checksum.generateFileChecksum("SHA-1", file)
                                .concat("\n"
                        ))
                )));
        
        final String SHA256 = is.tagFileChecksum
                .concat(" ".concat(is.tagFileChecksumSHA256
                        .concat(" ".concat(
                                utils.Checksum.generateFileChecksum("SHA-256", file)
                                .concat("\n"
                        ))
                )));
        
        final String MD5 = is.tagFileChecksum
                .concat(" ".concat(is.tagFileChecksumMD5
                        .concat(" ".concat(
                                utils.Checksum.generateFileChecksum("MD5", file)
                                .concat("\n")
                        )
                )));
        
        // now save this information into our file info object
        tempInfo.setTagFileChecksumMD5(MD5);
        tempInfo.setTagFileChecksumSHA1(SHA1);
        tempInfo.setTagFileChecksumSHA256(SHA256);
        tempInfo.setTagFileChecksumSSDEEP(SSDEEP);
        
        // give back the result from the checksum computation
        return SHA1.concat(SHA256.concat(MD5).concat(SSDEEP));
    }

    /**
     * Get the file size text
     * @param file  A file on disk
     * @return      A text ready to include on the SPDX document
     */
    private String getFileSize(File file) {
        // define the file size in human readable format
        final long fileSize = file.length();
        // write this value onto the file info object
        tempInfo.setFileSize(fileSize);
        // get the text for the SPDX tag
        final String tagFileSize = ( fileSize > 1000 ? 
                is.tagFileSize.concat(" ".concat(
                        utils.files.humanReadableSize( fileSize ).concat(
                        " (".concat( fileSize + " bytes)")
                        )
                ))
                :
                is.tagFileSize.concat(" ".concat( fileSize + " bytes")
                )).concat("\n");
        // all done
        return tagFileSize;
    }

    /**
     * This method does the most time-consuming operation of the SPDX creation.
     * We will read the full content of the source code file into memory and
     * then pass the content against the triggers to check if anything is
     * "triggered". In case that happens, we add the output onto the final 
     * result, which might be a license identificator or copyright assignment.
     * In the process, we also provide a Lines Of Code count for text files.
     * @param file  A file on disk
     * @return      A piece of text ready to be inserted inside the SPDX content
     */
    private String getCodeInsight(File file) {        
        // read this file from disk onto local memory
        String content = utils.files.readAsString(file);
        String result = "";
        
        // when the file has source code, we count the lines of code
        if(tempInfo.getFileType() == FileType.SOURCE){
            // calculate the lines of code
            final int LOC = getLOC(content);
            // get the tag to be written on the SPDX
            final String fileLOC = is.tagFileLOC.concat(" " + LOC + "\n");
            // save this value to the file info object
            tempInfo.setFileLOC(LOC);
            // get everything together
            result = result.concat(fileLOC);
        }
        
        // when the file is identified as containing text, we'd like to take
        // a look inside and identify its content where possible
        if(tempInfo.getExtensionObject() != null 
                && tempInfo.getExtensionObject()
                        .getContentType() == ContentType.TEXT){
            // try to identify some of the most common triggers
            for(Trigger thisTrigger: core.triggers.getList()){
                // does our text contains an applicable trigger?
                if(thisTrigger.isApplicable(content)){
                   result = result.concat(thisTrigger.getResult()).concat("\n");
                }
            }
        }
        return result;
    }

    /**
     * Given a piece of source code, count the number of lines that are code.
     * On this calculation, comments are included. However, empty lines aren't
     * There exist many different manners
     * @param sourceCodeText
     * @return 
     */
    private int getLOC(String sourceCodeText){
        String[] lines = sourceCodeText.split("\n");
        int LOC = 0;
        // iterate all lines on the text file
        for(String line : lines){
            // skip the empty lines
            if(line.isEmpty()){
                continue;
            }
            // count one line
            LOC++;
        }
        return LOC;
    }
    
    
    /**
     * Creates a new file extension when it was not previously indexed in
     * our records. No parameters are needed, it is supposed to be called
     * during the processing of files. This code is launched on a separate
     * thread to prevent delaying the overall progress
     */
    private void createExtension() {
        Thread thread = new Thread(){
            @Override
            public void run(){
              ExtensionCreate ext = new ExtensionCreate();
              ext.automatically(tempInfo.getExtension(), false);
            }
        };
        thread.start();
    }
    
    
    /**
     * Provides a simple summary of what has been indexed
     */
    public void printSummary(){
    
    }

    /**
     * Writes the header for this SPDX document
     * @param folderSource  The folder from where we get information
     */
    private void createHeader(File folderSourceCode) {
        final String header =  
                  addParagraph("SPDX Document Information")
                + addText("SPDXVersion: SPDX-1.2")
                + addText("DataLicense: CC-BY-4.0")
                + "\n"
                
                + addParagraph("Creation Information")
                + addText("Creator: " + System.getProperty("user.name"))
                + addText("Creator: Tool: TripleCheck " + core.version)
                + addText("Created: " + utils.time.getDateSPDX())
                + "\n"
                
                + addParagraph("Package Information")
                + "PackageName: "  + folderSourceCode.getName()
                //+ "\nPackageFileName: " + folderSourceCode.getName()
                //+ "\nPackageDownloadLocation: " + packageDownloadLocation
                //+ "\nPackageLicenseConcluded: " + PackageLicenseConcluded
                + "\n"
                + "\n"
                + addParagraph("File Information")
                ;
        try {
            // now write the header
            out.write(header);
        } catch (IOException ex) {
            Logger.getLogger(DocumentCreate2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
}