/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-07T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: status.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows the status of tasks that were processed or that
 * are still running. </text> 
 */

package basic;

import definitions.Messages;
import definitions.is;
import main.core;
import script.Plugin;
import script.RunningTask;
import script.log;
import utils.html;
import www.Table;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 21st of December 2013 in Darsmtadt, Germany
 */
public class status extends Plugin{
     
    String id = "Task status";
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode(id, "application-monitor.png", "main");
    }
    
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // are there any tasks happening right now?
        if(core.runningTasks.isEmpty()){
            request.setPage("notasks.html");
            return;
        }
        
        // do we mention any task to see in special?
        String ID = request.getParameter(is.ID);
        // let's show more details about a specific task
        if(ID != null){
            processId(ID, request);
            return;
        }
        
        String result = 
                  html.div()
                + html.h2("Tasks")
                + html._div;
        
        String[] line = new String[]{
            "%" , 
            "Activity", 
            "Details",
            "Id", 
            "Status"
        };
        
        Table table = new Table(line);
        
        // list all the tasks
        for(RunningTask task : core.runningTasks){
            // gather the details
            line[0] = task.getPercentage() + "%";
            line[1] = task.getTitle();
            line[2] = "<a href=\"status?id="
                    + task.getUID() + "\">read</a>";
            line[3] = "" + task.getUID();
            line[4] = task.getStatus();
            // add the new line
            table.add(line);
           
        }
        
        // all done, output the results
        result += html.div(20) 
                + table.output()
                + html._div
                ;
        request.setAnswer(result);
    }

    /**
     * This method shows the details for a given task
     * @param ID The number ID of task
     * @param request where the reply is placed
     */
    private void processId(String ID, WebRequest request) {
        RunningTask task = null;
        long UID;
        // convert the text id onto a number that we can use
        try{
            UID = Long.parseLong(ID);
            // if something goes wrong, mark it here
        } catch (NumberFormatException e){
            UID = -1;
        }
        // something went wrong, fail here
        if(UID<0){
            request.setAnswer("Invalid ID number");
            return;
        }
        // go through all the tasks, try to find the one that is intended
        for(RunningTask thisTask : core.runningTasks){
            //System.err.println(thisTask.getUID());
            if(thisTask.getUID() == UID){
                task = thisTask;
                break;
            }
        }
        // have we found the task?
        if(task == null){
            // nope, time to fail here
            request.setAnswer("Task "+UID+" was not found");
            return;
        }
        // only now we are sure to have the task and be able of showing it
        displayStatus(task, request);
        
    }

    /**
     * Display the current status of the selected task
     * @param UID
     * @param request 
     */
    private void displayStatus(RunningTask task, WebRequest request) {
        // placeholder for the meta tag
        String meta = "";

        // add a page refresh in case the task is still processing
        if(task.isProcessing()){
            meta = utils.html.redirectMetaTag("/basic/status?id=" 
                    + task.getUID(), 3);
        }
        
        // include the log history so far
        String logHistory = "";
        if(task.getLogHistory().size() > 1){
            logHistory = html.h3("Log");
            String lastItem = "";
            for(String logItem : task.getLogHistory()){
                lastItem = "- " + logItem + html.br;
                logHistory += lastItem;
            }
            // remove the last log line, it is repeated on the "current status"
            if(lastItem.isEmpty() == false){
                logHistory = logHistory.substring
                    (0, logHistory.lastIndexOf(lastItem));
            }
        }
        
        // get the next step to show users what to do
        String nextStep = "";
        if((task.isProcessing() == false)&&(task.nextStep.isEmpty()==false)){
            nextStep = html.h3("Next steps")
                    + task.nextStep
                    + html.br;
        }
        
        // do the status when not emoty
        String status = "";
        if(task.getStatus().isEmpty() == false){
            status = html.h3("Current status")
                    + task.getStatus() 
                    + html.br+ html.br;
        }
        
        
        // prepare the output
        String result = ""
                + "<html><head>"
                + meta
                + "</head><body>"
                + html.div(10)
                + html.h2( 
                        //html.getIcon("gear.png", request) 
                        //+ "" 
                        //+ 
                        task.getTitle() 
                        )
                + "Started in " + utils.time.getTimeFromLong(task.getUID())
                + html.br
                + "Temporary Id number: " + task.getUID()
                + html.br
                + "Percentage complete: " + task.getPercentage() + "%"
                + html.br
                + html.br
                + status
                + nextStep
                + logHistory
                + html._div
                + "</body></html>";
        request.setAnswer(result);
    }
    
}
