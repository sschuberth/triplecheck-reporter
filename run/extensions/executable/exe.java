package executable;

import java.io.File;
import script.FileExtension;
import spdxlib.ContentType;
import spdxlib.FileCategory;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-15-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: exe.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines how a file with a given extension should
 * look alike. This is mostly useful to know in our context:
 * - is this a plain text or binary file?
 * - is there any information that we can extract from this file?
 * </text> 
 */


/**
 *
 * @author Nuno Brito, 15th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class exe extends FileExtension{
    
    @Override
    public Boolean isApplicable(File binaryFile) {
        return true;
    }

    @Override
    public Boolean isApplicable(String textFile) {
        return true;
    }

    @Override
    public String getDescription() {
        return "Windows Executable";
    }

    @Override
    public String getIdentifierShort() {
        return "exe";
    }

    @Override
    public ContentType getContentType() {
        return ContentType.BINARY;
    }

    @Override
    public FileCategory getCategory() {
        return FileCategory.EXECUTABLE;
    }

   
    
    
}
