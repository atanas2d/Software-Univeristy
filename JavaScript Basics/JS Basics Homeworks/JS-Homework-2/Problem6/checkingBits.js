/**
 * Created by atanasWin on 22/7/2014.
 */
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
    rl.question("Please enter integer: ", function(answer) {
        // TODO: Log result
        if (answer == 'q') {
            rl.close();
            return;
        }
        if (bitChecker(answer) == -1) {
            console.log("Wrong input.");
        } else if (bitChecker(answer) == 0){
            console.log("false");
        } else {
            console.log("true");
        }
        rl.close();
        getInput();
    });
}

function bitChecker(value) {
    // initial check for exceptions
    if (isNaN(value) || !isFinite(value) || value < 0 || value % 1 ) {
        return -1;
    }
    // convert int to bit
    var bitStr = Number(value).toString(2);
    if (bitStr[bitStr.length - 3] == 1) {
        return 1;
    } else {
        return 0;
    }

}

getInput();