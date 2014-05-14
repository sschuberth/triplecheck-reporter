/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-14T16:39:10Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TriggerControl.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The manager for triggers that detect licenses and 
    other details inside source code files.</text> 
 */

package structure;

import definitions.folder;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import main.core;
import script.Trigger;
import script.log;

/**
 *
 * @author Nuno Brito, 14th of May 2014 in Darmstadt, Germany.
 */
public final class TriggerControl {
    
    private final ArrayList<Trigger> list = new ArrayList();
    
    
    public TriggerControl(){
        addTriggers();
    }
    
     /**
     * This method adds up all the triggers found on the triggers folder
     */
    private void addTriggers(){
        File folderTriggers = new File(core.getWorkFolder(), folder.triggers);
        ArrayList<File> files = utils.files.findFilesFiltered(folderTriggers, ".java", 2);
        for(File file : files){
            Trigger result = (Trigger) script.exec.runJava(file, is.trigger);
            if(result != null){
                log.write(is.ADDING, "Trigger: " + result.getShortIdentifier());
                list.add(result);
            }
        }
        
         // worry about the case when there is no folder nor triggers to include
        if(list.isEmpty()){
            log.write(is.WARNING, "No trigger were added, "
                    + "trigger detection is disabled.");
        }
        
    }

    public Iterable<Trigger> getList() {
        return list;
    }

    
    
}


