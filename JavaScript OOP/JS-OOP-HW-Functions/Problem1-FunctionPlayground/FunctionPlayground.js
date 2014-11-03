/**
 * Created by atanas2d on 14-11-1.
 */
function argumentLess() {
    console.log("This function contains " + arguments.length + " arguments.");
    for (var i = 0; i < arguments.length; i++) {
        var argumentType = typeof arguments[i];
        console.log("Argument " + (i+1) + " is of type: " + argumentType);
        console.log(this);
    }
    console.log("End of report.");
}

var objectFunction = function(){
    var obj = {};
    return obj;
};

var sampleFunction = function() {
    argumentLess(objectFunction());
}

argumentLess(sampleFunction());
argumentLess(sampleFunction(), 123);
argumentLess(this);
argumentLess(sampleFunction());
argumentLess.call(null, "Nasko", this);
argumentLess.apply(null,[1,2,3,4,"Hi"]);

sampleFunction();