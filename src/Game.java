import java.util.Random;
import java.util.Scanner;

public class game {

    public static int choice_nb_player(){
        System.out.println("Choose the number of players you want to play between 2 and 4");
        Scanner sc = new Scanner(System.in);
        Byte number=0;
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

    public static player[] start_to_play(gameboard board) {
        //int choice = choice_nb_player();
        int choice = 2;
        player[] list = new player[choice];

        for(int i = 0; i < choice; i++){
            player p = new player();
            list[i] = p;
        }
        list[0].start_play("Wname",'W',5, 4, board);
        list[1].start_play("Xname",'X',5, 5, board);

        if (choice == 3){
            list[2].start_play("Yname",'Y',4, 4, board);
        }

        else if (choice == 4){
            list[3].start_play("Zname",'Z',4,5, board);
        }
        return list;
    }
    public static player[] start_to_play(player[] list) {
        player stock = list[0];
        for(int i = 0; i < list.length; i++){
            int randint = new Random().nextInt(list.length);

        }
        return list;
    }

    public static void main(String[] args){
        //  creating an object gameboard


    }
}
