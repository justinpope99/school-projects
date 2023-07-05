"use strict";

(function (citytech) {

    citytech.screen = citytech.screen || {};
    const querySelectorAll = "#screen-display > div";

    function clear() {
        let nodeSelections = document.querySelectorAll(querySelectorAll);
        let divSelectionArray = [...nodeSelections];

        divSelectionArray.forEach(element => {
            element.classList.remove("highLight");
        });

    }

    citytech.screen.highLightDiv = function (mode) {

        clear();

        let method = undefined;
        switch (mode) {
            case 'v':
            method = isVowel;
            break;
            case 'c':
                method = isConsonant;
                break;
            case 'a':
                method = isLetter;
                break;
            default :
                method = clear;
                break;    
        }

        let nodeSelections = document.querySelectorAll(querySelectorAll);
        let divSelectionArray = [...nodeSelections];

        divSelectionArray.filter( e => method(e.innerHTML))
                        .forEach(e => e.classList.add("highLight"));


    }

    function isVowel(text) {
        let pattern = /[AEIOUaeiou]/;
        let result = pattern.test(text);
        return result;
    }

    function isLetter(text) {
        let pattern = /[A-Za-z]/;
        let result = pattern.test(text);
        return result;
    }

    function isConsonant(text) {
        return !isVowel(text) && isLetter(text);
    }

}) (window.citytech = window.citytech || {});

