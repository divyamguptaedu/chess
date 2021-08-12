import java.util.Arrays;

class Grid {
    String[][] grid;
    Grid() {
        grid = new String[8][8];
    }

    void defaultGrid() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = "_";
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = "A";
            }
        }
        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = "A";
            }
        }
    }

    void displayGrid() {
        System.out.println("");
        System.out.println("---------------------------------");
        for (String[] row : grid) {
            System.out.print("| ");
            for (String index : row) {
                System.out.print(index);
                System.out.print(" | ");
            }
            System.out.println("");
        }
        System.out.println("---------------------------------");
        System.out.println("");
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.defaultGrid();
        grid.displayGrid();
    }
}
