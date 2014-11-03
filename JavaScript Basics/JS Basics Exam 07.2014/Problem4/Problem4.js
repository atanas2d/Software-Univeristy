/**
 * Created by atanasWin on 28/7/2014.
 */
function solve(input) {
    // get the unique names of the teams played:
    var resultObj = {};
    var teams = [];
    for (var i = 0; i < input.length; i++) {
        var teamNames = input[i].substring(0,input[i].indexOf(":"));
        teamNames = teamNames.split("/");
        for (var name in teamNames) {
           teamNames[name] = teamNames[name].trim();
            /// !!! If necessary check for whitespaces between the team name
            if (teams.indexOf(teamNames[name]) == -1) {
                teams.push(teamNames[name]);
            }
        }
    }
    // sort teams by names:
    teams.sort();
    // record team names in the object
    for (var i in teams) {
        resultObj[teams[i]] = {};
    }
    // gather information for every team:
    for (var team in resultObj) {
        var goalsScored = 0;
        var goalsConceded = 0;
        var matchesPlayedWith = [];
        for (var i = 0; i < input.length; i++) {
            if (input[i].indexOf(team) != -1) {
                // get team names from the record
                var teamNames = input[i].substring(0,input[i].indexOf(":"));
                teamNames = teamNames.split("/");
                for (var name in teamNames) {
                    teamNames[name] = teamNames[name].trim();
                }
                // get result from the record
                var result = input[i].substring(input[i].indexOf(":") + 1, input[i].length);
                result = result.split("-");
                for (var key in result) {
                    result[key] = result[key].trim();
                }
                // get stats:
                if (teamNames.indexOf(team) == 0) {
                    goalsScored += parseInt(result[0]);
                    goalsConceded += parseInt(result[1]);
                    if (matchesPlayedWith.indexOf(teamNames[1]) == -1) {
                        matchesPlayedWith.push(teamNames[1]);
                    }
                } else {
                    goalsScored += parseInt(result[1]);
                    goalsConceded += parseInt(result[0]);
                    if (matchesPlayedWith.indexOf(teamNames[0]) == -1) {
                        matchesPlayedWith.push(teamNames[0]);
                    }
                }
            }

        }
        resultObj[team]["goalsScored"] = goalsScored;
        resultObj[team]["goalsConceded"] = goalsConceded;
        matchesPlayedWith.sort();
        resultObj[team]["matchesPlayedWith"] = [];
        for (var i in matchesPlayedWith) {
            resultObj[team]["matchesPlayedWith"].push(matchesPlayedWith[i]);
        }
    }

    console.log(JSON.stringify(resultObj));
}