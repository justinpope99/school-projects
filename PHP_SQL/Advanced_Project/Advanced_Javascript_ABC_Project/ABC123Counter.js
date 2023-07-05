// Justin Pope

function abc(mode) {
    let abc = "abcdefghijklmnopqrstuvwxyz"

    if (mode == "A" || mode == 'Z')
        abc = abc.toUpperCase();

    abc = abc.split("");

    if (mode == 'Z' || mode == 'z')
        abc = abc.reverse();

    return abc;
}

function generateABC(modes) {
    let letters = modes.split("");
    let results = [];

    letters.forEach(e => {
        let alphaBets = abc(e);
        results.push(alphaBets);
    });

    return results.flat();
}

function highLight(pThis) {
    let highLight = pThis.dataset.highlight;
    console.log({highLight, dataSet: pThis.dataset});
    let highLightselected = document.getElementById("highLightselected");
    highLightselected.value = highLight;
    citytech.screen.highLightDiv(highLight);
}

function countFromRadio(pThis) {
    let mode = pThis.dataset.mode;
    console.log({dataSet: pThis.dataset});
    updatePage(mode);

    let abcGenerator = document.getElementById("abcGenerator");
    abcGenerator.value = mode;

    let highLight = document.getElementById("highLightselected").value;
    citytech.screen.highLightDiv(highLight)

}

function updatePage(mode) {
    let divABC = document.getElementById("screen-display");
    let results = generateABC(mode);
    console.log({results});

    divABC.innerHTML = "";

    let style = "abc";
    if (results.length > 53) {
        style = "abcS52";
    }
    else if (results.length < 30) {
        style = "abcS26";
    }

    let divCount = document.getElementById("rowCount");
    divCount.innerHTML = results.length;

    results.forEach( e=> {
        let newElement = document.createElement('div');
        newElement.innerHTML = e;
        newElement.classList.add(style);
        divABC.appendChild(newElement);
    });

}





