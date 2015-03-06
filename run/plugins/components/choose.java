/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-31T18:55:10Z
 * LicenseName: AGPL-3.0+
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
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 5th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class choose extends Plugin{
    
    
    final String
            descStartSmall = "<br><span style=\"font-family: serif; color: rgb(0, 0, 0); "
            + "background-color: rgb(180, 255, 148); font-size: 12px; "
            + "line-height: 33px;\">&nbsp;",
            descEnd = "&nbsp;</span>";
    
    @Override
    public void startup(){
        log.hooks.addAction(SearchType.Components_Choose.getHook(), 
                thisFile, "doSearchAndChooseComponent");    
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
    public void doSearchAndChooseComponent() {
        // get the term that the end-user is looking for
        String searchTerm = coreGUI.studio.getSearch().getText();
        //coreGUI.studio.getSearch().setText(searchTerm);

        searchTerm = searchTerm.replace(SearchType.Components_Choose.getSearchBoxText(), "");
        
        // no text? show the main page again
        if(searchTerm.isEmpty()){
            //coreGUI.studio.getSearch().transferFocus();
            coreGUI.studio.showDialogAddFilesToComponent();
            coreGUI.studio.setSearchProvider(SearchType.Components_Choose);
            return;
        }
        
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }

        // place the loading message
        swingUtils.setText(html.textGreyAligned("Looking for matches.."));
                
        ArrayList<LinkType> links = new ArrayList();
        links.add(LinkType.Choose);
        links.add(LinkType.View);
        
        String result = engine.components.search(searchTerm, links);
              
        // no results found?
        if(result.isEmpty()){
            swingUtils.setText(html.textGreyAligned("No results found"));
            return;
        }
        
        
        // main title of the component
        result = result.replace("<%t1%>", descStartSmall);
        result = result.replace("</%t1%>", descEnd);
        // description of the item
        result = result.replace("<%d1%>", "<br><i>");
        result = result.replace("</%d1%>", "</i>");
        // all done, output the result
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
        request.setTemplate("comp_associated.html");
        
        // change the title
        request.changeTemplate("%title%", "Choose a component");
        
        
        ArrayList<LinkType> link = new ArrayList();
        link.add(LinkType.Choose);
        
        String listOfComponents = engine.components.getReport(link);
              
        // main body of content
        request.changeTemplate("%text%", listOfComponents);
        // main title of the component
        request.changeTemplate("<%t1%>", descStartSmall);
        request.changeTemplate("</%t1%>", descEnd);
        // description of the item
        request.changeTemplate("<%d1%>", "<br><i>");
        request.changeTemplate("</%d1%>", "</i>");
        
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
            return;
        }
        // write the component to disk
        component.writeToDisk();
        log.write(is.INFO, "Wrote component %1 from %2 to disk", id, path);
        
    }
    
    
}
