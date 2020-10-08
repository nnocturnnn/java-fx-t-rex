package world.ucode;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game  {
    public Stage primaryStage;
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public static ArrayList<Cloud> clouds = new ArrayList<>();
    public static ArrayList<Cactus> cacti = new ArrayList<>();
    Dino dino;
    public static int score = 0;
    public Label scorelabel = new Label(String.valueOf(score));

    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.dino = new Dino(primaryStage);
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
        appRoot.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
        scorelabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 40px; -fx-text-fill: #535353;");
        gameRoot.getChildren().addAll(dino);
        appRoot.setStyle("-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);");
        appRoot.getChildren().addAll(gameRoot,scorelabel);
        return appRoot;
    }

    public void update() {
        if (dino.velocity.getY() < 350) {
            dino.velocity = dino.velocity.add(0,1);  // gravity
            dino.setTranslateY(dino.getTranslateY()+3);
            if (dino.velocity.getY() == 275) {
                dino.jump = true;
            }
        }
        score++;
        if (score % 100 == 0) {
            Utils.playSound("papam.mp3");
        }
        if (dino.getTranslateY() > 350) {   // ground
            dino.setTranslateY(350);
        }
        dino.moveX((int)dino.velocity.getX());
        dino.moveY((int)dino.velocity.getY());
        scorelabel.setText(String.valueOf(score));
        scorelabel.setTranslateX(400);
        scorelabel.setTranslateY(120);
        dino.translateXProperty().addListener((ovs,old, newValue)-> {  // move map
            int offset = newValue.intValue();
            if (offset > 200)
                gameRoot.setLayoutX(-(offset - 200));
        });
    }

    public void start() {
        Scene scene = new Scene(createContent());
        Utils.playSound("pip.mp3");
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
               dino.jump();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dino.one == false) {
                    this.stop();
                }
                update();
            }
        };
        timer.start();

    }

}