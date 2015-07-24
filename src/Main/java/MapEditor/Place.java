package MapEditor;

import MapEditor.Objects.Wall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Place {

    public int mX, mY;
    private ObjectHandler handler;

    public Place(ObjectHandler handler) {
        this.handler = handler;
    }

    public void Move(int x, int y) {
        this.mX = (int) Math.floor(x / 32) * 32 + 16;
        this.mY = (int) Math.floor(y / 32) * 32 + 16;
    }

    public void click() {
        if (handler.State == 0) {
            //object pick-up code
        } else if (handler.State == 1) {
            switch (handler.type) {
                case Wall:
                    handler.addObject(new Wall(mX, mY));
                    break;
            }
        } else if (handler.State == 2) {
            //place moved block code
        }
    }

    public void render(Graphics g) {
        if (handler.State == 0) return;

        if (handler.State == 1) {
            switch (handler.type) {
                case Wall:
                    try {
                        Graphics2D g2d = (Graphics2D) g;
                        Image img = ImageIO.read(new File("src/Main/resources/Sprites/Wall/Wall 1.png"));
                        g2d.drawImage(img, mX - 16, mY - 16, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

}
