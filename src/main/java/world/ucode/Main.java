package world.ucode;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        primaryStage.setTitle("dino");
        primaryStage.getIcons().add(new Image("sprites/Dino-stand.png"));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
        new MenuBasic(pane, primaryStage);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}