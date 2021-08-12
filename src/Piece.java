import java.util.List;
import java.util.Set;

abstract class Piece {
    Color color;
    abstract List<Set<Integer>> findMoves(Grid grid);
    @Override
    public abstract String toString();
}
