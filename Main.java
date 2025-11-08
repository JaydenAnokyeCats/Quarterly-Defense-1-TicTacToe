import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



        System.out.println("Welcome to Tic Tac Toe! Type in your preferred username:");
        String playerName = scanner.nextLine();


        TicTacToe game = new TicTacToe(playerName);


        System.out.println("This is a test build of tic tac toe. will be removed when the project is in a finished state.\n");
        boolean mainLoop = true;
        while (mainLoop) {
            System.out.println("\nHere is the menu, pick an option:");
            System.out.println("1. Play Game");
            System.out.println("2. View Stats");
            System.out.println("3. Exit");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();


            if (menuChoice == 1) {
                boolean gameLoop = true;

                game.printInstruct();
                /* Everything was getting crowded within my main class, making
                it hard for me to work. Decided to split the printed stream of
                text into my TicTacToe class for better construction.
                */
                String playerChoice = scanner.nextLine();

                /* equalsIgnoreCase compares two strings together while ignoring any
                capital instances. Meaning it just checks to see if the value in the first
                string is equal to that of the second.
                */
                if (playerChoice.equalsIgnoreCase("manual")) {
                    System.out.print("Choose your player (X or O): ");

                    String player = scanner.nextLine().toUpperCase();


                    while (player.isEmpty() || (!player.equals("X") && !player.equals("O"))) {
                        System.out.print("Invalid choice. Please choose X or O: ");
                        player = scanner.nextLine().toUpperCase();
                    }


                    char playerChar = player.charAt(0);
                    game.setCurrentPlayer(playerChar);

                } else if (playerChoice.equalsIgnoreCase("chance")) {
                    if (random.nextInt(2) == 0) {
                        game.setCurrentPlayer('X');
                    } else {
                        game.setCurrentPlayer('O');
                    }
                } else {
                    System.out.println("Not an option. Defaulting to random selection.");
                    if (random.nextInt(2) == 0) {
                        game.setCurrentPlayer('X');
                    } else {
                        game.setCurrentPlayer('O');
                    }
                }


                // Game logic here
                System.out.println(game.printBoard());
                while (gameLoop) {
                    
                    System.out.println("Player " + game.getCurrentPlayer() + "'s turn. Enter your row (0, 1, or 2):");
                    int row = scanner.nextInt();
                    System.out.println("Now enter a column (0, 1, or 2):");
                    int col = scanner.nextInt();

                    String result = game.placementBoard(row, col);
                    System.out.println(result + "\n");
                    Thread.sleep(500);

                    System.out.println(game.printBoard());


                    if (result.equals("Placed.")) {
                        if (game.checkWin()) {

                            System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                            if (game.getCurrentPlayer() == 'X') {
                                game.addWinsX();
                            }else{
                                game.addWinsO();
                            }
                            Thread.sleep(2000);
                            game.resetBoard();
                            gameLoop = false;
                        } else if (game.checkTie()) {

                            System.out.println("Tied game! Nobody wins.");
                            game.addTies();
                            Thread.sleep(2000);
                            game.resetBoard();
                            gameLoop = false;
                        } else {
                            game.switchPlayer();
                        }
                    }
                }
                    //Try U+00D8 later
            } else if (menuChoice == 2) {
                System.out.printf("\nViewing Stats for %s...\n", game.getName());
                game.getStats();
            } else if (menuChoice == 3) {
                System.out.println("Exiting...");
                mainLoop = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }


        }
        scanner.close();
    }
}
