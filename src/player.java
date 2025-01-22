import java.util.Scanner;

public class player{
    //Attributes
    int [] position = new int[2];
    char sign;
    String name;
    player()
    {
    }

    //Method
    public void start_play(String new_name, char new_sign, int x, int y, gameboard board) {
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
            System.out.println("Too long ! Your name will be : " + name);
        }
        else{
            name = entry;
        }
    }

    public void move(gameboard board) {
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
                move(board);
            }
        }
    }
    public void destruct(gameboard board) {
        /**
         * This function ask the player the coordinate where he wants to destruct
         */
        System.out.println(name +", choose somewhere to destruct");
        System.out.print("Position x : ");

        byte x = bytecord();
        System.out.print("Position y : ");
        byte y = bytecord();

        board.destruct(this, x, y);
    }

    public static byte bytecord(){
        /**
         * This function look if the thing ask is a number
         */
        Scanner sc = new Scanner(System.in);
        byte num;
        try{
            num = sc.nextByte();
        }
        catch(Exception e){
            System.out.println("Not a number");
            return bytecord();
        }
        return num;
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
