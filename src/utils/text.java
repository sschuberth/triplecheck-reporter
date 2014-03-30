/*
 * This class provides some handy routines for filtering text and providing
 * a safe input for our applications.
 */

package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nuno Brito, 24th of July 2011 in Darmstadt, Germany
 * @modified in 8th December 2012 to match winbuilder needs.
 */
public class text {


     /**
        * Gets a string value from laptop characteristics based on a given pattern.
        * A Matcher object is used internally.
        *
        * @param source string containing the text to be parsed
        * @param reg regular expression pattern to use
        * @param group index of one of the groups found by the pattern
        * @return String containing the found pattern, or null otherwise
        */
        public static String findRegEx(String source, String reg, int group) {
        String out = null;

        Pattern p = Pattern.compile(reg); // Prepare the search pattern.
        Matcher matcher = p.matcher(source); // Retrieve our items.

        if (matcher.find()) {
        try {
        out = matcher.group(group);
        } catch (Exception e) {}
        }

        return out;
        }


          /** When given a text string, compute the SHA 256 result */
  public static String generateStringMD5(String content){

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(content.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        //convert the byte to hex format method 2
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
    }
      
  
  /** When given a text string, compute the SHA 256 result */
  public static String generateStringSHA256(String content){

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(content.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        //convert the byte to hex format method 2
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
    }
  
  
  
     /**
      * Get safe string
      * Picks a given string and cleans out any invalid characters, replacing
      * spaces with "_"
      */
       public static String safeString(String input){

           // clean up the tags
           //input = input.replace(" ", "_");
           input = input.replace("<", ""); 
           input = input.replace(">", ""); 
           input = input.replace("%", ""); 
           input = input.replace(";", ""); 
          //input = input.replace(";", ".");
 
           
           String output =
                utils.text.findRegEx( // only accept a-Z, 0-9 and -, _ chars
                        input,"[a-zA-Z0-9-_@\\.]+$", 0);

       return output;
       }

       
     /**
      * Only returns numbers from a given string
      * @param input
      * @return 
      */  
     public static int justNumbers(String input){
         String temp = input.replaceAll("[^0-9]", "");
         if(temp == null){
             return -1;
         }
         return Integer.parseInt(temp);
     }


  
       
       /** Disarm potential injections*/
       public static String safeHTML(String input){

           String output = input;
           // clean up the tags
           //input = input.replace(" ", "_");
           output = output.replace("<", ""); 
           output = output.replace(">", ""); 
           output = output.replace("%", ""); 
           output = output.replace(";", ""); 
           output = output.replace("\"", ""); 
           output = output.replace("'", ""); 

       return output;
       }
    
  
       
     /** Convert an array of strings to one string.
      *  Put the 'separator' string between each element.
      */
    public static String arrayToString(String[] a, String separator) {
        StringBuilder result = new StringBuilder();
        if (a.length > 0) {
            result.append(a[0]);
            for (int i=1; i<a.length; i++) {
                result.append(separator);
                result.append(a[i]);
            }
        }
        return result.toString();
    }

    
    /** Provides the index number of a given string inside an array.
     Returns -1 if the string was not found, 0 equals to the first item and
     so forth.*/
    public static int arrayIndex(String find, final String[] fields){
        int result = -1;
        int count = 0;
            for(String field : fields){
                if(field.equalsIgnoreCase(find))
                    return count;
                count++;
            }
        return result;
    }

    
  

    /**
     * This method tests if a given string is empty or null
     * It is required to ensure that we can compile this application using
     * Java 1.5
     */
    public static Boolean isEmpty(String input){
        Boolean result = (input == null) || (input.length() == 0);
    return result;
    }


    /**
     * Provides a text that will match a desired dimension, reducing
     * it if necessary.
     */

    public static String shortText(String text, int maxLength){
        String result = text;

        // if this text portion is bigger than allowed, reduce
        if(text.length() > maxLength){
            int half = maxLength / 2;
            int length = text.length();
            result = text.substring(0, half) + ".."
                    + text.substring(length - half, length);
        }

        return result;
    }


    /** get the string ready for output as debug */
     public static String doFormat(String title, String value){
         return title + " = " +value+ "; ";
     }

    /** convert an int value to hex */
     public static String getHex(final String title, final int value){
         String result = java.lang.Integer.toHexString (value);
         return doFormat(title, "0x"+result.toUpperCase());
     }

    /** convert a Long value to hex */
    public static String getHex(final String title, final long value){
         String result = java.lang.Long.toHexString (value);
          return doFormat(title, "0x"+result.toUpperCase());
     }

    /** Add a new element to a static String array */
     public static String[] stringArrayAdd(final String[] input,
             final String newText){
         String result = "";
         // iterate all elements
         for(String current : input)
             if(current.length() > 0)
             result = result.concat(current + ";");
         result = result.concat(newText + ";");
         // write back our list
        return result.split(";");
     }

   /** Remove an element from a static String array */
     public static String[] stringArrayRemove(final String[] input,
             final String removeText){
        String result = "";
        for(String current : input){
            if (current.equalsIgnoreCase(removeText))
                continue;
            else
                result = result.concat(current + ";");
        }
       // write back our list
        return result.split(";");
     }


   /** Remove an element from a static String array */
     public static String[] stringPrune(final String[] input){
        String result = "";
        for(String current : input){
            if (current.isEmpty())
                continue;
            else
                result = result.concat(current + ";");
        }
       // write back our list
        return result.split(";");
     }

     
     
     
    /** Converts a given record onto a string that can be written on a file */
    public static String convertRecordToString(String[] record){
        String result = "";
        // iterate all fields of this record
        for(String field : record) // add a comma to split them
                result = result.concat(field + ";");
            // add the breakline
            result = result.concat("\n");
        return result;
    }


   /** Replaces empty elements with space to ensure compatibility with
    * string.split */
     public static String[] stringClean(final String[] input){
        String result = "";
        for(String current : input){
            if (current.isEmpty())
                result = result.concat(" " + ";");
            else {
                // clean up our code
                current = current.replace(";",",");
                current = current.replace("\n","");
                current = current.replace("\r","");
                
                result = result.concat(current + ";");
            }
        }
       // write back our list
        return result.split(";");
     }

    /** Picks a string and makes it URL safe */
    public static String quickEncode(String input){
        String
                result = input.replace(" ", "%20");
                result = result.replace("&", ".!.AND");
                result = result.replace("=", ".!.EQUAL");
                result = result.replace("/", ".!.fslash");
                result = result.replace("\\", ".!.bslash");
                result = result.replace("?", ".!.question");
        return result;
    }
    /** Decodes a URL safe string  */
    public static String quickDecode(String input){
        String
                result = input.replace("%20", " ");
                result = result.replace(".!.AND", "&");
                result = result.replace(".!.EQUAL", "=");
                result = result.replace(".!.fslash", "/");
                result = result.replace(".!.bslash", "\\");
                result = result.replace(".!.question", "?");
        return result;
    }

     /** 
     * Gets a given repeated entry inside an array 
     * (TextTest unit provides a demonstration of this function)
     * Nov 2011, NB
     */
    public static String getMultiple(String input, String filter){
            // split everything
            String[] split = input.split("&");
            String result = "";
            // iterate them all
            for(int i = 0; i < split.length; i++){
                // continue to the next one if we don't like this one
                if(split[i].contains(filter)==false)
                    continue;
                // get only the last part that contains the value
                String snip = split[i].substring(split[i].indexOf("=")+1);
                // clean it
                //snip = org.htmlparser.util.Translate.decode(snip);
                snip = java.net.URLDecoder.decode(snip);
                // add it up
                result = result.concat(snip + "|");
            }
            // add the inital splitter
            if(result.length()>0)
                result = "|" + result;
            // give it all back
        return result;
    }

    
}
