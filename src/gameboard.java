import java.util.Scanner;

public class gameboard{
    //Attributes
    char [][] board= new char[10][11];
    byte nb_player = 0;
    int[] first_coords = new int[4];
    char empty = '_';
    char wall = 'H';
    gameboard()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]= empty;
            }
        }
    }


    public void printBoard() {
        /**
         *
         */

        Style.colorDisplay(board);
        }



    public void destruct(player player, int x, int y) {
        /**
         * This function bloc a case
         */
        // take

        if(x<0 || x > board.length-1){
            System.out.println("Not in a valid position !");
            player.destruct(this);
        }
        else if(y<0 || y > board[0].length-1){
            System.out.println("Not in a valid position !");
            player.destruct(this);
        }
        else{
            board[y-1][x-1] = 'H';
        }
    }


    public void movement_player(player player, String input) {
        if(input.equals("z") || input.equals("Z")) {
            if (player.position[1] - 1 >= 0) {
                if (board[player.position[1] - 1][player.position[0]] == empty) {
                    board[player.position[1]][player.position[0]] = empty;
                    player.position[1] -= 1;
                }
            }
        }
        else if(input.equals("q") || input.equals("Q")){
            if(player.position[0]-1 >= 0){
                if(board[player.position[1]][player.position[0]-1] == empty) {
                    board[player.position[1]][player.position[0]] = empty;
                    player.position[0] -= 1;
                }
            }
        }
        else if(input.equals("s") || input.equals("S")){
            if(player.position[1]+1 < board.length){
                if(board[player.position[1]+1][player.position[0]] == empty) {
                    board[player.position[1]][player.position[0]] = empty;
                    player.position[1] += 1;
                }
            }
        }
        else{
            if(player.position[0]+1 < board[0].length){
                if(board[player.position[1]][player.position[0]+1] == empty) {
                    board[player.position[1]][player.position[0]] = empty;
                    player.position[0] += 1;

                }
            }
        }
        board[player.position[1]][player.position[0]] = player.sign;
    }

}
