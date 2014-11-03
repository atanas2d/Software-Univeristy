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
        sortArray(numsArr);
        console.log();
        console.log("Enter new num sequence (type 'q' for exit):");
        getNumSequence(rl);
    });
}
function sortArray(numsArr) {
    var result = [];
    var l = numsArr.length
    for (var i =0; i < l; i++) {
        var minValue = Math.min.apply(null, numsArr);
        var index = numsArr.indexOf(minValue);
        result.push(numsArr.splice(index,1));
    }
    console.log(result);
}
getInput();