import java.util.List;
import java.util.Set;

class Rook extends Piece {
    Color color;

    Rook(String color) {
        this.color = new Color(color);
    }

    @Override
    List<Set<Integer>> findMoves(Grid grid) {
        return null;
    }

    @Override
    public String toString() {
        return "R";
    }
}
