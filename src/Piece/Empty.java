package Piece;
import java.util.List;

/**
 * This class represents the Empty chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class Empty extends Piece {

    /**
     * Constructor method for empty piece.
     */
    public Empty() { }

    /**
     * Dummy method to find legal moves based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves of the selected piece.
     */
    public List<List<int[]>> findMoves(int i, int j) {
        return null;
    }

    /**
     * Getter function for the color property.
     * @return the string representing color of the piece.
     */
    public String getColor() {
        return null;
    }

    /**
     * Gives pawn the ability to be printed as a letter in the grid.
     * @return the string letter representing the piece type.
     */
    @Override
    public String toString() {
        return "_";
    }
}
