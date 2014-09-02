package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:20Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: EUDatagrid.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class EUDatagrid extends License{
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
        return "EUDatagrid"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "EU DataGrid Software License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "EU DataGrid Software License\n"
        + "\n"
        + "Copyright (c) 2001 EU DataGrid. All rights reserved.\n"
        + "\n"
        + "This software includes voluntary contributions made to the EU DataGrid. For more"
        + " information on the EU DataGrid, please see http://www.eu-datagrid.org/.\n"
        + "\n"
        + "Installation, use, reproduction, display, modification and redistribution of thi"
        + "s software, with or without modification, in source and binary forms, are permit"
        + "ted. Any exercise of rights under this license by you or your sub-licensees is s"
        + "ubject to the following conditions:\n"
        + "\n"
        + "1. Redistributions of this software, with or without modification, must reproduc"
        + "e the above copyright notice and the above license statement as well as this lis"
        + "t of conditions, in the software, the user documentation and any other materials"
        + " provided with the software.\n"
        + "\n"
        + "2. The user documentation, if any, included with a redistribution, must include "
        + "the following notice:\n"
        + "\"This product includes software developed by the EU DataGrid (http://www.eu-data"
        + "grid.org/).\"\n"
        + "\n"
        + "Alternatively, if that is where third-party acknowledgments normally appear, thi"
        + "s acknowledgment must be reproduced in the software itself.\n"
        + "\n"
        + "3. The names \"EDG\", \"EDG Toolkit\", “EU DataGrid” and \"EU DataGrid Project\" may n"
        + "ot be used to endorse or promote software, or products derived therefrom, except"
        + " with prior written permission by hep-project-grid-edg-license@cern.ch.\n"
        + "\n"
        + "4. You are under no obligation to provide anyone with any bug fixes, patches, up"
        + "grades or other modifications, enhancements or derivatives of the features,funct"
        + "ionality or performance of this software that you may develop. However, if you p"
        + "ublish or distribute your modifications, enhancements or derivative works withou"
        + "t contemporaneously requiring users to enter into a separate written license agr"
        + "eement, then you are deemed to have granted participants in the EU DataGrid a wo"
        + "rldwide, non-exclusive, royalty-free, perpetual license to install, use, reprodu"
        + "ce, display, modify, redistribute and sub-license your modifications, enhancemen"
        + "ts or derivative works, whether in binary or source code form, under the license"
        + " conditions stated in this list of conditions.\n"
        + "\n"
        + "5. DISCLAIMER \n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE EU DATAGRID AND CONTRIBUTORS \"AS IS\" AND ANY EX"
        + "PRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTI"
        + "ES OF MERCHANTABILITY, OF SATISFACTORY QUALITY, AND FITNESS FOR A PARTICULAR PUR"
        + "POSE OR USE ARE DISCLAIMED. THE EU DATAGRID AND CONTRIBUTORS MAKE NO REPRESENTAT"
        + "ION THAT THE SOFTWARE, MODIFICATIONS, ENHANCEMENTS OR DERIVATIVE WORKS THEREOF, "
        + "WILL NOT INFRINGE ANY PATENT, COPYRIGHT, TRADE SECRET OR OTHER PROPRIETARY RIGHT"
        + ". \n"
        + "\n"
        + "6. LIMITATION OF LIABILITY\n"
        + "\n"
        + "THE EU DATAGRID AND CONTRIBUTORS SHALL HAVE NO LIABILITY TO LICENSEE OR OTHER PE"
        + "RSONS FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, CONSEQUENTIAL, EXEMPLARY, OR PU"
        + "NITIVE DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, PROCUREMENT OF SU"
        + "BSTITUTE GOODS OR SERVICES, LOSS OF USE, DATA OR PROFITS, OR BUSINESS INTERRUPTI"
        + "ON, HOWEVER CAUSED AND ON ANY THEORY OF CONTRACT, WARRANTY, TORT (INCLUDING NEGL"
        + "IGENCE), PRODUCT LIABILITY OR OTHERWISE, ARISING IN ANY WAY OUT OF THE USE OF TH"
        + "IS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. \n"
; // the license text
    }
 
    
}
