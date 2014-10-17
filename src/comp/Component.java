/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-03T11:09:05Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Component.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class defines a basic software component. It
 * is later used for grouping files under a single component/license(s)</text> 
 */

package comp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.ArrayList;
import main.engine;
import spdxlib.License;
import utils.www.html;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class Component {

    protected String
            id,             // short identifier (only numbers and letters, no spaces permitted)
            title,          // the full title for the component
            referenceURL,   // the home page or website that explains component
            downloadURL,    // when available, from where it can be downloaded    
            authors,        // main authors and contributors (separated by \n)
            desc,           // short summary about the component
            organization,   // to which company, foundation (...) is the code related
            version,        // in some cases, the applicable version
            dateCreated,    // when this component was first created
            dateLastModified,   // last time it was modified
            lic,            // the license declared by the author
            remarks,        // special remarks to be included in reports
            type;           // comes from a public repository or is it local?
            
    protected ArrayList<License> applicableLicenses;  // set of applicable licenses
    protected ArrayList<Component> subComponents;  // components included within

    public void setApplicableLicenses(ArrayList<License> applicableLicenses) {
        this.applicableLicenses = applicableLicenses;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    

    public void setDescription(String descriptionOneLine) {
        this.desc = descriptionOneLine;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setReferenceURL(String referenceURL) {
        this.referenceURL = referenceURL;
    }

    public void setSubComponents(ArrayList<Component> subComponents) {
        this.subComponents = subComponents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDeclaredLicense(String declaredLicense) {
        this.lic = declaredLicense;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ArrayList<License> getApplicableLicenses() {
        return applicableLicenses;
    }

    public String getAuthors() {
        return authors;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public String getDescription() {
        return desc;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public String getId() {
        return id;
    }

    public String getLic() {
        return lic;
    }

    public String getOrganization() {
        return organization;
    }

    public String getReferenceURL() {
        return referenceURL;
    }

    public String getRemarks() {
        return remarks;
    }

    public ArrayList<Component> getSubComponents() {
        return subComponents;
    }

    public String getTitle() {
        if(title == null){
            return id;
        }
        
        return title;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }
    
    
    
    /**
     * Writes this component to disk
     */
    public void writeToDisk(){
        // convert this object to a json representation
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(this);
        // now get the file where the json will be written
        File file = new File(engine.getComponentFolder(), id + ".json");
        // now write it up
        utils.files.SaveStringToFile(file, jsonOutput);
    }

  
    /**
     * Returns a gson string with the contents of this object
     * @return  A json text
     */
    public String getJsonString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
    
    
    /**
     * Outputs a simple HTML report about this component to the end user
     * @return  An HTML text
     */
    public String getSummaryHTML() {
        if(title == null){
            title = id;
        }
        
        String details = "";
        
        details += addItem(desc, "Description");
        details += addItem(authors, "Authors");
        details += addItem(lic, "License");
        details += addItem(organization, "Organization");
        details += addItem(downloadURL, "Download URL");
        details += addItem(referenceURL, "Reference URL");
        details += addItem(remarks, "Remarks");
        details += addItem(dateCreated, "Date when record was created");
        details += addItem(dateLastModified, "Date when record was modified");
        
        return ""
                + html.div()
                + html.h2(title)
                + details
                + html._div
                ;
    }

    
    /**
     * Adds a field of the component object if it is not empty
     * @return  A string ready to be added on the output, or an empty string
     * if the value itself is empty or null
     */
    private String addItem(final String field, final String title){
        // preflight check
        if(field == null || field.isEmpty()){
            return "";
            
        }
        // output the text
        return html.h3(title) 
                + html.div()
                + field
                + html._div
                ;
    }
    
    
    /**
     * this method is used on lists where we can pick this component
     * @param title The title to show on the link
     * @param link  The base URL where the link points to
     * @return 
     */
    String getOneLineHTML(ArrayList<LinkType> links) {
        
        if(title == null || title.isEmpty()){
            title = id;
        }
        
        String result = this.title
                + " "
                + html.textGrey("("+ id +")")
                + " ";
        
        for(LinkType link : links){
            switch(link){
                case View:
                    result += " | " + html.link("view", "/components/showComponent.java?name=" + id 
                            + "&type=" + type);
                    break;
                case Choose:
                    result += " | " + html.link("choose", "choose/?x=select&name=" + id);
                    break;
                    
            }
        }
        
        // add the description
        final int max = 70;
        String descOutput;
        if(desc.length() > max){
            descOutput = desc.substring(0, max);
            int lastSpace = descOutput.lastIndexOf(" ");
            descOutput = descOutput.substring(0, lastSpace) + " (..)";
        }else{
            descOutput = desc;
        }
        
        
        result += html.textGrey(" <i>" + descOutput + "</i>");
        
        // all done
        return result;
    }

    void setType(final String typeRepository) {
        type = typeRepository;
    }
    

}
