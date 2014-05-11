/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-01T00:00:00Z
 *
 * LicenseName: EUPL-1.1-without-appendix
 *
 * FileName: SectionCreator.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> Keeps all objects regarding the header of SPDX
 *  documents </text> 
 */

package spdxlib;

import java.io.Serializable;
import java.util.ArrayList;


public class SectionCreator implements Serializable{

   public TagValue
           SPDXVersion, // specification version that was used, mandatory, one
           dataLicense, // license applicable to SPDX report, mandatory, one
           documentComment; // comments for readers of SPDX doc, optional, one
            
   public ArrayList<Person> // who created the SPDX file, mandatory, one or many  
           people = new ArrayList();          
    
   public TagValue 
           created, // when was the report created? mandatory, one 
           creatorComment; // global comment from all people, optional, one
   
   
    @Override
    public String toString(){
        String title = "SPDX creators"; 
        //if(people.size()>1){
            title = title.concat(" ("
                    + people.size() + ")");
        //}
       return title;
    }
   
}
