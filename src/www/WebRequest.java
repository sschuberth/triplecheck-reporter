/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-02T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: WebRequest.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class is used for interpreting requests deriving
 * from the GUI or from a web browser. </text> 
 */

package www;

import definitions.is;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.controller;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import script.log;

/**
 *
 * @author Nuno Brito, 2nd of December 2013 in Darsmtadt, Germany
 */
public class WebRequest {
    
    // the set of parameters in key/value style
    public ArrayList<String[]> parameters = new ArrayList<String[]>(); 
    
    // what we reply when there is no answer?
    private final String noAnswerReply = "No answer";
    
    // helps to know if this request has already been handled or not
    private boolean
            wasAnswered = false;
    
    public String 
            originIP; // if deriving from the web, what is the IP Address?
    
    private String
            answer, // what should be provide as answer (in HTML)
            templateText = ""; // when we want to use a template

    // defines the specific type of request that is being handled here
    public RequestType 
            requestType = RequestType.UNKNOWN;
    
     // defines from where this request is coming from
     // the idea is to help the processing adjust the answer accordingly
    public RequestOrigin
            requestOrigin = RequestOrigin.UNKNOWN;

    // Define the root folder where the related files are located?
    public File BaseFolder;
    
    // these two variables help to measure the processing time for each request
    private final long
            timeStart;
    
    private long
            timeEnd;
    
    // in case we want to run a file with a script
    public File 
            scriptFile = null,
            scriptFolder = null;
    // if a file with a script was added, which method should be run?
    public String scriptMethod;
    
    // used when we want to set up a page for this request
    private URL page;
    
    
    // used only for the SimpleFramework web server
    public Request requestSimple;
    public Response responseSimple;
    
      /**
     * The constructor, let's setup this object to track the time when it was
     * created and other initial settings.
     */
    public WebRequest(){
        timeStart = System.currentTimeMillis();
    }
    /**
     * Has this request already been processed?
     * @return True if there is an answer, false if none was yet done
     */
    public boolean hasAnswer(){
        return wasAnswered;
    }
    
        
    /**
     * When we have an answer ready, the next step is storing it inside
     * using this method.
     * @param text The HTML text that will be provided as answer
     */
    public void setAnswer(String text){
        setAnswer(text, false);
    }
    
    
    /**
     * When we have an answer ready, the next step is storing it inside
     * using this method.
     * @param text The HTML text that will be provided as answer
     */
    public void setAnswer(String text, boolean cache){
        // don't allow more than one answer to exist
        if(wasAnswered){
            System.err.println("WR001 - Answer for request was already given");
            return;
        }
        // set the answer text
        answer = text;  
        //System.out.println(text);
        wasAnswered = true;
        timeEnd = System.currentTimeMillis();
        // place this answer on the queue to be solved
        controller.display(this, cache);
        // all done in our side
    }
            
    
    public String getAnswer() {
        if(answer == null){
            setAnswer(noAnswerReply);
            return answer;
        }
        
        if(answer.isEmpty()){
            setAnswer(noAnswerReply);
        }
        return answer;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public long getTimeEnd() {
        return timeEnd;
    }
    
    /**
     * Adds a key value parameter to this request
     * @param key The title
     * @param value The value of the parameter
     */
    public void addParameter(String key, String value){
        String[] parameter = new String[]{key, value};
        // initialize this array if necessary
        if(parameters == null){
            parameters = new ArrayList<String[]>();
        }
        parameters.add(parameter);
    }

    
    /**
     * Defines an HTML page as the template to be written as answer
     * @param pageHTML an HTML file on disk
     */
    public void setTemplate(String pageHTML){
        File file = new File(BaseFolder, pageHTML);
        
        // in case the file does not exist, complain here
        if(file.exists() == false){
            log.write(is.ERROR, "WRs44 - File not found to be used as template:"
                    + " %1", file.getAbsolutePath());
        }
               
        templateText = utils_deprecated.files.readAsString(file);
    }
    
    
    /**
     * Changes the text on the template
     * @param oldText original text with old value
     * @param newText what we want to see as new value
     */
    public void changeTemplate(String oldText, String newText){
        templateText = templateText.replace(oldText, newText);
    }
    
    /**
     * Closes the request using the template text as source for reply
     */
    public void close(){
        setAnswer(templateText);
    }
    
    
    /**
     * No further changes to the template are possible
     */
    public void closeTemplate(){
        File file = new File(BaseFolder, "temp.html");
        utils_deprecated.files.SaveStringToFile(file, templateText);
        setPage(file);
    }
    
    
    
    /**
     * If there is a page available, give it back
     * @return The URL object with the respective Page object
     */
    public URL getPage() {
        return page;
    }

    /**
     * If there is a page that we want to setup, this is the place
     * @param page 
     */
    public void setPage(URL page) {
        this.page = page;
    }
    
    /**
     * If there is a page that we want to setup, this is the place
     * @param page 
     */
    public void setPage(File page) {
        try {
            setPage(page.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(WebRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fileText = utils_deprecated.files.readAsString(page);
        setAnswer(fileText);
    }
    
     /**
     * If there is a page that we want to setup, this is the place
     * @param page An HTML page on the same folder where the script is running
     */
    public void setPage(String page) {
        log.write(is.COMPLETED, "Displaying web page: %1", page);
        File file = new File(BaseFolder, page);
        setPage(file);
    }
   

    /**
     * Helps to clarify if a page was loaded or not
     * @return true when there is a page available
     */
    public boolean hasPage(){
        return page != null;
    }
    
    
    /**
     * Retrieves a specific parameter from this request
     * @param key the title of the parameter
     * @return A string with the requested parameter or null as reply if doesn't exist
     */
    public String getParameter(String key){
        String result = null;
        // go through all parameters
        for(String[] parameter : parameters){
            // don't be picky, we accept both lower or upper case combinations
            if(parameter[0].equalsIgnoreCase(key)){
                // we have a match, get its value
                result = parameter[1];
                // all done, no need to continue
                break;
            }
        }
        return result;
    }
    
    
}
