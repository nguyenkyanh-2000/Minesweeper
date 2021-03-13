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

    public void useRightClick(){
        boolean tmp = !isFlagged();
        setFlagged(tmp);
    }

    public void show(){
    }

    public void plantTheCell(Cell a[][]){
    }
}
