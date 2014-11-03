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
    getChars(rl);
}

function getChars(rl) {
    rl.question("Enter a sequence of chars like ' a, b, @, f, c, 5, A, ... ': ", function(chars) {
        // TODO: get the first char sequence
        if (chars == 'q') {
            process.exit(0);
        }
        var charArr = chars.split(",");
        for (var i = 0; i < charArr.length; i++) {
            charArr[i] = charArr[i].trim();
        }
        findMaxSequence(charArr);
        console.log();
        console.log("Enter new char sequence (type 'q' for exit):");
        getChars(rl);
    });
}
function findMaxSequence(charArr) {
    var counter = 0;
    var bestCount = 0;
    var result = charArr[0];
    var tempResult = [];
    for (var i = 1; i < charArr.length; i++) {

        if(charArr[i] == charArr[i-1]) {
            counter++;
            tempResult.push(charArr[i-1])
            if (counter >= bestCount) {
                bestCount = counter;
                result = tempResult;
                if ((i + 1 < charArr.length && charArr[i] != charArr[i+1]) || (i == charArr.length - 1)) {
                    result.push(charArr[i-1]);
                }
            }
        }
        if (charArr[i] != charArr[i-1]) {
            counter = 0;
            tempResult = [];
        }
    }
    console.log(result);
}

getInput();