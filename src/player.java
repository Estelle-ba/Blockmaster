import java.util.Random;
import java.util.Scanner;

public class player {

    Scanner sc = new Scanner(System.in);

    //Attributes
    int [] position = new int[2];
    char sign;
    String name;
    String color;
    int score = 0;
    boolean RR = false;
    boolean keyboard_key = false;
    char[][] keys = {{'z','Z'}, {'q','Q'},{'s','S'},{'d','D'}};

    player(){}

    /**
     * This function put all the thing necessary for a player to start a game
     * @param new_name : add a name to the player
     * @param new_color : add a color to the player
     * @param new_sign : add a sign to the player
     * @param x : take the horizontal coordonates
     * @param y : take the horizontal coordonates
     * @param board : take the gameboard to put the player in it
     */
    public void create_new_player(String new_name, String new_color, char new_sign, int x, int y, gameboard board) {
        name = new_name;
        sign = new_sign;
        changePosition(x, y);
        board.nb_player +=1;
        board.board[y][x] = sign;
        color = new_color;
    }

    /**
     * This function change the coordinate of the player
     * @param x : take the horizontal coordonates
     * @param y : take the horizontal coordonates
     */
    public void changePosition(int x, int y) {
        position[0] = x;
        position[1] = y;
    }

    /**
     * This function change the name of the player
     */
    public void changeName(){
        System.out.println("Choose your name between 2 and 10 characters");
        String entry = sc.nextLine();
        if(entry.length() < 2 || entry.length() > 10){
            System.out.println("Not a valid name! Your name will be : " + name);
        }
        else{
            name = entry;
        }
    }

    /**
     * This function ask the player the coordinate where he wants to destruct
     * @param board : take the gameboard
     */
    public void choice_where_to_move(gameboard board) {
        System.out.println(" Choose somewhere to move ! Choose z (up), q(left), s(down) or d(right)");
        String entry = sc.nextLine();
        char input = 'A';
        try {
            input = entry.charAt(0);
        }catch (Exception e){
            choice_where_to_move(board);
        }
        if (input == 'z' || input == 'q' || input == 's' || input == 'd') {
            board.movement_player(this, input);

        } else if (input == 'Z' || input == 'Q' || input == 'S' || input == 'D') {
            board.movement_player(this, input);

        } else if (input == 'b' || input == 'B') {
            int random = new Random().nextInt(3);

            if (random == 0) {
                RR = true;
            }
            choice_where_to_move(board);
        } else if (input == 'p' || input == 'P') {
            int random = new Random().nextInt(3);

            if (random == 0) {
                keyboard_key = true;
            }
            choice_where_to_move(board);
        } else {
            choice_where_to_move(board);
        }

    }

    /**
     * Converts a letter to its corresponding numeric position in the alphabet.
     * @param letter the character to be converted (must be a letter from 'A' to 'Z' or 'a' to 'z')
     * @return the numeric position of the letter in the alphabet (1-26)
     * @throws IllegalArgumentException if the input character is not a letter
     */
    public static Byte letterToNumber(char letter) {
        if (letter >= 'A' && letter <= 'Z') {
            return (byte) (letter - 'A' + 1);
        } else if (letter >= 'a' && letter <= 'z') {
            return (byte) (letter - 'a' + 1);
        } else {
            throw new IllegalArgumentException("The character is not a letter.");
        }
    }

    /**
     * Checks if a character is a valid letter in the English alphabet.
     * @param letter the character to validate
     * @return true if the character is a letter, false otherwise
     */
    private boolean isValidLetter(char letter) {
        return (letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z');
    }

    /**
     * This function ask the player the coordinate where he wants to destruct
     * @param board : take the gameboard
     */
    public void choice_where_to_destruct(gameboard board) {
        System.out.println(name + ", choose a square to destroy");
        System.out.print("Position : ");
        try {
            String input = sc.nextLine();

            if (input.length() < 2) {
                System.out.println("⚠ Incorrect entry (please follow instructions) ⚠");
                choice_where_to_destruct(board);
            }

            String part1String = input.substring(0, 1);
            String part2String = input.substring(1);

            char charx = part1String.charAt(0);

            if (!isValidLetter(charx)) {
                System.out.println("⚠ Incorrect entry (the first character must be a letter between A & K) ⚠");
                choice_where_to_destruct(board);
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

    /**
     * This function put the keyboard random
     */
    public void keyboard_keys() {
        System.out.println("Your keyboards has been changed");
        char[] stock;

        for(int i = 0; i < keys.length; i++){   //make random the list of keys
            int randint = new Random().nextInt(keys.length);
            stock = keys[i];
            keys[i] = keys[randint];
            keys[randint] = stock;
        }
    }
}
