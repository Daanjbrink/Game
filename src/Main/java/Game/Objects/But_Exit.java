package Game.Objects;

import Game.Engine.Main;
import Game.Engine.Object;
import Game.Utils.Draw;
import org.lwjgl.input.Mouse;

public class But_Exit extends Object {

    private final String imgLoc = "Text/Exit.png";
    private Main main;

    public But_Exit(int x, int y, Main main) {
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
            if (Mouse.getX() > x && Mouse.getX() < (x + width)
                    && (main.height - Mouse.getY()) > y && (main.height - Mouse.getY()) < (y + height)) {
                System.exit(0);
            }
        }
    }
}