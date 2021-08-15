package Chess.Piece;
import java.util.List;

/**
 * This abstract class represents the basic properties of a chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public abstract class Piece {
    /**
     * The color of the piece which represents the team.
     */
    public Color color;

    /**
     * Every piece type should have a method to find legal moves based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves of the selected piece.
     */
    public abstract List<List<int[]>> findMoves(int i, int j);

    /**
     * Every piece type should have the ability to be printed as a letter in the grid.
     * @return the string letter representing the piece type.
     */
    @Override
    public abstract String toString();

    /**
     * Getter function for the color property.
     * @return the string representing color of the piece.
     */
    public abstract String getColor();
}
