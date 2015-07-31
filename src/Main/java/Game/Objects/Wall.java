package Game.Objects;

import Game.Engine.DrawImage;
import Game.Engine.Main;
import Game.Engine.Object;

public class Wall extends Object {

    private Main main;

    public Wall(int x, int y, Main main) {
        this.main = main;

        this.x = x;
        this.y = y;

        try {
            this.img = main.manager.get("Wall/Wall 1.png");
            this.width = img.getImageWidth();
            this.height = img.getImageHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        new DrawImage().Draw(x, y, img);
    }

    public void renderMP() {

    }

    public void update() {

    }
}