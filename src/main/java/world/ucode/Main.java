package world.ucode;

import java.io.FileInputStream;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args)  {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image ground = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Ground.png"));
        ImageView imv = new ImageView(ground);
        imv.setY(350);
        Group group = new Group();
        Scene scene = new Scene(group, 900, 600);
        group.getChildren().add(imv);
        primaryStage.setTitle("dino");
        Duration duration = Duration.millis(2500);
        TranslateTransition transition = new TranslateTransition(duration, imvy);
        transition.setAutoReverse(true);
        transition.setByX(1000);
        transition.play();

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void update() {

    }
}