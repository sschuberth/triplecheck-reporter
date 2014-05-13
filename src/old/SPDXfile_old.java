  /*
   * SPDXVersion: SPDX-1.1
   * Person: Person: Nuno Brito (nuno.brito@triplecheck.de)
   * Person: Organization: TripleCheck (contact@triplecheck.de)
   * Date: 2013-08-29T00:00:00Z
   * LicenseName: EUPL-1.1-without-appendix
   * FileName: SPDXfile.java  
   * FileType: SOURCE
   * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
   * FileComment: <text> Object that contains an SPDX report. This class 
   * contains the basic functions to readLines an SPDX file from disk, to perform 
   * the basic operations such as adding/changing/finding data and then 
   * saving this information back to a file on disk. </text> 
   */

package old;

import definitions.Process;
import definitions.id;
import definitions.is;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import script.FileExtension;
import script.log;
import spdxlib.FileCategory;
import spdxlib.FileLanguage;
import spdxlib.FileOrigin;
import spdxlib.Keyword;
import utils.files;
import utils.html;
import static utils.misc.sortByComparator;

public final class SPDXfile_old implements Serializable{
    
    
    // The variables listed here follow the same order as
    // listed on the SPDX 1.1 specification
   
   public SectionCreator creatorSection;
   public SectionPackage packageSection;
    
   // list of triggers applicable to this SPDX  
   ArrayList<TagLicense> licenses;          
   
   // where we report all found fileSection of the package
   public SectionFiles fileSection;
   
   Person  reviewer;
   TagValue
           reviewDate,
           reviewComment;
   
   public ArrayList<TagValue> 
            tags = new ArrayList(); 
    
   // basic objects to support the SPDX processing
   public File
           file; // direct file pointer to this file

   public String 
            rawText; // text for the SPDX file
   
   ArrayList<String[]> 
           lines1; // where we keep all the lines that were separated
   
   
   // have statistics been already calculated for this document?
   private boolean hasStats = false;
   
   private HashMap<FileLanguage, Integer> statsLanguagesFound;
   private int statsLanguagesTotal;
   
   // related to artwork
   private int statsArtworkCount;
   private HashMap<FileCategory, Integer> statsArtworkFound;
   
   // are redundant files present on the document?
   private Boolean statsHasVersioning = false;
   
   // how many triggers were declated in this document?
   private int statsLicensesDeclaredCount;
   // there is a difference between declared and concluded triggers
   private HashMap<String, Integer> statsLicensesDeclared;
   
   /**
    * Constructor where we initialize this object by serving an SPDX text
    * file as source of knowledge to fill up the contents
    * @param file 
    */
   public SPDXfile_old(File file){
      newStart(file);
   }

   /**
    * Resets the variables for this object
    */
   private void cleanUpVariables(){
       creatorSection = new SectionCreator();
       packageSection = new SectionPackage();
       licenses = new ArrayList();
       fileSection = new SectionFiles(this);
       statsLanguagesFound = new HashMap();
       statsArtworkFound = new HashMap();
       statsLicensesDeclared = new HashMap();
       statsLanguagesTotal = 0;
       statsLicensesDeclaredCount = 0;
       statsArtworkCount = 0;
   }
   
   /**
    * The initializer of this class
    * @param file   File on disk from where the SPDX document can be readLines
    */
   private void newStart(File file){
        // assign the file pointer
        this.file = file;
        // clean up / initialize our variables
        cleanUpVariables();
        // do the normal reading
        read(file);
        // now pre-process the stats
        doStats();
   }
    
    /**
     * A reader for the version 1.1 of SPDX tag value format
     * @param file The text file with the SPDX content
     * @return SPDX object with the processed content from SPDX text file
     */
     private void read(File file){
        // preflight checks
         // preflight checks 
        if(file == null){
            return;
        }
        if(file.exists() == false){
            return;
        }
        if(file.isDirectory()){
            return;
        }
         
        // readLines all available data from the given file
        readLines();
        // process all this information into meaningful data
        processData();
    }
    
     
   /**
    * Based on the information available on the "data" object, the SPDX
    * document object will be filled with this information. 
     * @param file SPDX text file with the data to be interpreted
    */
   private void processData(){
       
       if(lines1.size() > 6000){
           log.write(is.INFO, "Processing %1 with %2 files, please wait..",
                   this.file.getName() + "", lines1.size() + "");
       }
       
      // reading is done in sequential mode, not very fast but it is robust 
      creatorSection.SPDXVersion = readGeneric(Keyword.SPDXVersion);
      creatorSection.dataLicense = readGeneric(Keyword.DataLicense);
      creatorSection.documentComment = readGeneric(Keyword.DocumentComment);
      // readLines people information
      parseTags();
      creatorSection.created = readGeneric(Keyword.Created);
      creatorSection.creatorComment = readGeneric(Keyword.CreatorComment);
   }
   
