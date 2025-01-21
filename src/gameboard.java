public class gameboard {
    //Attributes
    String [][] board= new String[11][10];
    gameboard()
    {
        System.out.println("Welcome to javaTpoint");
    }
    //Method
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }
    public void destruct() {
    }
    public void mouvment_player() {
    }
    public static void main(String[] args){
    //  creating an object using new keyword
        gameboard obj = new gameboard();
        obj.printBoard();
    }
}
