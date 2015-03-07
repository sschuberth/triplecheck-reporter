/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-03T12:10:47Z
 * LicenseName: AGPL-3.0+
 * FileName: showComponents.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for finding components </text> 
 */

package components;

import GUI.SearchType;
import comp.LinkType;
import definitions.is;
import java.util.ArrayList;
import main.engine;
import main.coreGUI;
import script.Plugin;
import main.script.log;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class searchComponents extends Plugin{
     
    String id = "Components";
    
    final String
    descStartSmall = "<br><span style=\"font-family: serif; color: rgb(0, 0, 0); "
    + "background-color: rgb(180, 255, 148); font-size: 12px; "
    + "line-height: 33px;\">&nbsp;",
    descEnd = "&nbsp;</span>";
    
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
        String searchTerm = coreGUI.studio.getSearch().getText().toLowerCase();
        
        // no need to worry about empty searches or less than two characters
        if(searchTerm.length() < 2){
            return;
        }

        // list the links that we want to show
        ArrayList<LinkType> links = new ArrayList();
        links.add(LinkType.View);
        
        String result = engine.components.search(searchTerm , links);
        
        // main title of the component
        result = result.replace("<%t1%>", descStartSmall);
        result = result.replace("</%t1%>", descEnd);
        // description of the item
        result = result.replace("<%d1%>", "<br><i>");
        result = result.replace("</%d1%>", "</i>");

        coreGUI.studio.editorPane(is.contentHTML, false, 0, result, Boolean.TRUE, null);
    }
    
}
