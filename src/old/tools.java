/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-17T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: check.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class contains several functions that help
 * to check certain details about SPDX information.</text> 
 */

package old;

import java.io.File;
import main.core;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 17th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class tools {

    /**
     * Verifies if a given SPDX document exists inside our archive or or not
     * @param spdxTarget The file inside the SPDX Archive
     * @param request
     * @return null if the file does not exists, otherwise return a pointer
     */
    public static File getFile(String spdxTarget, WebRequest request){
         if(spdxTarget == null){
            request.setAnswer("No file specified");
            return null;
        }
        // does this file exists?
        File file = new File(core.getProductsFolder(), spdxTarget);
        // this file needs to exist
        if((file.exists() == false) || (file.isDirectory())){
            request.setAnswer("Sorry, the file was not found: " + spdxTarget);
            return null;
        }
        // all done
        return file;
    }
    
   
}
