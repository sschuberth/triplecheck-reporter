/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: License.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> In UK English, please read "Licence" where applicable. 
 * To ease distincion and avoid confusions, "License" in the US meaning is used 
 * for all cases. This class is used as a template for defining scripts that 
 * will try to detect applicable licenses.
 * 
 * Whenever possible, we use the SPDX definition for a given license as  
 * available from
 * </text> 
 */

package script;

import java.io.File;
import java.util.Date;


/**
 *
 * @author Nuno Brito, 14th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public interface License {
    
    public File 
            thisFile = null, // pointer to this beanshell file being executed
            thisDir = null; // pointer to the beanshell directory on disk
    
    
    final String LicenseInfoInFile = "LicenseInfoInFile: ";
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    public Boolean isApplicable(String text);
    
    /**
     * Verifies if the provided file apply to the triggers that
     * are included on this license.
     * @param file Pointer the file on disk
     * @return 
     */
    public Boolean isApplicable(File file);
    
    /**
     * How this file should be identified. Use the SPDX identifier when possible
     * @return Short text identiyfing the license name
     */
    public String getShortIdentifier();
    
    /**
     * From where it is possible to download a text file with this license.
     * If not possible to download a text file, at least some web page where
     * the license terms are specified
     * @return Internet address pointing to the text file (when possible)
     */
    public String getURL();
    
    // the types of file formats that are supported on detection
    public Boolean supportsBinaries();
    public Boolean supportsTextFiles();
    
    // when was this license published
    public Date getDatePublished();
    
    public String getFullName();
    
    // a short getQuickSummary about the license
    public String getQuickSummary();
    public String getQuickSummaryLink();
    
    // what should be given as result?
    public String getResult();
    
}
