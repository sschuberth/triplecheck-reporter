package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-06T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: TestTriggerGPL2.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the detection of licenses </text> 
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
public class TestTriggerGPL2 {
    
    
    String content = ""
+"		    GNU GENERAL PUBLIC LICENSE"
+"		       Version 2, June 1991"
+""
+" Copyright (C) 1989, 1991 Free Software Foundation, Inc."
+"     51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA"
+" Everyone is permitted to copy and distribute verbatim copies"
+" of this license document, but changing it is not allowed.";
    
   
    
    public TestTriggerGPL2() {
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
     public void findGPLv2() {
     
         // add up all the licenses from our folder
         actions.addLicenses();
         
         
         String lowerCaseContent = content.toLowerCase();
         for(License thisLicense: core.licenses){
            if(thisLicense.isApplicable(lowerCaseContent )){
                assertEquals("GPL-2.0", thisLicense.getShortIdentifier());
                System.out.println("Found GPL v2 license");
            }
        }
     
     }
}
