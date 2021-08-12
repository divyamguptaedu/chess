import java.util.List;
import java.util.Set;

class Pawn extends Piece {
    Color color;

    Pawn(String color) {
        this.color = new Color(color);
    }

    @Override
    List<Set<Integer>> findMoves(Grid grid) {
        return null;
    }

    @Override
    public String toString() {
        return "P";
    }
}
