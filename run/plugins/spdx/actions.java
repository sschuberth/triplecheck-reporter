/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-08T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: actions.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package spdx;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import script.Plugin;
import utils.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 08th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class actions extends Plugin{

    /**
     * Shows a summary of details about the selected package
     * @param request
     */
    @Override
    public void main(WebRequest request) {
        // get the first parameter, which contains the file path
        String[] action = request.parameters.get(0);
        
        // create the file pointer
        File targetFile = new File(action[1]);
        // default answer
        String result = "File was not found: " 
                + targetFile.getAbsolutePath();
        
        // if the file exists, show it
        if(targetFile.exists()){
            result = readFile(targetFile);
        }
        
        request.setAnswer(result);
    }

    /**
     * This method attempts to display a file from disk and format in a manner
     * that looks more human-readable.
     * 
     * @param targetFile    The file that we want to open
     * @return              HTML text ready to be displayed to the user
     */
    private String readFile(File targetFile) {
        // read the contents of this file
        String result = utils.files.readAsString(targetFile);
        
        // add line breaks
        result = result.replace("\n", "\n" + html.br);
        
        return result;
    }
    
    
    /**
     * Opens up a requested folder on disk
     */
    public void folder(WebRequest request) {
    String paramString = request.getParameter("target");
        File file = new File(paramString);
         try {
                Desktop.getDesktop().open(file.getParentFile());
            } catch (IOException ex) {
            }
         
         
         String output = "Opening the folder.";
         request.setAnswer(output);
    }
    
    
    
}