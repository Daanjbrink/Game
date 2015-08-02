package Game.Objects;

import Game.Engine.Main;
import Game.Engine.Object;
import Game.Utils.Draw;
import org.lwjgl.input.Mouse;

public class But_Exit extends Object {

    private Main main;

    private String imgLoc = "Text/Exit.png";

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
        new Draw().Draw(x, y, img);
    }

    public void renderMP() {

    }

    public void update() {
        if (Mouse.isButtonDown(0)) {
            if (Mouse.getX() > x && Mouse.getX() < (x + img.getImageWidth())
                    && Mouse.getY() > y && Mouse.getY() < (y + img.getImageHeight())) {
                System.exit(0);
            }
        }
    }
}