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
    rl.question("Enter a sequence of numbers like ' 1, 2, 2, 2, 10, 5, -1, ... ': ", function(nums) {
        // TODO: get the first char sequence
        if (nums == 'q') {
            process.exit(0);
        }
        var numsArr = nums.split(",");
        for (var i = 0; i < numsArr.length; i++) {
            numsArr[i] = numsArr[i].trim();
            numsArr[i] = parseInt(numsArr[i]);
        }
        findMostFreqNum(numsArr);
        console.log();
        console.log("Enter new num sequence (type 'q' for exit):");
        getNumSequence(rl);
    });
}
function findMostFreqNum(numsArr) {
    var counter = 1;
    var bestCount = 1;
    var result = [numsArr[0]];
    var tempResult = [];
    for (var j = 0; j < numsArr.length - 1; j++)  {
        if (numsArr[j] != '-') {
            tempResult.push(numsArr[j]);
            for (var i = j+1; i < numsArr.length; i++) {
                if (numsArr[i] != '-' && numsArr[j] == numsArr[i]) {
                    counter++;
                    tempResult.push(numsArr[i]);
                    numsArr[i] = '-';
                }
            }
            numsArr[j] = '-';
            if (counter > bestCount) {
                bestCount = counter;
                result = tempResult;
            }
            counter = 1;
            tempResult = [];
        }
    }
    console.log(result[0] + " (" + result.length + " times)");
}
getInput();