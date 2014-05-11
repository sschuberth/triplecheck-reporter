/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-10T14:28:12Z
 * LicenseName: EUPL-1.1-without-appendix 
 * FileName: MapDB_Indexer.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Provides a database using MapDB_Indexer </text> 
 */

package utils.db;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;
import main.core;
import org.mapdb.DB;
import org.mapdb.DBMaker;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class MapDB_Indexer {

// the database object            
DB db;        

    // constructor
    public MapDB_Indexer(String title, boolean freshStart){
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
        System.out.println("Using DB at " + file.getAbsolutePath());
        // compute some stats
        ConcurrentNavigableMap<Integer,String> currentMap = map();
        long counter = currentMap.size();
        System.out.println("DB has " + counter + " entries");
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
    
    public ConcurrentNavigableMap<Integer, String> map(){
        return db.getTreeMap("users");
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
