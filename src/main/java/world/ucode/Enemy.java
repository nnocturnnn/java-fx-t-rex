package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.geometry.Rectangle2D;

public class Enemy extends Pane {
    ImageView block;
    public Enemy(Image sprite, int x, int y)  {
        block = new ImageView(sprite);
        int r_cactus = (int)(Math.random()*6);
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(435, 0, 48, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(485, 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 95, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(645, 0, 50, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(695, 0, 105, 95));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(800, 0, 150, 100));
        }
        if (r_cactus < 3) {
            y += 20;
        }
        setTranslateX(x);
        setTranslateY(y);
        getChildren().add(block);
        Game.enemys.add(this);
        Game.gameRoot.getChildren().add(this);
    }

}
