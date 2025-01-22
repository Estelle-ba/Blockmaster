

// Affichage des règles
    // En-tête décoratif avec "RULES"
    // Affichage des règles du jeu
        // Message pour revenir au menu

// Système pour quitter la page
    // Attendre une touche
        // Revenir au menu après la touche
    // Afficher une erreur si problème



public class rules {
    public static void rules_display() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*-*-*-*-*-*-*-*RULES*-*-*-*-*-*-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Welcome to [name]");
        System.out.println("The rules of the game are simple:");
        System.out.println("Rule number 1: A player cannot destroy an occupied or already destroyed square.");
        System.out.println("Rule number 2: A player cannot occupy a destroyed square or a square already occupied.");
        System.out.println("Rule number 3: A player blocked during a turn is declared a loser.");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Press any key to return to the main menu.");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        try {
            System.in.read(); // Attend une pression sur n'importe quelle touche
            Menu.mainMenu(""); // Retour au menu principal après l'entrée
        } catch (Exception e) {
            e.printStackTrace(); // Affiche une erreur en cas de problème
        }
    }
}

