/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ExtensionType.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A class used as template for the Json text that replaces
    the former processing with Beanshell scripts</text> 
 */

package structure;

import java.util.ArrayList;
import spdxlib.ContentType;
import spdxlib.FileCategory;
import spdxlib.FileLanguage;

/**
 *
 * @author Nuno Brito, 25th of May 2014 in Darmstadt, Germany.
 */
public class ExtensionType {
    public String 
            idShort,
            idLong,
            description;
    
    public ContentType contentType;
    public FileCategory category;
    public FileLanguage language;
    public ArrayList<FileLanguage> languages;
}
