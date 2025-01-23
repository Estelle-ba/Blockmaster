import java.util.Scanner;

public class Menu {

    public static final Scanner entry = new Scanner(System.in); // Method to get the user's input

    // Global & necessary variables
    // ...

    /**
     * Function that displays the main menu in order to choose an option
     * @param choiceF as a string used to get what the user typed
     */
    public static void mainMenu(String choiceF) {
        // Main Menu Banner
        System.out.println("------------------------------------------------------------------------");
        System.out.println("  ◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤————  Destruct Chess*  ————◥◣◥◣◥◣◥◣◥◣◥◣◥◣◥");
        System.out.println("------------------------------------------------------------------------");
        // Description
        System.out.println("Destruct Chess is a game where you have to click on specific places ");
        System.out.println("to block your opponents in order to win !");
        System.out.println("------------------------------------------------------------------------");

        while (!choiceF.equals("PLAY") && !choiceF.equals("play")
                && !choiceF.equals("RULES") && !choiceF.equals("rules")
                && !choiceF.equals("QUIT") && !choiceF.equals("quit")
                && !choiceF.equals("SCORE") && !choiceF.equals("score")) {
            // When you write down something invalid
            if (choiceF != "") {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                System.out.println("------------------------------------------------------------------------");
            }
            // Choose what to do
            System.out.println("- Write down what you want to do : -------------------------------------");
            System.out.println("⌈       PLAY = Launch a party       |       SCORE = See the rules      ⌉");
            System.out.println("⌊       RULES = See the rules       |       QUIT = Stop the game       ⌋");
            System.out.println("------------------------------------------------------------------------");
            // Write down a new choice
            if (entry.hasNextLine()) {
                choiceF = entry.nextLine();
            }
        }
        // To go to the party option before launching a party
        if (choiceF.equals("PLAY") || choiceF.equals("play")) {

            gameboard board = new gameboard();
            player[] list_player = game.start_party(board);
            byte number_player = 0;
            boolean RR = false;

            game.turns(board, list_player, number_player, RR);
        } else if (choiceF.equals("SCORE") || choiceF.equals("score")) {
        // To go to the score page
            Score.score_display();


        } else if (choiceF.equals("RULES") || choiceF.equals("rules")) {
        // To go to the rules of the game
            rules.rules_display();

        // To exit the program
        } else if (choiceF.equals("QUIT") || choiceF.equals("quit")){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("         Destruct Chess* is closing, thank you for playing !");
            System.out.println("         Credits : Draxan LT, Thiméo O, Estelle B, Shayan C");
            System.out.println("------------------------------------------------------------------------");
            System.exit(0);
        }

    }
}