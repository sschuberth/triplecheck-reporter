  /*
   * SPDXVersion: SPDX-1.1
   * Person: Person: Nuno Brito (nuno.brito@triplecheck.de)
   * Person: Organization: TripleCheck (contact@triplecheck.de)
   * Created: 2013-08-29T00:00:00Z
   * LicenseName: NOASSERTION
   * FileName: Person.java  
   * FileType: SOURCE
   * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
   * FileComment: <text> Class defining the identity of a given person </text> 
   */

package spdxlib;



public class Person {

    private String
            person = "", // mandatory field
            personEmail = "", // optional field
            organization = "", // mandatory field
            organizationEmail = "", // optional field
            tool = "", // mandatory field
            toolVersion = "" // mandatory field
            ;
    
    
    private TagValue
            tagOrganization,
            tagPerson,
            tagTool;
    
    /**
     * Provides a distinctive identifier title
     * @return 
     */
    public String getTitle(){
        // if there is a name, use it
        if(tagPerson != null){
            return tagPerson.toString();
        }
        // or use the organization name if available
        if(tagOrganization != null){
            return tagOrganization.toString();
        }
        // or even use the tool name if available
        if(tagTool != null){
            return tagTool.toString();
        }
        // nothing good here, just return null..
        return null;
    }

    public TagValue getTagPerson() {
        return tagPerson;
    }

    public void setTagPerson(TagValue tagPerson) {
        // do the basic handling
        person = tagPerson.toString();
        this.tagPerson = tagPerson;
        // now do the more refined processing, try to extract values
        String temp = tagPerson.toString();
        // do we have an email address like: "(nuno.brito@triplecheck.de)"?
         if(temp.contains(" (")&&temp.contains(")")){
            int start = temp.indexOf("(");
            int end = temp.lastIndexOf(")");
            //  something is wrong, just leave
            if(start +1 > end){
                return;
            }
            // get the email address
            String thisMail = temp.substring(start +1, end);
            this.personEmail = thisMail;
            this.person = temp.substring(0, start -1);
        }
    }

    public TagValue getTagOrganization() {
        return tagOrganization;
    }

    public void setTagOrganization(TagValue tagOrganization) {
        // do the basic handling
        organization = tagOrganization.toString();
        this.tagOrganization = tagOrganization;
        // now do the more refined processing, try to extract values
        String temp = tagOrganization.toString();
        // do we have an email address like: "(nuno.brito@triplecheck.de)"?
         if(temp.contains(" (")&&temp.contains(")")){
            int start = temp.indexOf("(");
            int end = temp.lastIndexOf(")");
            //  something is wrong, just leave
            if(start +1 > end){
                return;
            }
            // get the email address
            String thisMail = temp.substring(start +1, end);
            this.organizationEmail = thisMail;
            this.organization = temp.substring(0, start -1);
        }
    }

    public TagValue getTagTool() {
        return tagTool;
    }

    public void setTagTool(TagValue tagTool) {
        // basic handling
        this.tagTool = tagTool;
        tool = tagTool.toString();
        // more refined search for the version number
        int pos = tool.indexOf("-");
        if(pos < 1){
            return;
        }
        // hopefully we get a nicely formatted string
       toolVersion = tool.substring(pos+1);
       tool = tool.substring(0, pos);
    }
    
    
    
    @Override
    public String toString(){
        return getTitle();
    }

    public String getPerson() {
        return person;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public String getOrganization() {
        return organization;
    }

    public String getOrganizationEmail() {
        return organizationEmail;
    }

    public String getTool() {
        return tool;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    /**
     * Calculates what is the best place to add a new tag related to a Person
     * @return the line number inside the SPDX document that should be used
     */
    public int getAnchor() {
         // if there is a name, use it
        if(tagPerson != null){
            return tagPerson.linePosition;
        }
        // or use the organization name if available
        if(tagOrganization != null){
            return tagOrganization.linePosition;
        }
        // or even use the tool name if available
        if(tagTool != null){
            return tagTool.linePosition;
        }
        // nothing good here, just return 0 but this is not a goot thing..
        return 0;
    }
    
    
    
}
