package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {
    Color color;

    public Bishop(String color) {
        this.color = new Color(color);
    }

    public List<int[]> findMovesUpRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0 ; a--) {
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    public List<int[]> findMovesUpLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0 ; a--) {
            result.add(new int[]{a, j - b});
            b++;
        }
        return result;
    }

    public List<int[]> findMovesDownRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    public List<int[]> findMovesDownLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            result.add(new int[]{a, j - b});
            b++;
        }
        return result;
    }

    @Override
    public String toString() {
        return "B";
    }
}
