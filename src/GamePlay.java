import Piece.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay {

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.displayGrid();
        boolean blackMove = true;
        boolean gameEnd = false;
        Scanner scanner = new Scanner(System.in);
        String temp;
        int i = 0;
        while (!gameEnd) {
            i++;
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
            System.out.println("Enter coloum index: ");
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
            if (blackMove && grid.grid[i1][j1].getColor() != "Black") {
                System.out.println("It's not your turn.");
                continue;
            }
            if (!blackMove && grid.grid[i1][j1].getColor() != "White") {
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
            if (i1 < 0 || i1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            System.out.println("Enter coloum index: ");
            temp = scanner.next();
            if (temp.equals("END")) {
                gameEnd = true;
                continue;
            }
            int j2 = Integer.parseInt(temp);
            if (j1 < 0 || j1 > 7) {
                System.out.println("That's an invalid position.");
                continue;
            }
            if (grid.grid[i1][j1] instanceof Pawn) {
                if (!contains(i2, j2, filterPawnMoves(i1, j1, (grid.grid[i1][j1]).findMoves(i1, j1), grid))) {
                    System.out.println("That's an invalid move.");
                    continue;
                }
            }
            if (grid.grid[i1][j1] instanceof Bishop || grid.grid[i1][j1] instanceof Rook || grid.grid[i1][j1] instanceof Queen) {
                if (!contains(i2, j2, limitTillEnemy(i1, j1, (grid.grid[i1][j1]).findMoves(i1, j1), grid))) {
                    System.out.println("That's an invalid move.");
                    continue;
                }
            }
            if (grid.grid[i1][j1] instanceof King || grid.grid[i1][j1] instanceof Knight) {
                if (!contains(i2, j2, removeFriends(i1, j1, (grid.grid[i1][j1]).findMoves(i1, j1), grid))) {
                    System.out.println("That's an invalid move.");
                    continue;
                }
            }
            if (!(grid.grid[i2][j2] instanceof Empty)) {
                grid.grid[i2][j2] = new Empty();
            }
            if (grid.grid[i1][j1] instanceof Pawn) {
                ((Pawn) grid.grid[i1][j1]).firstMoveDone = true;
            }
            if (grid.grid[i2][j2] instanceof King) {
                String color = grid.grid[i1][j1].getColor();
                grid.swap(i1, j1, i2, j2);
                grid.displayGrid();
                System.out.println("Congratulations! The " + color + " team won!");
                gameEnd = true;
            } else {
                blackMove = !blackMove;
                grid.swap(i1, j1, i2, j2);
                grid.displayGrid();
            }
        }
    }

    // for king and knight moves;
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

    // for bishop, rook, and queen moves;
    private static List<List<int[]>> limitTillEnemy(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].getColor();
        List<List<int[]>> result = new ArrayList<>();
        List<int[]> temp;
        for (List<int[]> list : input) {
            temp = new ArrayList<>();
            for (int x = 0; x < list.size(); x++) {
                if (grid.grid[list.get(x)[0]][list.get(x)[1]] instanceof Empty) {
                    temp.add(list.get(x));
                } else {
                    if (grid.grid[list.get(x)[0]][list.get(x)[1]].getColor().equals(color)) {
                        result.add(temp);
                        break;
                    } else {
                        temp.add(list.get(x));
                        result.add(temp);
                        break;
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }

    // for pawn moves;
    private static List<List<int[]>> filterPawnMoves(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].getColor();
        if (((Pawn) grid.grid[i][j]).firstMoveDone == true) {
            if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                input.get(0).remove(0);
            }
        }
        if (((Pawn) grid.grid[i][j]).firstMoveDone == false) {
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

    private static boolean contains(int i, int j, List<List<int[]>> input) {
        for (List<int[]> list : input) {
            for (int[] set : list) {
                if (set[0] == i && set[1] == j) {
                    return true;
                }
            }
        }
        return false;
    }
}
