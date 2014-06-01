package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:48Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Sleepycat.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Sleepycat extends License{
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
        return "Sleepycat"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Sleepycat License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Sleepycat License\n"
        + "Copyright (c) 1990-1999\n"
        + "Sleepycat Software. All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without\n"
        + "modification, are permitted provided that the following conditions\n"
        + "are met:\n"
        + "\n"
        + "Redistributions of source code must retain the above copyright\n"
        + "notice, this list of conditions and the following disclaimer.\n"
        + "Redistributions in binary form must reproduce the above copyright\n"
        + "notice, this list of conditions and the following disclaimer in the\n"
        + "documentation and/or other materials provided with the distribution.\n"
        + "Redistributions in any form must be accompanied by information on\n"
        + "how to obtain complete source code for the DB software and any\n"
        + "accompanying software that uses the DB software. The source code\n"
        + "must either be included in the distribution or be available for no\n"
        + "more than the cost of distribution plus a nominal fee, and must be\n"
        + "freely redistributable under reasonable conditions. For an\n"
        + "executable file, complete source code means the source code for all\n"
        + "modules it contains. It does not include source code for modules or\n"
        + "files that typically accompany the major components of the operating\n"
        + "system on which the executable file runs.\n"
        + "THIS SOFTWARE IS PROVIDED BY SLEEPYCAT SOFTWARE ``AS IS'' AND ANY EXPRESS\n"
        + "OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED\n"
        + "WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR\n"
        + "NON-INFRINGEMENT, ARE DISCLAIMED. IN NO EVENT SHALL SLEEPYCAT SOFTWARE\n"
        + "BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR\n"
        + "CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF\n"
        + "SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS\n"
        + "INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN\n"
        + "CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)\n"
        + "ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF\n"
        + "THE POSSIBILITY OF SUCH DAMAGE.\n"
        + "\n"
        + "Copyright (c) 1990, 1993, 1994, 1995\n"
        + "The Regents of the University of California. All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without\n"
        + "modification, are permitted provided that the following conditions\n"
        + "are met:\n"
        + "\n"
        + "Redistributions of source code must retain the above copyright\n"
        + "notice, this list of conditions and the following disclaimer.\n"
        + "Redistributions in binary form must reproduce the above copyright\n"
        + "notice, this list of conditions and the following disclaimer in the\n"
        + "documentation and/or other materials provided with the distribution.\n"
        + "Neither the name of the University nor the names of its contributors\n"
        + "may be used to endorse or promote products derived from this software\n"
        + "without specific prior written permission.\n"
        + "THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND\n"
        + "ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE\n"
        + "IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE\n"
        + "ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE\n"
        + "FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL\n"
        + "DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS\n"
        + "OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)\n"
        + "HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n"
        + "LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY\n"
        + "OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF\n"
        + "SUCH DAMAGE.\n"
        + "\n"
        + "Copyright (c) 1995, 1996\n"
        + "The President and Fellows of Harvard University. All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without\n"
        + "modification, are permitted provided that the following conditions\n"
        + "are met:\n"
        + "\n"
        + "Redistributions of source code must retain the above copyright\n"
        + "notice, this list of conditions and the following disclaimer.\n"
        + "Redistributions in binary form must reproduce the above copyright\n"
        + "notice, this list of conditions and the following disclaimer in the\n"
        + "documentation and/or other materials provided with the distribution.\n"
        + "Neither the name of the University nor the names of its contributors\n"
        + "may be used to endorse or promote products derived from this software\n"
        + "without specific prior written permission.\n"
        + "THIS SOFTWARE IS PROVIDED BY HARVARD AND ITS CONTRIBUTORS ``AS IS'' AND\n"
        + "ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE\n"
        + "IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE\n"
        + "ARE DISCLAIMED. IN NO EVENT SHALL HARVARD OR ITS CONTRIBUTORS BE LIABLE\n"
        + "FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL\n"
        + "DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS\n"
        + "OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)\n"
        + "HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n"
        + "LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY\n"
        + "OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF\n"
        + "SUCH DAMAGE.\n"
; // the license text
    }
 
    
}
