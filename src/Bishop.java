import java.util.List;
import java.util.Set;

class Bishop extends Piece {
    Color color;

    Bishop(String color) {
        this.color = new Color(color);
    }

    @Override
    List<Set<Integer>> findMoves(Grid grid) {
        return null;
    }

    @Override
    public String toString() {
        return "B";
    }
}
