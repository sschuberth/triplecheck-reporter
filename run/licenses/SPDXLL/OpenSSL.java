package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:36Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OpenSSL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OpenSSL extends License{
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
        return "OpenSSL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "OpenSSL License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "OpenSSL License\n"
        + "\n"
        + " ====================================================================\n"
        + "  Copyright (c) 1998-2008 The OpenSSL Project.  All rights reserved.\n"
        + " \n"
        + "  Redistribution and use in source and binary forms, with or without\n"
        + "  modification, are permitted provided that the following conditions\n"
        + "  are met:\n"
        + " \n"
        + "  1. Redistributions of source code must retain the above copyright\n"
        + "     notice, this list of conditions and the following disclaimer.\n"
        + " \n"
        + "  2. Redistributions in binary form must reproduce the above copyright\n"
        + "     notice, this list of conditions and the following disclaimer in\n"
        + "     the documentation and/or other materials provided with the\n"
        + "     distribution.\n"
        + " \n"
        + "  3. All advertising materials mentioning features or use of this\n"
        + "     software must display the following acknowledgment:\n"
        + "     \"This product includes software developed by the OpenSSL Project\n"
        + "     for use in the OpenSSL Toolkit. (http://www.openssl.org/)\"\n"
        + " \n"
        + "  4. The names \"OpenSSL Toolkit\" and \"OpenSSL Project\" must not be used to\n"
        + "     endorse or promote products derived from this software without\n"
        + "     prior written permission. For written permission, please contact\n"
        + "     openssl-core@openssl.org.\n"
        + " \n"
        + "  5. Products derived from this software may not be called \"OpenSSL\"\n"
        + "     nor may \"OpenSSL\" appear in their names without prior written\n"
        + "     permission of the OpenSSL Project.\n"
        + " \n"
        + "  6. Redistributions of any form whatsoever must retain the following\n"
        + "     acknowledgment:\n"
        + "     \"This product includes software developed by the OpenSSL Project\n"
        + "     for use in the OpenSSL Toolkit (http://www.openssl.org/)\"\n"
        + " \n"
        + "  THIS SOFTWARE IS PROVIDED BY THE OpenSSL PROJECT ``AS IS'' AND ANY\n"
        + "  EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE\n"
        + "  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR\n"
        + "  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE OpenSSL PROJECT OR\n"
        + "  ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,\n"
        + "  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT\n"
        + "  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;\n"
        + "  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)\n"
        + "  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,\n"
        + "  STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)\n"
        + "  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED\n"
        + "  OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + "  ====================================================================\n"
        + " \n"
        + "  This product includes cryptographic software written by Eric Young\n"
        + "  (eay@cryptsoft.com).  This product includes software written by Tim\n"
        + "  Hudson (tjh@cryptsoft.com).\n"
        + " \n"
        + "\n"
        + " Original SSLeay License\n"
        + " -----------------------\n"
        + "\n"
        + "Copyright (C) 1995-1998 Eric Young (eay@cryptsoft.com)\n"
        + "All rights reserved.\n"
        + " \n"
        + "  This package is an SSL implementation written\n"
        + "  by Eric Young (eay@cryptsoft.com).\n"
        + "  The implementation was written so as to conform with Netscapes SSL.\n"
        + " \n"
        + "  This library is free for commercial and non-commercial use as long as\n"
        + "  the following conditions are aheared to.  The following conditions\n"
        + "  apply to all code found in this distribution, be it the RC4, RSA,\n"
        + "  lhash, DES, etc., code; not just the SSL code.  The SSL documentation\n"
        + "  included with this distribution is covered by the same copyright terms\n"
        + "  except that the holder is Tim Hudson (tjh@cryptsoft.com).\n"
        + " \n"
        + "  Copyright remains Eric Young's, and as such any Copyright notices in\n"
        + "  the code are not to be removed.\n"
        + "  If this package is used in a product, Eric Young should be given attribution\n"
        + "  as the author of the parts of the library used.\n"
        + "  This can be in the form of a textual message at program startup or\n"
        + "  in documentation (online or textual) provided with the package.\n"
        + " \n"
        + "  Redistribution and use in source and binary forms, with or without\n"
        + "  modification, are permitted provided that the following conditions\n"
        + "  are met:\n"
        + "  1. Redistributions of source code must retain the copyright\n"
        + "     notice, this list of conditions and the following disclaimer.\n"
        + "  2. Redistributions in binary form must reproduce the above copyright\n"
        + "     notice, this list of conditions and the following disclaimer in the\n"
        + "     documentation and/or other materials provided with the distribution.\n"
        + "  3. All advertising materials mentioning features or use of this software\n"
        + "     must display the following acknowledgement:\n"
        + "     \"This product includes cryptographic software written by\n"
        + "      Eric Young (eay@cryptsoft.com)\"\n"
        + "     The word 'cryptographic' can be left out if the rouines from the library\n"
        + "     being used are not cryptographic related :-).\n"
        + "  4. If you include any Windows specific code (or a derivative thereof) from\n"
        + "     the apps directory (application code) you must include an acknowledgement:\n"
        + "     \"This product includes software written by Tim Hudson (tjh@cryptsoft.com)\"\n"
        + " \n"
        + "  THIS SOFTWARE IS PROVIDED BY ERIC YOUNG ``AS IS'' AND ANY EXPRESS OR IMPLIED W"
        + "ARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABIL"
        + "ITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE "
        + "AUTHOR OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, "
        + "EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT "
        + "OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTE"
        + "RRUPTION)\n"
        + "HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABI"
        + "LITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE "
        + "USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + " \n"
        + "  The licence and distribution terms for any publically available version or der"
        + "ivative of this code cannot be changed.  i.e. this code cannot simply be copied "
        + "and put under another distribution licence\n"
        + "  [including the GNU Public Licence.]\n"
        + " \n"
; // the license text
    }
 
    
}
