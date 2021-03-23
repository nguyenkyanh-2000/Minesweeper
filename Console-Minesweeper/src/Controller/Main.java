package Controller;

import Model.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene game = new Scene(root, 600, 600);
        primaryStage.setScene(game);
        primaryStage.show();
        Board b = new Board("Beginner");
    }
}
