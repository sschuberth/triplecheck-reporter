
import definitions.TriggerType;
import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: CopyrightDetector.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A generic trigger to detect copyright text.</text> 
 */


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class CopyrightDetector implements Trigger {
    
    String copyrightText = "";
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
       
               // the mega-super expression to catch copyright statements
     String patternString = ""
             + "(\\((C|c)\\) |)"    // detect a (c) before the copyright text
             + "(C|c)opyright"      // detect the copyright text
             + "( \\((C|c)\\)|) "   // sometimes with a (c)
             + "([0-9]|)"           // optionally with the year
             + "+"             
             + "[^\\n\\t\\*]+\\.?";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        String copyright = "";
        //int count = 0;
        while(matcher.find()) {
            //count++;
            copyright = text.substring(matcher.start(), matcher.end())
                    +"\n";
//            System.out.println("found: " + count + " : "
//                    + text.substring(matcher.start(), matcher.end())
//
//                    //+ matcher.start() + " - " + matcher.end()
//                    );
        }
        
        copyrightText = copyright;
        // do a debug result
        System.out.println(copyright
                + "\n------------");
        
        return copyrightText.isEmpty();
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