package world.ucode;

import java.io.FileInputStream;
import javafx.animation.Animation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dino extends Pane {
    public Point2D velocity ;
    public boolean jump = true;
    public Stage primaryStage;
    protected boolean one = true;

    public Dino(Stage primaryStage){
        this.primaryStage = primaryStage;
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
            velocity = new Point2D(7,350);
            setTranslateY(350);
            getChildren().addAll(imageView);
        } catch (Exception e){
            System.out.println("err");
        }
    }

    public void moveY(int value) {
        for(int i = 0; i < Math.abs(value); i++) {
            for(Cactus w : Game.cacti) {
                if (this.getBoundsInParent().intersects(w.getBoundsInParent()) && one) {
                    one = false;
                    Utils.playSound("dead.mp3");
                    new EndMenu(primaryStage).start();
                }
            }
            setTranslateY(getTranslateY());
        }
    }

    public void moveX(int value) {
        for(int i = 0; i < value; i++) {
            for(Cactus w : Game.cacti) {
                if (this.getBoundsInParent().intersects(w.getBoundsInParent()) && one) {
                    one = false;
                    Utils.playSound("dead.mp3");
                    new EndMenu(primaryStage).start();
                }
            }
            setTranslateX(getTranslateX()+0.5);
        }
    }

    public void jump() {
        int y = 0;
        velocity = velocity.add(0,0);
        Utils.playSound("pip.mp3");
        if (this.jump) {
            while(y != 110) {
                velocity = velocity.add(0, -1);
                setTranslateY(getTranslateY() - 1);
                setTranslateX(getTranslateX() + 0.5);
                y++;
            }
            this.jump = false;
        }
    }
}