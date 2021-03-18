import java.util.ArrayList;
import java.util.Collections;

public class Board {

    static Mode mode;

    public static Mode getMode() {
        return mode;
    }

    public static ArrayList<Cell> getCellCollection() {
        return CellCollection;
    }

    static ArrayList <Cell> CellCollection, MineList = new ArrayList<Cell>();

    /**
     * Default board = "Beginner"
     * Size 8 x 8 with 10 mines
     */

    public Board() {
        mode = Mode.BEGINNER;
        CellCollection = new ArrayList<Cell>();
    }
    /**
     * Getters & Setters
     */

    /**
     * Methods
     */

    public void placeEmptyandMine(){
        MineList.clear();
        int tmp = 0;
        for (int i = 0; i <= mode.getHeight() - 1; i++){
            for (int j = 0; j <= mode.getWidth() - 1; j++) {
                if (tmp < mode.getNumofMines()) {
                    CellCollection.add(new MineCell(i, j));
                    tmp++;
                }
                else {
                    CellCollection.add(new EmptyCell(i, j));
                }
            }
        }
        //shuffleCells(CellCollection);
    }


    public void placeValue() {
        for (Cell i: MineList) {
            for (Cell j: i.getMyNeighbours()) {
                if (j instanceof EmptyCell){
                    j = new ValueCell(j.getxPosition(), j.getyPosition());
                }
                else if (j instanceof ValueCell){
                    ((ValueCell) j).increaseValue();
                }
            }
        }
    }

    public void swapCells(Cell c1, Cell c2){

        int tmpX = c1.getxPosition();
        int tmpY = c1.getyPosition();
        boolean tmpF = c1.isFlagged();
        boolean tmpR = c1.isRevealed();
        Cell tmp = c1;

        // Cell 1 turns into cell 2
        c1.setxPosition(c2.getxPosition());
        c1.setyPosition(c2.getyPosition());
        c1.setRevealed(c2.isRevealed());
        c1.setFlagged(c2.isFlagged());
        c1 = c2;

        // Cell 2 turns into cell 1
        c2.setxPosition(tmpX);
        c2.setyPosition(tmpY);
        c2.setRevealed(tmpR);
        c2.setFlagged(tmpF);
        c2 = tmp;

    }

    public void shuffleCells(Cell a[][]) {
        ArrayList <Cell> CellList = new ArrayList<Cell>();
        for (int i = 0; i <= mode.getHeight() - 1 ;i++){
            for (int j = 0; j <= mode.getWidth() - 1; j++){
                CellList.add(a[i][j]);
            }
        }
        Collections.shuffle(CellList);
        int i_row = -1;
        for (int i = 0; i <= CellList.size() - 1; i++){
            int i_col = i % mode.getWidth();
            if (i_col == 0){
                i_row++;
            }
            CellList.get(i).setxPosition(i_col);
            CellList.get(i).setyPosition(i_row);
        }
    }


    public ArrayList<Cell> getMineList() {
        return MineList;
    }

    /**public void locateMines(){
        for (int i = 0; i <= mode.getHeight() - 1; i++){
            for (int j = 0; j <= mode.getWidth() - 1; j++) {
                if (CellCollection[i][j] instanceof MineCell){
                    int xx = ((MineCell) CellCollection[i][j]).getxPosition();
                    int yy = ((MineCell) CellCollection[i][j]).getyPosition();
                    MineList.add(CellCollection[xx][yy]);
                }
            }
        }
    }**/

    public void makeNewBoard(){
        placeEmptyandMine();
    }

    public void showCurrentBoard() {
        for (int i = 0; i <= mode.getHeight()-1; i++){
            System.out.println();
            for (int j = 0; j <= mode.getWidth() - 1; j++) {
                CellCollection.get(i*j + j).show();
            }
        }
    }

    public void showEveryCell() {
        for (int i = 0; i <= mode.getHeight()-1; i++){
            System.out.println();
            for (int j = 0; j <= mode.getWidth() - 1; j++) {
                CellCollection.get(i*j + j).setRevealed(true);
                CellCollection.get(i*j + j).show();
            }
        }
    }
}
