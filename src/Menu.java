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

        while (!choiceF.equals("PLAY") && !choiceF.equals("RULES") && !choiceF.equals("QUIT")) {
            // When you write down something invalid
            if (choiceF != "") {
                System.out.println("⚠ Incorrect entry (please follow instructions MOTHERFUCKER) ⚠");
                System.out.println("------------------------------------------------------------------------");
            }
            // Choose what to do
            System.out.println("Write down what you want to do :");
            System.out.println("[ PLAY = Launch a party | RULES = See the rules | QUIT = Stop the game ]");
            System.out.println("------------------------------------------------------------------------");
            // Write down a new choice
            if (entry.hasNextLine()) {
                choiceF = entry.nextLine();
            }
        }
        // To go to the party option before launching a party
        if (choiceF.equals("PLAY")) {
            System.out.println("Placeholder playOptions()"); // [X][X][X] Temporary [X][X][X]

            gameboard obj = new gameboard();

            //  creating player objects
            player player_1 = new player();
            player player_2 = new player();
            player player_3 = new player();
            player player_4 = new player();

            //Change player attributes
            player_2.sign="X";
            player_2.name="Xname";

            obj.Create(player_1, player_2, player_3, player_4);

            while(obj.nb_player > 1) {
                obj.play(player_1);
                obj.play(player_2);
            }

        // To go to the rules of the game
        } else if (choiceF.equals("RULES")) {
            rules.rules_display();
        // To exit the program
        } else {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Destruct Chess* is closing, thank you for playing !");
            System.out.println("Credits : Draxan LT, Thiméo O, Estelle B, Shayan C");
            System.out.println("------------------------------------------------------------------------");
            System.exit(0);
        }

    }
}