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
import comp.Component;
import comp.LinkType;
import definitions.is;
import java.util.ArrayList;
import main.coreGUI;
import main.engine;
import script.Plugin;
import main.script.log;
import utils.www.html;
import utils.www.Link;
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
        final String searchTerm = coreGUI.studio.getSearch().getText();
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
        
        String result = engine.components.search(searchTerm, link);
        swingUtils.setText(result);
    }
       
    /**
     * This method shows a list of components to the end-user and permits
     * to choose one that will later be applied to a given set of files.
     * @param request 
     */
    public void showDialog(WebRequest request) {
        // set the default search provider to select components
        coreGUI.studio.setSearchProvider(SearchType.Components_Choose);
        // show a simple template (might be replaced with better in the future)
        request.setTemplate("chooseComponent.html");
        
        ArrayList<LinkType> link = new ArrayList();
        link.add(LinkType.Choose);
        
        String listOfComponents =// html.h3("Local components")
                //+ 
                engine.components.getReport(link);
              
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
        
        // do we need to create a new Json?
        if(path != null && path.endsWith(".jsons")){
            createJsonFromDatabase(path, name);
        }
        
//        final String type = request.getParameter("license");
        log.write(is.INFO, "Marking files as belonging to : %1", name);
        request.setAnswer("Marked selected files as part of " + name);
        coreGUI.studio.setFilesWithComponent(name);
        
    }

    /**
     * Given a path and project name of something that was chosen from a
     * repository, we now work to create a separate component that we can
     * further customize as needed
     * @param path  Path to the repository
     * @param id    Identification of the project we want to extract
     */
    private void createJsonFromDatabase(String path, String id) {
        Component component = engine.components.getFromRepository(path, id);
        if(component == null){
            log.write(is.ERROR, "CH147 - Didn't found component %1 at repository %2",
                    id, path);
        }
        // write the component to disk
        component.writeToDisk();
        log.write(is.INFO, "Wrote component %1 from %2 to disk", id, path);
        
    }
    
    
}
