package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;

public class Cactus extends Pane {
    public int num;
    public int height;
    public int width;

    public Cactus(int num)  {
        try {
            this.num = num;
            String src = "/Users/asydoruk/hui/src/main/resources/Cactus-" + String.valueOf(num) + ".png";
            Image cactus = new Image(new FileInputStream(src));
            ImageView iv_cactus = new ImageView(cactus);
            if (num == 0) {
                this.height = 48;
                this.width = 25;
            } else if (num == 1) {
                this.height = 35;
                this.width = 17;
            } else if (num == 2) {
                this.height = 49;
                this.width = 51;
            } else if (num == 3) {
                this.height = 49;
                this.width = 49;
            } else if (num == 4) {
                this.height = 35;
                this.width = 34;
            }
            getChildren().add(iv_cactus);
        } catch (Exception e) {
            return;
        }

    }

}