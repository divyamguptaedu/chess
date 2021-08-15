package Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Bishop chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class Bishop extends Piece {

    /**
     * The color of the piece which represents the team.
     */
    private final Color color;

    /**
     * Constructor method for bishop piece.
     * @param color color of the pawn which represents the team.
     */
    public Bishop(String color) {
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
        result.add(this.findMovesUpRight(i, j));
        result.add(this.findMovesUpLeft(i, j));
        result.add(this.findMovesDownRight(i, j));
        result.add(this.findMovesDownLeft(i, j));
        return result;
    }

    /**
     * Method to find legal moves in up-right direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of legal moves in up-right direction of the selected piece.
     */
    private List<int[]> findMovesUpRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0; a--) {
            if (j + b > 7) {
                break;
            }
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    /**
     * Method to find legal moves in up-left direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of legal moves in up-left direction of the selected piece.
     */
    private List<int[]> findMovesUpLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i - 1; a >= 0 ; a--) {
            if (j - b < 0) {
                break;
            }
            result.add(new int[]{a, j - b});
            b++;
        }
        return result;
    }

    /**
     * Method to find legal moves in down-right direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of legal moves in down-right direction of the selected piece.
     */
    private List<int[]> findMovesDownRight(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            if (j + b > 7) {
                break;
            }
            result.add(new int[]{a, j + b});
            b++;
        }
        return result;
    }

    /**
     * Method to find legal moves in down-left direction based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of legal moves in down-left direction of the selected piece.
     */
    private List<int[]> findMovesDownLeft(int i, int j) {
        List<int[]> result = new ArrayList<>();
        int b = 1;
        for (int a = i + 1; a < 8 ; a++) {
            if (j - b < 0) {
                break;
            }
            result.add(new int[]{a, j - b});
            b++;
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
        return "B";
    }
}
