package world.ucode;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Dino extends Pane{
    ImageView imageView;
    int count = 3;
    int columns = 3;
    int offsetX = 96;
    int offsetY = 33;
    int width = 16;
    int height = 16;
    public SpriteAnimation animation;
    public Point2D dinoVelocity = new Point2D(0,0);
    private boolean canJump = true;
    public boolean one = true;

    public Dino(Image Imv){
        imageView = new ImageView(Imv);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(this.imageView,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(this.imageView);
    }

    public void moveX(int value){
        boolean movingRight = value > 0;
        for(int i = 0; i<Math.abs(value); i++) {
            for (Node texture : Game.textures) {
                if(this.getBoundsInParent().intersects(texture.getBoundsInParent())) {
                    if (movingRight) {
                        if (this.getTranslateX() + Game.MARIO_SIZE == texture.getTranslateX()){
                            this.setTranslateX(this.getTranslateX() - 1);
                            return;
                        }
                    } else {
                        if (this.getTranslateX() == texture.getTranslateX() + Game.BLOCK_SIZE) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            return;
                        }
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
                        if(this.getTranslateY()+ Game.MARIO_SIZE == texture.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                    }
                    else{
                        if(this.getTranslateY() == texture.getTranslateY()+ Game.BLOCK_SIZE){
                            this.setTranslateY(this.getTranslateY()+1);
                            dinoVelocity = new Point2D(0,10);
                            return;
                        }
                    }
                }
            }
            for(Enemy w : Game.enemys) {
                if (this.getBoundsInParent().intersects(w.getBoundsInParent()) && one) {
                    one = false;
                    Utils.playSound("dead.mp3");
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