/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-03T11:22:45Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Component.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Helps to findId and process the components that we
 * have available. </text> 
 */

package structure;

import com.google.gson.Gson;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import main.core;



/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class ComponentControl {
  
    /**
     * Do a basic test of the components that we have available
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        writeDefaultComponentToDisk();
        
        ComponentControl components = new ComponentControl();
        components.findId("def");
        
        Component component = components.findId("default");
        
        System.out.println(component.downloadURL);
        
        System.exit(1981);
    }
    
    
    /**
     * Simple test, write the default component to disk
     */
    private static void writeDefaultComponentToDisk(){
         Component comp = new Default();
         comp.writeToDisk();
    }

    
    /**
     * Looks for components that match an exact Id. If there is more than
     * one component with the same Id, only the first one that is found will
     * be provided.
     * @param id    The unique identification for the component
     */
    public Component findId(final String id) {
        return findId(id, core.getComponentFolder(), 25);
    }
    
    /**
     * The iterative method that will match a specific ID
     * @param id        The id to match
     * @param where     The folder where we want to look
     * @param maxDeep   How deep in the folder structure can we go?
     * @return          A component if exact match is found, null otherwise
     */
    private Component findId(final String id, File where, int maxDeep){
    // create the gson builder
    Gson gson = new Gson();
    // get an array with the files on the current folder
    File[] files = where.listFiles();

    if(files != null)
        // iterate through each file
        for (File file : files) {
        if (file.isFile()){
            // read the contents of this file
            final String input = utils.files.readAsString(file);
            final Component result = gson.fromJson(input, Component.class);
            if(utils.text.equals(result.id, id)){
                return result;
            }
        }
        else
        if ( (file.isDirectory())
            &&( maxDeep-1 > 0 ) ){
            // do the recursive crawling
            Component result = findId(id, file, maxDeep-1);
            if(result != null){
                return result;
            }
        }
        }
    return null;
  }
    
    
}


class Default extends Component{
    public Default(){
        id = "default";
        title = "The default component";
        referenceURL = "http://triplecheck.de";
        downloadURL = "http://triplecheck.de/download";    
        authors = "Nuno Brito";
        descriptionOneLine = "A test component";
        descriptionLarge = "This test component helps to debug the component functionality";
        organization = "TripleCheck";
        version = "1.0";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        
        dateCreated = "2014-6-03 11:45:51";
        dateLastModified = dateFormat.format(new Date());

        applicableLicenses = new ArrayList();
        subComponents = new ArrayList();

    }
}
