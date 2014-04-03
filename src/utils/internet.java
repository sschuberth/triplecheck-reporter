package utils;

import GUI.MetaContainer;
import definitions.is;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import org.simpleframework.http.Request;



/**
 *
 * @author Nuno Brito, 10th August 2010 in Coimbra, Portugal.
 */
public class internet {

    static internet action = new internet();

    String[] test_connectivity = {
        "http://google.com",
        "http://cnn.com",
        "http://digg.com",
        "http://wordpress.com",
        "http://www.w3.org",
        "http://yahoo.com",
    };

    Boolean debug = true;


   
   //checks for connection to the internet through dummy request
        public static String getTextFile(String TextFileURL)
        {
            String text_out = "";
                try {


                        //make a valid URL to get ninja.txt
                        URL url = new URL(TextFileURL);

                        //open a connection to that source
                        HttpURLConnection urlConnect =
                                (HttpURLConnection)url.openConnection();

                        // ensure that there is no cache to give old outdated files
                            urlConnect.setDoInput(true);
                            urlConnect.setUseCaches(false);
                            //urlConnect.setConnectTimeout(1000);
                            //urlConnect.setDoInput(false);
                            //urlConnect.setDoOutput(false);

                            DataInputStream dis;
                            String s;


                            dis = new DataInputStream(urlConnect.getInputStream());


                            while ((s = dis.readLine()) != null)
                                {
                                      //text_out = text_out +"\r\n"+s;
                                      if(s.length() == 0)
                                          continue;
                                      
                                      text_out = text_out.concat(s + "\n");
                                }
                               dis.close();



                } catch (UnknownHostException e) {
                       // e.printStackTrace();
                        return "";
                }
                catch (IOException e) {
                       // e.printStackTrace();
                        return "";
                }
                return text_out;
        }

/** sends email using an external PHP script, useful to bypass proxies */
public static String sendEmail(String emailAddress, 
        String subject, String body){
    String website = "http://nunobrito.eu/email/egos.php"
                    + "?address=" + emailAddress
                    + "&subject=" + subject
                    + "&body=" + body
                    ;
    String result = webget(website);
    //String result = webget("http://google.com");
    System.out.println(website);
    return result;
}
        
        
/**
 * <b>Bare Bones Browser Launch for Java</b><br>
 * Utility class to open a web page from a Swing application
 * in the user's default browser.<br>
 * Supports: Mac OS X, GNU/Linux, Unix, Windows XP/Vista/7<br>
 * Example Usage:<code><br> &nbsp; &nbsp;
 *    String url = "http://www.google.com/";<br> &nbsp; &nbsp;
 *    BareBonesBrowserLaunch.openURL(url);<br></code>
 * Latest Version: <a href="http://www.centerkey.com/java/browser/">www.centerkey.com/java/browser</a><br>
 * Author: Dem Pilafian<br>
 * Public Domain Software -- Free to Use as You Like
 * @version 3.0, February 7, 2010
 */
   static final String[] browsers = { "google-chrome", "firefox", "opera",
      "konqueror", "epiphany", "seamonkey", "galeon", "kazehakase", "mozilla" };
   static final String errMsg = "Error attempting to launch web browser";

