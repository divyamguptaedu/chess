package Piece;

import java.util.List;
import java.util.Set;

public class Empty extends Piece {

    public Empty() { }

    @Override
    List<Set<Integer>> findMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "_";
    }
}
