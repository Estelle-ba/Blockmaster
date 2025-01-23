import java.util.Scanner;

public class gameboard{
    //Attributes
    char [][] board= new char[10][11];
    byte nb_player = 0;
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
         * This function make the gameboard appears
         */

        Style.colorDisplay(board);
    }



    public void destruct(player player, int x, int y) {
        /**
         * This function bloc a case
         */

        if(x-1<0 || x > board.length-1){
            System.out.println("Not in a valid position !");
            player.destruct(this);
        }
        else if(y-1<0 || y-1 > board[0].length-1){
            System.out.println("Not in a valid position !");
            player.destruct(this);
        }
        else if (board[y-1][x-1] == empty){
            board[y-1][x-1] = 'H';
        }
    }

    public void movement_player(player player, char input){
        /**
         * This function moves the player
         */
        int x = player.position[0];
        int y = player.position[1];
        if (input == 'q' || input == 'Q') {
            if (x - 1 >= 0) {
                if (board[y][x - 1] == empty) {
                    board[y][x] = empty;
                    x-=1;
                }
            }
        } else if (input == 'z' || input == 'Z') {
            if (y - 1 >= 0) {
                if (board[y - 1][x] == empty) {
                    board[y][x] = empty;
                    y-=1;
                }
            }
        } else if (input == 'd' || input == 'D') {
            if (x + 1 <= board[0].length - 1) {
                if (board[y][x + 1] == empty) {
                    board[y][x] = empty;
                    x+=1;
                }
            }
        }
        else if (input == 's' || input == 'S') {
            if (y + 1 <= board.length - 1) {
                if (board[y + 1][x] == empty) {
                    board[y][x] = empty;
                    y+=1;
                }
            }
        }
        player.changePosition(x, y);
        board[y][x] = player.sign;
    }

}
