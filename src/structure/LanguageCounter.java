/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-05-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LanguageCounter.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class was born out of the need to count the number
 * of files using a specific language. In the past, the code implementation
 * solved the problem but the performance was not satisfactory. This class
 * aims to enhance the speed required to do this math.</text>
 */

package structure;

import java.util.HashMap;
import java.util.Map;
import spdxlib.FileLanguage;

/**
 *
 * @author Nuno Brito, 25th of May 2014 in Darmstadt, Germany.
 */
public class LanguageCounter {
    
    // where we store the counters for the languages currently available
    private final int[] counters = new int[FileLanguage.values().length];
    // the overall file counter
    private int overallCounter = 0;
    
    public LanguageCounter(){
    }

    
    /**
     * Returns a sorted map where the highest values are placed on top
     * @return 
     */
    public Map<FileLanguage,Integer> sortedMap(){
        HashMap<FileLanguage, Integer> result = new HashMap<FileLanguage, Integer>();
        // populate the hashmap
        int counter = 0;
        for(FileLanguage language : FileLanguage.values()){
            result.put(language, counters[counter]);
            counter++;
        }
        // do the sorting
        Map<FileLanguage,Integer> map = ThirdParty.MiscMethods.sortByComparator(result);
        return map;
    }
    
    /**
     * Returns the value for a given language
     * @param index
     * @return 
     */
    public int get(final int index){
        return counters[index];
    }
    
    public int get(final FileLanguage language){
        return counters[language.ordinal()];
    }
    
    /**
     * Increment the counter for a given language by a given value
     * @param language
     * @param addedValue 
     */
    public void increment(final FileLanguage language, final int addedValue){
        counters[language.ordinal()]+= addedValue;
        overallCounter += addedValue;
    }
    
    /**
     * Increment a given language by 1
     * @param language 
     */
    public void increment(final FileLanguage language){
        counters[language.ordinal()]++;
        overallCounter++;
    }

    public int getOverallCounter() {
        return overallCounter;
    }
    
    
    
}
