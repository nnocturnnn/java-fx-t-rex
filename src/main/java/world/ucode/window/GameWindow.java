package world.ucode.window;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameWindow implements Window {
    public Pane pane;

    /**
     * Constructor
     *
     * @param pane
     */
    public GameWindow(Pane pane) {
        this.pane = pane;
    }

    public Scene create() {
        return new Scene(this.pane, 900, 600);
    }

}
