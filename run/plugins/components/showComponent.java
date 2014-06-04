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

import main.core;
import script.Plugin;
import spdxlib.License;
import structure.Component;
import utils.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class showComponent extends Plugin{
    
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       final String name = request.getParameter("name");
       final String type = request.getParameter("type");
       final String path = request.getParameter("path");
       final String license = request.getParameter("license");
       // no type means that we are dealing with a custom component
       if(type == null){
           Component component = core.components.get(name);
           final String result = component.getSummaryHTML();
           request.setAnswer(result);
           return;
       }
       
       // can we get the details without further delay?
       if(type.equals("gc")){
           String result = Component.getGoogleCodeDescription(name);
           
           String link = "https://code.google.com/p/" + name;
           
           result += html.br
                   + html.br
                   + html.div()
                   + "License: " + license
                   + html.br
                   + "Project page: "
                   + html.link(link, link)
                   + html._div
                   + html.br
                   + html.br
                   ;
           
           request.setAnswer(result);
           return;
       }
       
//       // otherwise, we are dealing from a repository component t
//       Component component = core.components.getFromRepository(path, name);
//       // no need to continue if we found nothing
//       if(component == null){
//           request.setAnswer("Error: Couldn't find " + name + " in " + path);
//           return;
//       }
//       // get the data from the component
//       String result = component.getSummaryHTML();
//       
//       // if this is google code project, we can show some more info
//       if(type.equals("gc")){
//           result += component.getGoogleCodeDescription();
//       }
//       
//       request.setAnswer(result);
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
