public class TicTacToe {
    // Variables
    private String name;
    private double wins;
    private int ties;
    private char[][] Grid;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private char currentPlayer = ' ';

    //Default Constructor
    public TicTacToe() {
        name = null;
        wins = 0;
        ties = 0;
        Grid = new char[3][3]; //This is how you declare a 2d char array. Goes by Row, Column
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Grid[i][j] = ' ';
            }
        }
    }

    //Parameter Constructor
    public TicTacToe(String username) {
        name = username;
        wins = 0;
        ties = 0;
        Grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Grid[i][j] = ' ';
            }
        }
    }

    // Methods

    //Accessors
    public void getStats() {
        System.out.printf("Wins: %s", wins);
        System.out.printf("\nTies: %s", ties);
    }

    //Mutators
    public void addWins() {
        wins += 1;
    }

    public void addTies() {
        ties += 1;
    }


    public void setCurrentPlayer(char player){
        currentPlayer = player;
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }


    public void currentPlayer(char playerType) {
        if (playerType == PLAYER_X) {
            this.currentPlayer = PLAYER_X;
        } else if (playerType == PLAYER_O) {
            this.currentPlayer = PLAYER_O;
        }
    }



    public void switchPlayer() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((Grid[i][0] == currentPlayer && Grid[i][1] == currentPlayer && Grid[i][2] == currentPlayer) ||
                    (Grid[0][i] == currentPlayer && Grid[1][i] == currentPlayer && Grid[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((Grid[0][0] == currentPlayer && Grid[1][1] == currentPlayer && Grid[2][2] == currentPlayer) ||
                (Grid[0][2] == currentPlayer && Grid[1][1] == currentPlayer && Grid[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //Board Printing Method
    public String printBoard() {
        StringBuilder sbBoard = new StringBuilder();

        /* StringBuilder is a more effective method when dealing with strings.
        For example, the method im using to connect multiple strings, append, is
        a better way over simple concatenation.
        Something I learned during my JUnit drills.
         */

        for (var i = 0; i < 3; i++) {
            sbBoard.append("|---|---|---|\n");
            for (var j = 0; j < 3; j++) {
                sbBoard.append("| " + Grid[i][j] + " ");
            }
            sbBoard.append("|\n");
        }

        return sbBoard.toString();
    }

    // Board Placement Method
    public String placementBoard(int row, int column) {
        if (row >= 0 && row < 3 && column >= 0 && column < 3) {
            if (Grid[row][column] == ' ' || Grid[row][column] == '\u0000') {
                Grid[row][column] = this.currentPlayer;
                return "Placed.";
            } else {
                return "This spot is already taken. Choose another spot.";
            }
        } else {
            return "Invalid placement. Choose row and column between 0 and 2.";
        }
    }
}
