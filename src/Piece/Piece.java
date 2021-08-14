package Piece;

import java.util.List;
import java.util.Set;

public abstract class Piece {
    Color color;
    abstract List<int[]> findMoves(int i, int j);
    @Override
    public abstract String toString();
}
