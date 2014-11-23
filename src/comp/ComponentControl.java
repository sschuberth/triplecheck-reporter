/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-03T11:22:45Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Component.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Helps to get and process the components that we
 * have available. </text> 
 */

package comp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import main.engine;
import utils.www.html;
import utils.www.Link;





/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class ComponentControl {


    enum SearchType {exactId, report, anyText};
    
    int componentCounter = 0;
    
    /**
     * Do a basic test of the components that we have available
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        writeDefaultComponentToDisk();
        
        ComponentControl components = new ComponentControl();
        components.get("def");
        Component component = components.get("default");
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
    public Component get(final String id) {
        // try to find a custom component first
        Component result = findId(id, SearchType.exactId, engine.getComponentFolder(), 25);
        return result;
    }
    
    /**
     * The iterative method that will match a specific ID
     * @param id        The id to match
     * @param where     The folder where we want to look
     * @param maxDeep   How deep in the folder structure can we go?
     * @return          A component if exact match is found, null otherwise
     */
    private Component findId(final String id, final SearchType searchType, 
            File where, int maxDeep){
    // create the gson builder
    Gson gson = new Gson();
    // get an array with the files on the current folder
    File[] files = where.listFiles();

    if(files != null)
        // iterate through each file
        for (File file : files) {
            final String name = file.getName();
            if (file.isFile() && name.endsWith(".json")){
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
                Component result = findId(id, searchType, file, maxDeep-1);
                if(result != null){
                    return result;
                }
            }
        }
    return null;
  }
    
    /**
     * The iterative method that will get all the custom created components
     * @param id        The id to match
     * @param where     The folder where we want to look
     * @param maxDeep   How deep in the folder structure can we go?
     * @return          A component if exact match is found, null otherwise
     */
    private String getReportCustomComponents(final ArrayList<LinkType> link,
            File where, int maxDeep){
        // create the gson builder
        Gson gson = new Gson();
        // get an array with the files on the current folder
        File[] files = where.listFiles();

        String output = "";

        if(files != null)
            // iterate through each file
            for (File file : files) {
                try{
                final String name = file.getName();
                if (file.isFile() && name.endsWith(".json")){
                    // read the contents of this file
                    final String input = utils.files.readAsString(file);
                    final Component result = gson.fromJson(input, Component.class);
                    output += result.getOneLineHTML(link) 
                            + html.br
                            ;
                    componentCounter++;
                }
                else
                if ( (file.isDirectory())
                    &&( maxDeep-1 > 0 ) ){
                    // do the recursive crawling
                    output += getReportCustomComponents(link, file, maxDeep-1);
                }
                }catch (Exception e){
                    System.err.println("CC156 - Invalid component: "
                    + file.getName() + "\n" + e.getMessage());
                }
            }
    return output;
  }

     /**
     * The iterative method that will get all the custom created components
     * @param id        The id to match
     * @param where     The folder where we want to look
     * @param maxDeep   How deep in the folder structure can we go?
     * @return          A component if exact match is found, null otherwise
     */
    private String searchLocalRepository(final ArrayList<LinkType> link,
            File where,final String searchTerm, int maxDeep){
        // create the gson builder
        Gson gson = new Gson();
        // get an array with the files on the current folder
        File[] files = where.listFiles();

        String output = "";

        if(files != null)
            // iterate through each file
            for (File file : files) {
                final String name = file.getName();
                if (file.isFile() && name.endsWith(".json")){
                    // read the contents of this file
                    final String input = utils.files.readAsString(file);
                    final Component result = gson.fromJson(input, Component.class);
                    // only continue if the id contain part of the search term
                    if(result.id.contains(searchTerm) == false){
                        continue;
                    }
                    output += result.getOneLineHTML(link) 
                            + html.br
                            ;
                    componentCounter++;
                }
                else
                if ( (file.isDirectory())
                    &&( maxDeep-1 > 0 ) ){
                    // do the recursive crawling
                    output += searchLocalRepository(link, file, searchTerm, maxDeep-1);
                }
            }
    return output;
  }

    
    
       
    /**
     * The iterative method that will match a specific ID
     * @param id        The id to match
     * @param where     The folder where we want to look
     * @param maxDeep   How deep in the folder structure can we go?
     * @return          A component if exact match is found, null otherwise
     */
    private String searchRepositoriesHTML(final String id, final Link link, 
            File where, int maxDeep){
        // get an array with the files on the current folder
        File[] files = where.listFiles();

        String output = "";

        if(files != null)
            // iterate through each file
            for (File file : files) {
                final String name = file.getName();
                if (file.isFile() && name.endsWith(".jsons")){
                    // read the contents of this file
                    output += processJsonsLineFind(id, file, link);
                }
                else
                if ( (file.isDirectory())
                    &&( maxDeep-1 > 0 ) ){
                    // do the recursive crawling
                    output += searchRepositoriesHTML(id, link, file, maxDeep-1);
                }
            }
        return output;
    }   
    
    /**
     * Gets a specific component from a specific project
     * @param path
     * @param param
     * @return 
     */
    public Component getFromRepository(final String path, final String param) {
        return repositoryFindId(param, new File(engine.getComponentFolder(), path));
    }
    /**
     * Shows an HTML list of all the components that we have available on disk
     * @param title  The title show on the HTML link for further details
     * @param link  The initial part of the link used on the view details
     * @return      An HTML page ready for display to end-users
     */
    public String getReport(ArrayList<LinkType> link) {
        componentCounter = 0;
        String result = getReportCustomComponents(link, engine.getComponentFolder(), 25);
        
        result = html.h3("Custom components available (" + componentCounter + ")")
                + result;
        
        result = html.div() + result + html._div;
        
        return result;
    }
    
    /**
     * Given a file containing a json haystack, try to find a needle
     * @param searchTerm    the search term
     * @param file          the file with the set of json records per line
     * @return 
     */
    private String processJsonsLineFind(final String searchTerm, final File file,
            final Link link){
        // create the gson builder
        Gson gson = new Gson();
        String output = "";
        final int maxValue = 100;
        //System.err.println("CC219 - Processing " + file.getName());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int counter = 0;
            long countTime = System.currentTimeMillis();
            // interpret the header line
            String line = reader.readLine();
            Repository rep = new Repository();
            rep.read(line);
            // get the relative path
            final String path = file.getAbsolutePath()
                    .replace(engine.getComponentFolder().getAbsolutePath(), "").replace("\\", "/");
            // now define the type of dataset we are using to help with the link
            final String type = "&type=" + rep.getType()
                    + "&path=" + path
                    + "&license=" + rep.getLicense()
                    ;
            
            // iterate all the lines
            while( (line = reader.readLine()) != null){
                final Component result = gson.fromJson(line, Component.class);

                if(result.id.contains(searchTerm)){
                    counter++;
                    if(counter < maxValue){
                        link.addParameters(result.id + type);
                        output += result.id
                                + " "
                                + html.textGrey("("
                                    + result.desc
                                    + ")")
                                + " "
                                + link.getLink()
                                + html.br
                                ;
                    }
                }
            } 
            
            long result = System.currentTimeMillis() - countTime;
            
            // did we found too many results?
            if(counter > maxValue){
                output = html.textGrey("Found " + counter + " results, showing the first "
                        + maxValue)
                        + html.br
                        + output;
            }
            
            output += html.br 
                    + "Search time: " 
                    + utils.time.timeNumberToHumanReadable(result);
           // System.err.println("CC235 - " + output);
            
        }catch (Exception e){}
        return output;
    }
      
     /**
     * Given a file containing a json haystack, try to find a needle
     * @param searchTerm    the search term
     * @param file          the file with the set of json records per line
     * @return 
     */
    private Component repositoryFindId(final String id, final File file){
        // create the gson builder
        Gson gson = new Gson();
        System.err.println("CC297 - Retrieving component from " + file.getName());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            // interpret the header line
            reader.readLine();
            String line;
            // iterate all the lines
            while( (line = reader.readLine()) != null){
                // transform into a component
                final Component result = gson.fromJson(line, Component.class);
                // do we have a match?
                if(utils.text.equals(id, result.id)){
                    // add up the type of repository that we are using
                    final String name = file.getName();
                    // is it the google code repository?
                    if(name.contains("gc.jsons")){
                        result.setType("gc");
                        result.setReferenceURL("https://code.google.com/p/" 
                                + id + "/");
                    }
                    
                    return result;
                }
            }
           
        }catch (Exception e){
            System.err.println("CC314 - Exception occurred");
        }
        return null;
    }
    
    
  /**
   * 
   * @param searchTerm  What we want to find
   * @param title     The title of the link
   * @param link        The link location
   * @return 
   */
    public String search(String searchTerm, Link link) {
        
        ArrayList<LinkType> links = new ArrayList();
        links.add(LinkType.View);
        
        String result = "" 
                + html.div()
                + html.h2("Local components")
                + searchLocalRepository(links, engine.getComponentFolder(), searchTerm, 25)
                + html.br
                + html.h2("Results on public repositories")
                + html.div()
                + searchRepositoriesHTML
                    (searchTerm, link, engine.getComponentFolder(), 25)
                + html._div
                + html._div
                ;
        return result;
    }
    
}
class Default extends Component{
    public Default(){
        id = "default";
        title = "The default component";
        referenceURL = "http://triplecheck.de";
        downloadURL = "http://triplecheck.de/download";    
        authors = "Nuno Brito";
        desc = "A test component";
        //summary = "This test component helps to debug the component functionality";
        organization = "TripleCheck";
        version = "1.0";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        
        dateCreated = "2014-6-03 11:45:51";
        dateLastModified = dateFormat.format(new Date());

        applicableLicenses = new ArrayList();
        subComponents = new ArrayList();
    }
  
}
