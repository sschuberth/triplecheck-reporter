package licenses;


import definitions.TriggerType;
import java.io.File;
import script.Trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-06T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: BSD3ClauseClear.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under a specific 
 *  license and which version is applicable when possible.</text> 
 * 
 * In some (not so frequent cases), there exists more than a single BSD license
 * declared inside a text portion. For example, when compiling all the licenses
 * inside a single document. At this point we are indexing them separately, if
 * there is demand this will be implemented and tested in the future.
 * 
 * For the most cases, our intention is to simply highlight that a BSD license 
 * was detected. Only on a post processing phase we run the appropriate tooling
 * to uncover the number of possible licenses inside a single file.
 * 
 * Exception is the SleepyCat license which includes the BSD-4-Clause license
 */


/**
 *
 * @author Nuno Brito, 6th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class BSD implements Trigger {
    
    // the keywordPreFilter of id's that we can use to identify a license
    final String[] keywordPreFilter = {     // text snippets common to BSD
        "following disclaimer",             
        "use in source and binary forms",
        "bsd"
    };
   
    // BSD-4-Clause
    final String[] keywordsBSD4Clause = {
        "all advertising",      // the advertisement clause
        "bsd-4-clause"
    };
    
    // BSD-4-Clause specific to the University of Berkley
    final String[] keywordsBSD4ClauseUC = {
        "name of the university", // unique identification
        "university nor",         // accommodate when text is broken
        "bsd-4-clause-uc"
    };
    
    // BSD-3-Clause-Clear
    final String[] keywordsBSD3ClauseClear = {
        "no express or", // the last paragraph is unique to this license
        "bsd-3-clause-clear"
    };
    
    // BSD-3-Clause-Clear
    final String[] keywordsBSD3Clause = {
        // this text is common to bigger BSD, but they were filtered before
        "names of its contributors",
        "specific prior written permission",
        "bsd-3-clause"
    };
    
     // BSD-3-Clause-Clear
    final String[] keywordsFreeBSD = {
        "freebsd project",
        "bsd-2-clause-freebsd"
    };
     // BSD-3-Clause-Clear
    final String[] keywordsNetBSD = {
        "netbsd foundation",
        "bsd-2-clause-netbsd"
    };
    
    
    
    // non determined type of BSD, we just know it is a BSD-like license
    final String[] 
            keywordsBSD= {
                "bsd"
                    },
            // we use this list to reduce false positives on random BSD search
            // in other words, reduce chances of false needles in the haystack
            keywordsWhiteListed = {
                "under bsd ",
                "bsd-license",
                "bsd license",
                "bsd-like",
                "bsd licence"
                    },
            keywordsBlackListed = {
                "change the bsd license"
            };
    
    
    
    
    final String bsd4ClauseSpecificUC = "4. neither the name of the university";
    
    String result = null;
    
    LicenseBSD 
            bsd2Clause = new LicenseBSD("BSD-2-Clause"),
            bsd2ClauseFreeBSD = new LicenseBSD("BSD-2-Clause-FreeBSD"),
            bsd2ClauseNetBSD = new LicenseBSD("BSD-2-Clause-NetBSD"),
            bsd3Clause = new LicenseBSD("BSD-3-Clause"),
            bsd3ClauseClear = new LicenseBSD("BSD-3-Clause-Clear"),
            bsd4Clause = new LicenseBSD("BSD-4-Clause"),
            bsd4ClauseUC = new LicenseBSD("BSD-4-Clause-UC");
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(final String text, final String textLowerCase){
        preFlight();
        // iterate all our ids
        for(String keyword : keywordPreFilter){
            if(textLowerCase.contains(keyword)){
                detectKindOfBSD(textLowerCase);
                return result != null;
            }
        }
        return false;
    }

    /**
     * Reset all the settings to start again
     */
    void preFlight(){
        result = null;
    }
    
    /**
     * Tries to distinguish the type of BSD license that we
     * are handling
     * @param textLowerCase 
     */
    private void detectKindOfBSD(final String textLowerCase){
        // is this a BSD-4-Clause type of license?
        if(isBSD(textLowerCase, keywordsBSD4Clause)){
            // there's a trick, the Sleepy Cat contains the same contents
//            if(textLowerCase.contains("the sleepycat license")){
//                result = "Sleepycat";
//                return;
//            }
            
            // is it the original berkley license?
            if(isBSD(textLowerCase, keywordsBSD4ClauseUC)){
                result = "BSD-4-Clause-UC";
            }else{
                // seems like this is the old, but generic version
                result = "BSD-4-Clause";
            }
        }
        else
        if(isBSD(textLowerCase, keywordsBSD3ClauseClear)){
            result = "BSD-3-Clause-Clear";
        }
        else
        if(isBSD(textLowerCase, keywordsBSD3Clause)){
            result = "BSD-3-Clause";
        }
        else
        if(isBSD(textLowerCase, keywordsFreeBSD)){
            result = "BSD-2-Clause-FreeBSD";
        }
        else
        if(isBSD(textLowerCase, keywordsNetBSD)){
            result = "BSD-2-Clause-NetBSD";
        }
        else
        if(isBSD(textLowerCase, keywordsBSD)){
            // is this a declared BSD license with at least 2 clauses?
            if((textLowerCase.contains("redistributions of source")
              &&(textLowerCase.contains("redistributions in binary"))
                    || textLowerCase.contains("BSD-2-Clause"))
                    ){
                result = "BSD-2-Clause";
                return;
            }
                
        // in some remote case, this might be an ISC license
           if(textLowerCase.contains("copyright notice and this permission notice appear in all copies.")){
               result = "ISC";
               return;
           } 
             
           // first check the permitted list of keywords
           if(isBSD(textLowerCase, keywordsWhiteListed)){
               // we got a match, but was it blacklisted before?
               if(isBSD(textLowerCase, keywordsBlackListed)){
                   // no point in continuing
                   result = null;
                   return;
               }
               
               // someone is declaring BSD but we lack further detail
               result = "BSD";
               return;
           }
        
           // no conclusive results, better safe than sorry. Don't mention BSD
           result = null;
            
        }
        
    }
    
    /**
     * Checks if a given content has the expected list of keyword identifiers
     * @param spdxId    The designation as provided by SPDX when available
     * @return          True if a match was found, otherwise return false
     */
    private Boolean isBSD(final String textLowerCase,
            final String[] keywords){
        // iterate throught the keywords for this license
        for(final String keyword : keywords){
            if(textLowerCase.contains(keyword)){
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public Boolean isApplicable(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getShortIdentifier() {
        return result;
    }

    @Override
    public Boolean supportsBinaries() {
        return false;
    }

    @Override
    public Boolean supportsTextFiles() {
        return true;
    }
 
    @Override
    public TriggerType getType(){
        return TriggerType.LICENSE;
    }

    @Override
    public String getFullName() {
        return "BSD";
    }

    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }
    
    @Override
    public String getTriggerTitle() {
        return "BSD";
    }
    
}


/**
 * Identify the BSD license
 * @author nuno
 */
class LicenseBSD{
    final String id;
    String keyword;
    
    // public constructor
    public LicenseBSD(final String thisId){
        id = thisId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
    
}