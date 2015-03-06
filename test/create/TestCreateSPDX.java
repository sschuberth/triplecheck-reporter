package create;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: TestCreateSPDX.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the creation of an SPDX document </text> 
 */

import java.io.File;
import org.junit.*;
import spdxlib.DocumentCreate;

/**
 *
 * @author Nuno Brito
 */
public class TestCreateSPDX {
    
    
    
    public TestCreateSPDX() {
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
     
         File baseFolder = new File("../..", "source");
         File thisFolder = new File(baseFolder, "adblockplusie");
         
         DocumentCreate spdx = new DocumentCreate();
         //spdx.create(spdx);
         
         // show all messages to let us know what is happening
//         spdx.showDebugMessages = true;
         
//         spdx.create(thisFolder);

//         String text = spdx.output;
//         
//         // get all the items that have a license declared
//         String keyword = "LicenseInfoInFile:";
//         int counterLicenses = (text.length() - text.replace(keyword, "").length())/keyword.length();
//         
//         // now do the same but just for copyright
//         keyword = "FileCopyrightText:";
//         int counterCopyright = (text.length() - text.replace(keyword, "").length())/keyword.length();
//         
//         System.out.println("Files with licenses: " + counterLicenses);
//         System.out.println("Files with copyright: " + counterCopyright);
     }
}