   /**
    * Opens the specified web page in the user's default browser
    * @param url A web address (URL) of a web page (ex: "http://www.google.com/")
    */
   public static void openURL(String url) {
      try {  //attempt to use Desktop library from JDK 1.6+ (even if on 1.5)
         Class<?> d = Class.forName("java.awt.Desktop");
         d.getDeclaredMethod("browse", new Class[] {java.net.URI.class}).invoke(
            d.getDeclaredMethod("getDesktop").invoke(null),
            new Object[] {java.net.URI.create(url)});
         //above code mimics:
         //   java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
         }
      catch (Exception ignore) {  //library not available or failed
         String osName = System.getProperty("os.name");
         try {
            if (osName.startsWith("Mac OS")) {
               Class.forName("com.apple.eio.FileManager").getDeclaredMethod(
                  "openURL", new Class[] {String.class}).invoke(null,
                  new Object[] {url});
               }
            else if (osName.startsWith("Windows"))
               Runtime.getRuntime().exec(
                  "rundll32 url.dll,FileProtocolHandler " + url);
            else { //assume Unix or Linux
               boolean found = false;
               for (String browser : browsers)
                  if (!found) {
                     found = Runtime.getRuntime().exec(
                        new String[] {"which", browser}).waitFor() == 0;
                     if (found)
                        Runtime.getRuntime().exec(new String[] {browser, url});
                     }
               if (!found)
                  throw new Exception(Arrays.toString(browsers));
               }
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, errMsg + "\n" + e.toString());
            }
         }
      }


   

   /** Get the login status */
   static public boolean isLogged(final String URL){
       // add our specific URL for the component and required parameter
       String target = URL + "/user?action=isLogged";
       // get the file
       String result = utils.internet.getTextFile(target);
        // output the result
        boolean out = result.equalsIgnoreCase("true");
       return out;
   }


       /** get a given page from a given URL address */
   static public String webget(String address) {
        // perhaps in the future we can use something like http://goo.gl/03WQp
        // provide a holder for the reply
        String result = "";

        try {
            URL webpage = new URL(address);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(webpage.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Process each line.
                result = result.concat(inputLine);
            }
            in.close();
        } catch (MalformedURLException me) {
//            System.err.println("webGet operation has failed, MalFormedException: "
//                    + me.toString());
            return me.toString();
        } catch (IOException ioe) {
//            System.err.println("webGet operation has failed, IOException: "
//                    + ioe.toString());
            return ioe.toString();
        }

        return result;
    }

private void log(String gender, String message){
                  System.out.println
                          ("internet ["+gender+"] "+message);
                    }
 static private void debug(String message){
                  if(action.debug)
                      action.log("debug",message);
 }





    /** Do a threaded webget to prevent congestions.
     *   This method is not working as originally intended but at least is still
     *   useful for making requests that do not require a reply back.
     */
    public static void threadedWebGet(String URL){
        // start a new thread for this purpose
        WebGetThread a = new WebGetThread(URL);
        a.start();
    }

    
   // derived from http://stackoverflow.com/questions/8765578/get-local-ip-address-without-connecting-to-the-internet
   static public String getLocalIP(){
        String result = "";
        try{
       Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    while (interfaces.hasMoreElements()){
        NetworkInterface current = interfaces.nextElement();
        //System.out.println(current);
        if (!current.isUp() || current.isLoopback() || current.isVirtual()) 
            continue;
        Enumeration<InetAddress> addresses = current.getInetAddresses();
        while (addresses.hasMoreElements()){
            InetAddress current_addr = addresses.nextElement();
            if (current_addr.isLoopbackAddress()) 
                continue;
            if (current_addr instanceof Inet4Address)
              result = result.concat(current_addr.getHostAddress() + "\n");
            //else if (current_addr instanceof Inet6Address)
            // System.out.println(current_addr.getHostAddress());
            //System.out.println(current_addr.getHostAddress());
        }
    }
        }catch (Exception e){
        }
    return result;
   }
 
   
      /** Get the value from an HTML provided on command line
     * @param request the request from our web server
     * @param parameter the key title for the value that we need acquire
     * @return a simple string with the value for the requested key
     */
   public static String getHTMLparameter(Request request, String parameter){
        String result = "";
        try {   // should we show a specific section?
                result = request.getParameter(parameter);
            } catch (IOException ex) {
            }

        if(result == null)
            result = ""; // we can't afford null values,

        // clean up the result
        result = java.net.URLDecoder.decode(result);
        
        return result;
    }
    
   
   
   
   
     
}
class WebGetThread extends Thread{
    private String URL = "";  // the target URL address

    /** Public constructor */
    public WebGetThread(String URL){
        this.URL = URL;
    }

    @Override
    public void run(){
        // get the page onto a string
        utils.internet.getTextFile(URL);
    }
    
     
}