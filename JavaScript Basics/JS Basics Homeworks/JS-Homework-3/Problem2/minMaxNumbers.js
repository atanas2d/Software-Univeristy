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
    console.log("ENTER 'q' FOR EXIT.");
    getNumbers(rl);
}

function getNumbers(rl) {
    rl.question("Please enter a sequence of numbers like: '1, 20, 3, -4 ...': ", function(numbers) {
        // TODO: get the numbers
        if (numbers == 'q') {
            process.exit(0);
        }
        var numArr = numbers.split(",");
        for (var i = 0; i < numArr.length; i++) {
            numArr[i] = numArr[i].trim();
            n = numArr[i];
            if (isNaN(n) || !isFinite(n) || ((n%1) != 0)) {
                console.log("Wrong n input ('"+ n +"'). Try again: ");
                getNumbers(rl);
            }
            numArr[i] = parseInt(numArr[i]);
        }
        findMinAndMax(numArr);
        getNumbers(rl);
    });
}

function findMinAndMax(numbers) {
    console.log(Math.min.apply(null, numbers));
    console.log(Math.max.apply(null, numbers));
}

getInput();