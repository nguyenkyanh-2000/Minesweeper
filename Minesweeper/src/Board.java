import java.util.ArrayList;
import java.util.Random;

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Board {

    private Mode mode;
    private Cell CellCollection[][];
    ArrayList <Point> MineList = new ArrayList<Point>();

    /**
     * Default board = "Beginner"
     * Size 8 x 8 with 10 mines
     */

    public Board() {
        mode = Mode.BEGINNER;
        CellCollection = new Cell[mode.getHeight()][mode.getWidth()];
    }

    /**
     * Methods
     */

    public void placeEmptyandMines(){
        MineList.clear();
        int tmp = 0;
        for (int i = 0; i <= mode.getHeight()-1; i++){
            for (int j = 0; j <= mode.getWidth() - 1; j++) {
                if (tmp < mode.getNumofMines()) {
                    CellCollection[i][j] = new MineCell(i, j);
                    tmp++;
                }
                else {
                    CellCollection[i][j] = new EmptyCell(i, j);
                }
            }
        }
        shuffleCells(CellCollection);
        locateMines(CellCollection);
    }

    public void placeValue(){
        for (int i=0; i<=MineList.size();i++){
                for (int j = -1; j <= 1; j++ ){
                    for (int k = -1; k <= 1; k++){
                        int xx = j + MineList.get(i).x;
                        int yy = k + MineList.get(i).y;
                        if (xx >=0 && xx <= mode.getHeight() && yy <= mode.getWidth() && yy >=0){
                            CellCollection[xx][yy] = new ValueCell(xx, yy);
                        }
                    }
                }
        }
    }

    public void shuffleCells(Cell a[][]) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);
                Cell tempCell = a[i][j];
                a[i][j] = a[m][n];
                a[m][n] = tempCell;
            }
        }
    }

    public void locateMines(Cell a[][]) {
        for (int i = 0; i <= mode.getHeight() - 1; i++) {
            for (int j = 0; j <= mode.getWidth() - 1; j++) {
                if (a[i][j] instanceof MineCell) {
                    Point tmp = new Point(i,j);
                    MineList.add(tmp);
                }
            }
        }
    }

    public void drawBoard(){
        placeEmptyandMines();
        placeValue();
        for (int i = 0; i <= mode.getHeight()-1; i++){
                System.out.println();
                for (int j = 0; j <= mode.getWidth() - 1; j++) {
                    if (CellCollection[i][j] instanceof EmptyCell) {
                        System.out.print("E");
                    }
                    else if (CellCollection[i][j] instanceof MineCell) {
                        System.out.print("M");
                    }
                    else if (CellCollection[i][j] instanceof ValueCell) {
                        System.out.print("V");
                    }

                }
        }
        System.out.println();
        System.out.print(MineList.get(1).x + " " + MineList.get(1).y);
    }

}
