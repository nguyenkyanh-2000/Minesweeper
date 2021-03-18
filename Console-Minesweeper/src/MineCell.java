public class MineCell extends Cell{

    public MineCell(){
        super();
    }

    public MineCell(int i) {
        super(i);
    }

    public MineCell(int x, int y) {
        super(x, y);
    }

    public void show(){
        super.show();
        if (isRevealed()){
            System.out.print("M ");
        }
    }

    public void useLeftClick(){
        Board.gameOver();
    }
}