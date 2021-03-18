import java.util.ArrayList;

public abstract class Cell {
    private int xPosition;
    private int yPosition;
    private boolean isRevealed;
    private boolean isFlagged;

    public Cell(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isRevealed = false;
        this.isFlagged = false;
    }

    /**
     * Getters & Setters
     */

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
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

    /**
     * Methods
     */

    public int change2Dto1D(int row, int col){
        return row * col + col;
    }


    public void useRightClick() {
        setFlagged(!isFlagged());
    }

    public void useLeftClick() {
        setRevealed(true);
    }

    public void show() {
    }

    // Return a list of Neighbouring Cells.
    public ArrayList<Cell> getMyNeighbours() {

        Mode m = Board.getMode();
        ArrayList<Cell> cc = Board.getCellCollection();
        ArrayList<Cell> myNeighbours = new ArrayList<Cell>();

        // Offsets of xPosition and yPosition
        int fx = xPosition + 1;
        int fy = yPosition + 1;
        int bx = xPosition - 1;
        int by = yPosition - 1;

        // Check if 8 surrounding cells exist.
        boolean north = by >= 0;
        boolean south = fy < m.getHeight();
        boolean west = bx >= 0;
        boolean east = fx < m.getWidth();
        boolean northwest = north && west;
        boolean northeast = north && east;
        boolean southwest = south && west;
        boolean southeast = south && east;

        // Add existing surrounding cells to the list.

        if (north) {
            myNeighbours.add(cc.get(change2Dto1D(xPosition,by)));
        }
        if (south) {
            myNeighbours.add(cc.get(change2Dto1D(xPosition,fy)));
        }
        if (west) {
            myNeighbours.add(cc.get(change2Dto1D(bx,yPosition)));
        }
        if (east) {
            myNeighbours.add(cc.get(change2Dto1D(fx,yPosition)));
        }
        if (northeast) {
            myNeighbours.add(cc.get(change2Dto1D(fx,by)));
        }
        if (northwest) {
            myNeighbours.add(cc.get(change2Dto1D(bx,by)));
        }
        if (southeast) {
            myNeighbours.add(cc.get(change2Dto1D(fx,fy)));
        }
        if (southwest) {
            myNeighbours.add(cc.get(change2Dto1D(bx,fy)));
        }

        return myNeighbours;
    }
}

