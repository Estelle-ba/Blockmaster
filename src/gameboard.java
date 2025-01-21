public class gameboard {
    //Attributes
    String [][] board= new String[10][11];
    gameboard()
    {
        System.out.println("Welcome to javaTpoint");
    }
    //Method
    public void Create(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]= "_";
            }
        }

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

    public void mouvment_player() {
    }


    public static void main(String[] args){
    //  creating an object using new keyword
        gameboard obj = new gameboard();
        obj.Create();
        obj.printBoard();
    }
}
