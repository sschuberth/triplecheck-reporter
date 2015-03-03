/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-02T08:53:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: settings.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows details about the settings of a project </text> 
 */

package provenance;

import definitions.Messages;
import main.script.log;
import script.Plugin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of May 2014 in Darsmtadt, Germany
 */
public class originality extends Plugin{
     
    final String templateFolderHTML = "originality.html";
    
    /**
     * Display the current settings
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       
       // load our template
       request.setTemplate(templateFolderHTML);
              
       // all done
       request.closeTemplate();
    }
    
}
