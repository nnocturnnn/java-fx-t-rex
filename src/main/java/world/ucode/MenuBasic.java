
package world.ucode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MenuBasic {
    public Stage mainMenu;
    public Pane pane;

    public MenuBasic(Pane pane, Stage mainMenu) {
        this.pane = pane;
        this.mainMenu = mainMenu;
        this.init();
    }

    public Label label() {
        Label label = new Label();

        label.setText("Dino");
        label.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 40; -fx-text-fill: #535353;");
        label.setLayoutX(355);
        label.setLayoutY(50);

        return label;
    }

    public ImageView groundImgView() {
        ImageView groundImgView = new ImageView(new Image("Ground.png"));
        groundImgView.setLayoutY(450);
        return groundImgView;
    }

    public ImageView dinoImgView() {
        ImageView dinoImgView = new ImageView(new Image("Dino-stand.png"));
        dinoImgView.setLayoutX(15);
        dinoImgView.setLayoutY(420);
        return dinoImgView;
    }

    public Button startBtn() {
        Button startBtn = new Button();
        startBtn.setText("Start");
        startBtn.setLayoutX(350);
        startBtn.setLayoutY(150);
        startBtn.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25; -fx-text-fill: #535353; -fx-font-size: 20;");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Game(mainMenu).start();
            }
        });

        return startBtn;
    }


    public Button resultsBtn() {
        Button ResultsBtn = new Button();

        ResultsBtn.setText("Results");
        ResultsBtn.setLayoutX(350);
        ResultsBtn.setLayoutY(200);
        ResultsBtn.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25; -fx-text-fill: #535353; -fx-font-size: 20;");

        ResultsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Results");
            }
        });

        return ResultsBtn;
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
        this.pane.getChildren().add(this.resultsBtn());
        this.pane.getChildren().add(this.exitBtn());
        this.pane.getChildren().add(this.dinoImgView());
        this.pane.getChildren().add(this.groundImgView());
        Scene scene = new Scene(pane);
        pane.setPrefSize(900,600);
        mainMenu.setScene(scene);
        mainMenu.centerOnScreen();
        mainMenu.show();
    }
}
