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
    final String[] keywordPreFilter = {
        "following disclaimer",
        "use in source and binary forms",
        "bsd"
    };
   
    // BSD-4-Clause-UC
    final String[] keywordsBSD4ClauseUC = {
        "name of the university",
        "university nor",
        "bsd-4-clause-uc"
    };
    
    // BSD-4-Clause
//    final String[] keywordsBSD4Clause = {
//        "name of the university",
//        "bsd-4-clause"
//    };
    
    
    
    final String bsd4ClauseSpecificUC = "4. neither the name of the university";
    
    String result = "";
    
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
                return true;
            }
        }
        return false;
    }

    /**
     * Reset all the settings to start again
     */
    void preFlight(){
        result = "BSD-3-Clause";
    }
    
    /**
     * Tries to distinguish the type of BSD license that we
     * are handling
     * @param textLowerCase 
     */
    private void detectKindOfBSD(final String textLowerCase){
        // find the BSD-4-Clause-UC license
        if(isBSD("BSD-4-Clause-UC", textLowerCase, keywordsBSD4ClauseUC)){
            // there's a trick, the Sleepy Cat contains the same contents
            if(textLowerCase.contains("the sleepycat license")){
                result = "Sleepycat";
                return;
            }
            return;
        }
//        else
//        if(
//         isBSD("BSD-4-Clause", textLowerCase, keywordsBSD4Clause);
//                ){
//        }
        
    }
    
    /**
     * Checks if a given content has the expected list of keyword identifiers
     * @param spdxId    The designation as provided by SPDX when available
     * @return          True if a match was found, otherwise return false
     */
    private Boolean isBSD(final String spdxId, final String textLowerCase,
            final String[] keywords){
        // iterate throught the keywords for this license
        for(final String keyword : keywords){
            if(textLowerCase.contains(keyword)){
                result = spdxId;
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