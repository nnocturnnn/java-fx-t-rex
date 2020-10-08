package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EndMenu {
    public Stage primaryStage;
    public Pane pane =  new Pane();

    public EndMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.init();
    }

    public void start() {
        Scene scene = new Scene(this.pane);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);");
        primaryStage.show();

    }

    public Label label() {
        Label label = new Label();

        label.setText("Game Over");
        label.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 25; -fx-text-fill: #535353;");
        label.setLayoutX(150);
        label.setLayoutY(50);

        return label;
    }

    public Button startBtn() {
        ImageView retryIm = new ImageView(new Image("Game_restart.png"));
        Button retry = new Button("Retry", retryIm);
        retry.setLayoutY(200);
        retry.setLayoutX(140);
        retry.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25; -fx-text-fill: #535353; -fx-font-size: 20;");
        retry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Game(primaryStage).start();
            }
        });

        return retry;
    }

    public Button exitBtn() {
        Button exitBtn = new Button();
        exitBtn.setText("Exit");

        exitBtn.setLayoutX(350);
        exitBtn.setLayoutY(250);
        exitBtn.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25; -fx-text-fill: #535353; -fx-font-size: 20;");
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        return exitBtn;
    }

    protected void init() {
        this.pane.setStyle("-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);");
        pane.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
        this.pane.getChildren().add(this.label());
        this.pane.getChildren().add(this.startBtn());
        this.pane.getChildren().add(this.exitBtn());
        pane.setPrefSize(900,600);
    }
}