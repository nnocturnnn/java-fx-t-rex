package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class Texture extends Pane {
    ImageView block;
    public Texture(Image sprite, int type, int x, int y)  {
        block = new ImageView(sprite);
        if (type == 0) {
            setTranslateX(x);
            setTranslateY(y);
            block.setViewport(new Rectangle2D(165, 0, 100, 36));
        } else if (type == 1) {
            setTranslateX(x);
            setTranslateY(y);
            block.setViewport(new Rectangle2D(0, 100, 2400, 120));
        }
        getChildren().add(block);
        Game.textures.add(this);
        Game.gameRoot.getChildren().add(this);
    }
}