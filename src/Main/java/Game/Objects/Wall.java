package Game.Objects;

import Game.Engine.Object;
import Game.Utils.AssetManager;
import Game.Utils.Draw;

public class Wall extends Object {

    private final String imgLoc = "Wall/Wall 1.png";

    public Wall(int x, int y, AssetManager manager) {

        this.x = x;
        this.y = y;

        try {
            this.img = manager.get(imgLoc);
            this.width = img.getImageWidth();
            this.height = img.getImageHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        Draw.Draw(x, y, img);
    }

    public void renderMP() {
        Draw.Draw(x, y, img);
    }

    public void update() {

    }
}