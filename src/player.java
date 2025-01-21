public class player {
    //Attributes
    int [] position = new int[2];
    boolean playing = false;
    String sign = "Y";
    String name = "Yname";
    player()
    {
    }
    //Method
    public void play() {
        playing = true;
    }


    public void notplay(){
        playing = false;
    }

    public void changePosition(int x, int y) {
        position[0] = y;
        position[1] = x;
    }
}
