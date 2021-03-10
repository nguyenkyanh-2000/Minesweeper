public class Board {

    private Mode mode;
    private Cell CellCollection[][];

    /**
     * Default board = "Beginner"
     * Size 8 x 8 with 10 mines
     */

    public Board() {
        mode = Mode.BEGINNER;
        CellCollection = new Cell[mode.getHeight()][mode.getWidth()];
    }

    /**
     * Methods
     */
}
