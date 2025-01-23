import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to manage player scores stored in a file.
 * This class provides methods to load, update, and display scores,
 * as well as to manage file input/output operations.
 */
public class Scores {

    /**
     * Flag indicating the sorting order for scores.
     * true = ascending order, false = descending order.
     */
    public static boolean sortBy = true;

    /**
     * Loads player data from a specified file.
     * Each line in the file should follow the format: "name,score".
     *
     * @param filename the name of the file containing player data
     * @return a list of players, where each player is represented as a string array with their name and score
     * @throws IOException if the file cannot be read
     */
    public static List<String[]> loadPlayerFile(String filename) {
        List<String[]> players = new ArrayList<>(); // Initialize a list to store player data
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Read each line from the file until the end
            while ((line = reader.readLine()) != null) {
                players.add(line.split(",")); // Split each line into name and score, then add it to the list
            }
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage()); // Handle errors while reading the file
        }
        return players; // Return the list of players
    }

    /**
     * Writes player data to a specified file. This method overwrites the existing file content.
     *
     * @param players  the list of players to write, where each player is represented as a string array with their name and score
     * @param filename the name of the file to write the player data to
     * @throws IOException if the file cannot be written to
     */
    public static void writePlayerFile(List<String[]> players, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write each player's name and score back to the file
            for (String[] player : players) {
                writer.write(player[0] + "," + player[1]); // Format: name,score
                writer.newLine(); // Move to the next line
            }
        } catch (IOException e) {
            System.err.println("Error while writing to the file: " + e.getMessage()); // Handle errors while writing to the file
        }
    }

    /**
     * Updates the score of a specific player. If the player already exists in the file, their score is incremented.
     * If the player does not exist, they are added to the file with an initial score of 1.
     *
     * @param winnerName the name of the player who won
     * @param filename   the name of the file containing player data
     * @throws IOException if the file cannot be read or written to
     */
    public static void updatePlayerScore(String winnerName, String filename) {
        List<String[]> players = loadPlayerFile(filename); // Load current players and scores from the file
        boolean found = false; // Track if the winner is already in the file

        // Search for the winner in the existing player list
        for (String[] player : players) {
            if (player[0].equals(winnerName)) { // If the winner is found
                player[1] = String.valueOf(Integer.parseInt(player[1]) + 1); // Increment their score
                found = true; // Mark as found
                break; // Exit the loop early since the winner was found
            }
        }

        // If the winner is not found, add a new entry for them
        if (!found) {
            players.add(new String[]{winnerName, "1"}); // New player starts with a score of 1
        }

        writePlayerFile(players, filename); // Save the updated player list back to the file
    }

    /**
     * Displays the top player scores in the console. The scores can be sorted in ascending or descending order.
     *
     * @param filename the name of the file containing player data
     * @param sortBy   if true, sorts scores in ascending order; if false, sorts in descending order
     * @throws IOException if the file cannot be read
     */
    public static void displayScores(String filename, boolean sortBy) {
        List<String[]> players = loadPlayerFile(filename); // Load players and scores from the file

        ScoresSorter.sortDesc(players);

        List<String[]> topPlayers = players.subList(0, Math.min(players.size(), 10));

        if (sortBy) {
            ScoresSorter.sortAsc(topPlayers);
        }

        // Print each best player's name and score in a readable format
        System.out.println("Top 10 scores :");
        for (int i = 0; i < topPlayers.size(); i++) {
            String[] player = topPlayers.get(i);
            System.out.println((i + 1) + ". Pseudo : " + player[0] + ", Score : " + player[1]);
        }
    }

    /**
     * Displays the score page to the user, allowing them to choose sorting options
     * (ascending or descending) or navigate back to the menu.
     */
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