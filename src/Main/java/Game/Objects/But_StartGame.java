package Game.Objects;

import Game.Engine.Object;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class But_StartGame extends Object {

    public But_StartGame(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = new Image("src/Main/resources/Sprites/Text/Play.png");
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        g.drawImage(img, x, y);
    }

    public void update() {

    }
}
