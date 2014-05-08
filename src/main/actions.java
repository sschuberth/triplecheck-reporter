/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-13T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: actions.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A simple static class to provide default actions 
 * related to SPDX handling </text> 
 */

package main;

import definitions.folder;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import script.log;


public class actions {

    /**
     * This method adds up all the triggers found on the triggers folder
     */
    public static void addTriggers(){
        File folderLicense = new File(core.getWorkFolder(), folder.triggers);
        ArrayList<File> files = utils.files.findFilesFiltered(folderLicense, ".java", 2);
        for(File file : files){
            core.script.runJava(file, null, is.trigger);
        }
        
         // worry about the case when there is no folder nor triggers to include
        if(core.triggers.isEmpty()){
            log.write(is.WARNING, "No trigger were added, "
                    + "trigger detection is disabled.");
        }
        
    }

   
    
    
  
    
}
