/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-09-02T17:08:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: cmdLine.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Handle the command line parameters.  </text> 
 */

package main;

import definitions.is;
import java.io.File;
import script.log;
import spdxlib.DocumentCreate2;

/**
 *
 * @author Nuno Brito, 2nd of September 2014 in Darmstadt, Germany
 */
public class cmdLine {
    
    // the SPDX document that we are about to create    
    static DocumentCreate2 spdx = new DocumentCreate2();
    
        
    /**
     * Are we calling command line parameters? If so, start them up
     * @param args  The arguments provided on command line
     * @return      True if valid parameters were found, false otherwise.
     */
    public static boolean isCommandLineUsed(final String[] args) {
        // what is the outcome of our processing?
        Boolean result = false;
        
        // no arguments? No need to continue
        if(args.length == 0){
            return result;
        }
        
        // get the first argument
        final String cmdAction = args[0].toLowerCase();
        
        // are we being asked to create an SPDX document?
        if(cmdAction.equals("spdx")){
            // do we have the right amount of parameters?
            if(args.length < 3){
                System.out.println("Expecting more parameters.");
                return true;
            }
            
            
            log.write(is.INFO, "Processing an SPDX folder/file:");
//            if(args.length == 3){
//            }
//            else
            // do we have a parameter for the package name?
            if(args.length == 4){
                spdx.setPackageName(args[3]);
            }
            else
            // do we want to define an URL?
            if(args.length == 5){
                spdx.setPackageURL(args[4]);
            }
          
            // now create the document      
            createCmdLineSPDX(args[1], args[2]);
           
            //result = true;
            System.exit(0);
        }
        
        // all done
        return result;
    }

    /**
     * Creates a new SPDX document from the command line
     * @param spdxFileOutput        The output from the SPDX generation
     * @param sourceCodeFolderOrFile The source used as input (files and folders)
     */
    private static void createCmdLineSPDX(final String spdxFileOutput, 
            final String sourceCodeFolderOrFile) {
        
        // the output file where we store the SPDX information
        final File spdxFile = new File(spdxFileOutput);
        final File sourceTarget = new File(sourceCodeFolderOrFile);

        // if this is a directory, we can't proceed
        if(spdxFile.isDirectory()){
            log.write(is.ERROR, "SPDX file is a folder: %1", 
                    spdxFile.getAbsolutePath());
            return;
        }
        // if this is a directory, we can't proceed
        if(sourceTarget.isFile()){
            log.write(is.ERROR, "Target file not yet supported: %1", 
                    sourceTarget.getAbsolutePath());
            return;
        }
        
        // delete any previous output file if it exists
        if(spdxFile.exists()){
            spdxFile.delete();
        }
        
        // generate the SPDX document
        log.write(is.INFO, "Generating an SPDX as %1. Using as source: %2"
                , spdxFile.getName(), sourceTarget.getName());
        // create the SPDX
        spdx.create(sourceTarget, spdxFile);
        System.out.println("Processed files: " + spdx.getFilesProcessed());
    }
    
    
    
}
