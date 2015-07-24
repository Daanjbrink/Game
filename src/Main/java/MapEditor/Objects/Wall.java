package MapEditor.Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Wall extends MapEditor.Object {

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = ImageIO.read(new File("src/Main/resources/Sprites/Wall/Wall 1.png"));
            this.width = ImageIO.read(new File("src/Main/resources/Sprites/Wall/Wall 1.png")).getWidth();
            this.height = ImageIO.read(new File("src/Main/resources/Sprites/Wall/Wall 1.png")).getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, x - 16, y - 16, null);
    }
}
