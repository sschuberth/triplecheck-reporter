/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-12-11T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: show.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The class that shows details about a given SPDX document
available on our archive our shows all the available SPDX documents when no
specific document is mentioned.
 * </text> 
 */

package spdx;

import java.io.File;
import main.coreGUI;
import main.engine;
import main.param;
import script.Plugin;
import insights.EvaluateLicensingQuality;
import spdxlib.SPDXfile;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 11th of December 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class fix_suggestion extends Plugin{
   
    
    String showSPDX = "showSPDX",
            fixCopyright = "%fixCopyright%",
            fixLicense = "%fixLicense%",
            fixDocumentation = "%fixDocumentation%"
            ;
    
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        //log.hooks.addAction(Messages.RefreshSPDX, thisFile, "refreshCache");
    }
    
   /**
     * Show the details about what can be fixed on the current state of this
     * document.
     * @param request 
     */
    @Override
    public void main(WebRequest request) {
        // get the file associated to this request
        File file = getFileSPDX(request);
        // get the document associated
        SPDXfile spdx = engine.reports.get(file);
               
        // preflight check
        if(spdx == null){
            request.setAnswer("Didn't found the requested SPDX document");
            return;
        }
        
        // run the quality analysis
        // get quality evaluation
        EvaluateLicensingQuality qualityTest = new EvaluateLicensingQuality();
        
        // are we using audit mode or permissive mode?
        final String toggleValue = settings.read(coreGUI.toggleScore, "-1");
        final int value = Integer.parseInt(toggleValue);
        boolean rigidStyle = false;
        if(value == 1){
            rigidStyle= true;
        }
        // do the licensing quality test
        qualityTest.setAuditMode(rigidStyle);
        qualityTest.process(file);
        
        double score = qualityTest.getScore() / 10.0;
        
        // get the template loaded
        request.setTemplate("webpage_fix.html");
        // get the fix suggestions
        request.changeTemplate(fixCopyright, qualityTest.getSuggestionFixCopyrightHTML());
        request.changeTemplate(fixLicense, qualityTest.getSuggestionFixLicenseHTML());
        request.changeTemplate(fixDocumentation, qualityTest.getSuggestionFixDocumentationHTML());
       
        // currently we have a rendering performance issue when too many
        // files need to be listed, so we output the page to the browser
        if(qualityTest.getCountCopyrightNotDeclared() > 100 
                || qualityTest.getCountLicensesNotDeclared() > 100){
            // create a new file on disk
            File fileResult = new File(thisFolder, "temp-fix-suggestions.html");
            utils.files.SaveStringToFile(fileResult, request.getTemplateText());
            // open the URL on the browser
            utils.internet.openURL("file:///" + fileResult.getAbsolutePath());
            // all done
            request.setAnswer("Too many files to list on this window, "
                    + "opening your web browser to list them all.");
            return;
        }
        

        // all done
        request.closeTemplate();
    }
   
    
    /**
     * Provide an associated SPDX document based on the parameter
     * given on the web request
     * @param request
     * @return 
     */
    private File getFileSPDX(WebRequest request){
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File file = getFile(spdxTarget, request);
        if(file == null){
            return null;
        }
      
        // get the canonical form
        String fileCanonical = utils.files.getCanonical(file);
        file = new File(fileCanonical);
        
        // get the SPDX file from the root node
        return file;
    }
    
     /**
* Verifies if a given SPDX document exists inside our archive or or not
* @param spdxTarget The file inside the SPDX Archive
* @param request
* @return null if the file does not exists, otherwise return a pointer
*/
    public static File getFile(String spdxTarget, WebRequest request){
         if(spdxTarget == null){
            request.setAnswer("No file specified");
            return null;
        }
        // does this file exists?
        File file = new File(engine.getProductsFolder(), spdxTarget);
        // this file needs to exist
        if((file.exists() == false) || (file.isDirectory())){
            request.setAnswer("Sorry, the file was not found: " + spdxTarget);
            return null;
        }
        // all done
        return file;
    } 

}
