package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;

public class Cloud extends Pane {
    public int num;
    public int height;
    public int width;

    public Cloud(int num)  {
        System.out.println(num);
        try {
        if (num == 1) {
            Image cactus = new Image(new FileInputStream("/Users/asydoruk/hui/src/main/resources/Cloud.png"));
            ImageView iv_cactus = new ImageView(cactus);
            getChildren().add(iv_cactus);
        } else {
            Image cactus = new Image(new FileInputStream("/Users/asydoruk/hui/src/main/resources/Cloud-min.png"));
            ImageView iv_cactus = new ImageView(cactus);
            getChildren().add(iv_cactus);
        }
        } catch (Exception e) {
            return;
        }

    }
}