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
    rl.question("Enter the first sequence of chars like ' a, b, @, f, c, 5, A, ... ': ", function(chars) {
        // TODO: get the first char sequence
        if (chars == 'q') {
            process.exit(0);
        }
        var charArr = chars.split(",");
        for (var i = 0; i < charArr.length; i++) {
            charArr[i] = charArr[i].trim();
        }
        charArr1 = charArr;
        getSecondCahrs(rl);
    });
}

function getSecondCahrs(rl) {
    rl.question("Enter the second sequence of chars like ' a, b, @, f, c, 5, A, ... ': ", function(chars) {
        // TODO: get the first char sequence
        if (chars == 'q') {
            process.exit(0);
        }
        var charArr = chars.split(",");
        for (var i = 0; i < charArr.length; i++) {
            charArr[i] = charArr[i].trim();
        }
        charArr2 = charArr;
        compareChars(charArr1, charArr2);
        console.log();
        console.log("New comparison... (type 'q' for EXIT)");
        getChars(rl);
    });
}

var charArr1;
var charArr2;

function compareChars(charArr1, charArr2) {

    if (charArr1.length != charArr2.length) {
        console.log("Result: Not Equal");
        return;
    }
    for (var i = 0; i < charArr1.length; i++) {
        if (charArr1[i] != charArr2[i]) {
            console.log("Result: Not Equal");
            return;
        }
    }
    console.log("Result: Equal");
}

getInput();