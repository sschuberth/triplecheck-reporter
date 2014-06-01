/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: search.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for finding information </text> 
 */

package licenses;

import definitions.Messages;
import definitions.is;
import java.io.File;
import main.core;
import script.Plugin;
import script.log;
import spdxlib.License;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darsmtadt, Germany
 */
public class search extends Plugin{
     
    String id = "Search licenses";
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
        // get our hook working for the specific license search
        log.hooks.addAction(Messages.SearchBoxLicenseSearch, 
                thisFile, "doFindLicense");  
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode(id, "magnifier-left.png", "main");
    }
    
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        // specific to the GUI
        if(request.requestOrigin == RequestOrigin.GUI_tree){
            core.studio.searchProvider = Messages.SearchBoxLicenseSearch;
        }
        // show up our search page
        File tempFile = new File(thisFolder, "searchLicenses.html");
        request.setPage(tempFile);
        
    }

  
      /**
     * When a given search term is available, show the licenses that are
     * a possible match
     */ 
    public void doFindLicense() {
        final String searchTerm = core.studio.getSearch().getText();
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }
        final String link = "/licenses/search?x=view&lic=";

        String output = core.licenses.search(searchTerm , "read", link);
        core.studio.editorPane(is.contentHTML, false, 0, output);
    }
    
    
    /**
     * View the specific details for a selected license
     * @param request 
     */
    public void view(WebRequest request){
        final String param = request.getParameter("lic");
        License license = core.licenses.get(param);
        final String result = license.getSummaryHTML();
        request.setAnswer(result);
    }
    
    
}
