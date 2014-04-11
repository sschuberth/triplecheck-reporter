/*
 * Methods to ease the handling of files
 */

package utils;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Nuno Brito, 6th of June 2011 in Darmstadt, Germany.
 */
public class files {

     
  /** Writes an inputstream back into a file */  
  static public void inputFileStreamToFile(InputStream inputStream, 
          File outFile){  
    
      OutputStream out = null;
      try{
          out = new FileOutputStream(outFile);
          byte buf[]=new byte[1024];
          int len;
          while((len=inputStream.read(buf))>0)
              out.write(buf,0,len);
          inputStream.close();
      }
      catch (IOException e){}
      finally {
            try {
                out.close();
            } catch (IOException ex) {
            }
       
      }

}

  /** Returns the extension of a file*/
  public static String getExtension(File file){
      String result;
      String filename = file.getName();
      // no dot found? no need to proceed
      if(filename.contains(".")==false){
          return "";
      }
      int mid= filename.lastIndexOf(".");
      result = filename.substring(mid+1, filename.length());  
      // ensure that we always get things in lowercase
      result = result.toLowerCase();
    return result;
  }

    public static String readAsString(File file){
        long length = file.length();
        byte[] bytes = new byte[(int) length];
        InputStream is = null;
        try{
        is = new FileInputStream(file);
        is.read(bytes);
        }catch(IOException e){}
        finally{ 
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException ex) {
            }
        }
        return new String(bytes);
    }


// Deletes all files and subdirectories under dir.
// Returns true if all deletions were successful.
// If a deletion fails, the method stops attempting to delete and returns false.
public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
        String[] children = dir.list();
        for (int i=0; i<children.length; i++) {
            boolean success = deleteDir(new File(dir, children[i]));
            if (!success) {
                return false;
            }
        }
    }
    // The directory is now empty so delete it
    return dir.delete();
}

/**
 * Counts the size of all files inside a given folder
 * @param where The folder where we want to count the files
 * @return 
 */
public static long folderSize(File where){
        ArrayList<File> folders = findFiles(where);
        long counter = 0;
        for(File folder : folders){
            counter += folder.length();
        }
        return counter;
}


/**
 * Find all files in a given folder and respective subfolders
 * @param where A file object of the start folder
 * @param maxDeep How deep is the crawl allowed to proceed
 * @return An array containing all the found files, returns null if none is
 * found
 */
 public static ArrayList<File> findFiles(File where){
     return findFiles(where, 25);
 }

 /**
 * Find all files in a given folder and respective subfolders
 * @param where A file object of the start folder
 * @param maxDeep How deep is the crawl allowed to proceed
 * @return An array containing all the found files, returns null if none is
 * found
 */
 public static ArrayList<File> findFilesFiltered(File where, final String what, int maxDeep){

    File[] files = where.listFiles();
    ArrayList<File> result = new ArrayList<File>();

    if(files != null)
    for (File file : files) {
      if (file.isFile()){
          if(file.getName().contains(what))
             result.add(file);}
      else
      if ( (file.isDirectory())
         &&( maxDeep-1 > 0 ) ){
            // do the recursive crawling
            ArrayList<File> temp = findFilesFiltered(file, what, maxDeep-1);

                for(File thisFile : temp)
                        result.add(thisFile);
      }
    }
    return result;
    }
 
/**
 * Find all files in a given folder and respective subfolders
 * @param where A file object of the start folder
 * @param maxDeep How deep is the crawl allowed to proceed
 * @return An array containing all the found files, returns null if none is
 * found
 */
 public static ArrayList<File> findFiles(File where, int maxDeep){

    File[] files = where.listFiles();
    ArrayList<File> result = new ArrayList<File>();

    if(files != null)
    for (File file : files) {
      if (file.isFile())
         result.add(file);
      else
      if ( (file.isDirectory())
         &&( maxDeep-1 > 0 ) ){
            // do the recursive crawling
            ArrayList<File> temp = findFiles(file, maxDeep-1);

                for(File thisFile : temp)
                        result.add(thisFile);
      }
    }
    return result;
    }


 /** Get the size of a given folder and respective files inside subfolders */
  public static long getFolderSize(File where, int maxDeep){
      // output variable
      long result = 0;
      // get all files from the given folder
      ArrayList<File> files = findFiles(where, 25);
      // iterate each file and sum the value
      for(File file : files)
          result += file.length();
      // output our result
     return result;
    }
 
  
  /**
   * Simpler version of find all folders on a given location
   * @param where
   * @return 
   */
  public static ArrayList<File> findFolders(File where){
      return findFolders(where, 25);
  }
  
/**
 * Find all subfolders in a given folder.
 * @param where A file object of the start folder
 * @param maxDeep How deep is the crawl allowed to proceed
 * @return An array containing all the found files, returns null if none is
 * found
 */
 public static ArrayList<File> findFolders(File where, int maxDeep){

    File[] files = where.listFiles();
    ArrayList<File> result = new ArrayList<File>();

    if(files != null)
    for (File file : files) {
      
      if ( (file.isDirectory())
         &&( maxDeep-1 > 0 ) ){
          result.add(file);
          // do the recursive crawling
          ArrayList<File> temp = findFolders(file, maxDeep-1);

                for(File thisFile : temp)
                        result.add(thisFile);
      }
    }
    return result;
  }

