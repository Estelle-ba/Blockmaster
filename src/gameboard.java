import java.util.Scanner;

public class gameboard {
    //Attributes
    String [][] board= new String[10][11];
    byte nb_player = 2;
    gameboard()
    {
    }

    //Methods
    public void Create(player player1, player player2, player player3, player player4){
        /**
         * This function instantiate the gameboard with the player in
         * Take player objects
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]= "_";
            }
        }

        player1.play();
        board[4][5] = player1.sign;
        player1.changePosition(4,5);
        player2.play();
        board[5][5] = player2.sign;
        player2.changePosition(5,5);
        if(nb_player>2){
            player3.play();
            board[5][5] = player3.sign;
            player3.changePosition(4,4);
            if(nb_player==4){
                player4.play();
                board[5][5] = player4.sign;
                player4.changePosition(5,4);
            }
        }
    }


    public void printBoard() {
        /**
         *
         *
         *
         *
         *
         *
         *
         *
         *
         */
        System.out.println(" A  B  C  D  E  F  G  H  I  J  K ");
        Style.colorDisplay(board);
        }



    public void destruct(player player) {
        /**
         * This function bloc a case
         */
        // take
        System.out.println(player.name +", choose somewhere to destruct");
        System.out.print("Position x : ");
        Scanner sc = new Scanner(System.in);
        Byte x=0;
        try{
            x = sc.nextByte();
        }
        catch(Exception e){
            destruct(player);
        }
        System.out.print("Position y : ");
        Scanner sca = new Scanner(System.in);
        Byte y = 0;
        try{
            y = sca.nextByte();
        }
        catch(Exception e){
            destruct(player);
        }


        if(x<1 || x > board.length){
            System.out.println("Not in a valid position !");
            destruct(player);
        }
        else if(y<1 || y > board[0].length){
            System.out.println("Not in a valid position !");
            destruct(player);
        }
        else{
            board[y-1][x-1] = "H";
        }
    }


    public void movement_player(player player) {
        /**
         * This function move the player
         */
        System.out.println(player.name +", it's your turn to move !");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("z") || input.equals("Z")){
            if(player.position[1]-1 >= 0){
                if(board[player.position[1]-1][player.position[0]] == "_" || board[player.position[1]-1][player.position[0]] == "o") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[1] -= 1;
                    board[player.position[1]][player.position[0]] = player.sign;
                }
            }
        }
        else if(input.equals("q") || input.equals("Q")){
            if(player.position[0]-1 >= 0){
                if(board[player.position[1]][player.position[0]-1] == "_") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[0] -= 1;
                    board[player.position[1]][player.position[0]] = player.sign;
                }
            }
        }
        else if(input.equals("s") || input.equals("S")){
            if(player.position[1]+1 < board.length){
                if(board[player.position[1]+1][player.position[0]] == "_") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[1] += 1;
                    board[player.position[1]][player.position[0]] = player.sign;
                }
            }
        }
        else if(input.equals("d") || input.equals("D")){
            if(player.position[0]+1 < board[0].length){
                if(board[player.position[1]][player.position[0]+1] == "_") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[0] += 1;
                    board[player.position[1]][player.position[0]] = player.sign;
                }
            }
        }
        else if(input.equals("quit") || input.equals("QUIT")){
            nb_player -= 1;
        }
        else{
            movement_player(player);
        }
    }

    public void play(player player) {
        /**
         * This function is the normal way to play
         */
        printBoard();
        movement_player(player);
        printBoard();
        destruct(player);
    }










    //Ce qui devra être dans la page main
    public static void main(String[] args){
        //  creating an object gameboard
//        gameboard obj = new gameboard();
//
//        //  creating player objects
//        player player_1 = new player();
//        player player_2 = new player();
//        player player_3 = new player();
//        player player_4 = new player();
//
//        //Change player attributes
//        player_2.sign="X";
//        player_2.name="Xname";
//
//
//        obj.Create(player_1, player_2, player_3, player_4);
//
//
//        while(obj.nb_player > 1) {
//            obj.play(player_1);
//            obj.play(player_2);
//        }
    }
}
