import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scores {

    public static List<String[]> loadPlayerFile(String filename) {
        List<String[]> players = new ArrayList<>(); //déclare la liste des joeurs
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                players.add(line.split(","));
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return players;
    }

    public static void writePlayerFile(List<String[]> players, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String[] player : players) {
                writer.write(player[0] + "," + player[1]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
    }

    public static void updatePlayerScore(String winnerName, String filename) {
        List<String[]> players = loadPlayerFile(filename);
        boolean found = false;

        for (String[] player : players) {
            if (player[0].equals(winnerName)) {
                player[1] = String.valueOf(Integer.parseInt(player[1]) + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            players.add(new String[]{winnerName, "1"});
        }

        writePlayerFile(players, filename);
    }

    public static void displayScores(String filename) {
        List<String[]> players = loadPlayerFile(filename);
        System.out.println("Scores actuels :");
        for (String[] player : players) {
            System.out.println("Pseudo : " + player[0] + ", Score : " + player[1]);
        }
    }
}
