package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:30:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Unlicense.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Unlicense extends License{
   /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    @Override
    public Boolean approvedOSI(){
        return false; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    @Override
    public String getId(){
        return "Unlicense"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "The Unlicense"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "This is free and unencumbered software released into the public domain.\n"
        + "\n"
        + "Anyone is free to copy, modify, publish, use, compile, sell, or\n"
        + "distribute this software, either in source code form or as a compiled\n"
        + "binary, for any purpose, commercial or non-commercial, and by any\n"
        + "means.\n"
        + "\n"
        + "In jurisdictions that recognize copyright laws, the author or authors\n"
        + "of this software dedicate any and all copyright interest in the\n"
        + "software to the public domain. We make this dedication for the benefit\n"
        + "of the public at large and to the detriment of our heirs and\n"
        + "successors. We intend this dedication to be an overt act of\n"
        + "relinquishment in perpetuity of all present and future rights to this\n"
        + "software under copyright law.\n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n"
        + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n"
        + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.\n"
        + "IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR\n"
        + "OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,\n"
        + "ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR\n"
        + "OTHER DEALINGS IN THE SOFTWARE.\n"
        + "\n"
        + "For more information, please refer to <http://unlicense.org/>\n"
; // the license text
    }
 
    
}
