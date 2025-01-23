import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scores {

    public static boolean sortBy = true;

    public static List<String[]> loadPlayerFile(String filename) {
        List<String[]> players = new ArrayList<>();
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

    public static void displayScores(String filename, boolean sortBy) {
        List<String[]> players = loadPlayerFile(filename);

        ScoresSorter.sortDesc(players);

        List<String[]> topPlayers = players.subList(0, Math.min(players.size(), 10));

        if (sortBy) {
            ScoresSorter.sortAsc(topPlayers);
        }

        System.out.println("Top 10 scores :");
        for (int i = 0; i < topPlayers.size(); i++) {
            String[] player = topPlayers.get(i);
            System.out.println((i + 1) + ". Pseudo : " + player[0] + ", Score : " + player[1]);
        }
    }

    public static void scorePageDisplay() {

        String choiceS = "";

        System.out.println("------------------------------------------------------------------------");
        System.out.println("-------------------------------- SCORE ---------------------------------");
        System.out.println("------------------------------------------------------------------------");
        // Place where the 10 best scores will be print

        displayScores(game.SCORES_FILE, sortBy);

        System.out.println("------------------------------------------------------------------------");

        while (!choiceS.equals("ACS") && !choiceS.equals("acs")
                && !choiceS.equals("DESC") && !choiceS.equals("desc")
                && !choiceS.equals("QUIT") && !choiceS.equals("quit")
                && !choiceS.equals("MENU") && !choiceS.equals("menu")) {
            // When you write down something invalid
            if (choiceS != "") {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                System.out.println("------------------------------------------------------------------------");
            }
            // Choose what to do
            System.out.println("- Write down what you want to do : -------------------------------------");
            System.out.println("⌈       ACS = Sort S ↗ B            |       DESC = Sort B ↘ S          ⌉");
            System.out.println("⌊       MENU = Return to menu       |       QUIT = Stop the game       ⌋");
            System.out.println("------------------------------------------------------------------------");
            // Write down a new choice
            if (Menu.entry.hasNextLine()) {
                choiceS = Menu.entry.nextLine();
            }
        }
        if (choiceS.equals("ACS") || choiceS.equals("acs")) {
            // To go to the score page
            sortBy = true;
            scorePageDisplay();

        } else if (choiceS.equals("DESC") || choiceS.equals("desc")) {
            // To go to the score page

            sortBy = false;
            Scores.scorePageDisplay();

        } else if (choiceS.equals("MENU") || choiceS.equals("menu")) {
            // To go to the rules of the game
            Menu.mainMenu("");


        } else if (choiceS.equals("QUIT") || choiceS.equals("quit")){
            // To exit the program
            Menu.exitGame();
        }
    }
}