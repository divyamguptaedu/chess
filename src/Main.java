public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.displayGrid();
        grid.swap(0, 4, 4, 6);
        grid.displayGrid();
    }
}
