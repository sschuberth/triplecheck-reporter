/*
 * This class provides support for download huge files (over 2Gb) down to disk.
 * It should be able of supporting resume and verification that the end result
 * matches a specific signature (md5 or simple similar).
 * 
 * This class is mostly intended to assist in the effort of downloading a large
 * ISO file from the Internet onto the local disk.
 * 
 * The downloaded parts are immediately flushed to the disk. This should 
 * hopefully avoid issues with memory usage.
 */
package script;

import main.script.log;
import definitions.is;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import main.engine;

/**
 *
 * @author Nuno Brito, 20th of January 2013 in Darmstadt, Germany
 */
public class DownloadBigFile {

    // the private variable for this method 
    private String 
            sourceURL,
            contentType,
            title = "download" // the identifier for this download entry
            ;
    
    private File
            file;
            
    private Boolean
            isDownloading = false;
    
    private BigInteger
            expectedSize;
    
    private long
            lastPercent = 0;
    
    public DownloadBigFile(String sourceURL, String targetFile) {
        this.file = new File(targetFile);
        this.sourceURL = sourceURL;
    }
    
    public DownloadBigFile(String sourceURL, File targetFile) {
        this.file = targetFile;
        this.sourceURL = sourceURL;
    }

    
    
    /**
     * Download the file to disk.
     */
    public void getFile(){
        isDownloading = true;
        boolean fileAlreadyExists = this.file.exists();
        
        // if the file already exists and has the size that we expect
        if(fileAlreadyExists)
//                && (file.length() == this.expectedSize.longValue()))
        {
            //System.out.println("File already exists with the right size");
            return;
        }
        
       
            try{         
                RandomAccessFile out = new RandomAccessFile(file, "rw");
        
        // go back to the previous position if we can
        out.seek(file.length());
        
        URL url = new URL(sourceURL);
        URLConnection urlCon = url.openConnection();
        InputStream fileInputStream = urlCon.getInputStream();
        // skip the first bytes of the file that were already downloaded
        fileInputStream.skip(file.length());
        
//        HttpIInStream fileInputStream = new HttpIInStream(sourceURL);
//        fileInputStream.seek(file.length(), 0);
        
        
        byte[] buf=new byte[8192];
        int bytesread, bytesBuffered = 0;
        long bytesTotal = 0;
        while( (bytesread = fileInputStream.read( buf )) > -1 ) {
            out.write( buf, 0, bytesread );
            bytesBuffered += bytesread;
            
            bytesTotal += bytesread;
            
            if (bytesBuffered > 2024 * 1024) { //flush after each 2 megabytes
                //out.flush();
                bytesBuffered = 0;
                // use the temporary holder to write the status of this thing
                engine.temp.put(sourceURL, bytesTotal);
                
                // calculate the percentage since last count
//                long currentPercent = 
//                        ( file.length() * 100) / expectedSize.longValue();
//                
//                long dif = currentPercent - lastPercent;
                
                // show status at a specific difference of percentage
                //TODO missing to add a scale factor between a short download
                // and a big download, where we adjust message frequency
//                if(dif > 0){
//                    String readableSize = utils.files.humanReadableSize( file.length());
//                    String fullSize = utils.files.humanReadableSize(expectedSize.longValue());
//                    
//                    log.write(is.INFO, "%1 -> %2 (%3% complete)"
//                            ,title
//                            ,readableSize + " / " + fullSize 
//                            ,"" + currentPercent);
//                }
//                // all done, update the counter
//                lastPercent = currentPercent;
            }
        }
       }catch (IOException e){
           log.write(is.ERROR, "Error occurred while downloading file: %1",
                   e.getLocalizedMessage());
       }
            // all done, finish here
       String fullSize = utils.files.humanReadableSize(file.length());    
       log.write(is.INFO, "Download complete, %1"
                            ,fullSize);
       isDownloading = false;
    }

    public String getContentType() {
        return contentType;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public File getTargetFile() {
        return file;
    }

    public Boolean getIsDownloading() {
        return isDownloading;
    }

    public BigInteger getExpectedSize() {
        return expectedSize;
    }

    public void setExpectedSize(BigInteger expectedSize) {
        this.expectedSize = expectedSize;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a new class, use two values as example and test the result
        String targetFile = "last.exe";
       // String sourceURL = "http://msft-dnl.digitalrivercontent.net/msvista/pub/X15-65804/X15-65804.iso";
 
        String sourceURL = "http://appldnld.apple.com.edgesuite.net/content.info.apple.com/QuickTime/061-5376.20090121.BD7E9/QuickTimeInstaller.exe";
        
        DownloadBigFile download = new DownloadBigFile(sourceURL, targetFile);
        download.setExpectedSize(new BigInteger("21878064"));
        download.getFile();
        
        //System.out.println(download.getTargetFile().length());
        
    }
}
