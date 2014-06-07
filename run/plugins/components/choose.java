/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-31T18:55:10Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: choose.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows the end-user to choose different components
    for a given file.</text> 
 */

package components;

import GUI.SearchType;
import GUI.swingUtils;
import java.util.ArrayList;
import main.core;
import script.Plugin;
import script.log;
import utils.html;
import www.Link;
import www.WebRequest;

/**
 * View component
 * Choose component
 * 
 * 
 * 
 */

/**
 *
 * @author Nuno Brito, 5th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class choose extends Plugin{
    
    
    @Override
    public void startup(){
        log.hooks.addAction(SearchType.Components_Choose.getHook(), 
                thisFile, "doFindComponent");    
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
    public void doFindComponent() {
        final String searchTerm = core.studio.getSearch().getText();
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }

        // place the loading message
        swingUtils.setText(html.textGreyAligned("Looking for matches.."));
        
        Link link = new Link();
        link.setTitle("choose");
        link.setUrl("choose/?x=select&name=");
        
//        Link linkDetails = new Link();
//        linkDetails.setTitle("details");
//        link.setUrl("/components/showComponent?name=");
//        
//        // add the link to our list
//        link.addLink(linkDetails);
        
        String result = core.components.search(searchTerm, link);
        swingUtils.setText(result);
    }
       
    /**
     * This method shows a list of components to the end-user and permits
     * to choose one that will later be applied to a given set of files.
     * @param request 
     */
    public void showDialog(WebRequest request) {
        // set the default search provider to select components
        core.studio.setSearchProvider(SearchType.Components_Choose);
        // show a simple template (might be replaced with better in the future)
        request.setTemplate("chooseComponent.html");
        
        ArrayList<LinkType> link = new ArrayList();
        link.add(LinkType.Choose);
        
        String listOfComponents =// html.h3("Local components")
                //+ 
                core.components.getReport(link);
              
        request.changeTemplate("[template]", listOfComponents);
        
        request.closeTemplate();
    }
    
    /**
     * This method is called when are sure about which component to apply
     * on a given set of files
     * @param request 
     */
    public void select(WebRequest request) {
        final String path = request.getParameter("path");
        final String name = request.getParameter("name");
//        final String type = request.getParameter("license");
//        System.err.println("Marking files as belonging to : " + name);
        request.setAnswer("Modified selected files as part of component ->" + path + "->" + name);
        core.studio.setFilesWithComponent(name);
        
    }
    
    
}
