class Color {

    String color;

    Color(String color) {
        if (color == "White" || color == "Black") {
            this.color = color;
        }
        this.color = "";
    }

    public String getColor() {
        return this.color;
    }
}
