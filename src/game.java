import java.util.Random;
import java.util.Scanner;

public class game {

    public static int choice_nb_player(){
        /**
         * This function ask the number of player to start the game
         */
        System.out.println("Choose the number of players you want to play between 2 and 4");
        Scanner sc = new Scanner(System.in);
        Byte number = 0;
        try{
            number = sc.nextByte();
        }
        catch(Exception e){
            return choice_nb_player();
        }
        if(number>4 || number<2){
            return choice_nb_player();
        }
        else return number;
    }

    public static player[] add_player(gameboard board) {
        /**
         * This function create the players with the number that was given
         */
        //int choice = choice_nb_player();
        int choice = 2;
        player[] list = new player[choice];

        for(int i = 0; i < choice; i++){
            player p = new player();
            list[i] = p;
        }
        list[0].start_play("Waluigi",'W',5,4, board);
        list[1].start_play("Mario",'X',5,5, board);

        if (choice == 3){
            list[2].start_play("Luigi",'Y',4, 4, board);
        }

        else if (choice == 4){
            list[3].start_play("Warrio",'Z',4,5, board);
        }
        return list;
    }

    public static player[] random_player(player[] list) {
        /**
         * This function designates a random player to start the game
         */
        player stock;
        for(int i = 0; i < list.length; i++){
            int randint = new Random().nextInt(list.length);
            stock = list[i];
            list[i] = list[randint];
            list[randint] = stock;

        }
        return list;
    }

    public static player[] start_to_play(gameboard board) {
        /**
         * This function reunate all the other function necessary to start the game
         **/
        player[] list = game.add_player(board);

        for(int i = 0; i < list.length; i++){
            int j = i+1;
            list[i].changeName();
        }

        player[] list_player = random_player(list);
        board.printBoard();
        return list_player;
    }


    // Ce sera dans le main
    public static void main(String[] args){
        //  creating an object gameboard

    }
}
