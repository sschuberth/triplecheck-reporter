/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-12-11T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
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
import spdxlib.EvaluateLicensingQuality;
import spdxlib.FileCategory;
import spdxlib.FileInfo2;
import spdxlib.FileOrigin;
import spdxlib.SPDXfile2;
import utils.www.html;
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
        SPDXfile2 spdx = engine.reports.get(file);
               
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
        // get the copyright evaluation
        evaluateCopyright(request, spdx, qualityTest);
        
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

    /**
     * Give advice regarding how well the copyright is documented. We expect
     * this method to only be called when modifying the web template
     * @param request 
     */
    private void evaluateCopyright(WebRequest request, SPDXfile2 spdx,
            EvaluateLicensingQuality test) {
        // where we store the results
        String result = "";
        int counter = 0;
        // do we really need an evaluation for this topic?
        if(test.getMaxPointsForCopyright() == test.getScoreCopyright()){
            result = "No action needed for this topic, looking good.";
            request.changeTemplate(fixCopyright, result);
            return;
        }
        
        // it seems that we do have some work to be done here
        for(FileInfo2 file : spdx.getFiles()){
            
            // we only want to process source code files
            if(file.getExtensionObject().getCategory() != FileCategory.SOURCE){
                continue;
            }
            // ignore the files that already have the copyright declared
            if(file.hasCopyrightDeclared()){
                continue;
            }
            
            // if the file was automatically generated, then don't care about it
            if(file.getFileOrigin() == FileOrigin.AUTOMATED){
                continue;
            }
            
            // list the ones that we still need to modify
            result = result.concat(""
                    + file.getFileName()
                    + html.br
            );
            // increase the counter
            counter++;
        }
        
        // adapt accordingly to a single result or  multiple results
        if(counter == 1){
            result = "No copyright statement was found for "
                    + result;
        }else{
            // show the list of results
        result = "No copyright statement was found for the "
                + "<b>"
                + counter
                + "</b>"
                + " files listed below."
                + html.br
                + html.br
                + result;
        }
        
        // output the result to public
        request.changeTemplate(fixCopyright, result);
            
    }
    
    

}
