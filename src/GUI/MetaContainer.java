/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-09T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: MetaContainer.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class is used as container for the META refresh
 * tag support inside JEditorPane </text> 
 */

package GUI;

import definitions.is;
import java.util.ArrayList;

/**
 *
 * @author Nuno Brito, 9th of December 2013 in Darsmtadt, Germany
 */
public class MetaContainer {

    public int delay = -1; 
            
    public String url = "",
            scriptMethod = is.methodDefault;
    
    public ArrayList<String[]> params = new ArrayList<String[]>();
    
}
