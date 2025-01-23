import java.util.Random;
import java.util.Scanner;

public class game {

    /**
     * Make the script wait until number_seconds seconds
     * @param number_seconds: the time the script has to stop
     */
    public static void wait(int number_seconds) {
        try {
            Thread.sleep(number_seconds * 1000);// multiply by 1 000 because it's in milliseconds
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This function ask the number of player to start the game
     * @return the number of player they choose
     */
    public static int choice_nb_player(){
        System.out.println("Choose the number of players you want to play between 2 and 4");
        Scanner sc = new Scanner(System.in);
        Byte number;
        try{    //try to have a byte
            number = sc.nextByte();
        }
        catch(Exception e){ //if it's not retry
            return choice_nb_player();
        }
        if(number>4 || number<2){ //if the byte not between 2 and 4
            return choice_nb_player();
        }
        else return number;
    }

    /**
     * This function create the players with the number that was given
     * @param board : put player on the gameboard
     */
    public static player[] add_player(gameboard board) {
        int choice = choice_nb_player();
        player[] list = new player[choice]; //create a list with the size of the number of players

        for(int i = 0; i < choice; i++){    // add players in the list
            player p = new player();
            list[i] = p;
        }

        // create 2 player
        list[0].create_new_player("Waluigi", Style.colors.BG_Blue,'W',5,4, board);
        list[1].create_new_player("Mario",Style.colors.BG_Red,'X',5,5, board);

        if (choice > 2){    // If there's more than 2 players
            list[2].create_new_player("Luigi",Style.colors.BG_Green,'Y',4, 4, board);
            if (choice == 4) {
                list[3].create_new_player("Warrio", Style.colors.BG_Yellow, 'Z', 4, 5, board);
            }
        }
        return list;
    }

    /**
     * This function designates a random player to start the game
     * @param list : list of the players in the game
     * @return the list of players but in a new order
     */
    public static player[] random_player(player[] list) {
        player stock;

        for(int i = 0; i < list.length; i++){   //make random the list of player
            int randint = new Random().nextInt(list.length);
            stock = list[i];
            list[i] = list[randint];
            list[randint] = stock;
        }

        return list;
    }

    /**
     * Futur player will be rickroll
     * @param player : called the player
     */
    public static void RR(player player){
        System.out.println(player.color + "   " + Style.colors.C_Reset+ " " + player.name + ", listen to this banger !!!");
        String[] lyrics= {"Never gonna give you up", "Never gonna let you down", "Never gonna run around and desert you",
                "Never gonna make you cry", "Never gonna say goodbye", "Never gonna tell a lie and hurt you"};
        String music = Style.colors.BG_Gray + "\uD83C\uDFB6";

        wait(2);

        for (int i = 0; i < 18; i++){   //print the music emojis
            System.out.print(music);
        }

        wait(3);
        System.out.println(Style.colors.C_Reset + '\n');

        for (int i = 0; i < lyrics.length; i++){    //print the music lyrics
            System.out.print(music);
            System.out.print(Style.colors.C_Reset + " " + lyrics[i]);
            System.out.println('\n');
            wait(2);
        }

        System.out.println("Hope you liked it !!!");
    }

    /**
     * This function reunate all the other function necessary to start the game
     * @param board : the game board
     * @return a list of player in the game
     */
    public static player[] start_party(gameboard board) {
        player[] list = game.add_player(board);

        for(int i = 0; i < list.length; i++){   //ask the players name or pseudo
            list[i].changeName();
            System.out.println("You'll be the color : "+list[i].color + "   " + Style.colors.C_Reset);
        }

        player[] list_player = random_player(list);
        board.printBoard();
        return list_player;
    }

    /**
     * This function operates the game in turn-based mode
     * @param board : the game board
     * @param list_player : take the list of the player in the game
     * @param number_player :
     * @param RR : the condtion to make appears the rickroll
     * @param keyboard_keys : change the touch of the player
     * @return the winner
     */
    public static player turns(gameboard board, player[] list_player, byte number_player, boolean RR, boolean keyboard_keys) {
        player current_player = list_player[number_player];
        if(current_player != null) {    // if the player is not eliminated

            if (board.nb_player == 1) { // if there is a winner
                return current_player;
            }

            else {
                if (gameboard.WallCollision(board, board.board, current_player.position[1], current_player.position[0])) { // if the current player loose
                    board.nb_player -= 1;
                    System.out.println(current_player.color + "   " + Style.colors.C_Reset + " " + current_player.name + ", you loose !");
                    list_player[number_player] = null;
                }
                else { //if the player is not eliminated
                    if(RR) { //the current player is rickroll
                        RR(current_player);
                        board.printBoard();
                    }
                    else if(keyboard_keys){ // the current player has his keyboard keys changes
                        current_player.keyboard_keys();
                        board.printBoard();
                    }
                    else {
                        System.out.println(current_player.color + "   " + Style.colors.C_Reset + " " + current_player.name + ", it's your turn");
                        extern_counting count = new extern_counting();
                        count.start();  // start the asynchronous function

                        int action = 0;

                        while (count.running && action < 2){
                            count.number = 1;
                            board.during_partie(current_player, action);
                            action++;
                        }

                        if (count.number == 0) {
                            System.out.println("You take too much time !");
                        }
                    }
                }
                RR = current_player.RR;
                keyboard_keys = current_player.keyboard_key;
                current_player.RR = false;
                current_player.keyboard_key = false;
            }
        }

        number_player++;    // make the function for the futur player
        if (number_player == list_player.length){
            number_player = 0;
        }
        return turns(board, list_player, number_player, RR, keyboard_keys);
    }

}


