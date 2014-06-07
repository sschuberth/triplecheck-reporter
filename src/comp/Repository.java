/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-04T17:55:35Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Repository.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the parameters for a basic repository.</text> 
 */

package comp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
*/
public class Repository {
    
    private String 
            title,
            created,
            license,
            copyright,
            comments,
            type;        

    
    /**
     * Reads the settings for this repository from a given json string
     * @param json  The JSON string
     */
    public void read(final String json){
        Gson gson = new Gson();
        Repository temp = gson.fromJson(json, Repository.class);
        title = temp.title;
        created = temp.created;
        license = temp.license;
        copyright = temp.copyright;
        comments = temp.comments;
        type = temp.type;
    }
    
    /**
     * Returns a gson string with the contents of this object
     * @return  A json text
     */
    public String getJsonString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
