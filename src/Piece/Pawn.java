package Piece;

import java.util.List;
import java.util.Set;

public class Pawn extends Piece {
    Color color;

    public Pawn(String color) {
        this.color = new Color(color);
    }

    List<int[]> findMoves(int i, int j) {
        return null;
    }
    @Override
    public String toString() {
        return "P";
    }
}
