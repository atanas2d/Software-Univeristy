/**
 * Created by atanasWin on 26/7/2014.
 */

function getInput() {
    //get an integer n:
    var readline = require('readline');
    var rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    getN(rl);

}

function getN(rl) {
    rl.question("Please enter an integer n. Enter 'q' for exit: ", function(n) {
        // TODO: get the food name
        if (n == 'q') {
            process.exit(0);
        }
        if (isNaN(n) || !isFinite(n) || ((n%1) != 0)) {
            console.log("Wrong n input. Try again: ");
            getN(rl);
        } else {
            printNumbers(n);
            getN(rl);
        }
    });
}

function printNumbers(n) {
    if (n < 1) {
        console.log("no");
    } else {
        var result = "";
        for (var i = 1; i <= n; i++) {
            if ((i % 4) != 0 && (i % 5) != 0) {
                result += (i + ", ");

            }
        }
        result = result.substring(0, result.length - 2);
        console.log(result);
    }
}

getInput();

