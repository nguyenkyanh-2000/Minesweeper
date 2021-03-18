import java.util.ArrayList;
import java.util.List;

class Point {

    int x;
    int y;

    public Point(){
    }
}

public class Cell {

    int x;
    int y;
    boolean isRevealed;
    boolean isFlagged;

    public Cell() {
        this.isRevealed = false;
        this.isFlagged = false;
    }

    public Cell(int i){
        this.x = to2dIndex(i).x;
        this.y = to2dIndex(i).y;
        this.isRevealed = false;
        this.isFlagged = false;
    }

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Methods
     */

    public static int to1dIndex(int x, int y){
        int row = Board.getMode().getHeight();
        int col = Board.getMode().getWidth();
        return y * row + x;
    }

    public static Point to2dIndex(int index){
        Point p = new Point();
        int row = Board.getMode().getHeight();
        int col = Board.getMode().getWidth();

        p.x = index % row;
        p.y = (index - p.x) / col;
        return p;
    }

    public List<Integer> getMyNeighbours() {
        List <Integer> tmp = new ArrayList<Integer>();
        Mode m = Board.getMode();
        for (int j = -1; j <= 1; j++ ) {
            for (int k = -1; k <= 1; k++) {
                int c = j + x;
                int r = k + y;
                if (r < 0  || r > m.getHeight() - 1 || c > m.getWidth() - 1 || c < 0) {
                    continue;
                }
                else{
                    int index = to1dIndex(c,r);
                    tmp.add(index);
                }
            }
        }
        tmp.remove(tmp.indexOf(to1dIndex(x,y)));
        return tmp;
    }

    public void useRightClick() {
        setFlagged(!isFlagged());
    }

    public void useLeftClick() {
        setRevealed(true);
    }

    public void show() {
        if (isRevealed == false){
            if (isFlagged == false) {
                System.out.print("* ");
            }
            else{
                System.out.print("+ ");
            }
        }
    }


    /**
     * Getters & Setters
     */

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

}