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

package structure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import main.core;
import spdxlib.License;


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
            descriptionOneLine,// one line summary about the component
            descriptionLarge,  // a more complete description in detail 
            organization,   // to which company, foundation (...) is the code related
            version,        // in some cases, the applicable version
            dateCreated,        // when this component was first created
            dateLastModified;   // last time it was modified
            
    protected ArrayList<License> applicableLicenses;  // set of applicable licenses
    protected ArrayList<Component> subComponents;  // components included within
    
    /**
     * Writes this component to disk
     */
    public void writeToDisk(){
        // convert this object to a json representation
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(this);
        // now get the file where the json will be written
        File file = new File(core.getComponentFolder(), id + ".json");
        // now write it up
        utils.files.SaveStringToFile(file, jsonOutput);
    }
    
}
