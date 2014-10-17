/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) 
 * Created: 2014-05-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: generateFileExtensionJson.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class helps to generate JSON files from objects
 * that were created by Beanshell. This is a way of avoiding the beanshell
 * processing which is practical, but relatively slower in terms of performance
 * when compared to normal byte code. This class translates the existing classes
 * into JSON format.</text>
 */

package experiment;

import com.google.gson.Gson;
import java.io.File;
import main.engine;

/**
 *
 * @author Nuno Brito, 25th of May 2014 in Darmstadt, Germany.
 */
public class generateFileExtensionJson {
    public static void main(String[] args) {
        // where to we want to store the files?
        File targetFolder = new File(engine.getMiscFolder(), "extensions");
        
//        engine.extensions.generateJsonFiles(targetFolder);
//        engine.extensions.readJsonFiles(targetFolder);
        
        System.exit(0);
    }

    


}

