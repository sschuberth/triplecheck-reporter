/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-04T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: misc.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Misc. methods </text> 
 */

package utils;

import java.text.DecimalFormat;
import java.util.*;


/**
 *
 * @author Nuno Brito, 4th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class misc {

     /**
     * Calculate a precise percentage on the value
     * @param value the value from which we want a percentage assigned
     * @param max the max value that represents 100%
     * @return a string representing the percentual value
     */
    public static String getPercentage(int value, int max){
        double dMax = max;
        double dValue = value;
        double per = (dValue*100)/ dMax;
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(per);
    }
    
    
    /**
     * Sort an hashmap according to its value.
     * @origin http://wikijava.org/wiki/Sort_a_HashMap
     * @date 2011-05-28
     * @modified http://nunobrito.eu
     * @date 2014-04-04
     */
    public static Map sortHashMap(HashMap input){
        Map<Object,Integer> map = new LinkedHashMap<Object,Integer>();
        List<Object> yourMapKeys = new ArrayList<Object>(input.keySet());
        List<Integer> yourMapValues = new ArrayList<Integer>(input.values());
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(yourMapValues);
        Object[] sortedArray = sortedSet.toArray();
        int size = sortedArray.length - 1;
        for (int i=size; i>=0; i--) {
        map.put
            (yourMapKeys.get(yourMapValues.indexOf(sortedArray[i])),
            (Integer) sortedArray[i]);
        }
    return map;
}
    
}
