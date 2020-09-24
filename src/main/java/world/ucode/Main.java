package world.ucode;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Line line = new Line(0, 350, 900, 350);
        Image ground = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Ground.png"));
        ImageView imv = new ImageView(ground);
        imv.setY(350);
        Group group = new Group();
        Scene scene = new Scene(group, 900, 600);
//        group.getChildren().add(line);
        group.getChildren().add(imv);

        primaryStage.setTitle("dino");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update() {

    }
}