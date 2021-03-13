public class EmptyCell extends Cell{
    public EmptyCell(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public void show(){
        System.out.print("E");
    }

    public void plantTheCell(Cell a[][]){
        a[getxPosition()][ getyPosition()] = new EmptyCell(getxPosition(), getyPosition());
    }
}
