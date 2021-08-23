package Chess;

import Chess.Piece.*;

import java.util.HashMap;

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
    HashMap<Piece, int[]> blackPieces;
    HashMap<Piece, int[]> whitePieces;
    Piece blackKing;
    Piece whiteKing;

    /**
     * Constructor method for grid object. Builds a default 8x8 grid.
     */
    Grid() {
        grid = new Piece[8][8];
        blackPieces = new HashMap<>();
        whitePieces = new HashMap<>();
        defaultGrid();
    }

    /**
     * Builds a default start-up grid with all pieces at traditional starting location.
     */
    void defaultGrid() {
        grid[0][0] = new Rook("White");
        whitePieces.put(grid[0][0], new int[] {0, 0});
        grid[0][1] = new Knight("White");
        whitePieces.put(grid[0][1], new int[] {0, 1});
        grid[0][2] = new Bishop("White");
        whitePieces.put(grid[0][2], new int[] {0, 2});
        grid[0][3] = new Queen("White");
        whitePieces.put(grid[0][3], new int[] {0, 3});
        grid[0][4] = new King("White");
        whitePieces.put(grid[0][4], new int[] {0, 4});
        whiteKing = grid[0][4];
        grid[0][5] = new Bishop("White");
        whitePieces.put(grid[0][5], new int[] {0, 5});
        grid[0][6] = new Knight("White");
        whitePieces.put(grid[0][6], new int[] {0, 6});
        grid[0][7] = new Rook("White");
        whitePieces.put(grid[0][7], new int[] {0, 7});

        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Pawn("White");
                whitePieces.put(grid[i][j], new int[] {i, j});
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
                blackPieces.put(grid[i][j], new int[] {i, j});
            }
        }
        grid[7][0] = new Rook("Black");
        blackPieces.put(grid[7][0], new int[] {7, 0});
        grid[7][1] = new Knight("Black");
        blackPieces.put(grid[7][1], new int[] {7, 1});
        grid[7][2] = new Bishop("Black");
        blackPieces.put(grid[7][2], new int[] {7, 2});
        grid[7][3] = new Queen("Black");
        blackPieces.put(grid[7][3], new int[] {7, 3});
        grid[7][4] = new King("Black");
        blackPieces.put(grid[7][4], new int[] {7, 4});
        blackKing = grid[7][4];
        grid[7][5] = new Bishop("Black");
        blackPieces.put(grid[7][5], new int[] {7, 5});
        grid[7][6] = new Knight("Black");
        blackPieces.put(grid[7][6], new int[] {7, 6});
        grid[7][7] = new Rook("Black");
        blackPieces.put(grid[7][7], new int[] {7, 7});

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
