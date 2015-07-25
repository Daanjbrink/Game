package Game.Objects;

import Game.Engine.Object;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Wall extends Object {

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = new Image("src/Main/resources/Sprites/Wall/Wall 1.png");
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        g.drawImage(img, x - 16, y - 16);
    }

    public void update() {

    }
}
