public class TicTacToe {
    // Variables
    private String name;
    private int Wins;
    private int Losses;
    private int Ties;
    private int Streak;
    private char[][] Grid;

    //Default Constructor
    public TicTacToe() {
        name = null;
        Wins = 0;
        Losses = 0;
        Ties = 0;
        Streak = 0;
        Grid = new char[3][3]; //This is how you declare a 2d char array
    }

}
