public class player {
    //Attributes
    int [] position = new int[2];
    boolean playing = false;
    player()
    {
    }
    //Method
    public void play() {
        playing = true;
    }

    public void changePosition(int x, int y) {
        position[0] = x;
        position[1] = y;
    }

    public static void main(String[] args){
        //  creating an object using new keyword
    }
}
