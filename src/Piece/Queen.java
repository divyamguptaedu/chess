package Piece;

import java.util.List;
import java.util.Set;

public class Queen extends Piece {
    Color color;

    public Queen(String color) {
        this.color = new Color(color);
    }

    @Override
    List<Set<Integer>> findMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
