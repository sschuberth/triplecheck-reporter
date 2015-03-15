// how good is the licensing quality in overall?
var quality_score = "1.2/10";

// detail what we found
var quality_score_details = "98 files with copyright declared <br />127 files with declared licenses<br />See what can be fixed";

var data1 = [{
            country: "Copyright",
            gold: 70,
            bronze: 30
        }, {
            country: "License",
            gold: 51,
            bronze: 49
        }, {
            country: "Documentation",
            gold: 16,
            bronze: 84
        }];

var q_color = [{
            valueField: "gold",
            name: "Obtained",
            color: "#66bb6a"
        }, {
            valueField: "bronze",
            name: "Total",
            color: "#e0e0e0"
        }];
