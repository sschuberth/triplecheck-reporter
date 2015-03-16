// what titles shall we show for the titles on the originality analysis?
var match_similar_title = "39 files are similar to other files on the web ";
var match_exact_title = "23 files are exact matches to other files on the web";

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
                },
                {
                        percent : 99,
                        lines: "129..242",
                        reference: "github:kingargyle-exist-1.4.x-8da367f/src/org/exist/client/ClientFrame.java<br>sha1:78ea40bb0dd097517c74371f5f8adee181c1f55e"
                }
                ]
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

var match_exact_list = [{
        type: "source",
        files: [{
            file: "./apache/commons/lang/CharUtils.java",
            matches: [
                "github:adblockplus-adblockplusandroid-d93ee48/src/org/apache/commons/lang/StringEscapeUtils.java",
                "github:adblockplus-adblockplusandroid-d93ee48/src/org/apache/commons/lang/StringEscapeUtils.java"
            ]
        },
        {
            file: "./python/LevelReader.py ",
            matches: [
                "github:nomadx-test-pygame-camera-0fa6449/src/LevelReader.py "
            ]
        }
        
    ]},{
        type: "archive",
        files: [{
            file: "./commons-compiler.jar ",
            matches: [
                "github:liferay-liferay-portal-f6e6328/lib/portal/commons-compiler.jar "
            ]
        }
    ]}
];
