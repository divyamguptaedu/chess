package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rook extends Piece {
    Color color;

    public Rook(String color) {
        this.color = new Color(color);
    }

    @Override
    public List<int[]> findMoves(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = 0; a < 8; a++) {
            if (a != i) result.add(new int[]{a, j});
        }
        for (int b = 0; b < 8; b++) {
            if (b != j) result.add(new int[]{i, b});
        }
        return result;
    }

    @Override
    public String toString() {
        return "R";
    }
}
