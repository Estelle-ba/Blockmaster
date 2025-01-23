public class rules { // Définition de la classe englobante

    //display of rules
        //system to leave the page :
        //if the player clicks on key, the page closes
            //otherwise the page remains


    // Définition de la méthode rules_display

    //String choiceF =

    public static void rules_display() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("-------------------------------- RULES ---------------------------------");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                      Welcome to Destruct Chess");
        System.out.println(" The rules of the game are simple:");
        System.out.println(" ");
        System.out.println(" 1. A player cannot destroy an occupied or already destroyed square.");
        System.out.println(" 2. A player cannot occupy a destroyed square or a square already occupied.");
        System.out.println(" 3. A player blocked during a turn is declared a loser.");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("              Press any key to return to the main menu");
        System.out.println("------------------------------------------------------------------------");

        try {
            System.in.read();
        } catch (Exception e) {
            Menu.mainMenu("");
        }
    }
}
