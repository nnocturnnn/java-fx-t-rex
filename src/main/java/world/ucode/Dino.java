package world.ucode;

import java.io.FileInputStream;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
//import



public class Dino extends Pane {
    public void go() throws Exception  {
//        Image f_dino = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Dino-right-up.png"));
        Image s_dino = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Dino-left-up.png"));
        ImageView imv = new ImageView(s_dino);
        Duration duration = Duration.millis(2500);
        TranslateTransition transition = new TranslateTransition(duration, imv);
        transition.setByY(1000);
        transition.setByX(200);
        transition.play();
    }
//    public Point2D velocity new Point2D(0,0);
//    Rectangle rect;
//    public Dino() {
//        rect = new Rectangle(20,20);
//        velocity = new Point2D(0,0);
//        setTranslateY(300);
//        setTranslateX(100);
//        getChildren().addAll(rect);
//    }

//    public void moveY(int value) {
//        for(int i = 0; i < value; i++)
//    }

}