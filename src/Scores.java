import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scores {

    /**
     * Writes a list of nicknames and scores to a file.
     *
     * @param players  List of players (each player is an array of 2 values: nickname and score).
     * @param filename Name of the file to write.
     */
    public static void writePlayerFile(List<String[]> players, int filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("players" + filename + ".labgen"))) {
            for (String[] player : players) {
                // Write each player to the file in "pseudo,score" form
                writer.write(player[0] + "," + player[1]);
                writer.newLine(); // Move to the next line
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads a file containing nicknames and scores, and returns them as a list.
     *
     * @param filename Name of the file to read.
     * @return List of players (each player is an array of 2 values: nickname and score).
     */
    public static List<String[]> loadPlayerFile(int filename) {
        File file = new File("players" + filename + ".labgen");
        List<String[]> players = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read each line and extract the nickname and score
            while ((line = reader.readLine()) != null) {
                String[] player = line.split(","); // Divide the line by the comma
                players.add(player); // Add the player (nickname, score) to the list
            }
        } catch (IOException e) {
            System.err.println("Error reading file : " + e.getMessage());
        }

        return players;
    }


    public static void main(String[] args) {
        List<String[]> players = new ArrayList<>();
        players.add(new String[]{"Alice", "1"});
        players.add(new String[]{"Bob", "2"});
        players.add(new String[]{"Charlie", "3"});


        writePlayerFile(players, 1);


        List<String[]> loadedPlayers = loadPlayerFile(1);

        
        System.out.println("Joueurs chargés depuis le fichier :");
        for (String[] player : loadedPlayers) {
            System.out.println("Pseudo : " + player[0] + ", Score : " + player[1]);
        }
    }


}
