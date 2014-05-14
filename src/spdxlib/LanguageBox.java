/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-05T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LanguageBox.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package spdxlib;

import java.util.ArrayList;


/**
 *
 * @author Nuno Brito, 5th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class LanguageBox implements Comparable<Integer>{

    // what kind of language are we targetting?
    private FileLanguage language;
    // how many files of this kind have we found so far?
    private int count = 0;
    // which files were found?
    private ArrayList<FileInfo2> list = new ArrayList();
    
    
    public LanguageBox(FileLanguage target){
        language = target;
    }

    /**
     * How many items were indexed so far?
     */
    public int getCount() {
        return count;
    }

    /**
     * What is the target language being focused?
     * @return 
     */
    public FileLanguage getLanguage() {
        return language;
    }
    

    /**
     * Add up a new file to our list, increase the counter
     * @param newFile   A fileInfo object
     */
    public void add(FileInfo2 newFile){
        list.add(newFile);
        count++;
    }
    
    


    @Override
    public int compareTo(Integer o) {
    if(this.count == o)
        return 0;
    else if (this.count < o)
        return 1;
    else 
        return -1;
    }
    
}
