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
    rl.question("Please enter number(n<9): ", function(answer) {
        // TODO: Log result
        if (answer == 'q') {
            rl.close();
            return;
        }
        if (divisionBy3(answer) == -1) {
            console.log("Wrong input.");
        } else if (divisionBy3(answer) == 0){
            console.log("the number is not divided by 3 without remainder");
        } else {
            console.log("the number is divided by 3 without remainder");
        }
        rl.close();
        getInput();
    });
}

function divisionBy3(value) {
    // initial check for exceptions
    if (isNaN(value) || !isFinite(value) || value < 9 || value % 1 ) {
        return -1;
    }
    // checks if the sum is divided by 3 without remainder:
    var nStr = value.toString();
    var sum = 0;
    for (var i = 0; i < nStr.length; i++) {
        sum += nStr[i];
    }
    if (sum % 3 == 0) {
        return 1;
    }
    return 0;
}

getInput();