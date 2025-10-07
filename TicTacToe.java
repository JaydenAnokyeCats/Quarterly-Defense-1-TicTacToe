public class TicTacToe {
    // Variables
    private String name;
    private int wins;
    private int losses;
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
    }

    //Mutators
}
