package world.ucode;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import javafx.scene.shape.Rectangle;



public class Dino extends Pane {
//    Image f_dino = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Dino-right-up.png"));
//    Image s_dino = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Dino-left-up.png"));

    public Point2D velocity new Point2D(0,0);
    Rectangle rect;
    public Dino() {
        rect = new Rectangle(20,20);
        velocity = new Point2D(0,0);
        setTranslateY(300);
        setTranslateX(100);
        getChildren().addAll(rect);
    }

    public void moveY(int value) {
        for(int i = 0; i < value; i++)
    }

}