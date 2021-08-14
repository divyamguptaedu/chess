package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Queen extends Piece {
    Color color;

    public Queen(String color) {
        this.color = new Color(color);
    }

    public List<List<int[]>> findMoves(int i, int j) {
        List<List<int[]>> result = new ArrayList<>();
        result.add(this.findMovesUp(i, j));
        result.add(this.findMovesDown(i, j));
        result.add(this.findMovesRight(i, j));
        result.add(this.findMovesLeft(i, j));
        result.add(this.findMovesUpRight(i, j));
        result.add(this.findMovesUpLeft(i, j));
        result.add(this.findMovesDownRight(i, j));
        result.add(this.findMovesDownLeft(i, j));
        return result;
    }

    private List<int[]> findMovesUp(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = i - 1; a >= 0 ; a--) {
            result.add(new int[]{a, j});
        }
        return result;
    }

    private List<int[]> findMovesDown(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = i + 1; a < 8 ; a++) {
            result.add(new int[]{a, j});
        }
        return result;
    }

    private List<int[]> findMovesRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = j + 1; a < 8 ; a++) {
            result.add(new int[]{i, a});
        }
        return result;
    }

    private List<int[]> findMovesLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = j - 1; a >= 0 ; a--) {
            result.add(new int[]{i, a});
        }
        return result;
    }

    private List<int[]> findMovesUpRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0 ; a--) {
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    private List<int[]> findMovesUpLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0 ; a--) {
            result.add(new int[]{a, j - b});
            b++;
        }
        return result;
    }

    private List<int[]> findMovesDownRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    private List<int[]> findMovesDownLeft(int i, int j) {
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
        return "Q";
    }
}
