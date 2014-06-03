/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-08T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: KeyStroke.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A very strange but necessary class. This class was 
 * written to be used with a search box. I wanted to provide a good feature:
 * whenever the user types a key on the search box, the results start to appear
 * according to what was already typed. This works like modern search engines
 * do. However, the problem is that when the knowledge is quite extense then it
 * starts to take some time to retrieve results. 
 * 
 * Even worse is the fact that the user needs sometimes to type a long word and
 * this search method will drag to a big delay the whole search process, making
 * it less pleasant.
 * 
 * How can we reduce this kind of issue? The idea is that when the user is
 * typing several keys in a very short amount of time then we don't need to
 * perform a new search for all these keys, we can track the time between 
 * keystrokes and only perform a search when he waits for something like 
 * half a second. The user doesn't notice that this happens in the background 
 * and we don't need to perform searches that would otherwise be safe to
 * consider as redundant. Everyone gets happy! :-) </text> 
 */

package utils;

import definitions.is;
import main.core;
import script.log;


/**
 *
 * @author Nuno Brito, 8th of November 2013 in Darmstadt, Germany.
 * nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class KeyStroke {

    long lastKeypress = System.currentTimeMillis();
//    private final String 
//            message; // the message to be launched through the log system
    
    public long sensitivity = 350;
    
    private String
            buffer = "" ; // the buffer of keys being typed very quickly
    
    /**
     * Where everything begins
     */
    public KeyStroke(){
//        this.message = message;
        launchThread();
    }

    /**
     * The user has pressed a key, let's store this key on our buffer
     * @param key the key that was pressed by the user
     */
    public void pressedKey(final String key){
        buffer = buffer.concat(key);
        lastKeypress = System.currentTimeMillis();
    }
    
    /**
     * Launch the thread to keep this thing active
     */
    void launchThread(){
         Thread thread = new Thread(){
                    @Override
                    public void run() {
                        while(true){
                            // hold on this thread for a second
                            time.waitMs(sensitivity);
                            // no need to process anything if buffer is empty
                            if(buffer.isEmpty()){
                                continue;
                            }
                            long timeNow = System.currentTimeMillis();
                            // we keep a buffer of 1 second between keys
                            long waitingTime = lastKeypress + sensitivity;
                            // has more than one second passed without pressing?
                            if(timeNow > waitingTime){                            
                                //log.write(is.COMMAND, message);
                                log.write(is.COMMAND, core.studio.getSearchProvider().getHook());
                                buffer = "";
                            }
                        }
                    }
                };
               // launch it up, fire and forget
               thread.start();
    }

    /**
     * Cleans up the buffer
     */
    public void clear() {
        buffer = "";
    }
    
}
