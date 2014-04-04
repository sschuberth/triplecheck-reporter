  /*
   * SPDXVersion: SPDX-1.1
   * Person: Person: Nuno Brito (nuno.brito@triplecheck.de)
   * Person: Organization: TripleCheck (contact@triplecheck.de)
   * Date: 2013-08-29T00:00:00Z
   * LicenseName: NOASSERTION
   * FileName: SPDXfile.java  
   * FileType: SOURCE
   * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
   * FileComment: <text> Object that contains an SPDX report. This class 
   * contains the basic functions to read an SPDX file from disk, to perform 
   * the basic operations such as adding/changing/finding data and then 
   * saving this information back to a file on disk. </text> 
   */

package spdxlib;

import definitions.Process;
import definitions.is;
import java.io.File;
import java.text.DecimalFormat;
import java.util.*;
import script.FileExtension;
import script.log;
import utils.files;

public final class SPDXfile {
    
    
    // The variables listed here follow the same order as
    // listed on the SPDX 1.1 specification
   
   public SectionCreator
           creatorSection = new SectionCreator();
    
   public SectionPackage
           packageSection = new SectionPackage();
    
   ArrayList<TagLicense> // list of licenses applicable to this SPDX  
           licenses = new ArrayList();          
   
   public SectionFiles // where we report all found fileSection of the package
           fileSection = new SectionFiles();
   
   Person
           reviewer;
   TagValue
           reviewDate,
           reviewComment;
   
   
   // basic objects to support the SPDX processing
   public File
           file; // direct file pointer to this file

   public TagValueCollection 
           data = new TagValueCollection(); // where all data tags are placed
   
   public String 
            rawText; // text for the SPDX file
   
   String[] 
           lines; // where we keep all the lines that were separated
   
   
   // have statistics been already calculated for this document?
   private boolean hasStats = false;
   // if there is a file, what is the checksum?
   private String checksum = "";
   // how many licenses are present in this document?
   private int statsLicensesDeclared = 0;
   // are redundant files present on the document?
   private boolean statsHasSVN = false;
   
   private HashMap<FileLanguage, Integer> statsLanguagesFound = new HashMap();
   private int statsLanguagesTotal = 0;
   
   /**
    * Constructor where we initialize this object by serving an SPDX text
    * file as source of knowledge to fill up the contents
    * @param file 
    */
   public SPDXfile(File file){
       // assign the file pointer
       this.file = file;
       // do the normal reading
       read(file);
       // now pre-process the stats
       doStats();
   }

//    public SPDXfile(File file, String text) {
//        // assign the file pointer
//       this.file = file;
//       rawText = text;
//       // do the normal reading
//       read(text);
//    }
   
    
    
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
         
        // get the file pointer for future reference
        data.tagFile = file;
        // get the complete content of the file to a string file
        rawText = utils.files.readAsString(file);
        lines = rawText.split("\n");
        // read all available data from the given file
        data.read(lines);
        // process all this information into meaningful data
        processData();
    }
    
   /**
    * Refreshes the data on this SPDX object with information directly
    * provided from a text string
    * @param text Content to be processed by the SPDX parser
    */
