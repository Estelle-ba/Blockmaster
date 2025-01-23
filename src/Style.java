public class Style {

    /**
     * Provides ANSI color codes for styling console output.
     * This class contains constants representing various background and text colors
     * using ANSI escape codes. The colors are defined for aesthetic purposes, such as
     * representing a chessboard theme or providing highlights.
     */
    public static class colors {

        public static final String BG_BeautyBlack = "\u001B[48;2;63;33;15m"; // Background color in vintage chess black
        public static final String BG_White = "\u001B[48;2;227;192;123m"; // Background color in vintage chess white
        public static final String BG_Blue = "\u001B[48;2;65;69;255m"; // Background color in blue
        public static final String BG_Red = "\u001B[48;2;255;65;65m"; // Background color in red
        public static final String BG_Green = "\u001B[48;2;78;255;65m"; // Background color in green
        public static final String BG_Yellow = "\u001B[48;2;255;223;0m"; // Background color in yellow
        public static final String BG_Gray = "\u001B[48;2;120;120;120m"; // Background color in gray
        public static final String C_Reset = "\u001B[0m"; // Reset text status

        public static final String BLACK = "\u001B[48;2;0;0;0m"; // Fond noir pur
        public static final String GrayDark = "\u001B[48;2;60;60;60m"; // Gris foncé
        public static final String White = "\u001B[48;2;255;255;255m"; // Fond blanc pur
    }

    /**
     * Displays a game board with colored blocks based on cell values.
     * This method renders a 2D character array representing the game board.
     * Each character in the array corresponds to a specific element of the game
     * and is displayed using ANSI color codes for better visualization.
     * @param board a 2D character array representing the game board.
     */
    public static void colorDisplay(char[][] board) {
        int cpt = 0;


        for (int i = 0; i < board.length; i++) {
            cpt += 1;
            System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset);
            System.out.print(Style.colors.White + "   " + Style.colors.C_Reset);
            System.out.print(Style.colors.GrayDark + "         " + Style.colors.C_Reset);
            if (cpt < 11) {
                if (cpt == 10) {
                    System.out.print(Style.colors.BLACK + cpt + " " + Style.colors.C_Reset);
                } else {System.out.print(Style.colors.BLACK + " " + cpt + " " + Style.colors.C_Reset);}

            } else {System.out.print(Style.colors.BLACK + "   " + Style.colors.C_Reset);}

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
