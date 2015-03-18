// how good is the licensing quality in overall?
var quality_score = "#score#";

// detail what we found
var quality_score_details = "#details#";

var quality_percentage = [{
            country: "Copyright",
            gold: cop1,
            bronze: cop2
        }, {
            country: "License",
            gold: lic1,
            bronze: lic2
        }, {
            country: "Documentation",
            gold: doc1,
            bronze: doc2
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
