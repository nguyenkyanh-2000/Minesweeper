public class MainProgram {
    public static void main(String args[]) {
        Board b = new Board();
        b.makeNewBoard();
        b.showEveryCell();
        System.out.println();
        for (Cell i: b.MineList){
            System.out.println("Mine: "+ i.getxPosition() + " " + i.getyPosition() + " || My neighbours are:");
            for (Cell j: i.getMyNeighbours()){
                System.out.print(j.getxPosition() + " " + j.getyPosition() + " ; ");
            }
            System.out.println();
        }

        for (Cell i: b.CellCollection.get(0).getMyNeighbours()){
            System.out.println(i.getxPosition() + " "+ i.getyPosition());
        }
    }
}
