
import definitions.TriggerType;
import java.io.File;
import java.util.Date;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
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
public class CopyrightAdblockPlus implements Trigger {
    
    String copyrightText = "Copyright (C) Eyeo GmbH";
    
    String[] list = {
            "Copyright (C) 2006-2013 Eyeo GmbH",    
            "This file is part of Adblock Plus"
    };
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
        // iterate all our ids
        for(String id : list){
            if(text.contains(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isApplicable(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getShortIdentifier() {
        return "ABP";
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
    public TriggerType getType(){
        return TriggerType.COPYRIGHT;
    }

    

    @Override
    public String getFullName() {
        return copyrightText;
    }

    @Override
    public String getResult() {
        return "FileCopyrightText: <text>"
                + copyrightText
                + "</text>";
    }

  
}