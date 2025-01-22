import java.util.Scanner;

public class player {

    Scanner sc = new Scanner(System.in);

    //Attributes
    int [] position = new int[2];
    boolean playing = false;
    char sign = 'Y';
    String name = "Yname";
    player()
    {
    }
    //Method
    public void start_play(String new_name, char new_sign, int x, int y, gameboard board) {
        playing = true;
        name = new_name;
        sign = new_sign;
        changePosition(x, y);
        board.nb_player +=1;
        board.board[y][x] = sign;
    }

    public void changePosition(int x, int y) {
        position[0] = y;
        position[1] = x;
    }

    public void move(gameboard board) {

        System.out.println(name +", it's your turn to move !");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("z") || input.equals("q")||input.equals("s") || input.equals("d")) {
            board.movement_player(this, input);
        }
        else if (input.equals("Z") || input.equals("Q")||input.equals("S") || input.equals("D")) {
            board.movement_player(this, input);
        }
        else if(input.equals("quit") || input.equals("QUIT")){
            board.nb_player -= 1;
        }
        else{
            move(board);
        }
    }

    public static Byte letterToNumber(char letter) {
        if (letter >= 'A' && letter <= 'Z') {
            return (byte) (letter - 'A' + 1);
        } else if (letter >= 'a' && letter <= 'z') {
            return (byte) (letter - 'a' + 1);
        } else {
            throw new IllegalArgumentException("The character is not a letter.");
        }
    }

    private boolean isValidLetter(char letter) {
        return (letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z');
    }

    public void destruct(gameboard board) {
        System.out.println(name + ", choose a square to destroy");
        System.out.print("Position : ");
        try {
            String input = sc.nextLine();

            if (input.length() < 2) {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                destruct(board);
                return;
            }

            String part1String = input.substring(0, 1);
            String part2String = input.substring(1);

            char charx = part1String.charAt(0);

            if (!isValidLetter(charx)) {
                System.out.println("⚠ Incorrect entry (the first character must be a letter between A & K) ⚠");
                destruct(board);
                return;
            }

            byte x = letterToNumber(charx);
            byte y;

            try {
                y = Byte.parseByte(part2String);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Incorrect entry (the second character must be number between 1 & 10) ⚠");
                destruct(board);
                return;
            }

            board.destruct(this, x, y);

        } catch (Exception e) {
            System.out.println("⚠ An error has occurred (please retry) ⚠");
            destruct(board);
        }
    }

    public void play(gameboard board) {
        /**
         * This function is the normal way to play
         */
        if(board.nb_player > 1){
            move(board);
            board.printBoard();
            destruct(board);
            board.printBoard();
        }
    }

    public static boolean WallCollision(gameboard board, char[][] lab, int x, int y) {
        int cpt = 0;

        if (x == 0) {
            cpt += 1;
        }
        else if (lab[x - 1][y] == board.wall) { // top
            cpt += 1;
        }

        if (x == 10) {
            cpt += 1;
        }
        else if (lab[x + 1][y] == board.wall) { // down
            cpt += 1;
        }

        if (y == 0) {
            cpt += 1;
        }
        else if (lab[x][y - 1] == board.wall) { // left
            cpt += 1;
        }

        if (y == 9) {
            cpt += 1;
        }
        else if (lab[x][y + 1] == board.wall) { // right
            cpt += 1;
        }


        return cpt >= 4;
    }

}