   /**
    * Generic way of finding specific entries on the SPDX document, this
    * only works for unique key titles.
    */
    TagValue readGeneric(final Keyword keyword){
       for(TagValue tag : tags){
           if(tag.title.equalsIgnoreCase(keyword.toString())){
               return tag;
           }
       }
       return null;
   }
   
    /**
     * Simply outputs to screen the basic data about this SPDX document
     */
    void printHeader() {
        
        String creatorsList = "\n";
        for(Person person : creatorSection.people){
          creatorsList = creatorsList.concat(person.toString()+"\n\n"); 
        }
        
//        System.out.println(
////                "SPDX version = " + SPDXVersion + "\n" +
////                "Data trigger = " + dataLicense + "\n" +
////                "Document Comment = " + documentComment + "\n" +
////                "Creators: " + creatorsList +
////                "Created = " + created + "\n" +
////                "Creator Comment = " + creatorComment + "\n" +
//                "Reported files: " + fileSection.files.size()
//                );
    }
   
    
    
    /**
     * Attempts to discover which part of document is being processed.
     * This helps to avoid a huge amount of IF statements for each tag processed
     */
    int whichSectionShouldBeProcess(final TagValue tag, int currentPosition){
     
            if(currentPosition < Process.header){ 
                if(tag.title.equalsIgnoreCase(Keyword.SPDXVersion.toString())){
                    return  Process.header;
                }
            }
            // shall we start processing package data?
            if(     (currentPosition >= Process.header) &&
                    (currentPosition < Process.packageData)){
                if(tag.title.equalsIgnoreCase
                        (Keyword.PackageName.toString())){
                    return Process.packageData;
                }
            }

            // shall we start getting file data?
            if(     (currentPosition >= Process.packageData)&&
                    (currentPosition < Process.files)){
                if(tag.title.equalsIgnoreCase
                        ("FileName")){
                    return Process.files;
                }
            } 
                
             // if there is reviewer data, start processing
            if(     (currentPosition >= Process.files)&&
                    (currentPosition < Process.review)){
                if(tag.title.substring(0, 6).equalsIgnoreCase("Review")){
                    return Process.review;
                }
            } 
            return currentPosition;
    }
    
    /**
     * It has been noted in some cases that people are very flexible about the
     * way how the people info is specified. So, it is necessary to go a bit
     * beyond the specification and adapt to the odd cases in order to retrieve
     * as much information as possible.
     */
    void parseTags(){
        /**
         * There exist several tag/values across the document that can be
         * errouneously mixed or misplaced. For example, the people info
         * also appears on the package originator.
         * 
         * Humans understand this information when inserted between two specific
         * blocks of data. Our method needs to replicate this method.
         * 
         * We will read sequentially all the found tag/value entries and signal
         * markers whenever passing throught some specific block sections.
         */
        
        // define our markers that will be used for positioning
        int processing = Process.nothing;
        
       for (TagValue tag : tags) {
           // do the markers check. No need to repeat them if already flagged
           processing = whichSectionShouldBeProcess(tag, processing);
           
           ///////////////////////////////////////////////////////////////////
           // check for the specific blocks that we want to tap
           ///////////////////////////////////////////////////////////////////
           
           switch(processing) {
               
               case Process.header:
                   parseCreatorTags(tag);
                   break;
                   
               case Process.packageData:
                   packageSection.parseTag(tag);
                   parseOtherLicensingTags(tag);
                   break;
                   
               case Process.files:
                   fileSection.parseTag(tag);
                   break;
                   
               case Process.review:
                   parseReviewerTags(tag);
                   break;
           }
       }
        
        // do the recovery attempts
        if(fileSection.unknown.size() > 0){
            for(TagValue unknown : fileSection.unknown){
                tryRecovery(unknown);
            }
        }
    }    
    
