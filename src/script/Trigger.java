/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Trigger.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> In UK English, please read "Licence" where applicable. 
 * To ease distincion and avoid confusions, "Trigger" in the US meaning is used 
 * for all cases. This class is used as a template for defining scripts that 
 * will try to detect applicable licenses.
 * 
 * Whenever possible, we use the SPDX definition for a given license as  
 * available from
 * </text> 
 */

package script;

import definitions.TriggerType;
import java.io.File;


/**
 *
 * @author Nuno Brito, 14th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public interface Trigger {
    
    public File 
            thisFile = null, // pointer to this beanshell file being executed
            thisDir = null; // pointer to the beanshell directory on disk
    
    
    // used only by License triggers
    final String LicenseInfoInFile = "LicenseInfoInFile: ";
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @param textLowerCase same text but fully in lowercase
     * @return 
     */
    public Boolean isApplicable(final String text, final String textLowerCase);
    
    /**
     * Verifies if the provided file apply to the triggers that
     * are included on this license.
     * @param file Pointer the file on disk
     * @return 
     */
    public Boolean isApplicable(File file);
    
    /**
     * How this file should be identified. Use the SPDX identifier when possible
     * @return Short text identifying the license name
     */
    public String getShortIdentifier();
    
    /**
     * What kind of trigger is this one? Copyright? License? Something else?
     * @return 
     */
    public TriggerType getType();
    
    // the types of file formats that are supported on detection
    public Boolean supportsBinaries();
    public Boolean supportsTextFiles();
    
    // when was this license published
    //public Date getDatePublished();
    
    public String getFullName();
    
    // what should be given as result?
    public String getResult();
    
    public String getTriggerTitle();
    
}
