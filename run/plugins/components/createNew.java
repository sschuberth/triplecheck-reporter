/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-03T12:53:12Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: createNew.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for creating new components </text> 
 */

package components;

import script.Plugin;
import structure.Component;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class createNew extends Plugin{
    
    public void createNew(WebRequest request){
        request.setTemplate("createNew.html");
        
        request.changeTemplate("template-pagetitle", "Create a new component");
        request.changeTemplate("template-id", "");
        request.changeTemplate("template-title", "");
        request.changeTemplate("template-website", "");
        request.changeTemplate("template-download", "");
        request.changeTemplate("template-button", "Create");
        
        request.closeTemplate();
    }
    
    /**
     * Creates the new component
     * @param request 
     */
    public void doCreate(WebRequest request){
        // get the parameters
        final String id = request.getParameter("id");
        final String title = request.getParameter("title");
        final String descriptionOneLine = "";
        final String website = request.getParameter("website");
        final String download = request.getParameter("download");
       
        // now write our component
        Component component = new Component();
        component.setId(id);
        component.setTitle(title);
        component.setDescriptionOneLine(descriptionOneLine);
        component.setReferenceURL(website);
        component.setDownloadURL(download);
        
        // now write this component to disk
        component.writeToDisk();
        
        // all done
        request.setAnswer("Added new component: " + id);
    }
    
}
