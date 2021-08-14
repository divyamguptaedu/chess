package Piece;

import java.util.List;
import java.util.Set;

public class Rook extends Piece {
    Color color;

    public Rook(String color) {
        this.color = new Color(color);
    }

    @Override
    List<int[]> findMoves(int i, int j) {
        return null;
    }
    @Override
    public String toString() {
        return "R";
    }
}
