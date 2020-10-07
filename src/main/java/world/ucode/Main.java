package world.ucode;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileInputStream;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;
import javafx.util.Duration;

public class Main extends Application {
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public static ArrayList<Cloud> clouds = new ArrayList<>();
    public static ArrayList<Cactus> cacti = new ArrayList<>();
    Dino dino = new Dino();
    public static int score = 0;
    public Label scorelabel = new Label(String.valueOf(score));

    public static void main(String[] args)  {
        Application.launch(args);
    }

    public Parent createContent() {
        gameRoot.setPrefSize(900,600);

        for(int i = 0; i < 100; i++) {
            int r_cactus = (int)(Math.random()*5);
            int r_cloud = (int)(Math.random()*2);
            Cactus cactus = new Cactus(r_cactus);
            cactus.setTranslateX(i*350+550);
            cactus.setTranslateY(350);
            cacti.add(cactus);
            Cloud cloud = new Cloud(r_cloud);
            cloud.setTranslateX(i*350+550);
            cloud.setTranslateY(50);
            clouds.add(cloud);
            try {
                Image backgroundImg = new Image(new FileInputStream("/Users/asydoruk/hui/src/main/resources/Ground.png"));
                ImageView backgroundIV = new ImageView(backgroundImg);
                backgroundIV.setTranslateY(380);
                backgroundIV.setTranslateX(i*900);
                gameRoot.getChildren().addAll(backgroundIV);
            } catch(Exception e) {
                System.out.println("err");
            }
            gameRoot.getChildren().addAll(cactus);
            gameRoot.getChildren().addAll(cloud);
        }

        gameRoot.getChildren().addAll(dino);
        appRoot.getChildren().addAll(gameRoot,scorelabel);
        return appRoot;
    }

    public void update() {

        if (dino.velocity.getY() < 350) {
            dino.velocity = dino.velocity.add(0,1);
            dino.setTranslateY(dino.getTranslateY()+3);
            if (dino.velocity.getY() == 275) {
                dino.jump = true;
            }
        }
        if (dino.getTranslateY() > 350) {
            dino.setTranslateY(350);
        }
        score++;
        dino.moveX((int)dino.velocity.getX());
        dino.moveY((int)dino.velocity.getY());
        scorelabel.setStyle("-fx-font-family: Press Start 2P; -fx-font-size: 30px;");
        scorelabel.setText(String.valueOf(score));
        scorelabel.setTranslateX(430);
        dino.translateXProperty().addListener((ovs,old, newValue)-> {
            int offset = newValue.intValue();
            if (offset > 200)
                gameRoot.setLayoutX(-(offset - 200));
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
               dino.jump();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();

    }

}