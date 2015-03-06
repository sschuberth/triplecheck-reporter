/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: search.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for finding information </text> 
 */

package licenses;

import GUI.SearchType;
import definitions.Messages;
import definitions.is;
import java.io.File;
import main.coreGUI;
import main.engine;
import script.Plugin;
import main.script.log;
import license.License;
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
        log.hooks.addAction(SearchType.License_Show.getHook(), 
                thisFile, "doFindLicense");  
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        log.write(is.INSTALLING, "Adding the license search tool");
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
            coreGUI.studio.setSearchProvider(SearchType.License_Show);
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
        final String searchTerm = coreGUI.studio.getSearch().getText();
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }
        final String link = "/licenses/search?x=view&lic=";

        String output = engine.licenses.search(searchTerm , "read", link);
        coreGUI.studio.editorPane(is.contentHTML, false, 0, output);
    }
    
    
    /**
     * View the specific details for a selected license
     * @param request 
     */
    public void view(WebRequest request){
        final String param = request.getParameter("lic");
        License license = engine.licenses.get(param);
        final String result = license.getSummaryHTML();
        request.setAnswer(result);
    }
    
    
}
