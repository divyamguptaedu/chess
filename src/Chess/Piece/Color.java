package Chess.Piece;
import java.util.NoSuchElementException;

/**
 * This class represents the color property of the chess piece.
 * @author DIVYAM GUPTA
 * @version 1.0
 */
public class Color {

    /**
     * The color of the piece which represents the team.
     */
    private String color;

    /**
     * The constructor method for the color object.
     * @param color the row index of the piece to be moved.
     */
    public Color(String color) {
        if (color.equals("White") || color.equals("Black")) {
            this.setColor(color);
        } else {
            throw new NoSuchElementException("Chess.Piece.Color can only be 'White' or 'Black'");
        }
    }

    /**
     * Getter function for the color property.
     * @return the string representing color of the piece.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter function for the color property.
     * @param color string representing color of the piece.
     */
    public void setColor(String color) {
        this.color = color;
    }
}
