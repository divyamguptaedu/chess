import Piece.Bishop;
import Piece.Empty;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;

import java.util.Set;

public class Grid {
    Piece[][] grid;
    Grid() {
        grid = new Piece[8][8];
        defaultGrid();
    }

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

    void swap(int i1, int j1, int i2, int j2) {
        Piece temp = grid[i1][j1];
        grid[i1][j1] = grid[i2][j2];
        grid[i2][j2] = temp;
    }
}
