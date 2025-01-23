// Plan for the Scores code:

// Score management
    // Load player data
        // Read each line from the file
        // Add the player's name and score to a list

    // Write updated data
        // Iterate through the list of players
        // Write each name and score to the file

    // Update a player's score
        // Load players from the file
        // If the player exists, increment their score
        // Otherwise, add a new player with a score of 1
        // Write the updated data back to the file

    // Display scores
        // Load players from the file
        // Print each player's name and score



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scores {

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

    public static void displayScores(String filename) {
        List<String[]> players = loadPlayerFile(filename); // Load players and scores from the file
        System.out.println("Current scores:"); // Display a header
        for (String[] player : players) {
            // Print each player's name and score in a readable format
            System.out.println("Name: " + player[0] + ", Score: " + player[1]);
        }
    }
}

