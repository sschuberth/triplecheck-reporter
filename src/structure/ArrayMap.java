/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-05-24T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ArrayMap.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A mix between ArrayList and Hashmap to improve
 * the performance. </text>
 */

package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nuno Brito, 24th of April 2014 in Darmstadt, Germany.
 * @param <K>   An object that we use as identifier
 * @param <V>   The result that we want to store
 */
public class ArrayMap<K, V> {
    
    ArrayList<K> listKey = new ArrayList();
    ArrayList<V> listValue = new ArrayList();
    
    
    /**
     * Places a given value to a given key
     * @param key 
     * @param value 
     */
    public void put(K key, V value){
        // array counter
        int counter = 0;
        // go through each key
        for(K thisItem : listKey){
            // if there is a match, replace the existing value
            if(thisItem.equals(key)){
                // place the object right here
                listValue.set(counter, value);
                // all done
                return;
            }
            // increase the counter, pass to the next
            counter++;
        }
        // no matches found, adding a new one
        listKey.add(key);
        listValue.add(value);
    }
    
    
    
    /**
     * When give a certain key, return the associated value
     * @param key   the key to find
     * @return  null if not found or the corresponding object when available
     */
    public V get(K key){
        // array counter
        int counter = 0;
         // go through each key
        for(K thisItem : listKey){
            // if there is a match, replace the existing value
            if(thisItem.equals(key)){
                // return this objet
                return listValue.get(counter);
            }
            // increase the counter, pass to the next
            counter++;
        }
        // nothing found, return null
        return null;
    }
    
    
    /**
     * Returns an array with the relevant keys
     * @return 
     */
    public ArrayList<K> keySet(){
        return listKey;
    }
    
    public Boolean containsKey(K key){
        return listKey.contains(key);
    }
    
    
    /**
     * Provides a sorted map with all the values sorted according to the
     * highest value
     * @return 
     */
    public Map<K, V> sortedMap(){
        HashMap<K, V> temp = new HashMap();
        for(int i = 0; i < listKey.size(); i++){
            temp.put(listKey.get(i), listValue.get(i));
        }
        // now do the sorting
        Map<K,V> map = ThirdParty.MiscMethods.sortByComparator(temp);
        // all done
        return map;
    }
    
    
}
