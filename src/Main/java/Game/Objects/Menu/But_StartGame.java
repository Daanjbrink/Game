package Game.Objects.Menu;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;
import org.lwjgl.input.Mouse;

public class But_StartGame extends Object {

    private final String imgLoc = "Text/Play.png";

    public But_StartGame(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = Vars.manager.get(imgLoc);
            this.width = img.getImageWidth();
            this.height = img.getImageHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        Draw.Draw(x, y, img);
    }

    public void update() {
        if (Mouse.isButtonDown(0)) {
            if (isClicked()) {
                System.out.println("Start");
            }
        }
    }
}