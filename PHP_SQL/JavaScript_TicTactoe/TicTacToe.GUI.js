"use strict";

(function (fCalculateWinner) {
    const tds = [... document.querySelectorAll("#game tbody td")];
    const btnReset = document.getElementById("reset");
    const message = document.getElementById("message");
    let isX = false;
    
    let clear = function() {
    
        message.innerHTML = "";
    
        tds.forEach((element,index) => {
            element.innerHTML = index;
            element.classList.remove("winner");
        });
    };
    
    clear();
    
    let highLight = function(winningCombo) {
    
            winningCombo.forEach(e => {
                tds[e].classList.add("winner");
            });
    };
    
    btnReset.onclick = clear;
    
    let nextMove = function() {
    
        let currentValue = this.innerHTML;
        let isLegalMove = currentValue.indexOf("X") + currentValue.indexOf("O") == -2;
    
        message.innerHTML = "";
        
        if (isLegalMove) {
            this.innerHTML = isX ? "X": "O";
            isX = !isX;
        }
        else {
            message.innerHTML = "Illegal move was attempted!!!";
        }

        let moves = tds.map(e => e.innerHTML);

        let status = fCalculateWinner(moves);


        if (status.isWinner){
            highLight(status.winningMoves);
            message.innerHTML = "You are a winner " + status.winningMoves;
        }
        console.log({status});
    } 
    
    tds.forEach( e => e.onclick = nextMove);
})(tictactoe.calculateWinner );
