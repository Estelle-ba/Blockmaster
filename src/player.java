import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class player {
    // Attributs
    int[] position = new int[2];
    boolean playing = false;
    String sign = "Y";
    String name = "Yname";
    int score = 0; // score initialisé à 0

    // Constructeur
    player() {
    }

    // Méthodes
    public void play() {
        playing = true;
    }

    public void changePosition(int x, int y) {
        position[0] = y;
        position[1] = x;
    }

    public void incrementScore() {
        score++; // Ajouter un point au score
    }

    public void displayScore() {
        System.out.println(name + " a " + score + " point(s).");
    }

    // Méthode pour enregistrer le score dans un fichier texte
    public void saveScoreToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true))) {
            // Append le score du joueur dans le fichier
            writer.write(name + " : " + score + " point(s)\n");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement du score : " + e.getMessage());
        }
    }
}
