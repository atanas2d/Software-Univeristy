/**
 * Created by atanasWin on 28/7/2014.
 */
function solve (input) {
    // determine degrees:
    var degrees = input[0];
    degrees = degrees.substring(degrees.indexOf("(") + 1, degrees.indexOf(")"));
    degrees = parseInt(degrees);
    degrees = degrees % 360;

    // put strings in matrix
    input.splice(0,1);

    var maxL = 0;
    for (var i = 0; i < input.length; i++ ) {
        if (input[i].length > maxL) {
            maxL = input[i].length;
        }
    }

    var strCount = input.length;

    var matrix = new Array(strCount);
    for (var i = 0; i < matrix.length; i++) {
        matrix[i] = new Array(maxL);
        for (var ii = 0; ii < matrix[i].length; ii++) {
            if (ii < input[i].length) {
                matrix[i][ii] = input[i].charAt(ii);
            } else {
                matrix[i][ii] = ' ';
            }
        }
    }

    switch (degrees) {
        case 0:
            var line = "";
            for (var i = 0; i < matrix.length; i++) {
                for (var ii = 0; ii < matrix[i].length; ii++) {
                    line += matrix[i][ii];
                }
                console.log(line);
                line = "";
            }
            break;
        case 90:
            var line = "";
            for (var ii = 0; ii < maxL; ii++) {
                for (var i = matrix.length - 1; i >= 0; i--) {
                    line += matrix[i][ii];
                }
                console.log(line);
                line = "";
            }
            break;
        case 180:
            var line = "";
            for (var i = strCount - 1; i >= 0; i--) {
                for (var ii = maxL - 1; ii >= 0; ii--) {
                    line += matrix[i][ii];
                }
                console.log(line);
                line = "";
            }
            break;
        case 270:
            var line = "";
            for (var ii = maxL - 1; ii >= 0; ii--) {
                for (var i = 0; i < strCount; i++) {
                    line += matrix[i][ii];
                }
                console.log(line);
                line = "";
            }
            break;
    }

}