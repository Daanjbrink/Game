package Game.Objects;

import Game.Engine.AssetManager;
import Game.Engine.DrawImage;
import Game.Engine.Object;
import org.lwjgl.input.Mouse;

public class But_StartGame extends Object {

    public But_StartGame(int x, int y, AssetManager manager) {
        this.x = x;
        this.y = y;

        try {
            this.img = manager.get("Text/Play.png");
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
        if (Mouse.isButtonDown(0)) {
            if (Mouse.getX() > x && Mouse.getX() < (x + img.getImageWidth())
                    && Mouse.getY() > y && Mouse.getY() < (y + img.getImageHeight())) {
                System.out.println("Start");
            }
        }
    }
}