    /**
     * Whenever a tag was found but was not allocated to a specific section
     * then it might just be misplaced. We will try to see if it belongs
     * to elsewhere in the document blocks
     */   
    void tryRecovery(TagValue tag){
        packageSection.parseTag(tag);
    }
    
    /**
     * Allows getting information from non-standard "Creator" tags onto a person
     * object. If no valid information is valid, return person as null object
     */
    void parseCreatorTags(TagValue tag){
        // only process tags starting with "Creat"
        if((tag.title.length() < 5)
                || (!tag.title.substring(0, 5).equalsIgnoreCase("Creat"))){
            return;
        }
        
        //System.out.println(tag.title + " - " + tag);
            // are we talking about custom people tags like WindRiver?
            if(tag.title.equalsIgnoreCase("Creator")){
                Person person = new Person();
                creatorSection.people.add(person);
                person.setTagPerson(tag);
            }
             
            // process strict Creator tag
            if(tag.title.equalsIgnoreCase("Creator->Person")){
                Person person = new Person();
                creatorSection.people.add(person);
                person.setTagPerson(tag);
            }
            
            // process organization details (we add them to last added person)
            if(tag.title.equalsIgnoreCase("Creator->Organization")){
                Person person = getLastCreator();
                person.setTagOrganization(tag);
            }

            // process the tool details if available
            if(tag.title.equalsIgnoreCase("Creator->Tool")){
                Person person = getLastCreator();
                person.setTagTool(tag);
            }
    }
    
    
   
    
    
    /**
     * Parse information regarding other triggers
     * @param tag 
     */
    private void parseOtherLicensingTags(TagValue tag) {
   
        if(tag.title.equalsIgnoreCase("LicenseID")){
                TagLicense license = new TagLicense();
                license.tagLicenseID = tag;
                licenses.add(license);
                return;
        }
        
       if(tag.title.equalsIgnoreCase("ExtractedText")){
                TagLicense license = getLastAddedLicense();
                license.tagExtractedText = tag;
                return;
       }
        
       if(tag.title.equalsIgnoreCase("LicenseName")){
                TagLicense license = getLastAddedLicense();
                license.tagLicenseName = tag;
                return;
       }
        
       if(tag.title.equalsIgnoreCase("LicenseCrossReference")){
                TagLicense license = getLastAddedLicense();
                license.tagLicenseCrossReference = tag;
                return;
       }
        
       if(tag.title.equalsIgnoreCase("LicenseComment")){
                TagLicense license = getLastAddedLicense();
                license.tagLicenseComment = tag;
       }
    }

    /**
     * Goes the array of triggers and gets the most recent one.
     * If there is none, it creates one.
     */
    private TagLicense getLastAddedLicense(){
        TagLicense result;
        if(licenses.size()>0){
            result = licenses.get(licenses.size()-1);
        }else{
            result = new TagLicense();
            licenses.add(result);
        }
        return result;
    }
    
     /**
     * Goes the array of people and gets the most recent one.
     * If there is none, it creates one.
     */
    private Person getLastCreator(){
        Person result;
        if(creatorSection.people.size()>0){
            result = creatorSection.people.get(creatorSection.people.size()-1);
        }else{
            result = new Person();
            creatorSection.people.add(result);
        }
        return result;
    }

    

    /**
     * Do the reviewer tags now
     */
    private void parseReviewerTags(TagValue tag) {
         // only process tags starting with "Creat"
        if((tag.title.length() < 6)
                || (!tag.title.substring(0, 5).equalsIgnoreCase("Review"))){
            return;
        }
        // start processing these tags
        
        if(tag.title.equalsIgnoreCase("Reviewer->Person")){
            if(reviewer == null){
                reviewer = new Person();
            }
                reviewer.setTagPerson(tag);
                return;
        }

        if(tag.title.equalsIgnoreCase("Reviewer->Organizations")){
            if(reviewer == null){
                reviewer = new Person();
            }
                reviewer.setTagOrganization(tag);
                return;
        }
        
        if(tag.title.equalsIgnoreCase("Reviewer->Tool")){
            if(reviewer == null){
                reviewer = new Person();
            }
                reviewer.setTagTool(tag);
                return;
        }
        
        
        if(tag.title.equalsIgnoreCase("ReviewDate")){
                reviewDate = tag;
                return;
        }

        if(tag.title.equalsIgnoreCase("ReviewComment")){
                reviewComment = tag;
        }
    }

