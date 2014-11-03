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
    rl.question("Enter an expression with brackets: ", function(chars) {
        // TODO: get the expression
        if (chars == 'q') {
            process.exit(0);
        }
        checkBrackets(chars);
        console.log();
        console.log("Enter new expression (type 'q' for exit):");
        getChars(rl);
    });
}
function checkBrackets(chars) {
    var correct = true;
    if (chars.indexOf("(") == -1 && chars.indexOf(")") == -1) {
        console.log("No brackets");
        return;
    } else if (chars.indexOf("(") == -1 || ( chars.indexOf(")") < chars.indexOf("(") ) ) {
        correct = false;
    } else {
        while (chars.indexOf("(") != -1) {
            var startBracket = chars.indexOf("(");
            chars = chars.substr(0, startBracket) + "-" + chars.substr(startBracket + 1);
            var endBracket = "-1";
            for (var i = startBracket; i < chars.length; i++) {
                if (chars[i] == ")") {
                    endBracket = i;
                }
            }
            if (endBracket == -1) {
                correct = false;
            }
            chars = chars.substr(0, endBracket) + "-" + chars.substr(endBracket + 1);
        }
    }
    correct ? console.log("correct") : console.log("incorrect");
}

getInput();