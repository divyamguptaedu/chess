package Chess;

import Chess.Piece.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override
    public void start(Stage primaryStage) {
        Grid grid = new Grid();
        GridPane gridPane = new GridPane();
        StackPane stackPane;
        Image image = null;
        ImageView imageView;
        int count = 0;
        double size = 75;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                stackPane = new StackPane();

                Rectangle rectangle = new Rectangle(size, size, size, size);
                if (count % 2 != 0) {
                    rectangle.setFill(Color.WHITE);
                }
                stackPane.getChildren().add(rectangle);

                if (!(grid.grid[i][j] instanceof Empty)) {
                    if (grid.grid[i][j] instanceof Pawn) {
                        if (grid.grid[i][j].getColor().equals("White")) {
                            image = new Image("pawn_white.png");
                        }
                        if (grid.grid[i][j].getColor().equals("Black")) {
                            image = new Image("pawn_black.png");
                        }
                    }
                    if (grid.grid[i][j] instanceof Rook) {
                        if (grid.grid[i][j].getColor().equals("White")) {
                            image = new Image("rook_white.png");
                        }
                        if (grid.grid[i][j].getColor().equals("Black")) {
                            image = new Image("rook_black.png");
                        }
                    }
                    if (grid.grid[i][j] instanceof Bishop) {
                        if (grid.grid[i][j].getColor().equals("White")) {
                            image = new Image("bishop_white.png");
                        }
                        if (grid.grid[i][j].getColor().equals("Black")) {
                            image = new Image("bishop_black.png");
                        }
                    }
                    if (grid.grid[i][j] instanceof Queen) {
                        if (grid.grid[i][j].getColor().equals("White")) {
                            image = new Image("queen_white.png");
                        }
                        if (grid.grid[i][j].getColor().equals("Black")) {
                            image = new Image("queen_black.png");
                        }
                    }
                    if (grid.grid[i][j] instanceof King) {
                        if (grid.grid[i][j].getColor().equals("White")) {
                            image = new Image("king_white.png");
                        }
                        if (grid.grid[i][j].getColor().equals("Black")) {
                            image = new Image("king_black.png");
                        }
                    }
                    if (grid.grid[i][j] instanceof Knight) {
                        if (grid.grid[i][j].getColor().equals("White")) {
                            image = new Image("knight_white.png");
                        }
                        if (grid.grid[i][j].getColor().equals("Black")) {
                            image = new Image("knight_black.png");
                        }
                    }
                    imageView = new ImageView(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(75);
                    stackPane.getChildren().add(imageView);
                }
                gridPane.add(stackPane, j, i);
                count++;
            }
        }
        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}