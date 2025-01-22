public class Game
{



    public static void main (String[] args) {

        char[][] lab = new char[11][10];
        char[][] labs = new char[11][10];
        int currentX = 0;
        int currentY = 0;
        create_lab(lab, 11, 10);
        lab[3][0] = 'X';
        System.out.println(verifCollision(lab, 1, 1));

        screen(lab, 11, 10);
        Files.writeLabFile(lab, 1);
        labs = Files.loadLabFile(1);
        System.out.println("---");
        //screen(labs, 11, 10);

    }

    public static char[][] create_lab(char[][] lab, int length, int width) {
        for (int i = 0; i < length; i++) { // fill maze
            for (int j = 0; j < width; j++) {
                lab[i][j] = '#';
            }
        }
        return lab;
    }

    public static void screen(char[][] lab, int length, int width) {
        // function show the maze
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String BLUE = "\033[34m";


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (lab[i][j] == 'S') {
                    System.out.print(GREEN + Character.toString(lab[i][j]) + RESET + "  ");
                }
                else if (lab[i][j] == 'E') {
                    System.out.print(RED + Character.toString(lab[i][j]) + RESET + "  ");
                }
                else if (lab[i][j] == 'X') {
                    System.out.print(BLUE + Character.toString(lab[i][j]) + RESET + "  ");
                }
                else if (lab[i][j] == 'P') {
                    System.out.print(BLUE + Character.toString(lab[i][j]) + RESET + "  ");
                }
                else if (i == 0 || i == length - 1 || j == 0 || j == width - 1) {
                    if (lab[i][j] != 'S' && lab[i][j] != 'E') {
                        System.out.print(Character.toString('#') + "  ");
                    }
                }
                else {
                    System.out.print(Character.toString(lab[i][j]) + "  ");
                }


            }
            System.out.print('\n');

        }
    }

    public static boolean verifCollision(char[][] lab, int x, int y) {
        if (lab[x+1][y] == 'X') { // right
            return false;
        }
        if (lab[x-1][y] == 'X') { //left
            return false;
        }
        if (lab[x][y+1] == 'X') { //top
            return false;
        }
        if (lab[x][y-1] == 'X') { //down
            return false;
        }


        return true;
    }


}
