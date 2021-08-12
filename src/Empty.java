import java.util.List;
import java.util.Set;

class Empty extends Piece {

    Empty() { }

    @Override
    List<Set<Integer>> findMoves(Grid grid) {
        return null;
    }

    @Override
    public String toString() {
        return "_";
    }
}
