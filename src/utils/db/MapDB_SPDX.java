/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-10T14:28:12Z
 * LicenseName: EUPL-1.1-without-appendix 
 * FileName: MapDB_SPDX.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Provides an SPDX database using MapDB </text> 
 */

package utils.db;

import definitions.is;
import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;
import main.core;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import script.log;
import old.SPDXfile_old;


/**
 *
 * @author Nuno Brito, 11th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class MapDB_SPDX {

// the database object            
DB db;        

    // constructor
    public MapDB_SPDX(boolean freshStart){
        // create an identifier 
        final String title = "spdx";
        File file = new File(getFolder(), title);
        // shall we remove the file to permit a fresh start from scratch?
        if(freshStart && file.exists()){
            // delete main db file
            file.delete();
            // delete the temporary files
            File tempFile = new File(getFolder(), title + ".p");
            tempFile.delete();
            tempFile = new File(getFolder(), title + ".t");
            tempFile.delete();
        }
        
        // create/open the database file
        db = DBMaker.newFileDB(file)
               .closeOnJvmShutdown()
               //.encryptionEnable("password")
               .make();
        
       // compute some stats
        ConcurrentNavigableMap<File, SPDXfile_old> currentMap = map();
         // create a relative path to preserve anonimity in logs
        String relativePath = file.getAbsolutePath()
                .replace(core.getWorkFolder().getAbsolutePath(), "");
        // output the message to end-users
        log.write(is.INFO, "Using DB at %1 with %2 entries", relativePath,
           currentMap.size() + "");
//        long counter = currentMap.size();
//        System.out.println("DB has " + counter + " entries");
    }    
    
    /**
     * Close the database
     */
    public void close(){
         db.close();
    }
    
    public void commit(){
        db.commit();
    }
    
    public ConcurrentNavigableMap<File, SPDXfile_old> map(){
        return db.getTreeMap("spdx");
    }
    
     /**
     * Gets the folder where misc settings are placed
     * @return The folder from where the main application is running
     */
    public static File getFolder(){
        File result = new File(core.getMiscFolder(), "mapdb");
        // if the folder doesn't exist, create one
        if(result.exists() == false){
            utils.files.mkdirs(result);
        }
        return result;
    }
    
}
