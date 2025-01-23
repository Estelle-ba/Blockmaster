public class Draw
{
    public static char[][] color1 = {
            {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0'},
            {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
            {'1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1'},
            {'1', '3', '3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '1'},
            {'1', '3', '2', '2', '2', '1', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '1', '2', '2', '2', '3', '1'}
    };

    public static char[][] color2 = {
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

    /**
     * This function prints a drawing from a drawing
     * @param color a matrix for drawing
     */
    public static void draw_gameboy(char[][] color) {
        String cpt = " A ";
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color[0].length; j++) {
                if (i == 4) {
                    if (j == 6 ) {
                        cpt = " A ";
                    };
                    if (j == 7 ) {
                        cpt = " B ";
                    }
                    if (j == 8 ) {
                        cpt = " C ";
                    }
                    if (j == 9 ) {
                        cpt = " D ";
                    }
                    if (j == 10 ) {
                        cpt = " E ";
                    }
                    if (j == 11 ) {
                        cpt = " F ";
                    }
                    if (j == 12 ) {
                        cpt = " G ";
                    }
                    if (j == 13 ) {
                        cpt = " H ";
                    }
                    if (j == 14 ) {
                        cpt = " I ";
                    }
                    if (j == 15 ) {
                        cpt = " J ";
                    }
                    if (j == 16 ) {
                        cpt = " K ";
                    }

                }
                switch (color[i][j]) {
                    case '0': System.out.print("   "); break;
                    case '1': System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset); break;
                    case '2' : System.out.print(Style.colors.GrayDark + "   " + Style.colors.C_Reset); break;
                    case '3' : System.out.print(Style.colors.White + "   " + Style.colors.C_Reset); break;
                    case '4' : System.out.print(Style.colors.BLACK + cpt + Style.colors.White); break;
                }
            }
            System.out.print('\n');
        }
    }
}
