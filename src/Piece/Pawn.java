package Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Pawn chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class Pawn extends Piece {
    /**
     * The color of the piece which represents the team.
     */
    private final Color color;

    /**
     * True if the pawn has already made the first move.
     */
    public Boolean firstMoveDone;

    /**
     * Constructor method for pawn piece.
     * @param color color of the pawn which represents the team.
     */
    public Pawn(String color) {
        this.color = new Color(color);
        this.firstMoveDone = false;
    }

    /**
     * Method to find legal moves based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves of the selected piece.
     */
    public List<List<int[]>> findMoves(int i, int j) {
        List<List<int[]>> result = new ArrayList<>();
        result.add(this.findMovesAhead(i, j));
        result.add(this.findMovesToKill(i, j));
        return result;
    }

    /**
     * Method to find legal moves in front based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of legal moves in front of the selected piece.
     */
    private List<int[]> findMovesAhead(int i, int j) {
        List<int[]> result = new ArrayList<>();
        if (this.color.getColor().equals("White")) {
            result.add(new int[]{i + 1, j});
            if (!this.firstMoveDone) {
                result.add(new int[]{i + 2, j});
            }
        }
        if (this.color.getColor().equals("Black")) {
            result.add(new int[]{i - 1, j});
            if (!this.firstMoveDone) {
                result.add(new int[]{i - 2, j});
            }
        }
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
                k--;
            }
        }
        return result;
    }

    /**
     * Method to find legal moves diagonally based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of diagonally legal moves of the selected piece.
     */
    private List<int[]> findMovesToKill(int i, int j) {
        List<int[]> result = new ArrayList<>();
        if (this.color.getColor().equals("White")) {
            result.add(new int[]{i + 1, j - 1});
            result.add(new int[]{i + 1, j + 1});
        }
        if (this.color.getColor().equals("Black")) {
            result.add(new int[]{i - 1, j - 1});
            result.add(new int[]{i - 1, j + 1});
        }
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
                k--;
            }
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
        return "P";
    }
}
