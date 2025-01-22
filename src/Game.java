public class Game
{



    public static void main (String[] args) {

        char[][] lab = new char[11][10];
        char[][] labs = new char[11][10];
        int currentX = 0;
        int currentY = 9;
        create_lab(lab, 11, 10);

        //lab[0][0] = 'X';
        lab[0][8] = 'X';
        lab[1][9] = 'X';

        lab[currentX][currentY] = 'P';
        System.out.println(WallCollision(lab, currentX, currentY));

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

    public static boolean WallCollision(char[][] lab, int x, int y) {
        int cpt = 0;

        if (x == 0) {
            cpt += 1;
        }
        else if (lab[x - 1][y] == 'X') { // top
            cpt += 1;
        }

        if (x == 10) {
            cpt += 1;
        }
        else if (lab[x + 1][y] == 'X') { // down
            cpt += 1;
        }

        if (y == 0) {
            cpt += 1;
        }
        else if (lab[x][y - 1] == 'X') { // left
            cpt += 1;
        }

        if (y == 9) {
            cpt += 1;
        }
        else if (lab[x][y + 1] == 'X') { // right
            cpt += 1;
        }



        return cpt >= 4;
    }


}
