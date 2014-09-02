/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-07T22:53:02Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SummaryControl.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The class that controls the othe SPDX related summaries
 * </text> 
 */

package spdxlib.summary;

import spdxlib.SPDXfile2;


/**
 *
 * @author Nuno Brito, 7th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class SummaryControl {
        
    private SPDXfile2 spdx;
    private CompSummary components;

    
    public SummaryControl(SPDXfile2 spdx){
        this.spdx = spdx;
        components = new CompSummary(spdx);
    }
    
    /**
     * Return the summary of the components for a given SPDX
     * @return  An HTML string ready to be displayed to the end-user
     */
    public String components(){
        return components.getComponentSummary();
    }
    
    
}
