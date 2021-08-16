package Chess;

import Chess.Piece.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the gameplay mechanism.
 * It consists of methods that filter out possible moves for each piece based on the current grid status.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class GamePlay {

    public static void main(String[] args) {
        play();
    }
    /**
     * This method runs the whole mechanism of creating, displaying, editing, and updating the grid.
     */
    static void play() {
        Grid grid = new Grid();
        grid.displayGrid();
        boolean blackMove = true;
        boolean gameEnd = false;
        Scanner scanner = new Scanner(System.in);
        String temp;
        while (!gameEnd) {
            System.out.println("Which piece do you want to move? (Type END to exit game.)");
            System.out.println("Enter row index: ");
            temp = scanner.next();
            if (temp.equals("END")) {
                gameEnd = true;
                continue;
            }
            int i1 = Integer.parseInt(temp);
            if (i1 < 0 || i1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            System.out.println("Enter column index: ");
            temp = scanner.next();
            if (temp.equals("END")) {
                gameEnd = true;
                continue;
            }
            int j1 = Integer.parseInt(temp);
            if (j1 < 0 || j1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            if (grid.grid[i1][j1] instanceof Empty) {
                System.out.println("There is no chess piece at this location.");
                continue;
            }
            if (blackMove && !grid.grid[i1][j1].getColor().equals("Black")) {
                System.out.println("It's not your turn.");
                continue;
            }
            if (!blackMove && !grid.grid[i1][j1].getColor().equals("White")) {
                System.out.println("It's not your turn.");
                continue;
            }
            System.out.println("Where do you want to move this piece? (Type END to exit game.)");
            System.out.println("Enter row index: ");
            temp = scanner.next();
            if (temp.equals("END")) {
                gameEnd = true;
                continue;
            }
            int i2 = Integer.parseInt(temp);
            if (i2 < 0 || i2 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            System.out.println("Enter column index: ");
            temp = scanner.next();
            if (temp.equals("END")) {
                gameEnd = true;
                continue;
            }
            int j2 = Integer.parseInt(temp);
            if (j2 < 0 || j2 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            if (grid.grid[i1][j1] instanceof Pawn) {
                if (contains(i2, j2, filterPawnMoves(i1, j1, (grid.grid[i1][j1]).findMoves(i1, j1), grid))) {
                    System.out.println("That's an invalid move.");
                    continue;
                }
            }
            if (grid.grid[i1][j1] instanceof Bishop || grid.grid[i1][j1] instanceof Rook || grid.grid[i1][j1] instanceof Queen) {
                if (contains(i2, j2, limitTillEnemy(i1, j1, (grid.grid[i1][j1]).findMoves(i1, j1), grid))) {
                    System.out.println("That's an invalid move.");
                    continue;
                }
            }
            if (grid.grid[i1][j1] instanceof King || grid.grid[i1][j1] instanceof Knight) {
                if (contains(i2, j2, removeFriends(i1, j1, (grid.grid[i1][j1]).findMoves(i1, j1), grid))) {
                    System.out.println("That's an invalid move.");
                    continue;
                }
            }
            if (grid.grid[i1][j1] instanceof Pawn) {
                ((Pawn) grid.grid[i1][j1]).firstMoveDone = true;
            }
            if (grid.grid[i2][j2] instanceof King) {
                String color = grid.grid[i1][j1].getColor();
                grid.grid[i2][j2] = new Empty();
                grid.swap(i1, j1, i2, j2);
                grid.displayGrid();
                System.out.println("Congratulations! The " + color + " team won!");
                gameEnd = true;
            } else {
                if (!(grid.grid[i2][j2] instanceof Empty)) {
                    grid.grid[i2][j2] = new Empty();
                }
                blackMove = !blackMove;
                grid.swap(i1, j1, i2, j2);
                grid.displayGrid();
            }
        }
    }

    /**
     * Removes those moves where there exists a piece of the same team. Primarily used for king and knight piece moves.
     * @param i the row index of the piece to be moved.
     * @param j  the column index of the piece to be moved.
     * @param input  the list of all preliminary legal moves of the selected piece.
     * @param grid  the current grid status.
     * @return the list of all totally legal moves of the selected piece.
     */
    private static List<List<int[]>> removeFriends(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].getColor();
        for (int x = 0; x < input.get(0).size(); x++) {
            if (!(grid.grid[input.get(0).get(x)[0]][input.get(0).get(x)[1]] instanceof Empty)) {
                if (grid.grid[input.get(0).get(x)[0]][input.get(0).get(x)[1]].getColor().equals(color)) {
                    input.get(0).remove(x);
                    x--;
                }
            }
        }
        return input;
    }

    /**
     * Removes illegal moves for those pieces who cannot leap over others.
     * Primarily used for bishop, queen, and rook piece moves.
     * @param i the row index of the piece to be moved.
     * @param j  the column index of the piece to be moved.
     * @param input  the list of all preliminary legal moves of the selected piece.
     * @param grid  the current grid status.
     * @return the list of all totally legal moves of the selected piece.
     */
    private static List<List<int[]>> limitTillEnemy(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].getColor();
        List<List<int[]>> result = new ArrayList<>();
        List<int[]> temp;
        for (List<int[]> list : input) {
            temp = new ArrayList<>();
            for (int[] ints : list) {
                if (grid.grid[ints[0]][ints[1]] instanceof Empty) {
                    temp.add(ints);
                } else {
                    if (!grid.grid[ints[0]][ints[1]].getColor().equals(color)) {
                        temp.add(ints);
                    }
                    result.add(temp);
                    break;
                }
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * Removes illegal moves for pawns based on their first move or diagonal move to kill the opponent.
     * @param i the row index of the piece to be moved.
     * @param j  the column index of the piece to be moved.
     * @param input  the list of all preliminary legal moves of the selected piece.
     * @param grid  the current grid status.
     * @return the list of all totally legal moves of the selected piece.
     */
    private static List<List<int[]>> filterPawnMoves(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].getColor();
        if (((Pawn) grid.grid[i][j]).firstMoveDone) {
            if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                input.get(0).remove(0);
            }
        }
        if (!((Pawn) grid.grid[i][j]).firstMoveDone) {
            if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                System.out.println(input.get(0).size());
                input.get(0).remove(0);
                input.get(0).remove(0);
            } else {
                if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                    input.get(0).remove(1);
                }
            }
        }
        for (int x = 0; x < input.get(1).size(); x++) {
            if ((grid.grid[input.get(1).get(x)[0]][input.get(1).get(x)[1]] instanceof Empty) || (grid.grid[input.get(1).get(x)[0]][input.get(1).get(x)[1]].getColor().equals(color))) {
                input.get(1).remove(x);
                x--;
            }
        }
        return input;
    }

    /**
     * Checks if a move is present in the list of legal moves.
     * @param i the row index of the location where the piece is to be moved.
     * @param j  the column index of the location where the piece is to be moved.
     * @param input  the list of all preliminary legal moves of the selected piece.
     * @return true if the move is legal, false if not.
     */
    private static boolean contains(int i, int j, List<List<int[]>> input) {
        for (List<int[]> list : input) {
            for (int[] set : list) {
                if (set[0] == i && set[1] == j) {
                    return false;
                }
            }
        }
        return true;
    }
}
