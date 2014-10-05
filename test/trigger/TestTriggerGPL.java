package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-09-24T18:14:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TestTriggerGPL3.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the detection of GPL terms. </text> 
 */

import java.io.File;
import main.core;
import main.start;
import org.junit.*;
import static org.junit.Assert.*;
import script.Trigger;

/**
 *
 * @author Nuno Brito
 */
public class TestTriggerGPL {
    
    
    String c1 = " * Adblock Plus is free software: you can redistribute it and/or modify"
        + "* it under the terms of the GNU General Public License version 3 as"
        + "* published by the Free Software Foundation.",
            
    // code copied from https://github.com/drbitboy/tdu850/blob/master/src/tdutest.c
    c2 = "/****************************************************************************\\\n" +
        "* *\n" +
        "* This file is licensed under the terms of the GNU General *\n" +
        "* Public License, version 2, or any later version. See file COPYING *\n" +
        "* for information on distribution conditions. *\n" +
        "\\****************************************************************************/";
    
    
    public TestTriggerGPL() {
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
     public void findGPL() {
     
         // initialize the triggers
         start.basicStart();
         
         System.out.println("------------------------");
         
         System.out.println("Number of triggers: " + core.triggers.size());
         System.out.println("------------------------");
         
         // now test the licenses
         testLicense("c1", c1, "LicenseInfoInFile: GPL-3.0");
         testLicense("c2", c2, "LicenseInfoInFile: GPL-2.0");
         
         // test individual files
         testFile("GPL/gpl-3.0.txt", "GPL-3.0", "LicenseInfoInFile: GPL-3.0");
         
     }

    /**
     * Tests if a given license was found on a given code snippet
     * @param codeSnippet
     * @param licenseId 
     */
    private void testLicense(final String title, final String codeSnippet, final String licenseId) {
         String lowerCaseContent = codeSnippet.toLowerCase();
         boolean didNotFind = true;
         for(Trigger thisLicense: core.triggers.getList()){
            if(thisLicense.isApplicable(codeSnippet, lowerCaseContent)){
                assertEquals(licenseId, thisLicense.getResult());
                //System.out.println(thisLicense.getResult());
                System.out.println("[OK] Found " + licenseId + " in " + title);
                didNotFind = false;
            }
         }
         // output a message to warn about what happened
         if(didNotFind){
            System.out.println("[NOK] Didn't found " + licenseId + " in " + title);
         }
         // all done
         System.out.println("----------------");
    }

    /**
     * Make sure that a given file only outputs an expected result from
     * our license detection engine
     * @param fileToTest        A file inside ./misc/licenses
     * @param licenseIdToMatch  The license Id that needs to be found
     */
    private void testFile(final String fileToTest, final String licenseIdToMatch,
            final String licenseID) {
        File targetFile = new File(core.getMiscFolder(), "test/licenses/" + fileToTest);
        if(targetFile.exists() == false){
            fail("Failed to find: " + targetFile.getAbsolutePath());
        }
        
        // read the file contents
        final String sourceCode = utils.files.readAsString(targetFile);
        final String sourceCodeLowerCase = sourceCode.toLowerCase();
        
        
        boolean didNotFind = true;
         for(Trigger thisLicense: core.triggers.getList()){
            if(thisLicense.isApplicable(sourceCode, sourceCodeLowerCase)){
                //assertEquals(licenseId, thisLicense.getResult());
                //System.out.println(thisLicense.getResult());
                System.out.println("Found " + thisLicense.getResult());
                didNotFind = false;
            }
         }
         // output a message to warn about what happened
         if(didNotFind){
           // System.out.println("[NOK] Didn't found " + licenseId + " in " + title);
         }
         // all done
         System.out.println("----------------");
    }
    
    
    
    
}