/**
 * Find all files and subfolders inside a given folder.
 * @param where A file object of the start folder
 * @param maxDeep How deep is the crawl allowed to proceed
 * @return An array containing all the found files, returns null if none is
 * found
 */
 public static ArrayList<File> findAll(File where, int maxDeep){

    File[] files = where.listFiles();
    ArrayList<File> result = new ArrayList<File>();

    if(files != null)
    for (File file : files) {
      if (file.isFile())
         result.add(file);
      else
      if ( (file.isDirectory())
         &&( maxDeep-1 > 0 ) ){
          result.add(file);
          // do the recursive crawling
          ArrayList<File> temp = findAll(file, maxDeep-1);

                for(File thisFile : temp)
                        result.add(thisFile);
      }
    }
    return result;
  }

/**
 * Find all subfolders inside a given folder.
 * @param where A file object of the start folder
 * @return An array containing all the found files, returns null if none is
 * found
 */
 public static ArrayList<File> findSubFolders(File where){
// 2013-MAY-11 psc added
    File[] files = where.listFiles();
    ArrayList<File> result = new ArrayList<File>();

    if(files != null)
    for (File file : files) {
      if (file.isDirectory()) {
         result.add(file);
      }
    }
    return result;
  }


 
   


/**
    * Ensures that we can pick on a value and present a readable
    * size of the file instead of plain bytes
    *
    * @param size
    * @return String
    */
   public static String humanReadableSize(Long size){

       long l = size;
       //Long.parseLong(size.trim());
       String output;

                long b;
                long MEGABYTE = 1024L * 1024L;
                long KILOBYTE = 1024;
                if (l > MEGABYTE){
                    b = l / MEGABYTE;
                    output = Long.toString(b)+" Mb";}
                else
                if (l > KILOBYTE){
                    b = l / KILOBYTE;
                    output = Long.toString(b)+" Kb";}
                else
                    output = size+" bytes";
    return output;
   }


   /** get the folder where our user documents are placed */
   public static synchronized String getDocumentsDirectory(){

       String result = "";

       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            javax.swing.JFileChooser jFileChooser1 = new javax.swing.JFileChooser();
            String myresult = jFileChooser1.getFileSystemView().getDefaultDirectory()
                    .getAbsolutePath();
            }
        });
               
            return result;
   }

   /** get the desktop folder  */
   public static synchronized String getDesktopDirectory(){
               javax.swing.JFileChooser jFileChooser1 = new javax.swing.JFileChooser();
            return jFileChooser1.getFileSystemView().getHomeDirectory()
                    .getAbsolutePath();
   }

   /** get our home folder (under windows this value is not certain)*/
   public static synchronized String getHomeDirectory(){
               javax.swing.JFileChooser jFileChooser1
                       = new javax.swing.JFileChooser();
            return jFileChooser1.getFileSystemView().getParentDirectory(
                   jFileChooser1.getFileSystemView().createFileObject
                   (getDesktopDirectory())
                   ).getAbsolutePath();
    }


   /** create a folder along with respective parent folders if needed */
   public static Boolean mkdirs(String folder){
       boolean result;

        File docs = new File(folder);
        result = docs.mkdirs();

        return result;
    }

  /** create a folder along with respective parent folders if needed */
   public static Boolean mkdirs(File docs){
       boolean result;
        result = docs.mkdirs();
        return result;
    }

   /**
    * Touch a file, if it does not exist then create an empty file.
    * @param file
    * @return
    */
   public static boolean touch(File folder, String file){
       File touch = new File(folder, file);
        try {
            touch.createNewFile();
        } catch (IOException ex) {
            return false;
        }
       return true;
   }


   /**
     * This method saves the contents from a string to a file
     *
     * @author Nuno Brito
     * @version 1.0
     * @date 2010/06/06
    */
   public static boolean SaveStringToFile(File inputFile, String inputString){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(inputFile));
            out.write(inputString);
            out.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
                return false;
            }
        return true;
	}


   /**
   * Load a text file contents as a <code>String<code>.
   * This method does not perform enconding conversions
   *
   * @param file The input file
   * @return The file contents as a <code>String</code>
   * @exception IOException IO Error
   */
  public static String deserializeString(File file)
      // code copied from http://goo.gl/5qa3y
    throws IOException {
      int len;
      char[] chr = new char[4096];
      final StringBuffer buffer = new StringBuffer();
      final FileReader reader = new FileReader(file);
      try {
          while ((len = reader.read(chr)) > 0) {
              buffer.append(chr, 0, len);
          }
      } finally {
          reader.close();
      }
      return buffer.toString();
  }


  
//  /**
//   * Copies a file from one location to another
//   * @param FromFile Source file
//   * @param ToFile Place where we want the new file to be copied
//   * @return 
//   */
//  static public Boolean copyFile(File FromFile, File ToFile){
//      Boolean result = false;
//      
//      // do a quick test, if the file is already there then don't overwrite
//      if(ToFile.exists() && (FromFile.length() == ToFile.length())){
//          // speed up our proceess.
//          return true;
//      }
//      
//        try {
//            // using Apache commons IO for added performance
//            FileUtils.copyFile(FromFile, ToFile, true);
//            result = ToFile.exists();
//        } catch (IOException ex) {
//        }
//      return result;
//  }
// 
//    /**
//   * Copies a file from one location to another
//   * @param FromFile Source file
//   * @param ToFile Place where we want the new file to be copied
//   * @return 
//   */
//  static public Boolean copyFolder(File FromFolder, File ToFolder){
//      Boolean result = true;
//        try {
//            // using Apache commons IO for added performance
//            FileUtils.copyDirectory(FromFolder, ToFolder, true);
//        } catch (IOException ex) {
//            result = false;
//        }
//      return result;
//  }
  
  
}