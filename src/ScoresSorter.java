import java.util.List;

public class ScoresSorter {

    // Sort from smallest to largest
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

    // Sort from largest to smallest
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