package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:14Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Multics.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Multics extends License{
   /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    @Override
    public Boolean approvedOSI(){
        return true; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    @Override
    public String getId(){
        return "Multics"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Multics License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Multics License\n"
        + "\n"
        + "Historical Background\n"
        + "\n"
        + "This edition of the Multics software materials and documentation is\n"
        + "provided and donated to Massachusetts Institute of Technology by Group\n"
        + "BULL including BULL HN Information Systems Inc. as a contribution to\n"
        + "computer science knowledge. This donation is made also to give evidence\n"
        + "of the common contributions of Massachusetts Institute of Technology,\n"
        + "Bell Laboratories, General Electric, Honeywell Information Systems\n"
        + "Inc., Honeywell BULL Inc., Groupe BULL and BULL HN Information Systems\n"
        + "Inc. to the development of this operating system. Multics development\n"
        + "was initiated by Massachusetts Institute of Technology Project MAC\n"
        + "(1963-1970), renamed the MIT Laboratory for Computer Science and\n"
        + "Artificial Intelligence in the mid 1970s, under the leadership of\n"
        + "Professor Fernando Jose Corbato. Users consider that Multics provided the\n"
        + "best software architecture for managing computer hardware properly and\n"
        + "for executing programs. Many subsequent operating systems incorporated\n"
        + "Multics principles. Multics was distributed in 1975 to 2000 by Group\n"
        + "Bull in Europe , and in the U.S. by Bull HN Information Systems Inc., as\n"
        + "successor in interest by change in name only to Honeywell Bull Inc. and\n"
        + "Honeywell Information Systems Inc. .\n"
        + "\n"
        + "-----------------------------------------------------------\n"
        + "\n"
        + "Permission to use, copy, modify, and distribute these programs and their\n"
        + "documentation for any purpose and without fee is hereby granted,provided\n"
        + "that the below copyright notice and historical background appear in all\n"
        + "copies and that both the copyright notice and historical background and\n"
        + "this permission notice appear in supporting documentation, and that\n"
        + "the names of MIT, HIS, BULL or BULL HN not be used in advertising or\n"
        + "publicity pertaining to distribution of the programs without specific\n"
        + "prior written permission.\n"
        + "Copyright 1972 by Massachusetts Institute of Technology and Honeywell Informatio"
        + "n\n"
        + "Systems Inc.\n"
        + "Copyright 2006 by BULL HN Information Systems Inc.\n"
        + "Copyright 2006 by Bull SAS\n"
        + "All Rights Reserved\n"
; // the license text
    }
 
    
}
