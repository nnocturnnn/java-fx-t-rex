package world.ucode;

import java.io.FileInputStream;

import javafx.animation.Animation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
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
            Image IMAGE = new Image(new FileInputStream("/Users/asydoruk/hui/2x-trex.png"));
            int COLUMNS  =   6;
            int COUNT    =  2;
            int OFFSET_X =  89;
            int OFFSET_Y =  0;
            int WIDTH    = 43;
            int HEIGHT   = 47;
            final ImageView imageView = new ImageView(IMAGE);
            imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
            final Animation animation = new SpriteAnimation(
                    imageView,
                    Duration.millis(500),
                    COUNT, COLUMNS,
                    OFFSET_X, OFFSET_Y,
                    WIDTH, HEIGHT
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
            setTranslateY(350);
            getChildren().addAll(imageView);
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
        int y = 0;
        if (this.jump) {
            while(y != 90) {
                velocity = velocity.add(0, -1);
                setTranslateY(getTranslateY() - 1);
                setTranslateX(getTranslateX() + 0.5);
                y++;
            }
            this.jump = false;
        }
    }
}