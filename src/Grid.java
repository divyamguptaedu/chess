import Piece.Bishop;
import Piece.Empty;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;

/**
 * This class represents the chess 8x8 grid.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
class Grid {
    /**
     * The two-dimensional piece grid.
     */
    Piece[][] grid;

    /**
     * Constructor method for grid object. Builds a default 8x8 grid.
     */
    Grid() {
        grid = new Piece[8][8];
        defaultGrid();
    }

    /**
     * Builds a default start-up grid with all pieces at traditional starting location.
     */
    void defaultGrid() {
        grid[0][0] = new Rook("White");
        grid[0][1] = new Knight("White");
        grid[0][2] = new Bishop("White");
        grid[0][3] = new Queen("White");
        grid[0][4] = new King("White");
        grid[0][5] = new Bishop("White");
        grid[0][6] = new Knight("White");
        grid[0][7] = new Rook("White");
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Pawn("White");
            }
        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Empty();
            }
        }
        for (int i = 6; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Pawn("Black");
            }
        }
        grid[7][0] = new Rook("Black");
        grid[7][1] = new Knight("Black");
        grid[7][2] = new Bishop("Black");
        grid[7][3] = new Queen("Black");
        grid[7][4] = new King("Black");
        grid[7][5] = new Bishop("Black");
        grid[7][6] = new Knight("Black");
        grid[7][7] = new Rook("Black");
    }

    /**
     * Displays the grid of pieces in an easy to understand manner.
     */
    void displayGrid() {
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("   [| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |]   ");
        System.out.println("-----------------------------------------");
        int legend = 0;
        for (Piece[] row : grid) {
            System.out.printf(" " + legend + " [|", legend);
            for (Piece index : row) {
                System.out.print(" " + index);
                System.out.print(" |");
            }
            System.out.print("] " + legend);
            legend++;
            System.out.println();
        }
        System.out.println("-----------------------------------------");
        System.out.println("   [| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |]   ");
        System.out.println("-----------------------------------------");
        System.out.println();
    }

    /**
     * Removes those moves where there exists a piece of the same team. Primarily used for king and knight piece moves.
     * @param i1 the row index of the piece to be moved.
     * @param j1  the column index of the piece to be moved.
     * @param i2  the row index of the location the piece is to be moved.
     * @param j2  the column index of the location the piece is to be moved.
     */
    void swap(int i1, int j1, int i2, int j2) {
        Piece temp = grid[i1][j1];
        grid[i1][j1] = grid[i2][j2];
        grid[i2][j2] = temp;
    }

}
