/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-09T11:09:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TriggerType.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the possible types of Triggers that we are 
 * using. For example, one trigger might be used to detect copyright notices,
 * while another trigger might be used for detecting licenses.</text> 
 */
package definitions;

/**
 *
 * @author Nuno Brito, 9th of April 2014 in Darmstadt, Germany.
 */
public enum TriggerType {
    IMPORT,         // general imports (Java, C, C++, ..) that are dependencies
    COPYRIGHT,      // cases where a copyright was detected
    LICENSE,        // triggers specific to licensing terms
    AUTO_GENERATED, // marks a file that was auto-generated (no IPR claims)
    UNKNOWN;        // trigger type is unknown (default value)
    
    
    public boolean toTitle(){
        switch(this){
            default: return true;
        }
    }

}
