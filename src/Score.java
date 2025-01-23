
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {

    public void incrementScore(player player, player score) {
        player.score++; // Ajouter un point au score
    }

    public void displayScore(player player, player score) {
        System.out.println(player + " a " + score + " point(s).");
    }

    public void saveScoreToFile(player name, player score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true))) {
            // Append le score du joueur dans le fichier
            writer.write(name + " : " + score + " point(s)\n");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement du score : " + e.getMessage());
        }
    }

    public String lastEdited(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            long last_Edited = file.lastModified();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return date.format(new Date(last_Edited));
        } else {
            return "⚠ The file doesn't exist ⚠";
        }
    }

    public boolean EditedLater(String filePath, Date comparisonDate) {
        File file = new File(filePath);
        if (file.exists()) {
            long last_Edited = file.lastModified();
            return last_Edited > comparisonDate.getTime();
        } else {
            System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
            return false;
        }
    }

    public static void score_display() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("-------------------------------- SCORE ---------------------------------");
        System.out.println("------------------------------------------------------------------------");
        // Place where the 10 best scores will be print



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

