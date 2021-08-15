package Chess.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Rook chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class Rook extends Piece {

    /**
     * The color of the piece which represents the team.
     */
    private final Color color;

    /**
     * Constructor method for rook piece.
     * @param color color of the pawn which represents the team.
     */
    public Rook(String color) {
        this.color = new Color(color);
    }

    /**
     * Method to find legal moves based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves of the selected piece.
     */
    public List<List<int[]>> findMoves(int i, int j) {
        List<List<int[]>> result = new ArrayList<>();
        result.add(this.findMovesUp(i, j));
        result.add(this.findMovesDown(i, j));
        result.add(this.findMovesRight(i, j));
        result.add(this.findMovesLeft(i, j));
        return result;
    }

    /**
     * Method to find legal moves in upward direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves in upward direction of the selected piece.
     */
    private List<int[]> findMovesUp(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = i - 1; a >= 0 ; a--) {
            result.add(new int[]{a, j});
        }
        return result;
    }

    /**
     * Method to find legal moves in downward direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves in downward direction of the selected piece.
     */
    private List<int[]> findMovesDown(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = i + 1; a < 8 ; a++) {
            result.add(new int[]{a, j});
        }
        return result;
    }

    /**
     * Method to find legal moves in right direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves in right direction of the selected piece.
     */
    private List<int[]> findMovesRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = j + 1; a < 8 ; a++) {
            result.add(new int[]{i, a});
        }
        return result;
    }

    /**
     * Method to find legal moves in left direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves in left direction of the selected piece.
     */
    private List<int[]> findMovesLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        for (int a = j - 1; a >= 0 ; a--) {
            result.add(new int[]{i, a});
        }
        return result;
    }

    /**
     * Getter function for the color property.
     * @return the string representing color of the piece.
     */
    public String getColor() {
        return color.getColor();
    }

    /**
     * Gives pawn the ability to be printed as a letter in the grid.
     * @return the string letter representing the piece type.
     */
    @Override
    public String toString() {
        return "R";
    }
}
