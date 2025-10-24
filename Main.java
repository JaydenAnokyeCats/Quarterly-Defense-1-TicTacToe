import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe! Type in your preferred username:");
        String playerName = scanner.nextLine();

        TicTacToe game = new TicTacToe(playerName);
        System.out.println("tic tac toe testing\n");
        boolean mainLoop = true;
        while (mainLoop) {
            System.out.println("Here is the menu, pick an option:");
            System.out.println("1. Play Game");
            System.out.println("2. View Stats");
            System.out.println("3. Exit");
            int menuChoice = scanner.nextInt();

            if (menuChoice == 1) {

                boolean b = true;
                while (b) {
                    System.out.println("Starting Game...");
                    System.out.println("You will be playing as X's. The board is 3x3, with rows and columns numbered 0 to 2.");
                    System.out.println("(e.g., top-left is row 0, column 0; bottom-right is row 2, column 2).");
                    System.out.println("Take turns placing your X's and O's. First to get 3 in a row wins!");

                    game.currentPlayer('X');

                    boolean gameOn = true;
                    while (gameOn) {
                        System.out.println("What player? (X or O)");
                        char player1 = scanner.next().toUpperCase().charAt(0);
                        game.setCurrentPlayer(player1);

                        System.out.println(game.printBoard());
                        System.out.println("Player " + game.getCurrentPlayer() + "'s turn. Enter row (0, 1, or 2):");
                        int row = scanner.nextInt();
                        System.out.println("Now enter a column (0, 1, or 2):");
                        int col = scanner.nextInt();

                        String result = game.placementBoard(row, col);
                        System.out.println(result);

                        if (result.equals("Placed.")) {
                            if (game.checkWin()) {
                                System.out.println(game.printBoard());
                                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                                game.addWins();
                                gameOn = false;
                            } else if (game.checkTie()) {
                                System.out.println(game.printBoard());
                                System.out.println("It's a tie!");
                                game.addTies();
                                gameOn = false;
                            } else {
                                game.switchPlayer();
                            }
                        }
                    }


                    System.out.println("Play again? (yes/no)");
                    String again = scanner.next().toLowerCase();
                    if (!again.equals("yes")) {
                        b = false;
                    }
                }

            } else if (menuChoice == 2) {
                System.out.println("\nViewing Stats...\n");
                game.getStats();
            } else if (menuChoice == 3) {
                System.out.println("Exiting...");
                mainLoop = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