//     public void read(String text){
//          // read all available data from the given file
//        data.read(text);
//        // process all this information into meaningful data
//        processData();
//     }
     
     
     
   /**
    * Based on the information available on the "data" object, the SPDX
    * document object will be filled with this information. 
     * @param file SPDX text file with the data to be interpreted
    */
   private void processData(){
      // reading is done in sequential mode, not very fast but it is robust 
      creatorSection.SPDXVersion = readGeneric(Keyword.SPDXVersion);
      creatorSection.dataLicense = readGeneric(Keyword.DataLicense);
      creatorSection.documentComment = readGeneric(Keyword.DocumentComment);
      // read people information
      parseSections();
      creatorSection.created = readGeneric(Keyword.Created);
      creatorSection.creatorComment = readGeneric(Keyword.CreatorComment);
      
   }
   
   /**
    * Generic way of finding specific entries on the SPDX document, this
    * only works for unique key titles.
    */
    TagValue readGeneric(final Keyword keyword){
       for(TagValue tag : data.tags){
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
////                "Data license = " + dataLicense + "\n" +
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
    void parseSections(){
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
        
        // go through all tag/value entries
        for(int i = 0; i < data.tags.size(); i++){
            // get the current tag
            TagValue tag = data.tags.get(i);
            // do the markers check. No need to repeat them if already flagged
            processing = whichSectionShouldBeProcess(tag, processing);
            
//            TagValue abc = data.tags.get(i); 
//            if(i==xxx){
//                System.out.println();
//            }
            
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
     * Parse information regarding other licenses
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
     * Goes the array of licenses and gets the most recent one.
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
        // if we have a license defined for this SPDX file, show it publicly
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
    public void addComponent(SPDXfile component){
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
        lines[tag.linePosition] = newText;
        return tag;
    }
    
    /**
     * After we are finished making changes, we can save the text file
     */
    public void commitChanges(){
        // save everything to disk
        String modifiedText = "";
        for(String line : lines){
            modifiedText += line + "\n";
        }
        rawText = modifiedText;
        // write file on disk
        files.SaveStringToFile(file, rawText);
    }

    /**
     * Whenever a given tag does not exist, there are cases when we need to add
     * one. This method permits to add a tag right after one that already exists 
     * @param linePosition The tag used as anchor
     * @param text the text to be included
     */
    public void addTag(int linePosition, String text) {
        lines[linePosition] += "\n" + text;
    }

    /**
     * How many licenses were declared inside this document?
     * @return number of licenses declared
     */
    public int getStatsLicensesDeclared() {
        return statsLicensesDeclared;
    }

    
    public boolean hasSVN() {
        return statsHasSVN;
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
        statsLicensesDeclared = 0;
        statsHasSVN = false;
        
        // A single big loop to get all our stats computed
        for(FileInfo fileInfo : fileSection.files){
            // count the number of declared licenses (not the concluded lic.)
            statsLicensesDeclared += fileInfo.countLicensesDeclared();
            // process the most popular language types on this project
            FileExtension extension = fileInfo.getExtension();
            // only proceed when there is a valid extension
            if(extension != null){
                // to which programming language is this file related?
                FileLanguage language = extension.getLanguage();
                // get the right index, increase the counter
                if(statsLanguagesFound.containsKey(language)){
                    int count = statsLanguagesFound.get(language);
                    count++;
                    statsLanguagesFound.put(language, count);
                }else{
                    // first time, add it up
                    statsLanguagesFound.put(language, 1);
                }
                // shall we count this as something we know? Avoid unsorted keys
                if(language != FileLanguage.UNSORTED){
                    // increase the counter
                    statsLanguagesTotal++;
                }
                
            }
        }
        
          
        // are SVN files present on this document?
        ArrayList<FileInfo> list = fileSection.files;
        for(FileInfo fileInfo : list){
            if(fileInfo.tagFileName.toString().contains(".svn")){
                statsHasSVN = true;
                break;
            }
        }
        
        debugStats();
        
        // all done
        hasStats = true;
    }

    /**
     * Give some indication of what is going on.
     */
    private void debugStats() {
        if(statsLanguagesFound.isEmpty()){
            System.err.println("SF650 - No languages were found?");
            return;
        }
        
        System.out.println("\nFile: " + file.getName() 
                + " (" +statsLanguagesTotal+ " known files)");
        // create a sorted array with the most popular languages
        Map<Object,Integer> map = sortHashMap(statsLanguagesFound);

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
                    + getPercentage(count, statsLanguagesTotal) + "%"
                    + ")");
        }
        
        
        
    }
    
 
    /**
     * Calculate a precise percentage on the value
     * @param value the value from which we want a percentage assigned
     * @param max the max value that represents 100%
     * @return a string representing the percentual value
     */
    private String getPercentage(int value, int max){
        double dMax = max;
        double dValue = value;
        double per = (dValue*100)/ dMax;
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(per);
    }
    
    
    /**
     * Sort an hashmap according to its value.
     * @origin http://wikijava.org/wiki/Sort_a_HashMap
     * @date 2011-05-28
     * @modified http://nunobrito.eu
     * @date 2014-04-04
     */
    private Map sortHashMap(HashMap input){
        Map<Object,Integer> map = new LinkedHashMap<Object,Integer>();
        List<Object> yourMapKeys = new ArrayList<Object>(input.keySet());
        List<Integer> yourMapValues = new ArrayList<Integer>(input.values());
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(yourMapValues);
        Object[] sortedArray = sortedSet.toArray();
        int size = sortedArray.length;
        for (int i=size-1; i>-1; i--) {
        map.put
            (yourMapKeys.get(yourMapValues.indexOf(sortedArray[i])),
            (Integer) sortedArray[i]);
        }
    return map;
}
    
}
