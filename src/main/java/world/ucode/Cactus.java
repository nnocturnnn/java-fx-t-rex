package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;

public class Cactus extends Pane {
    public int num;
    public int height;
    public int width;
    public Wall(int num) throws Exception {
        this.num = num;
        String src = "/Users/asydoruk/T-Rex_JavaFX/src/main/resources/Cactus-" + String.valueOf(num) + ".png";
        Image cactus = new Image(new FileInputStream(src));
        ImageView iv_cactus = new ImageView(cactus);
        if (num = 1) {

        } else if (num = 2) {

        } else if (num = 3) {

        } else if (num = 4) {

        } else if (num = 5) {

        }
        getChildren().add(iv_cactus);

    }


}