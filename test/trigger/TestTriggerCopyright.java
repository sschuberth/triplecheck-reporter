package trigger;

/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-09T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: TestTriggerCopyright.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Test the detection of copyright </text> 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;

/**
 *
 * @author Nuno Brito
 */
public class TestTriggerCopyright {
    
    
    String content = ""
+ "		    GNU GENERAL PUBLIC LICENSE"
+ "		       Version 2, June 1991"
+ ""
+ "\n Copyright (C) 1989, 1991 Free Software Foundation, Inc."
+ "\n     51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA"
+ "\n Everyone is permitted to copy and distribute verbatim copies"
+ "\n of this license document, but changing it is not allowed."
+ "\n"
+ "\n"
+ "\n * This file is part of Adblock Plus <http://adblockplus.org/>,"
+ "\n * Copyright (C) 2006-2014 Eyeo GmbH"
+ "\n *"
+ "\n * Adblock Plus is free software: you can redistribute it and/or modify"
+ "\n"
+ "\n"
+ "\n/* Copyright (c) 2012 the authors listed at the following URL, and/or"
+ "\nthe authors of referenced articles or incorporated external code:"
+ "\nhttp://en.literateprograms.org/Boyer-Moore_string_search_algorithm_(Java)?action=history&offset=20100924202517"
+ "\n"
+ "\nPermission is hereby granted, free of charge, to any person obtaining"
+ "\na copy of this software and associated documentation files (the"
+ "\n"
+ "\n * Brazil project web application toolkit,"
+ "\n* export version: 2.3 "
+ "\n* Copyright (c) 1998-2004 Sun Microsystems, Inc."
+ "\n*"
+ "\n* Sun Public License Notice"
+ "\n*"
+ "\n* The contents of this file are subject to the Sun Public License Version "
+ "\n"
+ "\n// Copyright 2011 the V8 project authors. All rights reserved."
+ "\n// Redistribution and use in source and binary forms, with or without"
+ "\n// modification, are permitted provided that the following conditions are"
+ "\n// met:"
            + ""
 + "\n* (C) Copyright 2000-2013, by Object Refinery Limited and Contributors."
 + "\n*"
 + "\n*"
+ "+\n * Disallocate virtual terminal(s)"
 + "\n*"
 + "\n* Copyright (C) 2003 by Tito Ragusa <farmatito@tiscali.it>"
 + "\n* Copyright (C) 1999-2004 by Erik Andersen <andersen@codepoet.org>"
+ " \n*"
+ " \n* Licensed under GPLv2 or later, see file LICENSE in this source tree."
+ " \n*/"
+ "\n/*"
 + "\n* Copyright (C) 2002 Roman Zippel <zippel@linux-m68k.org>"
+ "\n * Released under the terms of the GNU GPL v2.0."
+ "\n */"
+ "\n"
+ "\n *"
 + "\n* Copyright (C) 1993, 1994  Remy Card <card@masi.ibp.fr>"
 + "\n*                           Laboratoire MASI, Institut Blaise Pascal"
 + "\n*                           Universite Pierre et Marie Curie (Paris VI)"
 + "\n*"
 + "\n* This file can be redistributed under the terms of the GNU General"
+ "\n *"
+ "\n# Stolen from Linux kernel :)"
+ "\n"
+ "\n#	Check the stack usage of functions"
+ "\n#"
+ "\n#	Copyright Joern Engel <joern@wh.fh-wedel.de>"
+ "\n#	Inspired by Linus Torvalds"
+ "\n#	Original idea maybe from Keith Owens"
+ "\n"
+ ""
+ ""
+ "";

   
    
    public TestTriggerCopyright() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
     @Test
     public void findCopyright() {
         // the mega-super expression to catch copyright statements
     String patternString = ""
             + "(\\((C|c)\\) |)"    // detect a (c) before the copyright text
             + "(C|c)opyright"      // detect the copyright text
             + "( \\((C|c)\\)|) "   // sometimes with a (c)
             + "([0-9]|)"           // optionally with the year
             + "+"             
             + "[^\\n\\t\\*]+\\.?";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(content);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + content.substring(matcher.start(), matcher.end())

                    //+ matcher.start() + " - " + matcher.end()
                    );
        }
        
     }
}
