public class ValueCell extends Cell{

    private int value;
    public ValueCell(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        value = 1;
    }

    public void increaseValue(){
        this.value++;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void show(){
        System.out.print(value);
    }

    public void plantTheCell(Cell a[][]){
        a[getxPosition()][ getyPosition()] = new ValueCell(getxPosition(), getyPosition());
    }
}