    public String getId(){
        String title = packageSection.name.toString();
        return title;
    }
   
    @Override
    public String toString(){
        String licenseOutput = "";
        // if we have a trigger defined for this SPDX file, show it publicly
        if(packageSection.licenseConcluded.toString().isEmpty() == false){
            licenseOutput = " (" 
                    + packageSection.licenseConcluded.toString()+ ")";
        }
        return getId() + licenseOutput;
    }
    
    /**
     * Adds another SPDX document as a dependency of this SPDX
     * @param component
     */
    public void addComponent(SPDXfile_old component){
        // Add our component as a dependency
        System.err.println("UY76 - Adding component " 
                + component.file.getName());
        /**
         * Default format that we like:
         * 
         * PackageDependency: busybox-1.20.2.tar.bz2.spdx
         * 
         */
        
        // create the snippet of code that adds the dependency
        String snippet = "\n" + "PackageDependency: " 
                + component.file.getName();

        // verify that this dependency was not added before
        if(rawText.contains(snippet)){
            // nothing necessary to be done
            return;
        }
        
        // add this dependency to our text
        rawText = rawText.concat(snippet);
        // save the result to disk
        utils.files.SaveStringToFile(file, rawText);
    }

    /**
     * A critical feature is when we need to change a give tag inside the 
     * physical file on disk. This is not a straightforward action, might
     * have different types of consequences that are not yet handled.
     * @param tag The tag that we want to modify
     * @param original The original text portion we want to change
     * @param replacement The new string of text that will be written
     * @return Returns the modified tag value or the same if nothing changed
     */
    public TagValue changeTag(TagValue tag, String original, String replacement) {
        // preflight checks
        if(tag.isMultiLine){
            log.write(is.ERROR, "SPDX change tag error, multi-line tags are "
                    + "not yet supported: %1", tag.toString());
            return tag;
        }

        if(tag.linePosition < 0){
            log.write(is.ERROR, "SPDX change tag error, line position "
                 + "is necessary but was not found: %1", "" + tag.linePosition);
            return tag;
        }

        // do the change of text inside the tag
        String newText = tag.raw.replace(original, replacement);
        // save this info on the original tag object
        tag.raw = newText;
        
        // remove break lines, otherwise it adds a redundant line afterwards
        newText = newText.replace("\n", "");
        // replace the old line with the new contents
        //lines1.set(tag.linePosition, newText);
        
        
        // get the original value
        String[] lines = lines1.get(tag.linePosition);
        // create the array iterator
        List<String> output = new ArrayList<String>();
        // first, add the original values
        output.addAll(Arrays.asList(lines));
        // second, add the new value
        output.set(0, newText);
        // third, convert back to static array and place back in our list
        lines = output.toArray(new String[0]);
        lines1.set(tag.linePosition, lines);
        
        return tag;
    }
    
    /**
     * After we are finished making changes, we can save the text file
     */
    public void commitChanges(){
       // write file on disk
       files.SaveLargeStringToFile(file, lines1);
    }

    /**
     * Whenever a given tag does not exist, there are cases when we need to add
     * one. This method permits to add a tag on the position where a tag exists 
     * @param linePosition The tag used as anchor
     * @param text the text to be included
     */
    public void addTag(int linePosition, String text) {
        // get the original value
        String[] lines = lines1.get(linePosition);
        // create the array iterator
        List<String> output = new ArrayList<String>();
        // first, add the original values
        output.addAll(Arrays.asList(lines));
        // second, add the new value
        output.add(text);
        // third, convert back to static array and place back in our list
        lines = output.toArray(new String[0]);
        lines1.set(linePosition, lines);
    }

