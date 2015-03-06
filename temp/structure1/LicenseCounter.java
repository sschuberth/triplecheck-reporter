/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-05-25T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: LicenseCounter.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Similar to LanguageCounter, this class is used for
 * keeping track of how many similar licenses are being used on a project.</text>
 */

package structure1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import license.LicenseType;

/**
 *
 * @author Nuno Brito, 25th of May 2014 in Darmstadt, Germany.
 */
public class LicenseCounter {
    
    // where we store the counters for the languages currently available
    private final int[] counters = new int[LicenseType.values().length];
    // the overall file counter
    private int overallCounter = 0;
    
    public LicenseCounter(){
    }

    
    /**
     * Returns a sorted map where the highest values are placed on top
     * @return 
     */
    public Map<LicenseType,Integer> sortedMap(){
        HashMap<LicenseType, Integer> result = new HashMap<LicenseType, Integer>();
        // populate the hashmap
        int counter = 0;
        for(LicenseType license : LicenseType.values()){
            result.put(license, counters[counter]);
            counter++;
        }
        // do the sorting
        Map<LicenseType,Integer> map = ThirdParty.MiscMethods.sortByComparator(result);
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
    
    public int get(final LicenseType item){
        return counters[item.ordinal()];
    }
    
    /**
     * Increment the counter for a given language by a given value
     * @param item
     * @param addedValue 
     */
    public void increment(final LicenseType item, final int addedValue){
        counters[item.ordinal()]+= addedValue;
        overallCounter += addedValue;
    }
    
    /**
     * Increment a given language by 1
     * @param item 
     */
    public void increment(final LicenseType item){
        counters[item.ordinal()]++;
        overallCounter++;
    }

    public int getOverallCounter() {
        return overallCounter;
    }
    
    
    public void increment(final ArrayList<LicenseType> items){
        for(LicenseType item : items){
            counters[item.ordinal()]++;
            overallCounter++;
        }
    }
    
    
}
