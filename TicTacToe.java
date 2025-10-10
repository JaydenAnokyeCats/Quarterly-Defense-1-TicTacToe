public class TicTacToe {
    // Variables
    private String name;
    private double wins;
    private double losses;
    private int ties;
    private int highscore;
    private char[][] Grid;

    //Default Constructor
    public TicTacToe() {
        name = null;
        wins = 0;
        losses = 0;
        ties = 0;
        highscore = 0;
        Grid = new char[3][3]; //This is how you declare a 2d char array. Goes by Row, Column
    }

    //Parameter Constructor
    public TicTacToe(String username) {
      name = username;
      // Stats set to zero in default constructor
    }

    // Methods

    //Accessors
    public void getStats() {
        System.out.printf("Wins: %s", wins);
        System.out.printf("Losses: %s", losses);
        System.out.printf("Ties: %s", ties);
        System.out.printf("Highest Streak: %s", highscore);
        System.out.printf("Win/Lose Ratio: %s", wins/losses);
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

    //Board Creation Method
    public String createBoard() {
        StringBuilder sbBoard = new StringBuilder();

        /* StringBuilder is a more effective method when dealing with strings.
        For example, the method im using to connect multiple strings, append, is
        a better way over simple concatenation.
        Something I learned during my JUnit drills.
         */
        var tileIndex = 0;
        for (var i = 0; i < 3; i++) {
            sbBoard.append("|---|---|---|\n");
            for (var j = 0; j < 3; j++) {
                if (j < 1){
                    sbBoard.append("| " + "1" + " | " + "1" + " | " + "1" + " |\n");
                }else{
                    System.out.println();
                }
            }
        }

        return sbBoard.toString();
    }

    // Board Placement Method
    public String placementBoard(int row, int column, char type) {
        char place = Grid[row][column];



        return null;
    }

}
