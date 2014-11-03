/**
 * Created by atanasWin on 27/7/2014.
 */

var doc = window.document;

function displayProperties(obj) {
    var resultDiv = document.getElementById("result");
    for (var key in obj) {
        resultDiv.innerHTML += key + "<br/>";
    }
}

displayProperties(doc);