public class ValueCell extends Cell{

    private int value;

    public ValueCell(){
        super();
        value = 1;
    }

    public ValueCell(int i) {
        super(i);
        value = 1;
    }

    public ValueCell(int x, int y) {
        super(x, y);
        value = 1;
    }

    public int getValue() {
        return value;
    }

    public void incValue() {
        this.value++;
    }

    public void show() {
        super.show();
        if (isRevealed()) {
            System.out.print(value + " ");
        }
    }
}