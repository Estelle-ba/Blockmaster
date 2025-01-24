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

    /**
     * This function make the gameboard appears
     */
    public void printBoard() {

        Draw.draw_gameboy(Draw.color1);
        Style.colorDisplay(board);
        Draw.draw_gameboy(Draw.color2);
    }


    /**
     * This function bloc a case
     * @param player : take the player
     * @param x : take the horizontal coordonates
     * @param y : take the horizontal coordonates
     */
    public void destruct(player player, byte x, byte y) {
        if(x-1<0 || x-1 > board.length){
            System.out.println("Not in a valid position !");
            player.choice_where_to_destruct(this);
        }

        else if(y-1<0 || y-1 > board[0].length-1){
            System.out.println("Not in a valid position !");
            player.choice_where_to_destruct(this);
        }

        else if (board[y-1][x-1] == empty){
            board[y-1][x-1] = wall;
        }
    }

    /**
     * This function moves the player
     * @param player : take the player
     * @param input : takes character input
     */
    public void movement_player(player player, char input){
        int x = player.position[0];
        int y = player.position[1];

        if (input == player.keys[1][0] || input == player.keys[1][1]) { // move left
            if (x - 1 >= 0) {
                if (board[y][x - 1] == empty) {
                    board[y][x] = empty;
                    x -= 1;
                }
            }
        }

        else if (input == player.keys[0][0] || input == player.keys[0][1]) { // move up
            if (y - 1 >= 0) {
                if (board[y - 1][x] == empty) {
                    board[y][x] = empty;
                    y -= 1;
                }
            }
        }

        else if (input == player.keys[3][0] || input == player.keys[3][1]) { // move right
            if (x + 1 <= board[0].length - 1) {
                if (board[y][x + 1] == empty) {
                    board[y][x] = empty;
                    x += 1;
                }
            }
        }

        else if (input == player.keys[2][0] || input == player.keys[2][1]) { // move down
            if (y + 1 <= board.length - 1) {
                if (board[y + 1][x] == empty) {
                    board[y][x] = empty;
                    y += 1;
                }
            }
        }

        player.changePosition(x, y);
        board[y][x] = player.sign;
    }

    /**
     * This function is the normal way to play
     * @param player : take the player
     * @param number : take the number of the execution for the methods
     */
    public void during_partie(player player, int number) {
        switch (number) {
            case 0: //make the player move
                player.choice_where_to_move(this);
                printBoard();
                break;

            default:    //make the player destruct
                player.choice_where_to_destruct(this);
                printBoard();
                break;
        }
    }

    /**
     * This function ask the player the coordinate where he wants to destruct
     * @param board : take the gameboard to if there is an empty case
     * @param lab : take gameboard
     * @param x : take the horizontal coordonates
     * @param y : take the horizontal coordonates
     * return a boolean if there's a way to move
     */
    public static boolean WallCollision(gameboard board, char[][] lab, int x, int y) {
        int cpt = 0;

        if (x == 0) {
            cpt += 1;
        }
        else if (lab[x - 1][y] != board.empty) { // top
            cpt += 1;
        }

        if (x == 10) {
            cpt += 1;
        }
        else if (lab[x + 1][y] != board.empty) { // down
            cpt += 1;
        }

        if (y == 0) {
            cpt += 1;
        }
        else if (lab[x][y - 1] != board.empty) { // left
            cpt += 1;
        }

        if (y == 9) {
            cpt += 1;
        }
        else if (lab[x][y + 1] != board.empty) { // right
            cpt += 1;
        }

        return cpt >= 4;
    }
}

class extern_counting extends Thread {
    boolean running = true;
    int number = 1;

    /**
     * This function create an increment that stop in 15 seconds
     */
    public void counting(){
        game.wait(1);
        number++;
        if(number <=15) {
            counting();
        }
        running = false;
        number = 0;
    }

    public void run(){
        counting();
    }
}

