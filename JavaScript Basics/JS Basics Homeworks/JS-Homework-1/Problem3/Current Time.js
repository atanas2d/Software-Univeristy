/**
 * Created by atanasWin on 20/7/2014.
 */
var date = new Date();
var hours = date.getHours();
var mins = date.getMinutes();

if (mins < 10){
    console.log(hours + ":" + 0 + mins);
} else {
    console.log(hours + ":" + mins);
}