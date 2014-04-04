/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-19T00:00:00Z
 *
 * LicenseName: NOASSERTION
 *
 * FileName: PluginOld.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> Defines the structure of a plugin supported by this
 *  software </text> 
 */

package old;

import java.io.File;


/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public interface PluginOld {

    // things that we'd like to see on each plugin
    String 
            title = ""; // title used by the node
    
    File // pointer to the file on disk
            file = null; 
    
    
    // set of methods to be overriden
    public void onDoubleClick();
    public void onTripleClick();
    
//    @Override
//    public String toString(){
//        return title;
//    }
    
}
