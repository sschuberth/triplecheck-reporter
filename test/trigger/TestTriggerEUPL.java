package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-09-18T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TestTriggerEUPL.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the detection of EUPL licenses </text> 
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
public class TestTriggerEUPL {
    
    
    String content = "European Union Public Licence V. 1.1\n" +
"\n" +
"EUPL (c) the European Community 2007\n" +
"\n" +
"This European Union Public Licence (the \"EUPL\") applies to the Work or Software (as defined below) which is provided under the terms of this Licence. Any use of the Work, other than as authorised under this Licence is prohibited (to the extent such use is covered by a right of the copyright holder of the Work).\n" +
"\n" +
"The Original Work is provided under the terms of this Licence when the Licensor (as defined below) has placed the following notice im";
    
    //public ArrayList<License> licenseInfoInFile = new ArrayList(); // just one for the moment, single source can have multiple
   
    
    public TestTriggerEUPL() {
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
     public void findGPLv3() throws Exception {
     
         // add up all the triggers from our folder
         //actions.addTriggers();
         
         // initialize the triggers
         start.basicStart(new String[]{});
         
         boolean didNotFind = true;
         
         String lowerCaseContent = content.toLowerCase();
         for(Trigger thisLicense: engine.triggers.getList()){
            if(thisLicense.isApplicable(content, lowerCaseContent)){
                assertEquals("EUPL-1.1", thisLicense.getShortIdentifier());
                System.out.println("Found EUPL-1.1 license");
                didNotFind = false;
            }
        }
         
         // output a message to warn about what happened
         if(didNotFind){
            System.out.println("Didn't found the EUPL terms");
         }
     
     }
}
