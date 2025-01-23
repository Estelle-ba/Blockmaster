import java.util.Scanner;

public class player {

    Scanner sc = new Scanner(System.in);

    //Attributes
    int [] position = new int[2];
    char sign;
    String name;
    String color;
    player()
    {
    }
    //Method
    public void create_new_player(String new_name, String new_color, char new_sign, int x, int y, gameboard board) {
        /**
         * This function put all the thing necessary for a player to start a game
         */
        name = new_name;
        sign = new_sign;
        changePosition(x, y);
        board.nb_player +=1;
        board.board[y][x] = sign;
    }

    public void changePosition(int x, int y) {
        /**
         * This function change the coordinate of the player
         */
        position[0] = x;
        position[1] = y;
    }
    public void changeName(){
        System.out.println("Choose your name");
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        if(entry.length() < 2 || entry.length() > 20){
            System.out.println("Not a valid name! Your name will be : " + name);
        }
        else{
            name = entry;
        }
    }

    public void choice_where_to_move(gameboard board) {
        /**
         * This function ask the player the coordinate where he wants to destruct
         */
        System.out.println(name +", it's your turn to move ! Choose z (up), q(left), s(down) or d(right)");
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        if(entry.equals("quit") || entry.equals("QUIT")){
            board.nb_player -= 1;
        }
        else {
            char input = entry.charAt(0);
            if (input == 'z' || input == 'q' || input == 's' || input == 'd') {
                board.movement_player(this, input);
            } else if (input == 'Z' || input == 'Q' || input == 'S' || input == 'D') {
                board.movement_player(this, input);
            }
            else{
                choice_where_to_move(board);
            }
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

    public void choice_where_to_destruct(gameboard board) {
        /**
         * This function ask the player the coordinate where he wants to destruct
         */
        System.out.println(name + ", choose a square to destroy");
        System.out.print("Position : ");
        try {
            String input = sc.nextLine();

            if (input.length() < 2) {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                choice_where_to_destruct(board);
                return;
            }

            String part1String = input.substring(0, 1);
            String part2String = input.substring(1);

            char charx = part1String.charAt(0);

            if (!isValidLetter(charx)) {
                System.out.println("⚠ Incorrect entry (the first character must be a letter between A & K) ⚠");
                choice_where_to_destruct(board);
                return;
            }

            byte x = letterToNumber(charx);
            byte y;

            try {
                y = Byte.parseByte(part2String);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Incorrect entry (the second character must be number between 1 & 10) ⚠");
                choice_where_to_destruct(board);
                return;
            }

            board.destruct(this, x, y);

        } catch (Exception e) {
            System.out.println("⚠ An error has occurred (please retry) ⚠");
            choice_where_to_destruct(board);
        }
    }

    public void during_partie(gameboard board) {
        /**
         * This function is the normal way to play
         */
        choice_where_to_move(board);
        board.printBoard();
        choice_where_to_destruct(board);
        board.printBoard();
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
