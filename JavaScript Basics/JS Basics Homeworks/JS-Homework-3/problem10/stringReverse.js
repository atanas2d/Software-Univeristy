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
    getStr(rl);
}

function getStr(rl) {
    rl.question("Enter a string to reverse: ", function(string) {
        // TODO: get the first char sequence
        if (string == 'q') {
            process.exit(0);
        }
        reverseString(string);
        console.log();
        console.log("Enter new string to reverse (type 'q' for exit):");
        getStr(rl);
    });
}
function reverseString(str) {
    var result = "";
    for (var i = str.length - 1; i >= 0; i--) {
        result += str[i];
    }
    console.log(result);
}
getInput();