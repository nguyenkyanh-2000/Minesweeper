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
        if (this.isRevealed() == false){
            System.out.print("* ");
        }
        else{
            System.out.print(this.value + " ");
        }
    }

}

