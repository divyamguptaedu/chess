package Chess.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the King chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class King extends Piece {
    /**
     * The color of the piece which represents the team.
     */
    private final Color color;

    /**
     * Constructor method for king piece.
     * @param color color of the pawn which represents the team.
     */
    public King(String color) {
        this.color = new Color(color);
    }

    /**
     * Method to find legal moves based on current position.
     * @param i the row index of the piece to be moved.
     * @param j the column index of the piece to be moved.
     * @return the list of all totally legal moves of the selected piece.
     */
    public List<List<int[]>> findMoves(int i, int j) {
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{i - 1, j});
        result.add(new int[]{i + 1, j});
        result.add(new int[]{i, j - 1});
        result.add(new int[]{i, j + 1});
        result.add(new int[]{i - 1, j - 1});
        result.add(new int[]{i - 1, j + 1});
        result.add(new int[]{i + 1, j - 1});
        result.add(new int[]{i + 1, j + 1});
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
                k--;
            }
        }
        List<List<int[]>> finalResult = new ArrayList<>();
        finalResult.add(result);
        return finalResult;
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
        return "K";
    }
}
