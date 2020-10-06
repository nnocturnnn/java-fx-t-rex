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
    public Point2D velocity = new Point2D(7,350);
    public boolean jump = true;

    public Dino(){
        try {
            Image f_dino = new Image(new FileInputStream("/Users/asydoruk/hui/src/main/resources/Dino-right-up.png"));
//            Image s_dino = new Image(new FileInputStream("/Users/asydoruk/hui/src/main/resources/Dino-left-up.png"));
            ImageView imv_f_dino = new ImageView(f_dino);
            setTranslateY(350);
//            ImageView imv_s_dino = new ImageView(s_dino);
            getChildren().addAll(imv_f_dino);
//            getChildren().addAll(imv_s_dino);
        } catch (Exception e){
            System.out.println("err");
        }
    }

    public void moveY(int value) {
        for(int i = 0; i < Math.abs(value); i++) {
            for(Cactus w : Main.cacti) {
//                velocity = new Point2D(0, 10);
            }
            setTranslateY(getTranslateY());
        }
    }

    public void moveX(int value) {
        for(int i = 0; i < value; i++) {
            for(Cactus w : Main.cacti) {

            }
            setTranslateX(getTranslateX()+0.5);
        }
    }

    public void jump() {
        if (this.jump) {
            velocity = velocity.add(0, -40);
            setTranslateY(getTranslateY() - 10);
            setTranslateX(getTranslateX() + 5);
            setTranslateY(getTranslateY() - 10);
            setTranslateX(getTranslateX() + 5);
            setTranslateY(getTranslateY() - 10);
            setTranslateX(getTranslateX() + 5);
            setTranslateY(getTranslateY() - 10);
            setTranslateX(getTranslateX() + 5);
            velocity = velocity.add(0, -40);
            setTranslateY(getTranslateY() - 20);
            setTranslateX(getTranslateX() + 10);
            setTranslateY(getTranslateY() - 20);
            setTranslateX(getTranslateX() + 10);
            this.jump = false;
        }
    }
}