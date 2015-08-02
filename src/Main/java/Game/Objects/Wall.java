package Game.Objects;

import Game.Engine.Main;
import Game.Engine.Object;
import Game.Utils.DrawImage;

public class Wall extends Object {

    private Main main;

    private String imgLoc = "Wall/Wall 1.png";

    public Wall(int x, int y, Main main) {
        this.main = main;

        this.x = x;
        this.y = y;

        try {
            this.img = main.manager.get(imgLoc);
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