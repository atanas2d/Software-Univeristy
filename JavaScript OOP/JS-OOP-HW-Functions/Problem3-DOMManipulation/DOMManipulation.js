/**
 * Created by atanas2d on 14-11-3.
 */
var DOMManipulationModule = function() {

    function appendChild() {

        var childToAppend = arguments[0];
        var parentElement = document.querySelector(arguments[1]);

        parentElement.appendChild(childToAppend);
    }

    function removeChild() {

        var parentElement = document.querySelector(arguments[0]);
        var childToAppend = parentElement.querySelector(arguments[1]);

        parentElement.removeChild(childToAppend);
    }

    function addHandler() {

        var elements = document.querySelectorAll(arguments[0]);
        var event = arguments[1];
        var expression = arguments[2];

        for (var i = 0; i < elements.length; i++) {
            elements[i].addEventListener(event, expression);
        }
    }

    function retrieveElements() {

        var elements = document.querySelectorAll(arguments[0]);

        return elements;
    }

    var self = {
        appendChild: appendChild,
        removeChild: removeChild,
        addHandler: addHandler,
        retrieveElements: retrieveElements
    }

    return self;
}();