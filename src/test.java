public class test
{



    public static void main (String[] args) {

        char[][] lab = new char[10][11];
        char[][] labs = new char[11][10];
        int currentX = 0;
        int currentY = 9;
        create_lab(lab, 10, 11);

        //lab[0][0] = 'X';
        //lab[0][8] = 'X';
        lab[1][9] = 'X';




        //screen(lab, 11, 10);
        Files.writeLabFile(lab, 1);
        labs = Files.loadLabFile(1);

        //screen(labs, 11, 10);



        //System.out.println(" A  B  C  D  E  F  G  H  I  J  K ");



        colorDisplay(lab);


        System.out.print(" _\n| | \n| |");


        String[] gameBoy = {
                "   ________________________",
                "  |########################|",
                "  |#    Nintendo GAME BOY  #|",
                "  |#  .------------------.  #|",
                "  |#  |                  |  #|",
                "  |#  |   [  o   o  ]    |  #|",
                "  |#  |      \\____/      |  #|",
                "  |#  |                  |  #|",
                "  |#  '------------------'  #|",
                "  |#   __   ___   ___   __  #|",
                "  |#  |A | | B | |C | | D | #|",
                "  |#  '--------------------' #|",
                "  |#________________________#|",
                "  |##########################|",
                "   \\########################/",
                "    `----------------------'"
        };

        // Print the Game Boy ASCII art
        for (String line : gameBoy) {
            System.out.println(line);
        }

    }

    public static char[][] create_lab(char[][] lab, int length, int width) {
        for (int i = 0; i < length; i++) { // fill maze
            for (int j = 0; j < width; j++) {
                lab[i][j] = '_';
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

    public static void colorDisplay(char[][] board) {

        for (int a = 0; a < 20; a++) {
            System.out.print("___");
        }
        System.out.println(" ");
        System.out.print("|");
        for (int a = 0; a < 29; a++) {
            System.out.print("##");
        }
        System.out.print("|");
        System.out.print("\n");
        System.out.println("|#                                                        #|");
        System.out.println("|#                        GAME BOY                        #|");
        System.out.println("|#                                                        #|");
        System.out.println("|#            A  B  C  D  E  F  G  H  I  J  K             #|");
        System.out.println("|#           _________________________________            #|");

        for (int i = 0; i < board.length; i++) {
            System.out.print("|#          |");
            for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]) {
                    // Assign the _s with a black block
                    case '_':
                        if((i+j)%2 == 0){
                            System.out.print(Style.colors.BG_BeautyBlack + "   " + Style.colors.C_Reset);
                        }
                        else{
                            System.out.print(Style.colors.BG_White + "   " + Style.colors.C_Reset);
                        }
                        break;

                    // Assign the W player with a blue block
                    case 'W':
                        System.out.print(Style.colors.BG_Blue + "   " + Style.colors.C_Reset);
                        break;

                    // Assign the X player with a blue block
                    case 'X':
                        System.out.print(Style.colors.BG_Red + "   " + Style.colors.C_Reset);
                        break;

                    // Assign the Y player with a blue block
                    case 'Y':
                        System.out.print(Style.colors.BG_Green + "   " + Style.colors.C_Reset);
                        break;

                    // Assign the Z player with a blue block
                    case 'Z':
                        System.out.print(Style.colors.BG_Yellow + "   " + Style.colors.C_Reset);
                        break;

                    case 'H':
                        System.out.print(Style.colors.BG_Gray + "   " + Style.colors.C_Reset);
                        break;
                }

            }
            System.out.print("|           #|");
            System.out.print('\n');
        }

        System.out.println("|#           ---------------------------------            #|");
        for (int a = 0; a < 4; a++) {
            System.out.println("|#                                                        #|");
        }
        System.out.println("|#--------------------------------------------------------#|");
        System.out.println(" \\########################################################/");
        System.out.println("  \\######################################################/");
        System.out.println("   \\____________________________________________________/");


        //System.out.print('\n');
    }


}
