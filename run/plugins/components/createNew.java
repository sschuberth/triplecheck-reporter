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

import main.coreGUI;
import main.engine;
import script.Plugin;
import spdxlib.License;
import utils.www.html;
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
        
        request.changeTemplate("template-description", "");
        request.changeTemplate("template-versions", "");
        request.changeTemplate("template-author", "");
        request.changeTemplate("template-remarks", "");
        
        String licenses = "";
        for (License license : engine.licenses.getList()) {
            licenses = licenses.concat("<option>" + license.getId() + "</option>");
        }
        
        request.changeTemplate("<option>template-license</option>", licenses);
        
        request.changeTemplate("template-button", "Create");
        
        request.closeTemplate();
    }
    
    /**
     * Creates the new component
     * @param request 
     */
    public void doCreate(WebRequest request){
        // get the parameters
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String website = request.getParameter("website");
        String download = request.getParameter("download");
        String license = request.getParameter("license");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        String remarks = request.getParameter("remarks");
        String versions = request.getParameter("versions");
       
        
        if(id == null || id.isEmpty()){
            request.setAnswer(html.errorMessage("The short name can't be empty"));
            return;
        }
        
        System.out.println("CN76 got here");
        // now write our component
        comp.Component component = new comp.Component();
        component.setId(id);
        component.setTitle(title);
        component.setDescription(description);
        component.setDeclaredLicense(license);
        component.setAuthors(author);
        component.setVersion(versions);
        component.setRemarks(remarks);
        
        component.setReferenceURL(website);
        component.setDownloadURL(download);
        
        // now write this component to disk
        component.writeToDisk();
        
        // all done
        request.setAnswer("Added new component: " + id );
    }
    
}
