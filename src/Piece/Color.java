package Piece;

import java.util.NoSuchElementException;

public class Color {

    private String color;

    public Color(String color) {
        if (color == "White" || color == "Black") {
            this.setColor(color);
        } else {
            throw new NoSuchElementException("Piece.Color can only be 'White' or 'Black'");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