    /**
     * How many triggers were declared inside this document?
     * @return number of triggers declared
     */
    public int getStatsLicensesDeclared() {
        return statsLicensesDeclaredCount;
    }

    
    public boolean hasVersioningFilesPresent() {
        return statsHasVersioning;
    }
    
    
    /**
     * Computes all the statistics related to this document. This method
     * is aimed at centralizing the stats calculation and this way avoid
     * different loops several times, avoiding a waste of time and CPU.
     */
    private void doStats(){
        // no need to continue if stats were already processed
        if(hasStats) {
            return;
        }
    
        // initialize our variables
        statsLicensesDeclaredCount = 0;
        statsHasVersioning = false;
        
        // this list keeps files where multiple languages apply
        ArrayList<FileInfo_old> secondList = new ArrayList();
        
        // A single big loop to get all our stats computed
        for(FileInfo_old fileInfo : fileSection.files){
            
            
            // count the number of declared triggers (not the concluded lic.)
            int licensesCount =  fileInfo.countLicensesDeclared();
            statsLicensesDeclaredCount += licensesCount;
             // was at least one trigger added?
            if(licensesCount > 0){
                String license = fileInfo.getLicense();
                
//                if(trigger.equalsIgnoreCase("MIT")){
//                    System.out.println("");
//                }
                
                // do we already have a similar trigger?
                if(statsLicensesDeclared.containsKey(license)){
                    //  increase the counter
                    int count = statsLicensesDeclared.get(license);
                    count++;
                    statsLicensesDeclared.put(license, count);
                }else{
                    // first time, just add it up
                    statsLicensesDeclared.put(license, 1);
                }
            }
            
            // now add the concluded license
            if(fileInfo.tagLicenseConcluded != null){
                
            }
            
            
            // process the most popular language types on this project
            FileExtension extension = fileInfo.getExtension();
            // only proceed when there is a valid extension
            if(extension == null){
                continue;
            }
            // get the category type
            FileCategory category = extension.getCategory();
            
            
            // this is useful to know (because they are redundant in SPDX docs)
            if(category == FileCategory.VERSIONING){
                statsHasVersioning = true;
            }
            
            // is this an artwork that we should consider?
            if((category == FileCategory.IMAGE)
             ||(category == FileCategory.SOUND)
             ||(category == FileCategory.FONT)
             ||(category == FileCategory.MUSIC)
             ||(category == FileCategory.VIDEO)
                    ){
                // increase the counter
                statsArtworkCount ++;
                // if already exists, just add up this one
                if(statsArtworkFound.containsKey(category)){
                    int count = statsArtworkFound.get(category);
                    count++;
                    statsArtworkFound.put(category, count);
                }else{
                    // first time here, create a new one
                    statsArtworkFound.put(category, 1);
                }
            }
            
            
            // to which programming language is this file related?
            FileLanguage language = extension.getLanguage();
            // shall we count this as something we know? Avoid unsorted keys
            if(language != FileLanguage.UNSORTED){
                // increase the counter
                statsLanguagesTotal++;
                // enable the line below if you want to see what is selected
                //System.out.println(fileInfo.getName() + "-->" + language.toString());
            }

            // if the file is used by multiple languages, then we place it
            // on a post-processing list to discover how it is being used.
            if(language == FileLanguage.MULTIPLE){
                secondList.add(fileInfo);
                // no need to proceed, skip to next file
                continue;
            }

            // get the right index, increase the counter
            if(statsLanguagesFound.containsKey(language)){
                int count = statsLanguagesFound.get(language);
                count++;
                statsLanguagesFound.put(language, count);
            }else{
                // first time, add it up
                statsLanguagesFound.put(language, 1);
            }
                
                
            
        }
        
        // now go through the second list, try to discover where the files
        // applicable to multiple languages belong
        // iterate through all these files
        for(FileInfo_old fileInfo : secondList){
            // get the respective extension
            FileExtension extension = fileInfo.getExtension();
            // what are the multiple language options?
            ArrayList<FileLanguage> multiple = extension.getLanguages();
            // just a security check, we don't want empty variables
            if(multiple.isEmpty()){
                continue;
            }
            
            // let's do some ranking
            int highestCount = 0;
            FileLanguage top = null;
            
            //FileLanguage language = extension.getLanguage();
             
            // go through each indexed language
            for(FileLanguage thisLang : statsLanguagesFound.keySet()){
                // we only want the possible candidates
                if(extension.getLanguages().contains(thisLang)==false){
                    continue;
                }
                
                int thisCount = statsLanguagesFound.get(thisLang);
                if(thisCount > highestCount){
                    // we have a possible value
                    top = thisLang;
                }
            }
            // now we have the top ranked candidate
            if(top != null){
                int count = statsLanguagesFound.get(top);
                    count++;
                    statsLanguagesFound.put(top, count);
            }
            
            
           
            
        }
        
          
        //debugStats();
        
        // all done
        hasStats = true;
    }

