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
        console.log(evenNumber(answer));
        rl.close();
        getInput();
    });
}

function evenNumber(value) {
    // initial check for exceptions
    if (isNaN(value) || !isFinite(value) || value < 2 || value % 1 ) {
        return false;
    }
    // check if the number is prime:
    for (var i = 2; i <= Math.sqrt(value); i++) {
        if (value % i == 0) {
            return false;
        }
    }
    return true;
}

getInput();