public class MineCell extends Cell{


    public MineCell(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public void show(){
        System.out.print("M");
    }

    public void plantTheCell(Cell a[][]){
        a[getxPosition()][ getyPosition()] = new MineCell(getxPosition(), getyPosition());
    }
}
