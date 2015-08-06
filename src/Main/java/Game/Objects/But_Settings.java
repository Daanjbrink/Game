package Game.Objects;

import Game.Engine.Main;
import Game.Engine.Object;
import Game.Engine.States;
import Game.Utils.Draw;
import org.lwjgl.input.Mouse;

public class But_Settings extends Object {

    private Main main;

    private String imgLoc = "Text/Settings.png";

    public But_Settings(int x, int y, Main main) {
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
        Draw.Draw(x, y, img);
    }

    public void renderMP() {

    }

    public void update() {
        if (Mouse.isButtonDown(0)) {
            if (Mouse.getX() > x && Mouse.getX() < (x + img.getImageWidth())
                    && (main.height - Mouse.getY()) > y && (main.height - Mouse.getY()) < (y + height)) {
                main.enterState(States.Settings);
            }
        }
    }
}