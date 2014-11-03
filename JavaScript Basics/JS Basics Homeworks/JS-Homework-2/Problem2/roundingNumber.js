/**
 * Created by atanasWin on 21/7/2014.
 */

function getInput() {
    //get input:
    var readline = require('readline');
    var rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    console.log("Enter 'q' for exit...");
    rl.question("Please enter number: ", function(answer) {
        // TODO: Log result
        if (answer == 'q') {
            rl.close();
            return;
        }
        roundNumber(answer)
        rl.close();
        getInput();
    });
}

function roundNumber(value) {
    console.log(Math.floor(value));
    console.log(Math.round(value));
}

getInput();