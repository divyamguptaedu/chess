package Piece;

import java.util.List;
import java.util.Set;

public class Empty extends Piece {

    public Empty() { }

    @Override
    List<int[]> findMoves(int i, int j) {
        return null;
    }
    @Override
    public String toString() {
        return "_";
    }
}
