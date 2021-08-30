package Chess;

import Chess.Piece.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static Chess.GamePlay.*;

public class Interface extends Application {

    boolean blackMove = true;

    public static void main(String[] args) {
        launch(args);
    }

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
        Button checkforCheckMate = new Button();
        checkforCheckMate.setText("Checkmate");
        Font fontOne = Font.font("Helvetica", FontWeight.BOLD, 20);
        checkforCheckMate.setFont(fontOne);
        checkforCheckMate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Alert textAlert = new Alert(Alert.AlertType.INFORMATION);
                    textAlert.setTitle("Checkmate");
                    textAlert.setHeaderText("Think again!");
                    textAlert.setContentText("The opponent still has a way to save the king.");
                    textAlert.showAndWait();
            }
        });

        Button exit = new Button();
        exit.setText("Exit Game");
        Font fontTwo = Font.font("Helvetica", FontWeight.BOLD, 20);
        exit.setFont(fontTwo);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(checkforCheckMate, exit);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(100);
        vbox.getChildren().addAll(gridPane, hbox);
        Scene sceneTwo = new Scene(vbox, 600, 639);
        StackPane welcomeScreen = new StackPane();
        Image chess = new Image("chess.jpeg");
        ImageView chessBackground = new ImageView(chess);
        chessBackground.setFitHeight(650);
        chessBackground.setFitWidth(800);
        Button startGame = new Button();
        startGame.setText("Start Game");
        Font fontThree = Font.font("Helvetica", FontWeight.BOLD, 36);
        startGame.setFont(fontThree);
        startGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(sceneTwo);
                primaryStage.show();
            }
        });
        welcomeScreen.getChildren().addAll(chessBackground, startGame);
        Scene sceneOne = new Scene(welcomeScreen, 600, 639);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(sceneOne);
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
        if (from.getChildren().size() == 1) {
            Alert textAlert = new Alert(Alert.AlertType.ERROR);
            textAlert.setTitle("Error Dialog");
            textAlert.setHeaderText("Invalid Move");
            textAlert.setContentText("There is no chess piece present there.");
            textAlert.showAndWait();
            return;
        }
        if (blackMove && !grid.grid[indexArray[0]][indexArray[1]].getColor().equals("Black")) {
            Alert textAlert = new Alert(Alert.AlertType.ERROR);
            textAlert.setTitle("Error Dialog");
            textAlert.setHeaderText("Invalid Move");
            textAlert.setContentText("This is not your turn.");
            textAlert.showAndWait();
            return;
        }
        if (!blackMove && !grid.grid[indexArray[0]][indexArray[1]].getColor().equals("White")) {
            Alert textAlert = new Alert(Alert.AlertType.ERROR);
            textAlert.setTitle("Error Dialog");
            textAlert.setHeaderText("Invalid Move");
            textAlert.setContentText("This is not your turn.");
            textAlert.showAndWait();
            return;
        }
        StackPane to = (StackPane) gridPane.getChildren().get((indexArray[2] * 8) + indexArray[3]);
        if (grid.grid[indexArray[0]][indexArray[1]] instanceof Pawn) {
                if (!contains(indexArray[2], indexArray[3], filterPawnMoves(indexArray[0], indexArray[1], (grid.grid[indexArray[0]][indexArray[1]]).findMoves(indexArray[0], indexArray[1]), grid))) {
                    Alert textAlert = new Alert(Alert.AlertType.ERROR);
                    textAlert.setTitle("Error Dialog");
                    textAlert.setHeaderText("Invalid Move");
                    textAlert.setContentText("Wrong destination.");
                    textAlert.showAndWait();
                    return;
                }
            }
        if (grid.grid[indexArray[0]][indexArray[1]] instanceof Bishop || grid.grid[indexArray[0]][indexArray[1]] instanceof Rook || grid.grid[indexArray[0]][indexArray[1]] instanceof Queen) {
                if (!contains(indexArray[2], indexArray[3], limitTillEnemy(indexArray[0], indexArray[1], (grid.grid[indexArray[0]][indexArray[1]]).findMoves(indexArray[0], indexArray[1]), grid))) {
                    Alert textAlert = new Alert(Alert.AlertType.ERROR);
                    textAlert.setTitle("Error Dialog");
                    textAlert.setHeaderText("Invalid Move");
                    textAlert.setContentText("Wrong destination.");
                    textAlert.showAndWait();
                    return;
                }
            }
        if (grid.grid[indexArray[0]][indexArray[1]] instanceof King || grid.grid[indexArray[0]][indexArray[1]] instanceof Knight) {
                if (!contains(indexArray[2], indexArray[3], removeFriends(indexArray[0], indexArray[1], (grid.grid[indexArray[0]][indexArray[1]]).findMoves(indexArray[0], indexArray[1]), grid))) {
                    Alert textAlert = new Alert(Alert.AlertType.ERROR);
                    textAlert.setTitle("Error Dialog");
                    textAlert.setHeaderText("Invalid Move");
                    textAlert.setContentText("Wrong destination.");
                    textAlert.showAndWait();
                    return;
                }
            }
        if (grid.grid[indexArray[0]][indexArray[1]] instanceof Pawn) {
            ((Pawn) grid.grid[indexArray[0]][indexArray[1]]).firstMoveDone = true;
        }
        if (grid.grid[indexArray[2]][indexArray[3]] instanceof King) {
            if (grid.grid[indexArray[2]][indexArray[3]].getColor().equals("Black")) {
                grid.blackPieces.remove(grid.grid[indexArray[2]][indexArray[3]]);
                grid.whitePieces.put(grid.grid[indexArray[0]][indexArray[1]], new int[] {indexArray[2], indexArray[3]});
            }
            if (grid.grid[indexArray[2]][indexArray[3]].getColor().equals("White")) {
                grid.whitePieces.remove(grid.grid[indexArray[2]][indexArray[3]]);
                grid.blackPieces.put(grid.grid[indexArray[0]][indexArray[1]], new int[] {indexArray[2], indexArray[3]});
            }
            grid.grid[indexArray[2]][indexArray[3]] = new Empty();
            grid.swap(indexArray[0], indexArray[1], indexArray[2], indexArray[3]);
            if (to.getChildren().size() == 2) {
                ImageView image = (ImageView) from.getChildren().remove(1);
                to.getChildren().set(1, image);
            }
            Alert textAlert = new Alert(Alert.AlertType.INFORMATION);
            textAlert.setTitle("Game Won");
            textAlert.setHeaderText("Congratulations!");
            textAlert.setContentText("You finally killed the opponent's king. You have won.");
            textAlert.showAndWait();
            System.exit(0);
        } else {
            if (!(grid.grid[indexArray[2]][indexArray[3]] instanceof Empty)) {
                if (grid.grid[indexArray[2]][indexArray[3]].getColor().equals("Black")) {
                    grid.blackPieces.remove(grid.grid[indexArray[2]][indexArray[3]]);
                    grid.whitePieces.put(grid.grid[indexArray[0]][indexArray[1]], new int[] {indexArray[2], indexArray[3]});
                }
                if (grid.grid[indexArray[2]][indexArray[3]].getColor().equals("White")) {
                    grid.whitePieces.remove(grid.grid[indexArray[2]][indexArray[3]]);
                    grid.blackPieces.put(grid.grid[indexArray[0]][indexArray[1]], new int[] {indexArray[2], indexArray[3]});
                }
                grid.grid[indexArray[2]][indexArray[3]] = new Empty();
            } else {
                if (grid.grid[indexArray[0]][indexArray[1]].getColor().equals("Black")) {
                    grid.blackPieces.put(grid.grid[indexArray[0]][indexArray[1]], new int[] {indexArray[2], indexArray[3]});
                }
                if (grid.grid[indexArray[0]][indexArray[1]].getColor().equals("White")) {
                    grid.whitePieces.put(grid.grid[indexArray[0]][indexArray[1]], new int[] {indexArray[2], indexArray[3]});
                }
            }
            blackMove = !blackMove;
            grid.swap(indexArray[0], indexArray[1], indexArray[2], indexArray[3]);
            if (to.getChildren().size() == 2) {
                ImageView image = (ImageView) from.getChildren().remove(1);
                to.getChildren().set(1, image);
            }
            if (to.getChildren().size() == 1) {
                ImageView image = (ImageView) from.getChildren().remove(1);
                to.getChildren().add(image);
            }
        }
    }

}