package Piece;

import java.util.List;
import java.util.Set;

public abstract class Piece {
    Color color;
    abstract List<Set<Integer>> findMoves();
    @Override
    public abstract String toString();
}
