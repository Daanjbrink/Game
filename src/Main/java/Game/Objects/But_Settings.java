package Game.Objects;

import Game.Engine.*;
import Game.Engine.Object;
import org.lwjgl.input.Mouse;

public class But_Settings extends Object {

    private Main main;

    public But_Settings(int x, int y, AssetManager manager, Main main) {
        this.main = main;

        this.x = x;
        this.y = y;

        try {
            this.img = manager.get("Text/Settings.png");
            this.width =
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
                main.enterState(States.Settings);
            }
        }
    }
}