import java.util.List;
import java.util.Set;

class Knight extends Piece {
    Color color;

    Knight(String color) {
        this.color = new Color(color);
    }

    @Override
    List<Set<Integer>> findMoves(Grid grid) {
        return null;
    }

    @Override
    public String toString() {
        return "N";
    }
}
