package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Piece {
    public Color color;

    public abstract List<List<int[]>> findMoves(int i, int j);

    @Override
    public abstract String toString();

    public abstract String getColor();
}
