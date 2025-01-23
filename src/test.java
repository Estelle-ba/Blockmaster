public class test
{
    public static void main (String[] args) {

        char[][] lab = new char[10][11];
        create_lab(lab, 10, 11);

        char[][] color1 = {
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '1'},
                {'1', '3', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '3', '1'}
        };
        char[][] color2 = {
                {'1', '3', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '3', '1'},
                {'1', '3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '1'},
                {'1', '3', '3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '1', '1', '1', '1', '1', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1', '1', '3', '3', '1'},
                {'1', '3', '1', '1', '1', '1', '1', '1', '3', '3', '3', '3', '3', '3', '1', '1', '3', '3', '1', '1', '3', '3', '1'},
                {'1', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '1', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1', '0'},
                {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1', '0', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0'}
        };

        draw_gameboy(color1);
        colorDisplay(lab);
        draw_gameboy(color2);
    }

    public static void draw_gameboy(char[][] color) {
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color[0].length; j++) {
                switch (color[i][j]) {
                    case '0': System.out.print("   "); break;
                    case '1': System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset); break;
                    case '2' : System.out.print(Style.colors.GrayDark + "   " + Style.colors.C_Reset); break;
                    case '3' : System.out.print(Style.colors.White + "   " + Style.colors.C_Reset); break;
                    case '9' : System.out.print("   "); break;
                }
            }
            System.out.print('\n');
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



        for (int i = 0; i < board.length; i++) {
            System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset);
            System.out.print(Style.colors.White + "   " + Style.colors.C_Reset);
            System.out.print(Style.colors.GrayDark + "         " + Style.colors.C_Reset);
            System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset);
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
            System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset);
            System.out.print(Style.colors.GrayDark + "         " + Style.colors.C_Reset);
            System.out.print(Style.colors.White + "   " + Style.colors.C_Reset);
            System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset);
            System.out.print('\n');
        }

    }


}
