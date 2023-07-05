const tictactoe = {

    calculateWinner: function(moves) {

        let isWinner = false;
        let whoWon = "";
        let winningMoves = [];

        let status = moves[0] + moves[1] + moves[2];

        let results = {isWinner, whoWon, winningMoves};

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [0, 1, 2];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[3] + moves[4] + moves[5];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [3, 4, 5];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[6] + moves[7] + moves[8];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [6, 7, 8];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[0] + moves[3] + moves[6];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [0, 3, 6];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[1] + moves[4] + moves[7];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [1, 4, 7];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[2] + moves[5] + moves[8];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [2, 5, 8];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[0] + moves[4] + moves[8];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [0, 4, 8];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        status = moves[2] + moves[4] + moves[6];

        if (status == "OOO" || status == "XXX" ){
            whoWon = moves[0];
            isWinner = true;
            winningMoves = [2, 4, 6];
            results = {whoWon, isWinner, winningMoves};
            return results;
        }

        return results;
    },

    bar: function() {

    }
};