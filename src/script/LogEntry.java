/*
 * A log entry for keeping the data from each event that we want to track.
 */
package script;

import definitions.is;

/**
 *
 * @author Nuno Brito, 15th of December 2012 in Darmstadt, Germany.
 */
public class LogEntry {
    
    private int
            result; // what is the generic error/event code that we talk about? 
    
    private String 
            message;
    
    private String[]
            args;     // arguments used for translating the message text
    
    private Boolean hasArgs = false;
    
    private final long 
            time = System.currentTimeMillis();
            
    /** Set the content for this message */
    public LogEntry(final int code, final String message,
            final String... args){
        this.message = message;
        this.result = code;
        this.args = args;
        this.hasArgs = true;
    }
    /** Option without arguments */
    public LogEntry(final int code, final String message){
        this.message = message;
        this.result = code;
        this.args = null;
    }
    
    /**
     * Just prints a message, nothing attached
     * @param message 
     */
    public LogEntry (String message){
        this.message = message;
        this.result = is.EXTRA; // code word of things to ignore internally
        this.args = null;
    }
    
    /** Convert all arguments onto the nicely formatted text */
    private String convert(){
        String output = message.replace("%", "%!%");
        int count = 1;
      try{
        while(output.contains("%!%")){
            output = output.replace("%!%"+count, args[count-1]);
            count++;
        }
      }catch(Exception e){
        output = output.replace("%!%", "%");
      } finally{
          // all done
        return output;
      }
    }
    
        /** Gets our message. If it has arguments, they are converted
     * @return .*/
    public String getMessage() {
        String output = message;
        // messages with no header, just to be printed
        if(this.result == is.EXTRA){
            output = convert();
          return output;
        }
        
        // convert arguments to a proper text
        if(hasArgs){
            output = "["+is.translated(this.result)
                    +"] " +convert();
        }
        return output;
    }
    
   /** Gets our message without describing the type of command.*/
    public String getMessageSimple() {
        String output = message;
        // messages with no header, just to be printed
        if(this.result == is.EXTRA){
            output = convert();
          return output;
        }
        
        // convert arguments to a proper text
        if(hasArgs){
            output =  convert();
        }
        return output;
    }
    
    /**
     * Get the time when the entry was made
     * @return a date string
     */
    public String getTimeReadable(){
        String output;
            output = utils.time.getTimeFromLong(time);
        return output;
    }

    public int getResult() {
        return result;
    }

    public long getTime() {
        return time;
    }
    
    
    
}
