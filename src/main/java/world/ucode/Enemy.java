package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.geometry.Rectangle2D;

public class Enemy extends Pane {
    ImageView block;

    public void style_1(int r_cactus) {
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(441, 0, 38, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(480, 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 100, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(650, 0, 50, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(701, 0, 100, 95));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(802, 0, 150, 85));
        }
    }
    public void style_2(int r_cactus) {
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(445, 0, 35, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(481 , 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 100, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(652, 0, 52, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(698, 0, 103, 95));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(802, 0, 150, 85));
        }
    }
    public void style_3(int r_cactus) {
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(441, 0, 38, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(481 , 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 95, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(650, 0, 45, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(700, 0, 100, 95));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(803, 0, 150, 85));
        }
    }
    public void style_4(int r_cactus) {
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(441, 0, 38, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(480, 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 100, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(650, 0, 50, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(701, 0, 100, 95));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(802, 0, 150, 85));
        }
    }
    public void style_5(int r_cactus) {
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(441, 0, 38, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(485 , 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 96, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(650, 0, 51, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(700, 0, 100, 95));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(802, 0, 150, 85));
        }
    }
    public void style_6(int r_cactus) {
        if (r_cactus == 0) {
            block.setViewport(new Rectangle2D(441, 0, 38, 70));
        } else if (r_cactus == 1) {
            block.setViewport(new Rectangle2D(485, 0, 65, 70));
        } else if (r_cactus == 2) {
            block.setViewport(new Rectangle2D(550, 0, 95, 70));
        } else if (r_cactus == 3) {
            block.setViewport(new Rectangle2D(645, 0, 50, 95));
        } else if (r_cactus == 4) {
            block.setViewport(new Rectangle2D(695, 0, 105, 90));
        } else if (r_cactus == 5) {
            block.setViewport(new Rectangle2D(802, 0, 150, 85));
        }
    }

    public void proportion(int r_cactus) {
        if (r_cactus == 0) {
            block.setFitHeight(37);
            block.setFitWidth(20);
        } else if (r_cactus == 1) {
            block.setFitHeight(38);
            block.setFitWidth(35);
        } else if (r_cactus == 2) {
            block.setFitHeight(41);
            block.setFitWidth(55);
        } else if (r_cactus == 3) {
            block.setFitHeight(57);
            block.setFitWidth(30);
        } else if (r_cactus == 4) {
            block.setFitHeight(47);
            block.setFitWidth(55);
        } else if (r_cactus == 5) {
            block.setFitHeight(59);
            block.setFitWidth(105);
        }
    }

    public Enemy(Image sprite, int x, int y,int style)  {
        block = new ImageView(sprite);
        int r_cactus = (int)(Math.random()* 6);
        if (style == 1) {
            style_1(r_cactus);
        } else if (style == 2) {
            style_2(r_cactus);
        } else if (style == 3) {
            style_3(r_cactus);
        } else if (style == 4) {
            style_4(r_cactus);
        } else if (style == 5) {
            style_5(r_cactus);
        } else if (style == 6) {
            style_6(r_cactus);
        }
        proportion(r_cactus);
        if (r_cactus < 3) {
            y += 20;
        } else if (r_cactus == 4) {
            y += 10;
        }
        setTranslateX(x);
        setTranslateY(y);
        getChildren().add(block);
        Game.enemys.add(this);
        Game.gameRoot.getChildren().add(this);
    }

}
