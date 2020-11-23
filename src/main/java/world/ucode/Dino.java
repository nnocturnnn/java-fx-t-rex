package world.ucode;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;
import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Dino extends Pane{
    ImageView imageView;
    Rectangle rect;
    int count = 2;
    int columns = 3;
    int offsetX = 1855;
    int offsetY = 0;
    int width = 87;
    int height = 95;
    public SpriteAnimation animation;
    public Point2D dinoVelocity = new Point2D(0,0);
    private boolean canJump = true;
    public boolean one = true;

    // public void check_style(int style) {
    //     if (style == 2) {
            
    //     } else if (style == 3) {
           
    //     } else if (style == 4) {
           
    //     } else if (style == 5) {
            
    //     } else if (style == 6) {
    //     }
    // }
    public Dino(Image Imv, int style){
        imageView = new ImageView(Imv);
        check_style(style);
        imageView.setFitHeight(47);
        imageView.setFitWidth(51);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(this.imageView,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        getChildren().addAll(this.imageView);
    }

    public void moveX(int value){
        boolean movingRight = value > 0;
        for(int i = 0; i<Math.abs(value); i++) {
            for (Node texture : Game.textures) {
                if(this.getBoundsInParent().intersects(texture.getBoundsInParent())) {
                    if (movingRight) {
                        if (this.getTranslateX() == texture.getTranslateX()){
                            this.setTranslateX(this.getTranslateX() - 1);
                            return;
                        }
                    } else {
                        if (this.getTranslateX() == texture.getTranslateX()) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            return;
                        }
                    }
                }
            }
            for(Enemy w : Game.enemys) {
                if (w.getBoundsInParent().getWidth() != 105.0) {
                    if (this.getBoundsInParent().intersects(w.getBoundsInParent()) && one) {
                        one = false;
                        Utils.playSound("dead.mp3");
                    }
                }
            }
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }
    public void moveY(int value){
        boolean movingDown = value >0;
        for(int i = 0; i < Math.abs(value); i++){
            for(Texture texture :Game.textures){
                if(getBoundsInParent().intersects(texture.getBoundsInParent())){
                    if(movingDown){
                        if(this.getTranslateY() + 30 == texture.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                    }
                    else{
                        if(this.getTranslateY() == texture.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()+1);
                            dinoVelocity = new Point2D(0,10);
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
        }
    }
    public void jumpdino(){
        if(canJump){
            dinoVelocity = dinoVelocity.add(0,-30);
            Utils.playSound("pip.mp3");
            canJump = false;
        }
    }
}