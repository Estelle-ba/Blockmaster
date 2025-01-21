import java.util.Scanner;

public class rules {

    public static void main(String[] args) {

            //display of rules
            //system to leave the page :
                //if the player clicks on key, the page closes
                    //otherwise the page remains

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("*-*-*-*-*-*-*-*RULES*-*-*-*-*-*-*");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("welcome to [name]");
            System.out.println("the rules of the game are simple");
            System.out.println("rules number 1:");
            System.out.println("A player cannot destroy an occupied or already destroyed square.");
            System.out.println("rules number 2:");
            System.out.println("A player cannot occupy a destroyed square or a square already occupied.");
            System.out.println("rules number 3:");
            System.out.println("A player blocked during a turn is declared a loser.");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("press any key to return to the main menu");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");


        try {
            System.in.read(); // Attend une pression sur n'importe quelle touche
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
