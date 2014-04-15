/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-06T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: RunningTask.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class allows setting a thread that will perform 
 * a specific task. It is an extension of the Thread class that allows an
 * integration with the software to allow controlling it.</text> 
 */

package script;

import definitions.is;
import java.util.ArrayList;
import java.util.HashMap;
import main.core;

/**
 *
 * @author Nuno Brito, 6th of December 2013 in Darsmtadt, Germany
 */
public class RunningTask{
    
    protected int percentageComplete = 0;
    protected String 
            status = ""; // what is currently happening
    
    public String
            nextStep  = ""; // what the user can do after the task was completed
    
    // give an unique ID to this object
    private final long UID = System.currentTimeMillis();
    private String title;
    // is this task running or not?
    protected Boolean isProcessing = false;
    
    // where we keep our shared objects
    public HashMap
            temp = new HashMap<String, Object>();
    
     // the text that is repeated across these messages
    private String getHeader(){
        return "Task \"" + title //+ "\" ("+ UID + ")"
                + ": ";
    }
       
    // where we keep track of what has happened on this task
    private ArrayList<String> logHistory = new ArrayList();
    
    /**
     * Launches the task
     */
    public void launch(){
         // add up this object to the list of running tasks
        core.runningTasks.add(this);
        log.write(is.INFO, "Added a new task to our queue with the id: %1", "" 
                + UID);
        run();
    }

    /**
     * Informs if this task is still processing or not
     * @return true if it is still processing
     */
    public Boolean isProcessing() {
        return isProcessing;
    }

    /**
     * Returns the UID for this task. Should be noted that this unique
     * identification is also the time when the task has been initiated.
     * @return The value with the unique identification and time of creation
     */
    public long getUID() {
        return UID;
    }

    /**
     * The status of this task, up to date information about what is currently
     * happening. When the task is terminated, shows a summary about what has
     * happened.
     * @return A short message without any HTML formatting
     */
    public String getStatus() {
        return status;
    }

    /**
     * How far from overall percentage are we at completing this task?
     * @param percentageComplete 
     */
    public void setPercentageComplete(int percentageComplete) {
        String result = log.write(is.INFO, getHeader() + percentageComplete + "% complete");
        this.percentageComplete = percentageComplete;
        //logHistory.add(result);
    }

    
    /**
     * Outputs a log message to let everyone know what is happening
     * @param logMessage 
     */
    private String doLogMessage(String logMessage, String... parameters){
        String result = "";
        // no title? we can't proceed, sorry.
        if(title.isEmpty()){
            return result;
        } 
        
        
        
        if(parameters.length == 0)
            result = log.write(is.INFO, getHeader() + logMessage);
        
        if(parameters.length == 1)
            result = log.write(is.INFO, getHeader() + logMessage, parameters[0]);
        
        if(parameters.length == 2)
            result = log.write(is.INFO, getHeader() + logMessage, parameters[0], 
                    parameters[1]);
        
        // clean up the end result
        result = result.replace(getHeader(), "");
        logHistory.add(result);

        // all done
        return result;
    }

   
    
    /**
     * Text message with our current status explanation
     * @param status A text message, no HTML formatting here
     */
    public void setStatus(String status) {
        this.status = doLogMessage(status);
    }
    
    public void setStatus(String status, String parameter1) {
        this.status = doLogMessage(status, parameter1);
    }

    public void setStatus(String status, String parameter1, String parameter2) {
        this.status = doLogMessage(status, parameter1, parameter2);
    }

    /**
     * The title that identifies the generic type of task being done
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Are we still doing something with this task?
     * @param isProcessing True if there is action going on
     */
    public void setIsProcessing(Boolean isProcessing) {
        this.isProcessing = isProcessing;
    }

    
    
    /**
     * The title that gives the user an idea of what is being done
     * @return A normal text string with the title
     */
    public String getTitle() {
        return title;
    }
     
    
    public int getPercentage() {
        return this.percentageComplete;
    }
     
    /**
     * This method is where all the action happens, it is meant to be
     * overridden when implementing the task
     */
    public void doTask(){}
   
    // @Override
    public void run(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                isProcessing = true;
                doTask();
                isProcessing = false;
                }
            };
        thread.start();
    }

    /**
     * Returns what has happened so far with this task
     * @return An array with all the log activity
     */
    public ArrayList<String> getLogHistory() {
        return logHistory;
    }

   
    
    
}
