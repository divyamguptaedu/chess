package Chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Interface extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        int count = 0;
        double size = 50;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle r = new Rectangle(size, size, size, size);
                if (count % 2 != 0) {
                    r.setFill(Color.WHITE);
                }
                pane.add(r, j, i);
                count++;
            }
        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}