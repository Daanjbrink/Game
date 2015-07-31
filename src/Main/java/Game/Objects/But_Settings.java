package Game.Objects;

import Game.Engine.DrawImage;
import Game.Engine.Main;
import Game.Engine.Object;
import Game.Engine.States;
import org.lwjgl.input.Mouse;

public class But_Settings extends Object {

    private Main main;

    public But_Settings(int x, int y, Main main) {
        this.main = main;

        this.x = x;
        this.y = y;

        try {
            this.img = main.manager.get("Text/Settings.png");
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
                main.enterState(States.Settings);
            }
        }
    }
}