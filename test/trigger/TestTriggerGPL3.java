package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
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
import script.Trigger;

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
     
         // add up all the triggers from our folder
         actions.addLicenses();
         
         
         String lowerCaseContent = content.toLowerCase();
         for(Trigger thisLicense: core.triggers){
            if(thisLicense.isApplicable(lowerCaseContent )){
                assertEquals("GPL-3.0", thisLicense.getShortIdentifier());
                System.out.println("Found GPL v3 license");
            }
        }
     
     }
}
