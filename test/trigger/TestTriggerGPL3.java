package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: TestTriggerGPL3.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the detection of GPL v3 licenses </text> 
 */

import java.util.ArrayList;
import main.actions;
import main.core;
import org.junit.*;
import static org.junit.Assert.*;
import script.License;

/**
 *
 * @author Nuno Brito
 */
public class TestTriggerGPL3 {
    
    
    String content = " * Adblock Plus is free software: you can redistribute it and/or modify"
        + "* it under the terms of the GNU General Public License version 3 as"
        + "* published by the Free Software Foundation.";
    
    //public ArrayList<License> licenseInfoInFile = new ArrayList(); // just one for the moment, single source can have multiple
   
    
    public TestTriggerGPL3() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
     @Test
     public void findGPLv3() {
     
         // add up all the licenses from our folder
         actions.addLicenses();
         
         
         String lowerCaseContent = content.toLowerCase();
         for(License thisLicense: core.licenses){
//             if(thisLicense == null){
//                 continue;
//             }
            // System.out.println(thisLicense.getShortIdentifier());
            if(thisLicense.isApplicable(lowerCaseContent )){
                //licenseInfoInFile.add(thisLicense);
                System.out.println(thisLicense.getURL());
                System.out.println("Found GPL v3 license");
            }
        }
     
     }
}
