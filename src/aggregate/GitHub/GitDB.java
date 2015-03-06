/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-08T00:26:01Z
 * LicenseName: AGPL-3.0+ 
 * FileName: GitDB.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package aggregate.GitHub;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class GitDB {

            
DB db;        
        
    // constructor
    public GitDB(){
        File file = new File(GitHubAggregate.getFolder(), "users.mapdb");
        db = DBMaker.newFileDB(file)
               .closeOnJvmShutdown()
               //.encryptionEnable("password")
               .make();
        System.out.println("Using DB at " + file.getAbsolutePath());
        
    
        ConcurrentNavigableMap<Integer, GithubUser> currentMap = map();
        
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
    
    public ConcurrentNavigableMap<Integer, GithubUser> map(){
        return db.getTreeMap("users");
    }
    
}
