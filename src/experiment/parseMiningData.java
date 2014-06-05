/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-03T18:41:23Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: parseMiningData.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package experiment;

import components.Component;
import components.Repository;
import definitions.is;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import script.log;


/**
 *
 * @author Nuno Brito, 3rd of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class parseMiningData {
    
    int 
         charPosition = 0,
         counterLine = 0;
    
    BufferedReader reader;
    FileWriter fileWriter;
    
    public static void main(String[] args) throws Exception {
        // start the data mining parsing class
        parseMiningData parser = new parseMiningData();
        
        // parse the google code repository
        parser.parseGoogleCode(new File("D:\\triplechecksoftware\\datamining\\gc\\gcProjectInfo2012-Nov.txt\\gcProjectInfo2012-Nov.txt"),
                new File(core.getComponentFolder(), "googlecode/gc.jsons"), "Google code (2012-Nov)");
        
        System.exit(1981);
    }
    
    /**
     * Opens up a FLOSSMole archive to extract the required information
     * that we will use on the component list
     */
    public void parseGoogleCode(File sourceFile, File outputFile, String title){
        try {
          reader = new BufferedReader(new FileReader(sourceFile));
          fileWriter = new FileWriter(outputFile);
            
          // we don't need to interpret the header
          readAndSkipHeader();
          createHeaderLine(sourceFile, title, "gc");
          String line;
            // now iterate through all lines
            while ((line = reader.readLine()) != null) {
               try {
                    // read the tag/value information
                    processFileLine(line);
                
//                     if(counterLine > 200){
//                        break;
//                     }
                    
               } catch (Exception ex) {
                    log.write(is.ERROR, "Error reading line: %1 of file %2: %3"
                            ,counterLine + "", sourceFile.getAbsolutePath(), line);
                    // no need to stop, continue to the next item
                    continue;
                }
                // increase the line counter
                //charPosition+= line.length() + 1;
            }
            reader.close();
            fileWriter.close();
            // small tidybits that were left to fix up
            postProcessing();
      } catch (IOException ex) {
          Logger.getLogger(parseMiningData.class.getName()).log(Level.SEVERE, null, ex);
          // something went wrong
          log.write(is.ERROR, "Error when reading line: %1 of file %2"
                  ,counterLine + "", sourceFile.getAbsolutePath());
      }
    }

    /**
     * This method is used on the begining of a parsing where the original
     * file contains a header section
     */
    private void readAndSkipHeader() throws IOException{
        boolean continueReading = true;
        while(continueReading){
            String line = reader.readLine();
            if(line.startsWith("#")){
                continue;
            }else{
                continueReading = false;
            }
        }
        // after the header comes the field titles, skip this line too
        reader.readLine();
    }
    
    
    /**
     * Process a line of text
     * @param line 
     */
    private void processFileLine(String line) throws IOException {
        /**
            Data fields:
                0 proj_name             // the google URL
                1 datasource_id         // usually "350"
                2 code_license          // applicable license (e.g. GNU GPL v2)
                3 code_url              // URL to applicable license
                4 activity_level        // usually NULL
                5 content_license       // empty or shows "Creative Commons 3.0 BY"
                6 content_url           // URL to content license (when defined)
                7 project_summary       // one line summary
                8 project_description   // full HTML description
         */
        counterLine++;
        String[] fields = line.split("\t");
        //String thisLine = fields[0];
        
        Component component = new Component();
        component.setId(fields[0]);
        
        if(fields.length > 7){
            component.setDescriptionOneLine(fields[7]);
            component.setDeclaredLicense(fields[2]);
        }
               
        final String thisLine = component.getJsonString() + is.lineBreak;
        
        fileWriter.append(thisLine);
//        System.out.println(thisLine);
        
    }

    /**
     * After everything was said and done
     */
    private void postProcessing() {
        System.out.println("Lines indexed: " + counterLine);
    }

    /**
     * Create the initial line in our data file
     * @param sourceFile 
     */
    private void createHeaderLine(File sourceFile, final String title, 
            final String repType) throws IOException {
        
        Repository rep = new Repository();
        rep.setTitle(title);
        rep.setCopyright("Copyright (c) 2014 Nuno Brito");
        rep.setCreated(utils.time.getDateTimeISO());
        rep.setType(repType);
        rep.setLicense("CC-BY-4.0 license");
        rep.setComments("Data provided by FLOSSmole at http://flossmole.org");
        
        final String line = rep.getJsonString() + is.lineBreak;
        
//        String line = "Created in "
//                + utils.time.getDateTimeISO()
//                + " | CC-BY-4.0 license"
//                + " | Copyright (c) 2014 Nuno Brito"
//                + " | Data based on "
//                + sourceFile.getName()
//                + " by FLOSSmole at http://flossmole.org"
//                + is.lineBreak;
        fileWriter.append(line);
    }
    
}
