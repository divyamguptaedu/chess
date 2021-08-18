package Chess;

import Chess.Piece.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
        int[] indexArray = new int[4];
        gridPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int col  = covertToInt(mouseEvent.getX());
                int row  = covertToInt(mouseEvent.getY());
                indexArray[0] = row;
                indexArray[1] = col;
            }
        });
        gridPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int col  = covertToInt(mouseEvent.getX());
                int row  = covertToInt(mouseEvent.getY());
                indexArray[2] = row;
                indexArray[3] = col;
                processRequest(indexArray, gridPane, grid);
            }
        });
        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static int covertToInt(double x) {
        if (x >= 0.0 && x <= 75.0) {
            return 0;
        }
        if (x >= 75.0 && x <= 150.0) {
            return 1;
        }
        if (x >= 150.0 && x <= 225.0) {
            return 2;
        }
        if (x >= 225.0 && x <= 300.0) {
            return 3;
        }
        if (x >= 300.0 && x <= 375.0) {
            return 4;
        }
        if (x >= 375.0 && x <= 450.0) {
            return 5;
        }
        if (x >= 450.0 && x <= 525.0) {
            return 6;
        }
        if (x >= 525.0 && x <= 600.0) {
            return 7;
        }
        return 8;
    }

    private void processRequest(int[] indexArray, GridPane gridPane, Grid grid) {
        StackPane from = (StackPane) gridPane.getChildren().get((indexArray[0] * 8) + indexArray[1]);
        StackPane to = (StackPane) gridPane.getChildren().get((indexArray[2] * 8) + indexArray[3]);
        ImageView image = (ImageView) from.getChildren().remove(1);
        to.getChildren().add(image);
    }
}