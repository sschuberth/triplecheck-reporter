/*
 * Provides a hook system that allows end users to trigger custom actions
 * whenever a log entry is made that matches a given pattern.
 */
package script;

import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import main.core;

/**
 *
 * @author Nuno Brito, 12th of January 2013 in Darmstadt, Germany.
 */
public class Hooks {
    private HashMap<String, ArrayList<Hook>> hookList = new HashMap();
    
    
    /**
     * Removes all installed hooks
     */
    public void removeAll(){
        hookList.clear();
    }
    
    /**
     * @param hook The log message that triggers this action
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
            core.script.run(hook.script, hook.method, is.plugin);
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
