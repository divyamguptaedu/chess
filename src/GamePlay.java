import Piece.Empty;
import Piece.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay {

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

    // for king and knight moves;
    private List<int[]> removeFriends(int i, int j, List<int[]> input, Grid grid) {
        String color = grid.grid[i][j].color.color;
        for (int x = 0; i < input.size(); i++) {
            if (grid.grid[input.get(x)[0]][input.get(x)[1]].color.color == color) {
                input.remove(x);
            }
        }
        return input;
    }

    // for bishop, rook, and queen moves;
    private List<List<int[]>> limitTillEnemy(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].color.color;
        List<List<int[]>> result = new ArrayList<>();
        List<int[]> temp;
        for (List<int[]> list : input) {
            temp = new ArrayList<>();
            for (int x = 0; x < list.size(); x++) {
                if (grid.grid[list.get(x)[0]][list.get(x)[1]] instanceof Empty) {
                    temp.add(list.get(x));
                } else {
                    if (grid.grid[list.get(x)[0]][list.get(x)[1]].color.color == color) {
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
    private List<List<int[]>> filterPawnMoves(int i, int j, List<List<int[]>> input, Grid grid) {
        String color = grid.grid[i][j].color.color;
        if (((Pawn) grid.grid[i][j]).firstMoveDone == true) {
            if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                input.get(0).remove(0);
            }
        }
        if (((Pawn) grid.grid[i][j]).firstMoveDone == false) {
            if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                input.get(0).remove(0);
                input.get(0).remove(1);
            } else {
                if (!(grid.grid[input.get(0).get(0)[0]][input.get(0).get(0)[1]] instanceof Empty)) {
                    input.get(0).remove(1);
                }
            }
        }
        for (int x = 0; i < input.get(1).size(); i++) {
            if ((grid.grid[input.get(1).get(x)[0]][input.get(1).get(x)[1]] instanceof Empty) || (grid.grid[input.get(1).get(x)[0]][input.get(1).get(x)[1]].color.color == color)) {
                input.get(1).remove(x);
            }
        }
        return input;
    }
}
