reporter
========

This tool helps to evaluate your source code quality from a licensing compliance perspective.

The end result is a report written in SPDX format that includes:
- License and copyright identification (LGPL, GPL, Apache)
- Lines Of Code (LOC)
- Checksums (MD5, SHA256, SSDEEP)
- Filenames (and types)
- File size

The most common usages are:
- Estimate the code size (and complexity) before auditing the licenses
- See how well your code is identifiable to humans and licensing tools


Credits and thanks
==================

A list of the software, services and people that make triplecheck possible.

### Software
- JArchiveLib (Apache 2.0) http://rauschig.org/jarchivelib/
- Google GSON (Apache 2.0) https://code.google.com/p/google-gson/
- Java2HTML (GPL or CPL) http://www.java2html.de/
- JFreeChart (LGPL 2.1) http://www.jfree.org/jfreechart/
- MapDB (Apache 2.0) http://www.mapdb.org/
- Beanshell2 (LGPL) https://code.google.com/p/beanshell2/
- Jericho HTML parser (EPL and GPL) http://jericho.htmlparser.net/docs/index.html
- SimpleFramework (LGPL) http://www.simpleframework.org/ 
- Vogella RSS feed example (EPL) http://www.vogella.com/tutorials/RSSFeed/article.html


### Services and sites
- SPDX -> http://spdx.org (the Linux Foundation SPDX working group)
- Github -> http://github.com (THE place for sharing code)
- Metascan -> https://metascan-online.com/ (for helping with API to detect malware)
- File Extension Seeker -> http://file-extension.net (great help to identify extensions)


### People
- Gary O'Neal -> http://sourceauditor.com (always available with helpful feedback)