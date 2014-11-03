/**
 * Created by atanasWin on 22/7/2014.
 */
var foodName = "unknown food";
var ages = 0;
var maxAges = 0;
var amount = 0;

function getInput() {
    //get name of the food:
    var readline = require('readline');
    var rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    console.log("Enter 'q' for exit...");
    rl.question("Please enter the food name: ", function(food) {
        // TODO: get the food name
        if (food == 'q') {
            process.exit(0);
        }
        foodName = food;
        getAges(rl);
    });
}

function getAges(rl) {
    rl.question("Please enter your ages: ", function(ages1) {
        // TODO: get ages
        if (ages1 == 'q') {
            process.exit(0);
        }
        if (isNaN(ages1) || ages1 < 1 || ages1 > 200) {
            console.log("Wrong ages input. Try again. For exit type 'q'.");
            getAges(rl, foodName);
        } else {
            ages = ages1;
            getMaxAges(rl);
        }
    });
}

function getMaxAges(rl) {
    rl.question("Please your max ages: ", function(answer) {
        // TODO: get max ages
        if (answer == 'q') {
            rl.close();
            process.exit(0);
        }
        if (isNaN(answer) || answer < 1 || answer > 200 || answer < ages) {
            console.log("Wrong max ages input. Try again. (Enter 'q' for exit):")
            getMaxAges(rl);
        } else {
            maxAges = answer;
            getAmount(rl);
        }
    });
}

function getAmount(rl) {
    rl.question("Please enter daily amount of food: ", function(answer) {
        // TODO: get the food amound
        if (answer == 'q') {
            rl.close();
            process.exit(0);
        }
        if (isNaN(answer) || answer < 0) {
            console.log("Wrong daily amount input. Try again. (Enter 'q' for exit):");
            getAmount(rl);
        } else {
            amount = answer;
            calcSupply(foodName,ages, maxAges, amount);
            rl.close();
        }
    });
}

function calcSupply(foodName, ages, maxAges, foodAmount) {
    var result = (maxAges - ages)*foodAmount*365;
    console.log(result + "kg" + " of " + foodName + " would be enough until I am " + maxAges + " years old.");


}

getInput();