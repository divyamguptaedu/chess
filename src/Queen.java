import java.util.List;
import java.util.Set;

class Queen extends Piece {
    Color color;

    Queen(String color) {
        this.color = new Color(color);
    }

    @Override
    List<Set<Integer>> findMoves(Grid grid) {
        return null;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
