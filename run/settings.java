
import script.Plugin;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-13T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: settings.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Basic settings loaded on the beginning of the program
 * start.</text> 
 */

/**
 *
 * @author Nuno Brito, 13th of December 2013 in Darsmtadt, Germany
 */
public class settings extends Plugin{
    
    public void start(){
        // activate the counter
        utils.internet.threadedWebGet("http://c.statcounter.com/9475183/0/e5bd970e/0/");
    }  
}
