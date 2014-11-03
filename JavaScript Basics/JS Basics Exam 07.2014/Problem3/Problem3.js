/**
 * Created by atanasWin on 28/7/2014.
 */
function solve (input) {
    // print <table>
    console.log(input[0]);
    // print table header
    console.log(input[1]);
    // get table data:
    var dataArr = input.splice(2, input.length - 3);
    // get the prices:
    var prices = [];
    for (var i = 0; i < dataArr.length; i++) {
        var price = dataArr[i].split("<td>");
        price = price[2].replace("</td>","");
        price = Number(price);
        prices.push([price,i]);
    }
    // sort prices[][]
    prices.sort(function(a, b){return a[0]-b[0]});
    for (var i = 0; i < prices.length; i++) {
        console.log(dataArr[prices[i][1]]);
    }

    // print </table>
    console.log(input[input.length - 1]);
}