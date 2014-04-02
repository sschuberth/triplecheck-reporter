
import java.io.File;
import java.util.Date;
import script.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: CopyrightAdBlockPlus.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to know if the file belongs to a specific copyright.
 * </text> 
 */


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class CopyrightAdblockPlus implements License {
    
    String copyrightText = "Copyright (C) 2006-2013 Eyeo GmbH";
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
//        if(text.contains(copyrightText))
//            System.err.println("Bingo!");
        return text.contains(copyrightText);
    }

    @Override
    public Boolean isApplicable(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getShortIdentifier() {
        return "ABP-2013";
    }

    @Override
    public String getURL() {
        return "https://adblockplus.org";
    }

    @Override
    public Boolean supportsBinaries() {
        return false;
    }

    @Override
    public Boolean supportsTextFiles() {
        return true;
    }

   
    @Override
    public Date getDatePublished() {
        return utils.time.getDate(2006, 01, 01);
    }

    @Override
    public String getQuickSummary() {
        return  "";
    }
    
    @Override
    public String getQuickSummaryLink() {
        return "";
    }
    

    @Override
    public String getFullName() {
        return copyrightText;
    }

    @Override
    public String getResult() {
        return "FileCopyrightText: <text> "
                + copyrightText
                + "</text>";
    }

}