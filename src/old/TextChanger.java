/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 20134-04-04T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: TextChanger.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Usefull class to change text across the code</text> 
 */
package old;

import java.io.File;
import java.util.ArrayList;
import main.core;

/**
 *
 * @author Nuno Brito, 4th of April 2014 in Darmstadt, Germany
 */
public class TextChanger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<File> files = utils.files.findFiles(core.getExtensionsFolder());
        
        String text1 = "/**"
     +"* Who is the owner for description that was provided?\n"
     +"* What are the applicable license terms?\n"
     +"*/\n"
    +"@Override\n"
    +"public String getDescriptionCredits(){\n"
    +"    return null; //author of description\n"
    +"}\n";
        

        String text2 = "";
        
        
        int i = 0;
        for(File file : files){
            String path = file.getAbsolutePath();
            if(path.contains(".svn")){
                continue;
            }
            
            // read the file
            String text = utils.files.readAsString(file);

            if(text.contains(text1)){
                System.out.println(file.getAbsolutePath());
            
                String output = text.replace(text1, text2);
                utils.files.SaveStringToFile(file, output);
             i++;
            }
            
            
           
        }
        
        System.out.println("Total files: " + i);
        
        
        // import spdxlib.FileCategory;import spdxlib.FileLanguage;
    }
}
