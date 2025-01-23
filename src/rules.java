/**
 * Provides functionality to display the rules of the Destruct Chess game.
 * The class includes methods to show the rules and handle user navigation
 * back to the main menu or exiting the game.
 */
public class rules {

    /**
     * Displays the rules of the Destruct Chess game and provides navigation options.
     */
    public static void rules_display() {
        String choiceS = "";
        System.out.println("------------------------------------------------------------------------");
        System.out.println("-------------------------------- RULES ---------------------------------");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                        Welcome to Block Master");
        System.out.println(" The rules of the game are simple:");
        System.out.println(" ");
        System.out.println(" 1. A player cannot destroy an occupied or already destroyed square.");
        System.out.println(" 2. A player cannot occupy a destroyed square or a square already occupied.");
        System.out.println(" 3. A player blocked during a turn is declared a loser.");
        System.out.println("------------------------------------------------------------------------");

        while (!choiceS.equals("QUIT") && !choiceS.equals("quit")
                && !choiceS.equals("MENU") && !choiceS.equals("menu")) {
            // When you write down something invalid
            if (choiceS != "") {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                System.out.println("------------------------------------------------------------------------");
            }
            // Choose what to do
            System.out.println("- Write down what you want to do : -------------------------------------");
            System.out.println("[       MENU = Return to menu       |       QUIT = Stop the game       ]");
            System.out.println("------------------------------------------------------------------------");
            // Write down a new choice
            if (Menu.entry.hasNextLine()) {
                choiceS = Menu.entry.nextLine();
            }
        }
        if (choiceS.equals("MENU") || choiceS.equals("menu")) {
            // To go back to the menu
            Menu.mainMenu("");


        } else if (choiceS.equals("QUIT") || choiceS.equals("quit")){
            // To exit the program
            Menu.exitGame();
        }
    }
}
