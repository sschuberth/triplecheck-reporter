// how good is the licensing quality in overall?
var quality_score = "4.0/10";

// detail what we found
var quality_score_details = "Copyright: 0/20<br>License: 20/30<br>Documentation: 0/30";

var quality_percentage = [{
            country: "Copyright",
            gold: 0,
            bronze: 100
        }, {
            country: "License",
            gold: 66,
            bronze: 34
        }, {
            country: "Documentation",
            gold: 0,
            bronze: 100
        }];

var quality_color = [{
            valueField: "gold",
            name: "Available",
            color: "#66bb6a"
        }, 
        {
            valueField: "bronze",
            name: "Missing",
            color: "#e0e0e0"
        }];
