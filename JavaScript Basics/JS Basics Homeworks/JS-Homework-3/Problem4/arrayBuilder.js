/**
 * Created by atanasWin on 27/7/2014.
 */

function createArray(value) {
    var arr = new Array(20);
    for (var i = 0; i < arr.length; i++) {
        arr[i] = i*5;
    }
    console.log(arr);
}

createArray();