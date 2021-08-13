import Piece.Empty;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.displayGrid();

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            i++;
            System.out.println("Which piece do you want to move?");
            System.out.println("Enter row index: ");
            int i1 = scanner.nextInt();
            if (i1 < 0 || i1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            System.out.println("Enter coloum index: ");
            int j1 = scanner.nextInt();
            if (j1 < 0 || j1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            if (grid.grid[i1][j1] instanceof Empty) {
                System.out.println("There is no chess piece at this location.");
                continue;
            }
            System.out.println("Where do you want to move this piece?");
            System.out.println("Enter row index: ");
            int i2 = scanner.nextInt();
            if (i1 < 0 || i1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            System.out.println("Enter coloum index: ");
            int j2 = scanner.nextInt();
            if (j1 < 0 || j1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            if (!(grid.grid[i2][j2] instanceof Empty)) {
                grid.grid[i2][j2] = new Empty();
            }
            grid.swap(i1, j1, i2, j2);
            grid.displayGrid();
        }
    }
}
