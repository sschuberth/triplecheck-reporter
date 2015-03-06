/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-01-20T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> 
 * 
 * Provides a hook system that allows end users to trigger custom actions
 * whenever a log entry is made that matches a given pattern.
 * </text> 
 */
package script;

import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import main.engine;

/**
 *
 * @author Nuno Brito, 12th of January 2013 in Darmstadt, Germany.
 */
public class Hooks {
    private final HashMap<String, ArrayList<Hook>> hookList = new HashMap();
    
    
    /**
     * Removes all installed hooks
     */
    public void removeAll(){
        hookList.clear();
    }
    
    /**
     * @param hookText
     * @param script The file pointer to a script
     * @param method The method that we want to run
     */
    public void addAction(String hookText, File script, String method){
        // preflight check
        if(script == null){
            System.err.println("HK01 - Hooks cannot accept null files as input");
            return;
        }
        
        Hook hook = new Hook(script, method);
        // if we already a hook of this kind, get the array and add this up
        if(hookList.containsKey(hookText)){
            hookList.get(hookText).add(hook);
            return;
        }
            
        // we have nothing, create a new one from scratch
        ArrayList<Hook> array = new ArrayList();
        array.add(hook);
        hookList.put(hookText, array);        
    }
    
    public void process(String what){
        // 
        if(hookList.containsKey(what) == false){
            return;
        }
        // now it seems that we do have some hooks to run, let's do this
        
        ArrayList<Hook> selectedHooks = hookList.get(what);
        for(Hook hook : selectedHooks){
            //System.err.println("HK00 - Running hook " + hook.script);
            engine.script.run(hook.script, hook.method, is.plugin);
        }
    }
    
    
    class Hook {
        File script;
        String method;
        
        public Hook(File script, String method){
            this.script = script;
            this.method = method;
        }
    }
    
}
