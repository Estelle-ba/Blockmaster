import java.util.List;

/**
 * Utility class for sorting player scores and names.
 */
public class ScoresSorter {

    /**
     * Sorts a list of players in ascending order based on their scores.
     * @param players a list of players where each player is represented.
     */
    public static void sortAsc(List<String[]> players) {
        for (int i = 1; i < players.size(); i++) {
            String[] current = players.get(i);
            int score = Integer.parseInt(current[1]);
            String pseudo = current[0];
            int j = i - 1;

            while (j >= 0) {
                int compareScore = Integer.compare(score, Integer.parseInt(players.get(j)[1]));
                int comparePseudo = pseudo.compareTo(players.get(j)[0]);

                if (compareScore > 0 || (compareScore == 0 && comparePseudo >= 0)) {
                    break;
                }
                players.set(j + 1, players.get(j));
                j--;
            }
            players.set(j + 1, current);
        }
    }

    /**
     * Sorts a list of players in descending order based on their scores.
     * @param players a list of players where each player is represented.
     */
    public static void sortDesc(List<String[]> players) {
        for (int i = 1; i < players.size(); i++) {
            String[] current = players.get(i);
            int score = Integer.parseInt(current[1]);
            String pseudo = current[0];
            int j = i - 1;

            while (j >= 0) {
                int compareScore = Integer.compare(score, Integer.parseInt(players.get(j)[1]));
                int comparePseudo = pseudo.compareTo(players.get(j)[0]);

                if (compareScore < 0 || (compareScore == 0 && comparePseudo <= 0)) {
                    break;
                }
                players.set(j + 1, players.get(j));
                j--;
            }
            players.set(j + 1, current);
        }
    }
}