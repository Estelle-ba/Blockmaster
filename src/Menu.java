import java.util.Scanner;

/**
 * Represents the main menu of the Destruct Chess game.
 * Provides options for starting a game, viewing scores, reading rules, or exiting.
 */
public class Menu {

    /**
     * Scanner used to read user input from the console.
     */
    public static final Scanner entry = new Scanner(System.in); // Method to get the user's input

    /**
     * Exits the game by displaying a farewell message and terminating the program.
     */
    public static void exitGame() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("         Destruct Chess* is closing, thank you for playing !");
        System.out.println("         Credits : Draxan LT, Thiméo O, Estelle B, Shayan C");
        System.out.println("------------------------------------------------------------------------");
        System.exit(0);
    }

    /**
     * Displays the main menu and processes user input to navigate through the game's options.
     *
     * @param choiceM the initial user input representing their menu selection
     */
    public static void mainMenu(String choiceM) {
        // Main Menu Banner
        System.out.println("------------------------------------------------------------------------");
        System.out.println("  ◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤————  Destruct Chess*  ————◥◣◥◣◥◣◥◣◥◣◥◣◥◣◥");
        System.out.println("------------------------------------------------------------------------");
        // Description
        System.out.println("Destruct Chess is a game where you have to click on specific places ");
        System.out.println("to block your opponents in order to win !");
        System.out.println("------------------------------------------------------------------------");

        while (!choiceM.equals("PLAY") && !choiceM.equals("play")
                && !choiceM.equals("RULES") && !choiceM.equals("rules")
                && !choiceM.equals("QUIT") && !choiceM.equals("quit")
                && !choiceM.equals("SCORE") && !choiceM.equals("score")) {
            // When you write down something invalid
            if (choiceM != "") {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                System.out.println("------------------------------------------------------------------------");
            }
            // Choose what to do
            System.out.println("- Write down what you want to do : -------------------------------------");
            System.out.println("⌈       PLAY = Launch a party       |       SCORE = Go to score page   ⌉");
            System.out.println("⌊       RULES = See the rules       |       QUIT = Stop the game       ⌋");
            System.out.println("------------------------------------------------------------------------");
            // Write down a new choice
            if (entry.hasNextLine()) {
                choiceM = entry.nextLine();
            }
        }
        if (choiceM.equals("PLAY") || choiceM.equals("play")) {
            // To go to the party option before launching a party
            gameboard board = new gameboard();
            player[] list_player = game.start_party(board);
            byte number_player = 0;
            boolean RR = false;

            game.turns(board, list_player, number_player, RR);
        } else if (choiceM.equals("SCORE") || choiceM.equals("score")) {
            // To go to the score page
            Scores.scorePageDisplay();

        } else if (choiceM.equals("RULES") || choiceM.equals("rules")) {
            // To go to the rules of the game
            rules.rules_display();

        } else if (choiceM.equals("QUIT") || choiceM.equals("quit")){
            // To exit the program
            exitGame();
        }
    }
}