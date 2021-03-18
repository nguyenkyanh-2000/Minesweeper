public class EmptyCell extends Cell{

    public EmptyCell() {
    }

    public EmptyCell(int i) {
        super(i);
    }

    public EmptyCell(int x, int y) {
        super(x, y);
    }

    public void show(){
        super.show();
        if (isRevealed()) {
            System.out.print("E ");
        }
    }

    public void useLeftClick(){
        isRevealed = true;
        for (int i:this.getMyNeighbours()){
            Board.CellCollection.get(i).setRevealed(true);
        }
    }
}

