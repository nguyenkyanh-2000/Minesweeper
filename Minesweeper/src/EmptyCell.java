public class EmptyCell extends Cell{
    public EmptyCell(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public void show(){
        if (this.isRevealed() == false){
            System.out.print("* ");
        }
        else{
            System.out.print("E ");
        }
    }


}
