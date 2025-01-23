import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreSorter {

    // Méthode pour lire les scores à partir d'un fichier
    public ArrayList<PlayerScore> readScores(String filePath) {
        ArrayList<PlayerScore> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Supposons que le fichier est au format "Nom, Score"
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int score;
                    try {
                        score = Integer.parseInt(parts[1].trim());
                        scores.add(new PlayerScore(name, score));
                    } catch (NumberFormatException e) {
                        System.err.println("Score non valide : " + parts[1]);
                    }
                } else {
                    System.err.println("Ligne mal formatée : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            return null;
        }
        return scores;
    }

    // Méthode pour trier les scores par ordre croissant
    public ArrayList<PlayerScore> sortScoresAscending(ArrayList<PlayerScore> scores) {
        Collections.sort(scores, Comparator.comparingInt(PlayerScore::getScore));
        return scores;
    }

    // Méthode pour trier les scores par ordre décroissant
    public ArrayList<PlayerScore> sortScoresDescending(ArrayList<PlayerScore> scores) {
        Collections.sort(scores, Comparator.comparingInt(PlayerScore::getScore).reversed());
        return scores;
    }

    // Méthode pour afficher les scores
    public void printScores(ArrayList<PlayerScore> scores) {
        for (PlayerScore ps : scores) {
            System.out.println(ps);
        }
    }

    // Classe interne pour stocker les scores
    public static class PlayerScore {
        private final String name;
        private final int score;

        public PlayerScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + " - " + score;
        }
    }
}