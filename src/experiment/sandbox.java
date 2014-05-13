/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-05-11T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: sandbox.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A file for sporadic testing </text>
 */

package experiment;

import spdxlib.SPDXfile2;
import GUI.TreeNodeSPDX;
import GUI.TreeviewUtils;
import definitions.is;
import java.io.File;
import main.core;
import script.log;

/**
 *
 * @author Nuno Brito, 11th of May 2014 in Darmstadt, Germany.
 */
public class sandbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //final String target = "javascript-ipv6-2014-04-22.spdx";
        final String target = "linux-coreos.spdx";
        // "linux-coreos.spdx"
        File bigFile = new File (core.getMiscFolder(), target);
        if(bigFile.exists() == false){
            System.err.println("Not found: " + bigFile.getAbsolutePath());
            return;
        }
        SPDXfile2 spdx = new SPDXfile2(bigFile);
        log.write(is.INFO, "Finished reading spdx");
//        TreeNodeSPDX root = new TreeNodeSPDX("test");
        //TreeviewUtils.spdxDoTreeFileStructure(root, spdx);
//        log.write(is.INFO, "Finished creating node");
//        spdx.printFeedback();
        System.exit(1111);
    }
    
}
