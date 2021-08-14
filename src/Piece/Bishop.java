package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {
    private Color color;

    public Bishop(String color) {
        this.color = new Color(color);
    }

    public List<List<int[]>> findMoves(int i, int j) {
        List<List<int[]>> result = new ArrayList<>();
        result.add(this.findMovesUpRight(i, j));
        result.add(this.findMovesUpLeft(i, j));
        result.add(this.findMovesDownRight(i, j));
        result.add(this.findMovesDownLeft(i, j));
        return result;
    }

    private List<int[]> findMovesUpRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0; a--) {
            if (j + b > 7) {
                break;
            }
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    private List<int[]> findMovesUpLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0 ; a--) {
            if (j - b < 0) {
                break;
            }
            result.add(new int[]{a, j - b});
            b++;
        }
        return result;
    }

    private List<int[]> findMovesDownRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            if (j + b > 7) {
                break;
            }
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    private List<int[]> findMovesDownLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            if (j - b < 0) {
                break;
            }
            result.add(new int[]{a, j - b});
            b++;
        }

        return result;
    }

    public String getColor() {
        return color.getColor();
    }
    @Override
    public String toString() {
        return "B";
    }
}
