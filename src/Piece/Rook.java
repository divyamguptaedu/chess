package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rook extends Piece {
    Color color;

    public Rook(String color) {
        this.color = new Color(color);
    }

    public List<List<int[]>> findMoves(int i, int j) {
        List<List<int[]>> result = new ArrayList<>();
        result.add(this.findMovesUp(i, j));
        result.add(this.findMovesDown(i, j));
        result.add(this.findMovesRight(i, j));
        result.add(this.findMovesLeft(i, j));
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

    @Override
    public String toString() {
        return "R";
    }
}