    /**
     * The unsorted hashmap with the languages that were most often found
     * on this document
     * @return 
     */
    public HashMap<FileLanguage, Integer> getStatsLanguagesFound() {
        return statsLanguagesFound;
    }

    /**
     * Get the number of files that we recognized as source code
     * @return 
     */
    public int getStatsLanguagesTotal() {
        return statsLanguagesTotal;
    }

    /**
     * How many images, icons, sound clips and other artwork are present
     * on this report?
     * @return 
     */
    public int getStatsArtworkCount() {
        return statsArtworkCount;
    }

    
    
    
     
    
    
    /**
     * Give some indication of what is going on in terms of languages
     */
    public void debugStats() {
        if(statsLanguagesFound.isEmpty()){
            System.err.println("SF650 - No languages were found?");
            return;
        }
        
        System.out.println("\nFile: " + file.getName() 
                + " (" +statsLanguagesTotal+ " known files)");
        // create a sorted array with the most popular languages
        Map<Object,Integer> map = sortByComparator(statsLanguagesFound);

        // show the ordered results
        for(Object langObj :map.keySet()){
            FileLanguage lang = (FileLanguage) langObj;
            // ignore unsorted files, they're not needed
            if(lang == FileLanguage.UNSORTED){
                continue;
            }
            int count = map.get(lang);
            System.out.println(lang.toString() + " -> " + count 
                    + " ("
                    + utils.misc.getPercentage(count, statsLanguagesTotal) + "%"
                    + ")");
        }
    }

    

    public int getStatsLicensesDeclaredCount() {
        return statsLicensesDeclaredCount;
    }
    
 
    /**
     * Displays the copyright holders that were reported on this SPDX document
     * @return      the HTML text ready to be displayed for end-users
     */
    public String getCopyrightEvaluation(){
        String result = "";
        
        // create the initial list of copyright holders
        HashMap<String, Integer> copyrightList = new HashMap();
        // iterate each file on this SPDX
        for(FileInfo_old fileInfo : fileSection.files){
            String copyright = fileInfo.getCopyright();
            if(copyright.isEmpty()){
                continue;
            }
            // is this the first time we hear about this copyright?
            if(copyrightList.containsKey(copyright) == false){
                copyrightList.put(copyright, 1);
            }else{
                // not the first time, increment the counter
                int counter = copyrightList.get(copyright);
                counter++;
                copyrightList.put(copyright, counter);
            }
        }
        
         // create an HTML table
//        Table table = new Table(new String[]{"# files", "Text"}, new int[]{100, 300});
//        Table table = new Table(new String[]{""}, new int[]{200});
        
        // the overall counter
        int countRecords = 0;
        int countFiles = 0;
        
       Map map = sortByComparator(copyrightList);
        
        // When all copyright texts were processed, time to list them
        for(Object copyrightObj : map.keySet()){
            String copyright = (String) copyrightObj;
            int counter = copyrightList.get(copyright);
            countFiles += counter;
            countRecords++;
            // reinforce the break lines with HTML break lines
            copyright = copyright.replace("\n", "\n" + html.br);
//            table.add(new String[]{copyright + " (" +counter + " times)"});
             result += //"- " + 
                     copyright + " " 
                       
                     + html.textGrey( "(" +
                         utils.text.pluralize(counter, "file")
                             + ")"
                        )
                     //+ html.br
                     + html.br;
        }
        
        if(result.isEmpty() == false){
            result = html.h2("Copyright holders")
                    + html.textGrey(
                         "Found " + utils.text.pluralize(countRecords, "record")
                        + " across "+ utils.text.pluralize(countFiles, "file")
                        )
                    //+ html.br
                    + html.br
                    + result;
                
        }
        
//        result = table.output();
        
        return result;
    }
    
    
    /**
     * Given the recognized languages inside a given document, create
     * an evaluation about what is contained inside.
     * @return      An HTML summary to be displayed for end-users
     */
    public String getLanguageEvaluation(){
        if(statsLanguagesFound.isEmpty()){
            System.err.println("SH650 - No languages were found?");
            return "";
        }
        
        // get the sorted map with the related languages
        Map<Object,Integer> map = sortByComparator(statsLanguagesFound);
        int total = statsLanguagesTotal;
        
        String result = "";
        
        // show the ordered results
        for(Object langObj :map.keySet()){
            FileLanguage lang = (FileLanguage) langObj;
            // ignore unsorted files, they're not needed
            if(lang == FileLanguage.UNSORTED){
                continue;
            }
            int count = map.get(lang);
            result += ""
                    + count 
                    + " "
                    + lang.toString() 
                    + " files"
                    + " ("
                    + utils.misc.getPercentage(count, total) + "%"
                    + ")"
                    + html.br
                    ;
        }
        
        // add some info about icons and artwork
        if(statsArtworkCount > 0){
            //result +=  html.br;
            // iterate through all the categories that were found
            for(FileCategory category : statsArtworkFound.keySet()){
                int count = statsArtworkFound.get(category);
                // should we use 1 file or 2 file"s"
                String quantity = "s"; // default to plural
                // adjust text for singular text
                if(count == 1){
                    quantity = "";
                }
                result += ""
                        + count
                        + " "
                        + category.toString()
                        + quantity
                        + html.br;
            }
        }

        // all done with the artwork
        result +=  html.br;
        
        
        
        // Now list the triggers
        if(statsLicensesDeclaredCount > 0){
//            Map<String,Integer> map2 = utils.misc.sortHashMap(statsLicensesDeclared);
            // show the ordered results
            map = sortByComparator(statsLicensesDeclared);
            
            for(Object licObj :map.keySet()){
                String lic = (String) licObj;
                
                int count = statsLicensesDeclared.get(lic);
                result += ""
                        //+ " -> " 
                        + utils.misc.getPercentage(count, statsLicensesDeclaredCount) + "%"
                        + " "
                        + lic
                        + " ("
                        + count 
                        + " files)"
                        + html.br
                        ;
            }        
            result +=  html.br;
        }
        
        return result;
    }

    
    /**
     * A quick way for updating this SPDX object when there are changes
     * that were made to the text file
     * @return      True if everything went ok, False if something went wrong
     */
    public boolean refresh(){
        // can't continue without knowing where the SPDX is located
        if(file.exists() == false){
             log.write(is.ERROR, "SPDXfile1034 - SPDX file does not exist: %1", 
                     file.getAbsolutePath());
            return false;
        }
        // readLines all the data again
        newStart(file);
        // all good here
        return true;
    }
    
