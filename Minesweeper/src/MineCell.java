public class MineCell extends Cell{


    public MineCell(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public void show(){
        if (this.isRevealed() == false){
            System.out.print("* ");
        }
        else{
            System.out.print("M ");
        }
    }

}
