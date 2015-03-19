// how good is the licensing quality in overall?
var quality_score = "1.2/10";

// detail what we found
var quality_score_details = "98 files with copyright declared <br />127 files with declared licenses<br />See <a href=\"page_4.html\">what can be fixed</a>";

var quality_percentage = [{
            country: "Copyright",
            gold: 70,
            bronze: 30
        }, {
            country: "License",
            gold: 51,
            bronze: 49
        }, {
            country: "Documentation",
            doc_color: 16,
            bronze: 84
        }];

var quality_color = [{
            valueField: "gold",
            name: "Satisfactory",
            color: "#66bb6a"
        }, {
            valueField: "doc_color",
            name: "Needs improvement",
            color: "#ffa726"
        }, {
            valueField: "bronze",
            name: "Missing",
            color: "#e0e0e0"
        }];
