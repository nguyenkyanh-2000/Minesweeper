import java.util.Scanner;

public class Main {

    private static int count;
    private static Board b;
    public static void main(String[] args) {

        Board b = new Board("BEGINNER");
        System.out.println("Choose game mode: Beginner (Press B), Intermediate (Press I), and Expert (Press E)");
        Scanner scan = new Scanner(System.in);
        char c = scan.nextLine().charAt(0);
        switch (c) {
            case ('B'):
            case ('b'): {
                break;
            }
            case ('I'):
            case ('i'): {
                b = new Board("INTERMEDIATE");
                break;
            }

            case ('E'):
            case ('e'): {
                b = new Board("EXPERT");
                break;
            }
            default:
                throw new IllegalStateException("Wrong value, try again.");
        }

        count = 0;
        while (count != -1 && count < b.getMode().getNumofCells()) {
            boolean check = true;
            b.printBoard();
            System.out.println();
            System.out.println("Choose a cell to interact. The range for x is: 0 - " + (b.getWidth() - 1) +
                    ". The range for y is: 0 - " + (b.getHeight() - 1) + ". Input the x-pos and y-pos.");
            System.out.println("Input x:");
            int x = scan.nextInt();
            System.out.println("Input y:");
            int y = scan.nextInt();
            if (x > b.getWidth() - 1 || x < 0 || y > b.getHeight() - 1 || y < 0) {
                System.out.println("X or Y was incorrect. Try again!");
                continue;
            }
            System.out.println("Left click (L) or Right click (C)?");
            char tmp = scan.next().charAt(0);
            switch (tmp) {
                case 'l':
                case 'L': {
                    b.leftClick(x, y);
                    count++;
                    break;
                }
                case 'r':
                case 'R': {
                    b.rightClick(x, y);
                    break;
                }
                default:{
                    System.out.println("Wrong input! Try again");
                    continue;
                }
            }
        }

        if (count == b.getMode().getNumofCells()){
            System.out.println("You win the game!");
        }
    }
}
