/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-31T18:55:10Z
 * LicenseName: AGPL-3.0+
 * FileName: choose.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows the end-user to choose different licenses
    for a given file.</text> 
 */

package licenses;

import GUI.SearchType;
import GUI.TreeviewUtils;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import main.coreGUI;
import main.engine;
import script.Plugin;
import main.script.log;
import spdxlib.FileInfo;
import license.License;
import spdxlib.SPDXfile;
import spdxlib.swing.TreeNodeSPDX;
import utils.www.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 31st of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class choose extends Plugin{
    
    
    @Override
    public void startup(){
        log.hooks.addAction(SearchType.License_Choose.getHook(), 
                thisFile, "doFindLicense");    
    }

   
    
    /**
     * Shows a summary of details about the selected package
     * @param request
     */
    @Override
    public void main(WebRequest request) {
        // get the first parameter, which contains the file path
        //String[] action = request.parameters.get(0);
        request.setAnswer("test");
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
        System.out.println("Finding a license");
        final String link = (String) engine.temp.get("TreeviewLicenseSelectedFilesLink");
        String output = engine.licenses.search(searchTerm , "choose", link);
        coreGUI.studio.editorPane(is.contentHTML, false, 0, output);
    }
       
    /**
     * This method shows a list of licenses to the end-user and permits
     * to choose one that will later be applied to a given set of files.
     * @param request 
     */
    public void selectLicense(WebRequest request) {
        // get the first parameter
        String[] action = request.parameters.get(0);
        // now translate this parameter to the set of UID
        //String[] listUID = action[0].split(";");
        final String listUID = action[0];
        
        // now we want to show a list of the all the licenses available
        String result = "";
        
        final String link = "/licenses/choose?x=applyLicense"
                + "&uid=" + listUID
                + "&lic=";
        result += html.h2("Choose a license");
        
        
        result += getRecentlyUsedLicenses(listUID, "Choose", link);
        
        result += html.h3("Licenses available")
                + engine.licenses.getListHTML("Choose", link);
        
         // give a left-side margin on the output
        result = html.div(3)
                + result
                + html._div;
        
        request.setAnswer(result);
        
        // specific to the GUI
        if(request.requestOrigin == RequestOrigin.GUI_tree){
            coreGUI.studio.setSearchProvider(SearchType.License_Choose);
            // save in the common space the treeview with selected links
            engine.temp.put("TreeviewLicenseSelectedFilesLink", link);
        }
        
    }
    
    
    /**
     * Place the most recently used licenses on top of the list
     * @param listUID   A list of nodes to change
     * @return          An HTML text ready to display on the end-user
     */
    private String getRecentlyUsedLicenses(String listUID, 
            String title, String link){
        String[] listArray = listUID.split(";");
        // get the node based on the first entry (there is at minimum one entry)
        TreeNodeSPDX node = TreeviewUtils.getNode(listArray[0]);
        // get the file info object
        FileInfo fileInfo = (FileInfo) node.getUserObject();
        // get the respective spdx
        SPDXfile spdx = fileInfo.getSPDX();
        // now go through all file info and find licenses
        String result = coreGUI.popularity.processReport(spdx, title, link);
        
        // avoid the null results, replace with an empty string instead
        if(result==null){
            result = "";
        }
        
        return result;
    }
    
    /**
     * Apply a specific license to a set of files
     * @param request 
     */
    public void applyLicense(WebRequest request) {
        final String rawListUID = request.getParameter("uid");
        final String licenseId = request.getParameter("lic");
//        System.out.println("------");
//        System.out.println(rawListUID);
//        System.out.println(licenseId);
        // get the respective license object
        License license = engine.licenses.get(licenseId);
        // now create the UID list
        String[] listUID = rawListUID.split(";");
        // finish this up by changing the licenses
        TreeviewUtils.changeDeclaredLicense(listUID, license);
        
        request.setAnswer("Applied the " + license.getId() 
                + " to " + utils.text.pluralize(listUID.length, "file"));
        
        // if we are clicking from a tree view, go back to last selected node
        if(request.requestOrigin == RequestOrigin.GUI_tree 
                || request.requestOrigin == RequestOrigin.GUI){
            TreeNodeSPDX node = swingUtils.getSelectedNode();
            // update the selected node
            log.write(is.INFO, Messages.TreeNodeChanged, node.getUID());
            // change back to the default search provider
            coreGUI.studio.setSearchProvider(SearchType.License_Choose);
            //node.update(false);
        }
    
        
        
        
    }
    
    
    
    
}
