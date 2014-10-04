/*
 * A mix of log messages and output of results for methods that is all-in-one.
 * 
 * Some people would argue it is better to use something like log4J and I agree
 * with their perspective. However, I don't like to add overkills to something
 * that should be simple from the start: I want an output as integer, I want
 * to log a message and all of this to be logged somewhere to be output on the
 * console or web panels when needed.
 * 
 * Static version of the Log class
 */
package script;

import definitions.is;
import java.io.File;
import java.util.ArrayList;
import utils_deprecated.Settings;

/**
 *  Modified in 2013-09-19, log.write now outputs the formatted string as result
 * 
 * 
 * @author Nuno Brito, 15th of December 2012 in Darmstadt, Germany.
 */
public class log {
    
     private static final Boolean
            outputToScreen = true; // should the log message be printed?

    long 
            TimeStart = System.currentTimeMillis(); // when this log started
    
//    static Settings translation; // support for dynamic translations
//    static Boolean doTranslation = false; // should we support this or not?
    
    
    //HashMap<Long, LogEntry> list = new HashMap(); // where keep log messages
    static ArrayList<LogEntry> list = new ArrayList(); // where keep log messages
    public static Hooks hooks = new Hooks();
    
    static LogEntry latest = null; // the most recent message
    
    public log(){
    }
    
    
    /** 
     * Add a new message to our log history. If enabled, outputs a message to
     * the text console.
     * 
     * @param code The error code associated to this message (404, 500, ...)
     * @param message The text of the message, using %1, %2 for variables
     * @param args The variables, they will replace the %1, %2 on the message
     */
    private static String write1(final int code, final String message,
            final String[] args){
        if(message == null){
            return "";
        }
        // ignore empty messages
        if(message.isEmpty()){
            return "";
        }
        // create a new log entry with our data
        LogEntry newEntry = new LogEntry(code, message, args);
        // increase the counter
        // add this new entry on our list of log messages
        list.add(newEntry);
        // add this to our translator?
//        if(doTranslation && (code != is.COMMAND)){
//            addTranslation(message);
//        }
        
        // shall we print this out to the screen? (and avoid too much info)
        if(outputToScreen){
            System.out.println(
                    utils_deprecated.time.getTimeFromLong(newEntry.getTime())
                    + " " + newEntry.getMessage());
        }
        // process any hooks we might have
        hooks.process(message);
        latest = newEntry;
        return newEntry.getMessageSimple();
    }

        /**
     * Prints a message without the typical message code and time stamps
     * @param message what we want to output
     * @param writeTranslation Should this be written on the translation XML?
     */
    public static void print(final String message, Boolean writeTranslation){
    // create a new log entry with our data
        LogEntry newEntry = new LogEntry(message);
        // add this new entry on our list of log messages
        list.add(newEntry);
        // add this to our translator?
//        if(writeTranslation){
//            addTranslation(message);
//        }
       
        latest = newEntry;
    }
    
    /**
     * Prints a message without the typical message code and time stamps
     * @param message 
     */
    public static void print(final String message){
        print(message, false);
    }
    
    
    
    /**
     * Gets the current number of indexed log messages
     * @return number of messages indexed
     */
    public static int getCounter() {
        return list.size();
    }

    public static ArrayList<LogEntry> getList() {
        return list;
    }

    public static LogEntry getLatest() {
        return latest;
    }
    
    
    
    /**
     * Get all the messages since a given index number on our counter
     * @param lastCounter Last index that was retrieved
     * @return The list with relevant messages or an empty string if no
     * messages were found
     */
    public static String getMessagesSince(long lastCounter){
        String output = "";
        int counter = -1;
        
        for(LogEntry newEntry : list){
            counter++;
            // ignore older entries
            if(counter < lastCounter){
                continue;
            }
            if(newEntry.getResult() == is.EXTRA){
                    output = output.concat(
                        newEntry.getMessage()
                       + "\n"); 
                }else{
                    output = output.concat(
                      // utils.time.getTimeFromLong(newEntry.getTime())
                       utils_deprecated.time.getTimeFromLongNoDate(newEntry.getTime())
                       + " " + newEntry.getMessage()
                       + "\n"); 
                }
        }
        return output;
    }

    
 /**
  * Decides if wether or not we should output all the logged messages to the
  * console screen by default.
     * @param outputToScreenText Decide if the message should be readable or not
  */
    public void setOutputToScreen(Boolean outputToScreenText) {
        outputToScreenText = outputToScreen;
    }
    
    
    /**
     * Adds support for dynamic translation of values from English to any
     * other given language. The idea is to log all messages in English, write
     * them to a file on disk where volunteers can submit the translation and
     * then use these values when available.
     * 
     * Not sure about performance issues, but might be worth to try and see how
     * this code behaves.
     * @param languageID Language identifier based on two letters ISO standard
     * @param description Long text description of the language
     */
//    public static void EnableTranslator(String languageID, String description){
//        // where are we running from?
//        String folderBase = System.getProperties().getProperty("user.dir");
//        // getMessage the folder where translated files are available
//        File folderTranslation = new File(folderBase, "misc/translation");
//        // create the translations folder if necessary
//        utils.files.mkdirs(folderTranslation);
//        // now create the translation file
//        File fileTranslation = new File(folderTranslation, "lang-"+languageID
//                + ".xml"); // add the XML extension to ease editing
//        // create the new file or reopen if necessary
//        translation = new Settings(fileTranslation, description);
//        // user.dir and user.language from JVM can be used in the future
//        doTranslation = true;
//    }
    
    /**
     * Adds a new key available for translation if the key does not exist yet.
     * This way translators will only need to replace the corresponding message
     * value with the term in the language they select.
     * 
     * @param message 
     */
//    static void addTranslation(String message){
//        if(translation.hasKey(message)==false){
//            translation.write(message, message);
//        }
//    }
    
    
   public static String write(int code, String message){
       String[] text = new String[]{};
        return write1(code, message, text);
    }

    
    public static String write(int code, String message, String arg1){
       String[] text = new String[]{arg1};
        return write1(code, message, text);
    }

    public static String write(final int code, final String message,
            final String arg1, String arg2){
        String[] text = new String[]{arg1, arg2};
       return write1(code, message, text);
    }
   
    public static String write(final int code, final String message,
            final String arg1, String arg2, String arg3){
        String[] text = new String[]{arg1, arg2, arg3};
       return write1(code, message, text);
    }
   
   public static String write(final int code, final String message,
            final String arg1, String arg2, String arg3, String arg4){
        String[] text = new String[]{arg1, arg2, arg3, arg4};
       return write1(code, message, text);
    }
   
  public static String write(final int code, final String message,
            final String arg1, String arg2, String arg3, String arg4, 
            String arg5){
        String[] text = new String[]{arg1, arg2, arg3, arg4, arg5};
       return write1(code, message, text);
    }
    
    
}
