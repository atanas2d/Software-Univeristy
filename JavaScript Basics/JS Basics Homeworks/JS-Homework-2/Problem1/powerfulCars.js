/**
 * Created by atanasWin on 21/7/2014.
 */
function getInput() {
    var result;
    var readline = require('readline');
    var rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    console.log("Enter 'q' for exit...");
    var execute = true;
    rl.question("Please enter KW: ", function(answer) {
        // TODO: Log the result
        if (answer == 'q') {
            execute = false;
            rl.close();
            return;
        } else {
            result = convetKWtoHP(answer);
            console.log("Horse power: " + result);
            rl.close();
            getInput();
        }
    });
}

function convetKWtoHP(kw) {
    var hp = kw * 1.34102209;
    return hp.toFixed(2);
}

getInput();