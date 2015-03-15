// what titles shall we show for the titles on the originality analysis?
var match_similar_title = "3 files are similar to other files on the web ";
var match_exact_title = "301 files are exact matches to other files on the web";

// is there a list of items that we should show?
var match_similar_list = [{
        filename: "./files_minor.java (2 snippets)",
        snippet: [{
                title : "Lines 39..51: if (dir.isDirectory()) { String[] children = dir.list(); for (int i=0 ",
                code: "StringBuilder test = new StringBuilder();",
                similarity: [{
                        percent : 100,
                        lines: "1129..1142",
                        reference: "github:kingargyle-exist-1.4.x-8da367f/src/org/exist/client/ClientFrame.java<br>sha1:78ea40bb0dd097517c74371f5f8adee181c1f55e"
                }]
        }]
    },
    {
        filename: "./python/portscanner.py (1 snippet)",
        snippet: [{
                title : "Lines 18..33: 	try: connSkt = socket(AF_INET, SOCK_STREAM)",
                code: "While(true){delete dir.files()}",
                similarity: [{
                        percent : 100,
                        lines: "1130..1122",
                        reference: "github:kingargyle-exist-1.4.x-8da367f/src/org/exist/client/ClientFrame.java<br>sha1:78ea40bb0dd097517c74371f5f8adee181c1f55e"
                }]
        }]
    }
    
];




