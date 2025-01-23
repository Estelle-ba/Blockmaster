import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class game {
    public static void wait(int secondsToSleep) {
        try
        {
            Thread.sleep(secondsToSleep * 1000);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }
    public static int choice_nb_player(){
        /**
         * This function ask the number of player to start the game
         */
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

    public static player[] add_player(gameboard board) {
        /**
         * This function create the players with the number that was given
         */
        int choice = choice_nb_player();
        //int choice = 2;
        player[] list = new player[choice];

        for(int i = 0; i < choice; i++){
            player p = new player();
            list[i] = p;
        }
        list[0].create_new_player("Waluigi", Style.colors.BG_Blue,'W',5,4, board);
        list[1].create_new_player("Mario",Style.colors.BG_Red,'X',5,5, board);

        if (choice > 2){
            list[2].create_new_player("Luigi",Style.colors.BG_Green,'Y',4, 4, board);
            if (choice == 4) {
                list[3].create_new_player("Warrio", Style.colors.BG_Yellow, 'Z', 4, 5, board);
            }
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
    public static void RR(player player){
        /**
         * Futur player will be rickroll
         */
        System.out.println(player.color + "   " + Style.colors.C_Reset+ " " + player.name + ", listen to this banger !!!");
        String[] lyrics= {"Never gonna give you up", "Never gonna let you down", "Never gonna run around and desert you",
                "Never gonna make you cry", "Never gonna say goodbye", "Never gonna tell a lie and hurt you"};
        String music = Style.colors.BG_Gray + "\uD83C\uDFB6";
        wait(2);
        for (int i = 0; i < 18; i++){
            System.out.print(music);

        }
        wait(3);
        System.out.println(Style.colors.C_Reset + '\n');
        for (int i = 0; i < lyrics.length; i++){
            System.out.print(music);
            System.out.print(Style.colors.C_Reset + " " + lyrics[i]);
            System.out.println('\n');
            wait(2);
        }
        System.out.println("Hope you liked it !!!");
    }

    public static player[] start_party(gameboard board) {
        /**
         * This function reunate all the other function necessary to start the game
         **/
        player[] list = game.add_player(board);

        for(int i = 0; i < list.length; i++){
            list[i].changeName();
            System.out.println("You'll be the color : "+list[i].color + "   " + Style.colors.C_Reset);
        }

        player[] list_player = random_player(list);
        board.printBoard();
        return list_player;
    }

    public static player turns(gameboard board, player[] list_player, byte number_player, boolean RR) {
        if(board.nb_player > 1) {
            player current_player = list_player[number_player];
            if(current_player != null) {
                if (player.WallCollision(board, board.board, current_player.position[1], current_player.position[0])) {
                    board.nb_player -= 1;
                    System.out.println(current_player.color + "   " + Style.colors.C_Reset+ " " + current_player.name + ", you loose !");
                    list_player[number_player] = null;
                }
                else {
                    if(RR == true){
                        RR(current_player);
                        RR = false;
                        board.printBoard();
                    }
                    else {
                        current_player.during_partie(board);
                        RR = current_player.RR;
                    }
                }
            }
            number_player++;
            if (number_player == list_player.length){
                number_player = 0;
            }
            return turns(board, list_player, number_player, RR);
        }
        else{
            for (int i = 0; i < list_player.length; i++) {
                if (list_player[i] != null) {
                    System.out.println(list_player[i].name + " won !!!");
                    return list_player[i];
                }
            }
        }
        return null;
    }

}
