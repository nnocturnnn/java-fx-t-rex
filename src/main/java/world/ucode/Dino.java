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
    public Point2D velocity;

    public Dino(){
        try {
            Image f_dino = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Dino-right-up.png"));
            Image s_dino = new Image(new FileInputStream("/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Dino-left-up.png"));
            ImageView imv_f_dino = new ImageView(f_dino);
            ImageView imv_s_dino = new ImageView(s_dino);
            velocity = new Point2D(0,0);
            setTranslateY(350);
            setTranslateX(50);
            getChildren().addAll(imv_f_dino);
        } catch (Exception e){
            System.out.println("err");
        }
    }

    public void moveY(int value) {
        for(int i = 0; i < Math.abs(value); i++) {
            for(Cactus w : Main.cacti) {
                if(this.getBoundsInParent().intersects(w.getBoundsInParent())) {
                    setTranslateY(getTranslateY() + 1);
                }
            }
            setTranslateY(getTranslateY());
        }
    }

    public void moveX(int value) {
        for(int i = 0; i < value; i++) {
            for(Cactus w : Main.cacti) {
                if(getTranslateX()+w.width == w.getTranslateX())
                    Main.score++;
            }
            setTranslateX(getTranslateX()+1);
        }
    }

    public void jump() {
        velocity = new Point2D(3, -15);
    }
}