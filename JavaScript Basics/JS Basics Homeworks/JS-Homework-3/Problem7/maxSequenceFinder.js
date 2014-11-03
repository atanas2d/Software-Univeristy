/**
 * Created by atanasWin on 27/7/2014.
 */
function getInput() {
    //get an integer n:
    var readline = require('readline');
    var rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    console.log("ENTER 'q' FOR EXIT.");
    getNumSequence(rl);
}

function getNumSequence(rl) {
    rl.question("Enter a sequence of numbers like ' 1, 2, 3, 2, 10, 5, -1, ... ': ", function(chars) {
        // TODO: get the first char sequence
        if (chars == 'q') {
            process.exit(0);
        }
        var numsArr = chars.split(",");
        for (var i = 0; i < numsArr.length; i++) {
            numsArr[i] = numsArr[i].trim();
            numsArr[i] = parseInt(numsArr[i]);
        }
        findMaxSequence(numsArr);
        console.log();
        console.log("Enter new num sequence (type 'q' for exit):");
        getNumSequence(rl);
    });
}
function findMaxSequence(numsArr) {
    var counter = 0;
    var bestCount = 0;
    var result = "no";
    var tempResult = [];
    for (var i = 1; i < numsArr.length; i++) {

        if(numsArr[i] > numsArr[i-1]) {
            counter++;
            tempResult.push(numsArr[i-1])
            if (counter >= bestCount) {
                bestCount = counter;
                result = tempResult;
                if ((i + 1 < numsArr.length && numsArr[i] >= numsArr[i+1]) || (i == numsArr.length - 1)) {
                    result.push(numsArr[i]);
                }
            }
        }
        if (numsArr[i] <= numsArr[i-1]) {
            counter = 0;
            tempResult = [];
        }
    }
    console.log(result);
}
getInput();