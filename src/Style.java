public class Style {

    public static class colors {
        // ANSI codes for colors
        public static final String BG_BeautyBlack = "\u001B[48;2;63;33;15m"; // Background color in vintage chess black
        public static final String BG_White = "\u001B[48;2;227;192;123m"; // Background color in vintage chess white
        public static final String BG_Blue = "\u001B[48;2;65;69;255m"; // Background color in blue
        public static final String BG_Red = "\u001B[48;2;255;65;65m"; // Background color in red
        public static final String BG_Green = "\u001B[48;2;78;255;65m"; // Background color in green
        public static final String BG_Yellow = "\u001B[48;2;255;223;0m"; // Background color in yellow
        public static final String BG_Gray = "\u001B[48;2;120;120;120m"; // Background color in gray
        public static final String C_Reset = "\u001B[0m"; // Reset text status

    }

    public static void colorDisplay(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]) {
                    // Assign the _s with a black block
                    case "_":
                        if((i+j)%2 == 0){
                            System.out.print(colors.BG_BeautyBlack + "   " + colors.C_Reset);
                        }
                        else{
                            System.out.print(colors.BG_White + "   " + colors.C_Reset);
                        }
                        break;

                    // Assign the W player with a blue block
                    case "W":
                        System.out.print(colors.BG_Blue + "   " + colors.C_Reset);
                        break;

                    // Assign the X player with a blue block
                    case "X":
                        System.out.print(colors.BG_Red + "   " + colors.C_Reset);
                        break;

                    // Assign the Y player with a blue block
                    case "Y":
                        System.out.print(colors.BG_Green + "   " + colors.C_Reset);
                        break;

                    // Assign the Z player with a blue block
                    case "Z":
                        System.out.print(colors.BG_Yellow + "   " + colors.C_Reset);
                        break;

                    case "H":
                        System.out.print(colors.BG_Gray + "   " + colors.C_Reset);
                        break;
                }

            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
}
