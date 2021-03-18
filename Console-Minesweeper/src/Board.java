import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    static Mode mode;
    int width;
    int height;
    int minesLeft;
    static int score;
    static List<Cell> CellCollection = new ArrayList<Cell>();
    static List<Cell> MineList = new ArrayList<Cell>();

    public Board(String GameMode){
        mode = mode.valueOf(GameMode);
        width = mode.getWidth();
        height = mode.getHeight();
        score = 0;
        minesLeft = mode.getNumofMines();
        placeEmptyAndMineCells();
        updatePosition();
        placeValueCells();
    }

    /**
     * Methods
     */

    private void placeEmptyAndMineCells(){
        int numMines = mode.getNumofMines();
        for (int r = 0; r < mode.getHeight(); r++) {
            for (int c = 0; c < mode.getWidth(); c++) {
                if (numMines >= 0) {
                    CellCollection.add(new MineCell(r, c));
                    numMines--;
                } else {
                    CellCollection.add(new EmptyCell(r, c));
                }
            }
        }
        Collections.shuffle(CellCollection);
    }

    private void updatePosition(){
        for (int i = 0; i < CellCollection.size(); i++){
            Cell tmp = CellCollection.get(i);
            // Reset coordinates after shuffling
            tmp.setX(Cell.to2dIndex(i).x);
            tmp.setY(Cell.to2dIndex(i).y);
            // Keep track the mine cells
            if (tmp instanceof MineCell){
                MineList.add(tmp);
            }
        }
    }

    private void placeValueCells(){
        for (Cell i: MineList){
            for (int index: i.getMyNeighbours()){
                Cell tmp = CellCollection.get(index);
                if (tmp instanceof EmptyCell) {
                    CellCollection.set(index, new ValueCell());
                }
                else {
                    if (tmp instanceof ValueCell){
                        ((ValueCell) tmp).incValue();
                    }
                }
            }
        }
    }

    public void printBoard(){
        for (int r = 0; r < mode.getHeight(); r++){
            System.out.println();
            for (int c = 0; c < mode.getWidth(); c++){
                CellCollection.get(Cell.to1dIndex(c,r)).show();
            }
        }
    }

    public static void gameOver(){
        for (int r = 0; r < mode.getHeight(); r++){
            System.out.println();
            for (int c = 0; c < mode.getWidth(); c++){
                CellCollection.get(Cell.to1dIndex(c,r)).setRevealed(true);
                CellCollection.get(Cell.to1dIndex(c,r)).show();
            }
        }
        System.out.println();
        System.out.println("The score is " + score);
    }

    public void leftClick(int x, int y) {
        Cell tmp = CellCollection.get(Cell.to1dIndex(x, y));
        if (tmp.isRevealed) {
            System.out.println("This cell is already opened!. Choose a different cell!");
        } else {
            if (tmp.isFlagged == false) {
                tmp.useLeftClick();
            } else System.out.println("This is a mine cell! Remove the flag or choose a different cell!");
        }
    }

    public void rightClick(int x, int y){
        Cell tmp = CellCollection.get(Cell.to1dIndex(x,y));
        tmp.useRightClick();
        if (tmp.isFlagged == false){
            minesLeft--;
            if (tmp instanceof MineCell){
                score++;
            }
        }
        else {
            minesLeft++;
            if (tmp instanceof MineCell) {
                score--;
            }
        }
    }

    /**
     ** Getters and Setters
     */

    public static Mode getMode() {
        return mode;
    }

    public static List<Cell> getCellCollection(){
        return CellCollection;
    }

    public int getScore() {
        return score;
    }


}
