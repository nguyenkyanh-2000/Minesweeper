import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Board b = new Board("BEGINNER");
        b.rightClick(1,1);
        b.rightClick(2,3);
        b.leftClick(1,1);
        b.leftClick(4,5);
        b.leftClick(4,5);
        b.printBoard();
    }
}
