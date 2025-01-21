
public class gameboard {
    //Attributes
    String [][] board= new String[10][11];
    byte player = 2;
    gameboard()
    {
    }

    //Methods
    public void Create(player player1, player player2, player player3, player player4){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]= "_";
            }
        }

        player1.play();
        player2.play();

    }
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print('\n');
        }

    }
    public void destruct() {

    }

    public void movement_player() {

    }

    //
    public static void main(String[] args){
        //  creating an object gameboard
        gameboard obj = new gameboard();

        //  creating player objects
        player player_1 = new player();
        player player_2 = new player();
        player player_3 = new player();
        player player_4 = new player();


        obj.Create(player_1, player_2, player_3, player_4);
        obj.printBoard();
    }
}
