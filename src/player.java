public class player {
    //Attributes
    int [] position = new int[2];
    boolean playing = false;
    String sign = "W";
    String name = "Yname";
    player()
    {
    }
    //Method
    public void play() {
        playing = true;
    }

    public void changePosition(int x, int y) {
        position[0] = y;
        position[1] = x;
    }
}
