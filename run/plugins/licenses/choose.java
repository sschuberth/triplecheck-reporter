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

import definitions.Messages;
import script.Plugin;
import script.log;
import utils.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 08th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class choose extends Plugin{
    
    
    @Override
    public void startup(){
        // react whenever a tree node is changed
         log.hooks.addAction(Messages.TreeNodeDoubleClick, 
                thisFile, "processDoubleClick");    
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
     * This method shows a list of licenses to the end-user and permits
     * to choose one that will be applied to a given set of files.
     * @param request 
     */
    public void selectLicense(WebRequest request) {
        // get the first parameter
        String[] action = request.parameters.get(0);
        // now translate this parameter to the set of UID
        String[] listUID = action[0].split(";");
        
        
        
        request.setAnswer(utils.text.arrayToString(listUID, html.br));
    }
    
}
