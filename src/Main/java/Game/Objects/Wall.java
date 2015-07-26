package Game.Objects;

import Game.Engine.Object;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Wall extends Object {

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = new Image("Sprites/Wall/Wall 1.png");
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
        g.drawImage(img, x - 32, y - 32);
    }

    public void update() {

    }
}
