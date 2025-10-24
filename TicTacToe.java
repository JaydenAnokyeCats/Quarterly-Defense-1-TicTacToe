public class TicTacToe {
    // Variables
    private String name;
    private double wins;
    private double losses;
    private int ties;
    private int highscore;
    private char[][] Grid;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private char currentPlayer = ' ';

    //Default Constructor
    public TicTacToe() {
        name = null;
        wins = 0;
        losses = 0;
        ties = 0;
        highscore = 0;
        // Stats set to zero in default constructor
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
        System.out.printf("\nLosses: %s", losses);
        System.out.printf("\nTies: %s", ties);
        System.out.printf("\nHighest Streak: %s", highscore);
        System.out.printf("\nWin/Lose Ratio: %s", wins/losses);
    }

    //Mutators
    //These mutators call whenever the player wins, loses, or ties.
    public void addWins() {
        wins += 1;
    }

    public void addLoss() {
        losses += 1;
    }

    public void addTies() {
        ties += 1;
    }

    //Calls whenever the player gets a new high score
    public int getHighscore(int highscore) {
        this.highscore = highscore;
        return highscore;
    }

    // Sets the current player for the game
    public void currentPlayer(char playerType) { 
        if (playerType == PLAYER_X) {
            this.currentPlayer = PLAYER_X;
        } else if (playerType == PLAYER_O) {
            this.currentPlayer = PLAYER_O; 
        }
        // No return statement as the method is void
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
                sbBoard.append("| " + Grid[i][j] + " "); // Initializes empty spaces on the board
                
            }
            sbBoard.append("|\n");
        }

        return sbBoard.toString();
    }


    // Board Placement Method
    public String placementBoard(int row, int column) {
        if (row >= 0 && row < 3 && column >= 0 && column < 3) {
            if (Grid[row][column] == ' ' || Grid[row][column] == '\u0000') { // Check if the spot is empty 
                Grid[row][column] = this.currentPlayer; // Use the instance variable currentPlayer
                return "Placed.";
            } else {
                return "This spot is already taken. Choose another spot.";
            }
        } else {
            return "Invalid placement. Choose row and column between 0 and 2.";
        }
    }

}
