public class TicTacToe {
    // Variables
    private String name;
    private int winsX;
    private int winsO;
    private int ties;
    private char[][] Grid;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private char currentPlayer = ' ';

    //Default Constructor
    public TicTacToe() {
        name = null;
        winsX = 0;
        winsO = 0;
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
        winsX = 0;
        winsO = 0;
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
        System.out.printf("Wins (X): %s", winsX);
        System.out.printf("\nWins (O): %s", winsO + "\n");
        System.out.printf("Ties: %s", ties + "\n");
    }

    //Mutators
    public void addWinsX() {
        winsX += 1;
    }
    public void addWinsO() {
        winsO += 1;
    }

    public void addTies() {
        ties += 1;
    }


    // Sets the current player for the game
    public void setCurrentPlayer(char player) {
        if (player == PLAYER_X) {
            currentPlayer = PLAYER_X;
        } else if (player == PLAYER_O) {
            currentPlayer = PLAYER_O;
        }
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public String getName(){
        return name;
    }


    public void switchPlayer() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
    }

    public boolean checkWin() {
             /*
             Vertical and Horizontal Win checking. Reason why 'j' isn't here despite it representing the column,
             is because of the use of the for loop. I represents the column or row, and checks for any 3 way match.
             If there is none, increment until i is less than 3 (since the rows and columns go by 0-2)
             */
        for (int i = 0; i < 3; i++) {
            if ((Grid[i][0] == currentPlayer && Grid[i][1] == currentPlayer && Grid[i][2] == currentPlayer) ||
                    (Grid[0][i] == currentPlayer && Grid[1][i] == currentPlayer && Grid[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Diagonal Win checking
        if ((Grid[0][0] == currentPlayer && Grid[1][1] == currentPlayer && Grid[2][2] == currentPlayer) ||
                (Grid[0][2] == currentPlayer && Grid[1][1] == currentPlayer && Grid[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public boolean checkTie() {
        // Goes through the 3x3 grid and checks if there are any white spaces left. If not, return true.
        // Returning true means the board has been filled without a match, otherwise known as a tie.
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

    // Board Reset Method
    public void resetBoard(){
        Grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Grid[i][j] = ' ';
            }
        }
    }


    // Extras


    // Starting text, just describes how the game works
    public void printInstruct(){
        System.out.println("Starting Game...");
        System.out.println("The board is 3x3, with rows and columns numbered 0 to 2.");
        System.out.println("(e.g., top-left is row 0, column 0; bottom-right is row 2, column 2).\n");
        System.out.println("Take turns placing your X's and O's. First to get 3 in a row wins!\n");

        System.out.print("Do you want to manually select your player, or leave it up to chance? (Type 'manual' or 'chance'): ");
    }


}

