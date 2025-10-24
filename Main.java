import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe! Type in your preferred username:");
        //String playerName = scanner.nextLine();

        TicTacToe game = new TicTacToe();
        System.out.println("tic tac toe testing\n");

        System.out.println("Here is the menu, pick an option:");
        System.out.println("1. Play Game");
        System.out.println("2. View Stats");
        System.out.println("3. Exit");
        int menuChoice = scanner.nextInt();

        if (menuChoice == 1) {
            System.out.println("Starting Game...");
            System.out.println("You will be playing as X's. The board is 3x3, with rows and columns numbered 0 to 2.");
            System.out.println("(e.g., top-left is row 0, column 0; bottom-right is row 2, column 2).");
            System.out.println("Take turns placing your X's and O's. First to get 3 in a row wins!");
            // Game logic would go here
            // System.out.println(game.createBoard());
            System.out.println(game.printBoard());
            System.out.println("Player X's turn. Enter row (0, 1, or 2):");
            int row = scanner.nextInt();
            System.out.println("Now enter a column (0, 1, or 2):");
            int col = scanner.nextInt();
            
            game.currentPlayer('X');
            game.placementBoard(row,col);
            
            System.out.println(game.printBoard());


        } else if (menuChoice == 2) {
            System.out.println("\nViewing Stats...\n");
            game.getStats();
        } else if (menuChoice == 3) {
            System.out.println("Exiting...");
            
        } else {
            System.out.println("Invalid choice. Please try again.");
        }


        
        
        
      



    }
}