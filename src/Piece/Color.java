package Piece;

import java.util.NoSuchElementException;

class Color {

    String color;

    Color(String color) {
        if (color == "White" || color == "Black") {
            this.color = color;
        } else {
            throw new NoSuchElementException("Piece.Color can only be 'White' or 'Black'");
        }
    }

    public String getColor() {
        return this.color;
    }
}
