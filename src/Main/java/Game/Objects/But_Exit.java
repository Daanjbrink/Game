package Game.Objects;

import Game.Engine.Object;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class But_Exit extends Object {

    public But_Exit(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = new Image("Sprites/Text/Exit.png");
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        g.drawImage(img, x, y);
    }

    public void renderMP(Graphics g) {
        g.drawImage(img, x - 16, y - 16);
    }

    public void update() {

    }
}
