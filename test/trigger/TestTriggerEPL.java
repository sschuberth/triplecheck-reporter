package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-09-24T18:14:00Z
 * LicenseName: AGPL-3.0+
 * FileName: TestTriggerGPL3.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the detection of GPL terms. </text> 
 */



import main.engine;
import main.start;
import org.junit.*;
import static org.junit.Assert.*;
import provenance.Trigger;

/**
 *
 * @author Nuno Brito
 */
public class TestTriggerEPL {
    
    
    String c1 = "THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS "
            + "ECLIPSE PUBLIC LICENSE (\"AGREEMENT\"). ANY USE, REPRODUCTION "
            + "OR DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT'S ACCEPTANCE"
            + " OF THIS AGREEMENT. ",
            
    // code copied from https://github.com/drbitboy/tdu850/blob/master/src/tdutest.c
    c2 = "EPL-1.0";
    
    
    public TestTriggerEPL() {
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
     public void findGPL() throws Exception {
     
         // initialize the triggers
         start.basicStart(new String[]{});
         
         System.out.println("------------------------");
         
         System.out.println("Number of triggers: " + engine.triggers.size());
         System.out.println("------------------------");
         
         // now test the licenses
         testLicense("c1", c1, "LicenseInfoInFile: EPL-1.0");
         testLicense("c2", c2, "LicenseInfoInFile: EPL-1.0");
     }

    /**
     * Tests if a given license was found on a given code snippet
     * @param codeSnippet
     * @param licenseId 
     */
    private void testLicense(final String title, final String codeSnippet, final String licenseId) throws Exception {
         String lowerCaseContent = codeSnippet.toLowerCase();
         boolean didNotFind = true;
         for(Trigger thisLicense: engine.triggers.getList()){
            if(thisLicense.isApplicable(codeSnippet, lowerCaseContent)){
                assertEquals(licenseId, thisLicense.getResultSPDX());
                //System.out.println(thisLicense.getResultSPDX());
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
}
