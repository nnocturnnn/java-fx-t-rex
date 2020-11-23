package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    Stage primaryStage;
    public static ArrayList<Enemy> enemys = new ArrayList<>();
    public static ArrayList<Texture> textures = new ArrayList<>();
    private HashMap<KeyCode,Boolean> keys = new HashMap<>();
    public ArrayList<String> score = new ArrayList<>();
    public String path;
    public static int score = 0;
    public static int sound;
    public static int style;
    public Label scorelabel = new Label(String.valueOf(score));

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public Dino dino;

    public Game(Stage primaryStage,int style, int sound) {
        this.style = style;
        this.sound = sound;
        this.primaryStage = primaryStage;
        primaryStage.setScene(primaryStage.getScene());
        this.creation();
    }

    private void initContent(){
        path = "sprites/" + String.valueOf(style) + ".png";
        Image imv = new Image(path);
        for(int i = 0; i < 100; i++) {
            Texture cloud = new Texture(imv,0,i*350+550,50); // можно поставить рандомный у
            Texture ground = new Texture(imv,1,i*2400,350);
            Enemy enemy = new Enemy(imv,i*350+550,305,this.style);
        }
        dino = new Dino(imv,this.style);
        dino.setTranslateX(0);
        dino.setTranslateY(200);
        scorelabel.setTranslateX(400);
        scorelabel.setTranslateY(120);
        scorelabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 40px; -fx-text-fill: #535353;");
        gameRoot.getChildren().add(dino);
        appRoot.getChildren().addAll(gameRoot,scorelabel);
    }

    public void score() {
        score++;
        if (score % 100 == 0) {
            Utils.playSound("papam.mp3");
        }
        scorelabel.setText(String.valueOf(score));
    }

    public void start() {
        Pane new_Root = appRoot;
        primaryStage.setScene(new Scene(new_Root,900,600));
        appRoot.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
        appRoot.setStyle("-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);");
        primaryStage.centerOnScreen();
    }

    private void update(){
        if(isPressed(KeyCode.SPACE) && dino.getTranslateY()>=5){
            dino.jumpdino();
        }
        score();
        dino.setScaleX(1);
        dino.moveX(5);
        if(dino.dinoVelocity.getY()<10){
           dino.dinoVelocity = dino.dinoVelocity.add(0,1);
        }
        dino.moveY((int)dino.dinoVelocity.getY());
        dino.translateXProperty().addListener((ovs,old, newValue)-> {  // move map
            int offset = newValue.intValue();
            if (offset > 200)
                gameRoot.setLayoutX(-(offset - 200));
        });
    }

    public Button startBtn() {
        ImageView retryIm = new ImageView(new Image(path));
        retryIm.setViewport(new Rectangle2D(0, 0, 70, 65));
        Button retry = new Button("Retry", retryIm);
        retry.setLayoutY(220);
        retry.setLayoutX(370);
        retry.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25; -fx-text-fill: #535353; -fx-font-size: 20;");
        retry.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                score = 0;
                appRoot.getChildren().clear();
                gameRoot.getChildren().clear();
                gameRoot.setLayoutX(0);
                new Game(primaryStage,style,sound).start();
            }
        });

        return retry;
    }

    private boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }
    public void creation() {
        initContent();
        Utils.playSound("pip.mp3");
        primaryStage.getScene().setOnKeyPressed(event-> keys.put(event.getCode(), true));
        primaryStage.getScene().setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
             dino.animation.stop();
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dino.one == false) {
                    appRoot.getChildren().addAll(startBtn());
                    this.stop();
                }
                update();
            }
        };
        timer.start();
    }
}
