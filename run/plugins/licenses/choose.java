/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-31T18:55:10Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: actions.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows the end-user to choose different licenses
    for a given file.</text> 
 */

package licenses;

import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import main.core;
import script.Plugin;
import script.log;
import spdxlib.License;
import utils.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 08th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class choose extends Plugin{
    
    
    @Override
    public void startup(){
        log.hooks.addAction(Messages.SearchBoxLicenseSelect, 
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
        final String searchTerm = core.studio.getSearch().getText();
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }
        System.out.println("Finding a license");
        final String link = (String) core.temp.get("TreeviewLicenseSelectedFilesLink");
        String output = core.licenses.search(searchTerm , "choose", link);
        core.studio.editorPane(is.contentHTML, false, 0, output);
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
        result += html.h3("Choose a license");
        for(License license : core.licenses.getList()){
            final String thisLink = link + license.getId();
             result += license.getPrettyText("Choose", thisLink);
        }
        
         // give a left-side margin on the output
        result = html.div(3)
                + result
                + html._div;
        
        request.setAnswer(result);
        
        // specific to the GUI
        if(request.requestOrigin == RequestOrigin.GUI_tree){
            core.studio.searchProvider = Messages.SearchBoxLicenseSelect;
            // save in the common space the treeview with selected links
            core.temp.put("TreeviewLicenseSelectedFilesLink", link);
        }
        
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
        License license = core.licenses.get(licenseId);
        // now create the UID list
        String[] listUID = rawListUID.split(";");
        // finish this up by changing the licenses
        core.licenses.changeDeclaredLicense(listUID, license);
        
        request.setAnswer("All done");
        
        // if we are clicking from a tree view, go back to last selected node
        if(request.requestOrigin == RequestOrigin.GUI_tree 
                || request.requestOrigin == RequestOrigin.GUI){
            TreeNodeSPDX node = swingUtils.getSelectedNode();
            // update the selected node
            log.write(is.INFO, Messages.TreeNodeChanged, node.getUID());
            // change back to the default search provider
            core.studio.searchProvider = Messages.SearchBoxPressedENTER;
            core.studio.setSearchText("");
            //node.update(false);
        }
    
        
        
        
    }
    
    
    
    
}
