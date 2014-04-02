package create;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: TestCreateSPDX.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the creation of an SPDX document </text> 
 */

import java.io.File;
import main.actions;
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
     
         // add up all the licenses from our folder
         actions.addLicenses();
         
         File thisFolder = new File("tools/source", "adblockplus-2.5.1");
         
         System.out.println(thisFolder.getAbsolutePath());
        
         DocumentCreate spdx = new DocumentCreate();
         spdx.create(thisFolder);
        
     }
}
