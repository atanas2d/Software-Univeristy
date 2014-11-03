/**
 * Created by atanasWin on 28/7/2014.
 */
function solve(input) {
    var start = Number(input[0]);
    var end = Number(input[1]);
    //check all numbers in the range:
    console.log('<ul>');
    for (var i = start; i <= end; i++) {
        var currentNum = i.toString();
        var l = currentNum.length;
        var isRakiyaNum = false;
        //check the current number if it is rakiya number:
        for (var ii = 0; ii < l - 3; ii++) {
            // concatenate next two chars
            var nCheck = currentNum.charAt(ii).concat(currentNum.charAt(ii+1)) ;
            // check the rest of the number for jackpots
            var stringToCheck = currentNum.substring(ii + 2);
            if (stringToCheck.indexOf(nCheck) != -1) {
                isRakiyaNum = true;
            }
        }
        if (isRakiyaNum) {
            console.log("<li><span class='rakiya'>" + currentNum + "</span>" + "<a href=\"view.php?id=" + currentNum + ">View</a>" + "</li>");
        } else {
            console.log("<li><span class='num'>" + currentNum + "</span></li>");
        }
    }
    console.log('</ul>');
}