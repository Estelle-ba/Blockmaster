import java.io.*;

public class Files {


    public static void writeLabFile(char[][] lab, int filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("lab" + String.valueOf(filename + ".labgen"))))) {
            for (char[] row : lab) {
                writer.write(row); // Écrire la ligne dans le fichier
                writer.newLine(); // Ajouter une nouvelle ligne après chaque ligne
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }



    public static char[][] loadLabFile(int filename) {
        File file = new File("lab" + String.valueOf(filename + ".labgen"));
        char[][] lab = null;

        // Compter le nombre de lignes pour définir la taille du tableau
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int rowCount = 0;

            // Première boucle pour compter les lignes
            while ((line = reader.readLine()) != null) {
                rowCount++;
            }

            // Initialiser le tableau avec le nombre de lignes
            lab = new char[rowCount][];

            // Utiliser un nouveau BufferedReader pour relire le fichier
            try (BufferedReader reader2 = new BufferedReader(new FileReader(file))) {
                int currentRow = 0;

                // Lire chaque ligne et remplir le tableau
                while ((line = reader2.readLine()) != null) {
                    lab[currentRow] = line.toCharArray(); // Convertir la ligne en tableau de caractères
                    currentRow++;
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return lab;
    }
}
