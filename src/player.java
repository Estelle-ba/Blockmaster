import java.util.Scanner;

public class player{
    //Attributes
    int [] position = new int[2];
    boolean playing = false;
    String sign = "Y";
    String name = "Yname";
    player()
    {
    }
    //Method
    public void play() {
        playing = true;
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
    public void destruct(gameboard board) {
        System.out.println(name +", choose somewhere to destruct");
        System.out.print("Position x : ");
        Scanner sc = new Scanner(System.in);
        Byte x=0;
        try{
            x = sc.nextByte();
        }
        catch(Exception e){
            destruct(board);
        }
        System.out.print("Position y : ");
        Scanner sca = new Scanner(System.in);
        Byte y = 0;
        try{
            y = sca.nextByte();
        }
        catch(Exception e){
            destruct(board);
        }
        board.destruct(this, x, y);
    }

    public void play(gameboard board) {
        /**
         * This function is the normal way to play
         */
        move(board);
        board.printBoard();
        destruct(board);
        board.printBoard();
    }
}
