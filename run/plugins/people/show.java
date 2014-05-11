/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-15T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: show.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows handling the details with people inside SPDX
 *  documents. </text> 
 */

package people;

import definitions.is;
import java.io.File;
import main.core;
import main.param;
import net.htmlparser.jericho.FormFields;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import script.Plugin;
import script.log;
import spdxlib.Person;
import spdxlib.SPDXfile;
import spdxlib.TagValue;
import utils.html;
import www.WebRequest;

/**
 *
 * @author Nuno Brito, 15th of December 2013 in Darsmtadt, Germany
 */
public class show extends Plugin{

    String 
            name = "name",
            email = "email",
            organization = "organization",
            organizationEmail = "organizationemail",
            tool = "tool",
            toolVersion = "toolversion",
            sourceTag = "source";
    /**
     * Show the details about a given person
     * @param request
     * @expectedparameters: param.SPDX, "person"
     */
    public void details(WebRequest request){
        // get our template file
        File page = new File(thisFolder, "person.html");
        // create the template
        templateCreate(request, page);
    }
    
    
    /**
     * Change the details on the template page with the details of the person
     * that was currently selected
     */
    private void templateCreate(WebRequest request, File templatePage){
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File file = getFile(spdxTarget, request);
        if(file == null){
            return;
        }
        
        // get the SPDX file from the root node
        //System.err.println("DBG-S72 Reading SPDX");
        SPDXfile spdx = core.reports.get(file);
                //new SPDXfile(file);
       
        // get the filter, from where we will get our data to replace
        String filter = request.getParameter(param.filter);
        // the place where we will hold the person details
        Person person = null;
        // iterate through all known people
        for(Person thisPerson : spdx.creatorSection.people){
            if(thisPerson.getTitle().equals(filter)){
                // we found a match (ignore any duplicates)
                person = thisPerson;
                break;
            }
        }
        // need to check if we do have someone..
        if(person == null){
            request.setAnswer("Person was not found");
            return;
        }
        
        // place the contents of our template inside a string
        String webText = utils.files.readAsString(templatePage);
       
        // instantiate our HTML manipulating class
        Source source = new net.htmlparser.jericho.Source(webText);
        // get all the data available right now on the form
        FormFields formFields = source.getFormFields();
       
        formFields.setValue(name, person.getPerson());
        formFields.setValue(email, person.getPersonEmail());
        formFields.setValue(organization, person.getOrganization());
        formFields.setValue(organizationEmail, person.getOrganizationEmail());
        formFields.setValue(tool, person.getTool());
        formFields.setValue(toolVersion, person.getToolVersion());
        // point where is the SPDX with this information
        formFields.setValue(sourceTag, spdxTarget);
        formFields.setValue(param.filter, filter);
        
        
        // save the output
        OutputDocument outputDocument = new OutputDocument(source);
        // adds all segments necessary to effect changes
        outputDocument.replace(formFields);
        String result = outputDocument.toString();
       
        File tempFile = new File(thisFolder, "temp.html");
        utils.files.SaveStringToFile(tempFile, result);

        request.setPage(tempFile);
       //request.setAnswer(result);
    }
   
