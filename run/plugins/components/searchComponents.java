/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-03T12:10:47Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: showComponents.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for finding components </text> 
 */

package components;

import GUI.SearchType;
import definitions.is;
import main.engine;
import main.coreGUI;
import script.Plugin;
import script.log;
import utils.www.Link;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class searchComponents extends Plugin{
     
    String id = "Components";
    
    @Override
    public void startup(){
        // get our hook working for the specific license search
        log.hooks.addAction(SearchType.Components_Show.getHook(), 
                thisFile, "doFindComponents");  
    }
    
    /**
     * When a given search term is available, show the licenses that are
     * a possible match
     */ 
    public void doFindComponents() {
        String searchTerm = coreGUI.studio.getSearch().getText();
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }

        // create the link
        Link link = new Link();
        link.setTitle("details");
        link.setUrl("/components/showComponent?name=");
        
        String output = engine.components.search(searchTerm , link);
        coreGUI.studio.editorPane(is.contentHTML, false, 0, output, Boolean.TRUE, null);
    }
    
}
