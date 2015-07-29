package Game.Objects;

import Game.Engine.AssetManager;
import Game.Engine.DrawImage;
import Game.Engine.Object;

public class But_Exit extends Object {

    public But_Exit(int x, int y, AssetManager manager) {
        this.x = x;
        this.y = y;

        try {
            this.img = manager.get("Text/Exit.png");
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