    /**
    * Save the settings to disk
    * @param request 
    */
    public void save(WebRequest request){
         // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(sourceTag);
        // does this file exists?
        File file = getFile(spdxTarget, request);
        if(file == null){
            return;
        }
        
        // get the SPDX file from the root node
        SPDXfile spdx = new SPDXfile(file);
       
        // get the filter, from where we will get our data to replace
        String filter = request.getParameter(param.filter);
        // the place where we will hold the person details
        Person person = null;
        // iterate through all known people
        for(Person thisPerson : spdx.creatorSection.people){
            if(thisPerson.getTitle().equals(filter)){
                // we found a match (ignore any duplicates)
                person = thisPerson;
                break;
            }
        }
        // need to check if we do have someone..
        if(person == null){
            request.setAnswer("Person was not found");
            return;
        }
        
        // name of the SPDX author
        processItem(person.getTagPerson(), person.getPerson(),
                person.getAnchor(), spdx, request, name, "Creator: ");

        // email of the SPDX author
//        processItemEmail(person.getTagPerson(), person.getPerson(),
//                person.getAnchor(), spdx, request, email);
//        
        // does the name need to be changed?
        String thisPersonEmail = getParam(email, request);
        if(thisPersonEmail.endsWith(person.getPersonEmail())==false){
            // we need to change things
            spdx.changeTag(person.getTagPerson(), person.getPersonEmail(), thisPersonEmail);
        }
        
        
        // organization
        processItem(person.getTagOrganization(), person.getOrganization(),
                person.getAnchor(), spdx, request, organization, "Creator: Organization:");
      
         // does the name need to be changed?
        String thisOrganizationEmail = getParam(organizationEmail, request);
        if(thisOrganizationEmail.endsWith(person.getOrganizationEmail())==false){
            
            // we need to change things
            spdx.changeTag(person.getTagOrganization(), person.getOrganizationEmail(), thisOrganizationEmail);
        }
       

        // tool
        processItem(person.getTagTool(), person.getTool(),
                person.getAnchor(), spdx, request, tool, "Creator: Tool:");

      
       // does the name need to be changed?
        String thisToolVersion = getParam(toolVersion, request);
        if(thisToolVersion.endsWith(person.getToolVersion())==false){
            // we need to change things
            spdx.changeTag(person.getTagTool(), person.getToolVersion(), thisToolVersion);
        }
      
        
        //System.out.println(spdx.rawText);
        spdx.commitChanges();
        
        
         // all done
        String message = html.h3("Settings saved!");
        request.setAnswer(
                message
        //        utils.html.redirect("/webserver/server", 2, message)
        );
    }
    
    /**
     * Process the organization details
     * @param person the object with the details from the person
     * @param spdx the SPDX document
     * @param request the web request from the end user
     */
    private void processItem(TagValue oldTag, String oldValue, 
            int linePosition,
            SPDXfile spdx, WebRequest request,
            String formParam, String newTagText){
        // get the proposed value
        String newValue = getParam(formParam, request);
        // do we have an organization tag available?
        if(oldTag == null){
            // none, this means we need to create one
            String text = newTagText + " " + newValue; 
            spdx.addTag(linePosition, text); 
            log.write(is.ADDING, "Added new tag as %1", text);
            return;
            }
        
        // does the name exists but just needs to be changed?
        if(newValue.endsWith(oldValue)==false){
            // we need to change things
            spdx.changeTag(oldTag, oldValue, newValue);
        }
    }
    
//    /**
//     * Process the organization details
//     * @param person the object with the details from the person
//     * @param spdx the SPDX document
//     * @param request the web request from the end user
//     */
//    private void processItemEmail(TagValue originalTag, 
//            SPDXfile spdx, WebRequest request, String formParam){
//        // get the proposed value
//        String newValue = getParam(formParam, request);
//        // do we have an organization tag available?
//        if(originalTag == null){
//            // none, this means we need to create one
//            String text = newTagText + " " + newValue; 
//            spdx.addTag(linePosition, text); 
//            log.write(is.ADDING, "Added new tag as %1", text);
//            return;
//            }
//        
//        // does the name exists but just needs to be changed?
//        if(newValue.endsWith(oldValue)==false){
//            // we need to change things
//            spdx.changeTag(oldTag, oldValue, newValue);
//        }
//    }
   
    
    /**
     * 
     * @param parameter
     * @param request 
     */
    private String getParam(String parameter, WebRequest request){
        String result = "";
        try{
            result = request.getParameter(parameter);
        }catch (Exception e){
        }
        return result;
    }
    
    /**
     * Verifies if a given SPDX document exists inside our archive or or not
     * @param spdxTarget The file inside the SPDX Archive
     * @return null if the file does not exists, otherwise return a pointer
     */
    private File getFile(String spdxTarget, WebRequest request){
         if(spdxTarget == null){
            request.setAnswer("No file specified");
            return null;
        }
        // does this file exists?
        File file = new File(core.getProductsFolder(), spdxTarget);
        // this file needs to exist
        if((file.exists() == false) || (file.isDirectory())){
            request.setAnswer("File was not found in our archive, sorry");
            return null;
        }
        // all done
        return file;
    }
    
}
