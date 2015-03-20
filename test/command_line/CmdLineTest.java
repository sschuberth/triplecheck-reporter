/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2015-03-20T16:49:00Z
 * LicenseName: AGPL-3.0+
 * FileCopyrightText: <text> Copyright (c) 2015 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the available command line parameters.  </text> 
 */
package command_line;

import java.io.File;
import main.CmdLine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*

Syntax for each command line parameter

spdx texfileToBeCreated folderWithFilesToProcess packageURL


*/


/**
 *
 * @author Nuno Brito, 20th of March 2015 in Hannover, Germany
 */
public class CmdLineTest {
    
    // define the SPDX document to be created
    final File tempFolder = new File("temp");
    final File spdxFile = new File(tempFolder, "temp.spdx");
    // use a sample folder with files that we want to scan
    final File sourceFolder = new File("samples", "2015-03-06-Python-Java-Jars");
        
    
    public CmdLineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFail() {
        CmdLine cmd = new CmdLine();
        
        try{
            // no parameters? Should elegantly fail, no exception caused
            cmd.isCommandLineUsed(null);
        }catch (Exception e){
            fail();
        }
    }
    
    @Test
    public void testCreateSPDX() {
        CmdLine cmd = new CmdLine();
        
        // we need three parameters
        String[] params = new String[]{"spdx", "test"};
        // test the basic SPDX creation
        cmd.isCommandLineUsed(params);
        
        String answer = cmd.getAnswer();
        // did we got the expected answer?
        if(answer.equals(CmdLine.spdx_expecting_more_parameters)== false){
            fail("Expecting a different message");
        }
        
        // create the temporary folder for testing
        if(tempFolder.exists()){
            utils.files.deleteDir(tempFolder);
        }
        // create the temp folder, hopefully empty
        utils.files.mkdirs(tempFolder);
        
        // now define some dummy URL to be used as example
        final String packageURL = "test URL being used here";
        
        // create the parameters to be used
        params = new String[]{"spdx", spdxFile.getPath(),
            sourceFolder.getPath(), "test", packageURL};
        
        System.out.println("Testing the creation of an SPDX document");
        // call the command execution
        cmd.isCommandLineUsed(params);
        answer = cmd.getAnswer();
        
        if(spdxFile.exists() == false){
            fail("The SPDX document was not created");
        }
        
        if(answer.equals(CmdLine.spdx_created_document)== false){
            fail("Document failed to be created");
        }
        
        System.out.println("Concluded SPDX creation");
    }
    
    
    @Test
    public void testScoreProject() {
        System.out.println("Test the project scoring");
        String[] params = new String[]{"score", spdxFile.getPath()};
        
        // test the command
        CmdLine cmd = new CmdLine();
        cmd.isCommandLineUsed(params);
        
        // we expect 40 as value
        if(cmd.getAnswer().equals("40") == false){
            fail("The score is different from what we expected, please check");
        }
        
        // the answer that was provided by our scoring mechanism
        System.out.println("Score: " + cmd.getAnswer());
    }
    
    @Test
    public void testImprovementSuggestions() {
        System.out.println("Test the improvement suggestions");
        String[] params = new String[]{"suggestions", spdxFile.getPath()};
        
        // test the command
        CmdLine cmd = new CmdLine();
        cmd.isCommandLineUsed(params);
        
        // the answer that was provided by our scoring mechanism
        System.out.println("Suggestions:\n" + cmd.getAnswer());
        
        if(cmd.getAnswer().contains("documentation files missing:") == false){
            fail("The result is different from what we expected, please check");
        }
    }
    
//    @Test
//    public void testProjectOriginality() {
//        System.out.println("\nTest the project originality");
//        String[] params = new String[]{
//            "originality", 
//            spdxFile.getPath(),
//            sourceFolder.getPath()
//        };
//        
//        // test the command
//        CmdLine cmd = new CmdLine();
//        cmd.isCommandLineUsed(params);
//        
//        // we expect 40 as value
////        if(cmd.getAnswer().equals("40") == false){
////            fail("The score is different from what we expected, please check");
////        }
//        
//        // the answer that was provided by our scoring mechanism
//        System.out.println("Originality:\n" + cmd.getAnswer());
//    }
    
     @Test
    public void testReportCreate() {
        System.out.println("\nTest the HTML report functionality");
        String[] params = new String[]{
            "report", 
            spdxFile.getPath(),
            tempFolder.getPath()
        };
        
        // test the command
        CmdLine cmd = new CmdLine();
        cmd.isCommandLineUsed(params);
        
        // verify we finished the report as expected.
        if(cmd.getAnswer().equals(CmdLine.html_created_report) == false){
            fail("The report wasn't created with success");
        }
        
        // the answer that was provided by our scoring mechanism
        System.out.println("HTML report answer:\n" + cmd.getAnswer());
    }
    
}
