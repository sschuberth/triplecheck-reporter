package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:07Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: MS_RL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class MS_RL extends License{
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
        return "MS-RL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Microsoft Reciprocal License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Microsoft Reciprocal License (Ms-RL)\n"
        + " \n"
        + "This license governs use of the accompanying software. If you use the software, "
        + "you accept this license. If you do not accept the license, do not use the softwa"
        + "re.\n"
        + "\n"
        + "1.  Definitions\n"
        + "The terms \"reproduce,\" \"reproduction,\" \"derivative works,\" and \"distribution\" ha"
        + "ve the same meaning here as under U.S. copyright law.\n"
        + "A \"contribution\" is the original software, or any additions or changes to the so"
        + "ftware. \n"
        + "A \"contributor\" is any person that distributes its contribution under this licen"
        + "se. \n"
        + "\"Licensed patents\" are a contributor's patent claims that read directly on its c"
        + "ontribution.\n"
        + "\n"
        + "2.  Grant of Rights\n"
        + "(A) Copyright Grant- Subject to the terms of this license, including the license"
        + " conditions and limitations in section 3, each contributor grants you a non-excl"
        + "usive, worldwide, royalty-free copyright license to reproduce its contribution, "
        + "prepare derivative works of its contribution, and distribute its contribution or"
        + " any derivative works that you create.\n"
        + "(B) Patent Grant- Subject to the terms of this license, including the license co"
        + "nditions and limitations in section 3, each contributor grants you a non-exclusi"
        + "ve, worldwide, royalty-free license under its licensed patents to make, have mad"
        + "e, use, sell, offer for sale, import, and/or otherwise dispose of its contributi"
        + "on in the software or derivative works of the contribution in the software.\n"
        + "\n"
        + "3.  Conditions and Limitations\n"
        + "(A) Reciprocal Grants- For any file you distribute that contains code from the s"
        + "oftware (in source code or binary format), you must provide recipients the sourc"
        + "e code to that file along with a copy of this license, which license will govern"
        + " that file. You may license other files that are entirely your own work and do n"
        + "ot contain code from the software under any terms you choose. \n"
        + "(B) No Trademark License- This license does not grant you rights to use any cont"
        + "ributors' name, logo, or trademarks. \n"
        + "(C) If you bring a patent claim against any contributor over patents that you cl"
        + "aim are infringed by the software, your patent license from such contributor to "
        + "the software ends automatically. \n"
        + "(D) If you distribute any portion of the software, you must retain all copyright"
        + ", patent, trademark, and attribution notices that are present in the software. \n"
        + "(E) If you distribute any portion of the software in source code form, you may d"
        + "o so only under this license by including a complete copy of this license with y"
        + "our distribution. If you distribute any portion of the software in compiled or o"
        + "bject code form, you may only do so under a license that complies with this lice"
        + "nse. \n"
        + "(F) The software is licensed \"as-is.\" You bear the risk of using it. The contrib"
        + "utors give no express warranties, guarantees, or conditions. You may have additi"
        + "onal consumer rights under your local laws which this license cannot change. To "
        + "the extent permitted under your local laws, the contributors exclude the implied"
        + " warranties of merchantability, fitness for a particular purpose and non-infring"
        + "ement.\n"
; // the license text
    }
 
    
}
