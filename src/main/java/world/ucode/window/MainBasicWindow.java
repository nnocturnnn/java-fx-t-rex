package world.ucode.window;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MainBasicWindow implements Window {
    private Pane pane;

    public MainBasicWindow(Pane pane) {
        this.pane = pane;
    }

    @Override
    public Scene create() {

        return new Scene(this.pane, 900, 600);
    }
}
