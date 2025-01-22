import java.util.Scanner;

public class gameboard{
    //Attributes
    String [][] board= new String[10][11];
    byte nb_player = 2;
    int[] first_coords = new int[4];
    gameboard()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]= "_";
            }
        }
    }

    //Methods
    public void Add_player(player player1, player player2){
        /**
         * This function instantiate the gameboard with the player in
         * Take player objects
         */
        player1.play();
        board[4][5] = player1.sign;
        player1.changePosition(4,5);
        player2.play();
        board[5][5] = player2.sign;
        player2.changePosition(5,5);
        /*
        if(nb_player>2){
            player3.play();
            board[5][5] = player3.sign;
            player3.changePosition(4,4);
            if(nb_player==4){
                player4.play();
                board[5][5] = player4.sign;
                player4.changePosition(5,4);
            }
        }*/
    }


    public void printBoard() {
        /**
         *
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');

    }


    public void destruct(player player, int x, int y) {
        /**
         * This function bloc a case
         */
        // take

        if(x<1 || x > board.length){
            System.out.println("Not in a valid position !");
            player.destruct(this);
        }
        else if(y<1 || y > board[0].length){
            System.out.println("Not in a valid position !");
            player.destruct(this);
        }
        else{
            board[y-1][x-1] = "H";
        }
    }


    public void movement_player(player player, String input) {
        if(player.position[1]-1 >= 0){
            if(board[player.position[1]-1][player.position[0]] == "_") {
                board[player.position[1]][player.position[0]] = "_";
                player.position[1] -= 1;
            }
        }
        else if(input.equals("q") || input.equals("Q")){
            if(player.position[0]-1 >= 0){
                if(board[player.position[1]][player.position[0]-1] == "_") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[0] -= 1;
                }
            }
        }
        else if(input.equals("s") || input.equals("S")){
            if(player.position[1]+1 < board.length){
                if(board[player.position[1]+1][player.position[0]] == "_") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[1] += 1;
                }
            }
        }
        else{
            if(player.position[0]+1 < board[0].length){
                if(board[player.position[1]][player.position[0]+1] == "_") {
                    board[player.position[1]][player.position[0]] = "_";
                    player.position[0] += 1;

                }
            }
        }
        board[player.position[1]][player.position[0]] = player.sign;
    }












    //Ce qui devra être dans la page main
    public static void main(String[] args){
        //  creating an object gameboard
        gameboard obj = new gameboard();

        //  creating player objects
        player player_1 = new player();
        player player_2 = new player();
        /*
        player player_3 = new player();
        player player_4 = new player();*/

        //Change player attributes
        player_2.sign="X";
        player_2.name="Xname";

        /*
        obj.Create(player_1, player_2, player_3, player_4);*/

        obj.Add_player(player_1, player_2);
        while(obj.nb_player > 1) {
            player_1.play(obj);
            player_2.play(obj);
        }
    }
}
