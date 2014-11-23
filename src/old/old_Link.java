/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-05T15:22:47Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Link.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines a basic HTML link </text> 
 */

package old;

import java.util.ArrayList;
import utils.www.html;


/**
 *
 * @author Nuno Brito, 5th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class old_Link {

    private ArrayList<old_Link> links = new ArrayList();
    
    private String 
            title, 
            url,
            extra = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getLink(){
        if(links.isEmpty()){
            return html.link(title, url + extra);
        }else{
            String result = html.link(title, url + extra);
            
            for(old_Link link : links){
                result = result.concat(" | " + link.getLink());
            }
            
            return result;
        }
    }
    
    /**
     * Sometimes useful to have more than one link per object
     * @param link 
     */
    public void addLink(old_Link link){
        links.add(link);
    }

    /**
     * Add a parameter to a link
     * @param string 
     */
    public void addParameters(String text) {
        this.extra = text;
        if(links.isEmpty() == false){
            for(old_Link link : links){
                link.addParameters(text);
            }
        }
    }
    
}