    /**
     * When available, gives back the location where we can find the source code
     * files that were used when creating this document.
     * @return A pointer to the folder where the source code files are located
     */
    public File getSourceFolder() {
        if(file== null){
            return null;
        }
        // get the title
        String title = id.SOURCEFOLDER + file.getName();
        
        if(core.settings.hasKey(title)==false){
            System.err.println("SPDXfile1058: Didn't found " + title);
            return null;
        }
        // create the folder pointer
        File folder = new File(core.settings.read(title));
        
        // doesn't exist?
        if(folder.exists() == false){
            return null;
        }
        // all done!
        return folder;
    }
    
    /**
     * When given a relative path location, find the corresponding FileInfo
     * object or return null if it does not exist. This method is particularly
     * useful after a given SPDX object was indexed one time and then it is
     * refreshed due to some end-user editing. With this method you can get
     * the fresh FileInfo object with the most recent changes.
     * @param relativePath  The relativeLocation path from the older FileInfo
     * @return 
     */
    public FileInfo_old findRelative(String relativePath){
        for(FileInfo_old fileInfo : fileSection.files){
            if(fileInfo.getRelativeLocation().equals(relativePath)){
                return fileInfo;
            }
        }
        return null;
    }

    /**
     * Lists information according to the concluded licenses
     * @return 
     */
    public String summaryConcludedLicenses() {
        String result = "";
        int counter = 0;
        for(FileInfo_old fileInfo : fileSection.files){
            // no need to proceed when null or not asserted
            if(fileInfo.tagLicenseConcluded == null){
                continue;
            }
            if(fileInfo.tagLicenseConcluded.toString().equals("NOASSERTION")){
                continue;
            }
            counter++;
        }
        // add up the result
        result += counter + " files with concluded licenses"
                + html.br;
        
        // now get the values for provenanced files
        int counterAuthored = 0;
        int counterExternal = 0;
        
        for(FileInfo_old fileInfo : fileSection.files){
            if(fileInfo.tagFileOrigin==null){
                continue;
            }
            String value = fileInfo.tagFileOrigin.getValue();
            if(value.matches("" + FileOrigin.AUTHORED)){
                counterAuthored++;
            }
            if(value.matches("" + FileOrigin.EXTERNAL)){
                counterExternal++;
            }
        }
        
        // show the results
        if(counterAuthored > 0){
            result += counterAuthored + " files authored"
                    +html.br;
        }
         // show the results
        if(counterExternal > 0){
            result += counterExternal + " external resources"
                    +html.br;
        }
        return result;
    }
    
   
    /**
     * The objective of this method is to go throught each line on a given
     * text file and extract every possible information in regards to tag/value
     * data. The result is an arraylist of tags that contain in sequential order
     * all the tag/value entries that were found.
     */
    public void readLines(){
        System.err.println("TVC1143 - Reading SPDX: " + file.getName());
//// get the complete content of the file to a string file
//        lines1 = utils.files.readAsStringArray(file);
        
        lines1 = new ArrayList();
        // iterate through all lines
        int linePosition = 0;
          
      try {
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String temp;
            while ((temp = reader.readLine()) != null) {
                // read the tag/value information
                
             try {
                readLine(temp, linePosition);
                } catch (Exception ex) {
                     System.err.println("Error when reading line: " + linePosition
                  + " of file: " + file.getAbsolutePath());
                     continue;
                }
                
                // store the line as reference for later
//                String[] line = new String[]{temp};
//                lines1.add(line);
                // increase the line counter
                linePosition++;
            }
          
      } catch (Exception ex) {
          Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
          // this is a critical error, let's stop here to reflect
          System.err.println("Error when reading line: " + linePosition
                  + " of file: " + file.getAbsolutePath());
          System.exit(6751);
      }
//      System.err.println("TVC1178 - Finished SPDX: " + file.getName());
    }
    
    
    /**
     * When assigned with a specific line, process it
     * @param line  the text line to be processed
     * @param linePosition  At which position of the text file is this line?
     */
    public void readLine(String line, int linePosition){
        
            TagValue tag = new TagValue(this);
            
            // interpret multiple lines of text
            if(line.contains("<text>")){
                //TODO we need support to mulitple line
                return;
//                ReadMultipleLine multiple = new ReadMultipleLine();
//                multiple.getMultipleLine(lines, i);
//                i += multiple.lineCount - 1;
//                if(multiple.status != ReadMultipleLine.readStatus.OK){
//                    // if there was an error, avoid adding up this value
//                    return;
//                }
//                // add the text as a single line.
//                line = multiple.output;
//                tag.isMultiLine = true;
            }
            
            // we care about lines with tags
            if(line.contains(":")== false){
               return;
            }
            // find the initial title delimiter
            int limiter = line.indexOf(":");
            tag.linePosition = linePosition;
            // get the title name, remove empty spaces
             try{
       
            tag.title = line.substring(0, limiter).trim();
            // get the full content
            tag.raw = line + "\n";
              
             }catch (RuntimeException e){
                 System.err.println("SF11206 - Error reading tag on line: " +  linePosition);
                 System.exit(2034);
             }
            
            // get the associated value
            tag.setValue(line.substring(limiter + 2));
            // avoid the bad "created" tag that contains fake :
            if(   //TODO this could be replaced with a nice RegEx rule one day..
                    (tag.title.equalsIgnoreCase("Created")==false)
                  &&(tag.title.equalsIgnoreCase("ReviewDate")==false)
                    )
            // there are cases of sub-tags that need to be processed
            while(tag.getValue().contains(":")){
                limiter = tag.getValue().indexOf(":");
                // solve cases of people adding ":" inside the <text> tags
                if(tag.getValue().contains("<text>")){
                    int limiterEnd = tag.getValue().indexOf("<text>");
                    if(limiter > limiterEnd){
                        break;
                    }
                }
                // add the sub-tag, iterate to the next value
                String newTag = tag.getValue().substring(0, limiter).trim();
                tag.title = tag.title + "->" + newTag;
                tag.setValue(tag.getValue().substring(limiter + 2));
            }
        // all done
        tags.add(tag);
    }
    
    
}
