package MapEditor;

import MapEditor.Objects.Wall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
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

        if (handler.State == 2) {
            handler.objects.get(handler.Selected).setX(mX);
            handler.objects.get(handler.Selected).setY(mY);
        }
    }

    public void click(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (handler.State == 0) {
                for (int i = 0; i < handler.objects.size(); i++) {
                    Object tmp = handler.objects.get(i);
                    if (tmp.getX() == mX && tmp.getY() == mY) {
                        handler.Selected = tmp.getID();
                        handler.State = 2;
                    }
                }
            } else if (handler.State == 1) {
                if (!PlaceFree(mX, mY)) return;
                switch (handler.type) {
                    case Wall:
                        handler.area[mX][mY] = true;
                        handler.addObject(new Wall(mX, mY));
                        break;
                }
            } else if (handler.State == 2) {
                if (!PlaceFree(mX, mY)) return;
                handler.area[mX][mY] = true;
                handler.Selected = -1;
                handler.State = 0;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            if (handler.State == 0) {
                if (PlaceFree(mX, mY)) return;

                for (int i = 0; i < handler.objects.size(); i++) {
                    Object tmp = handler.objects.get(i);
                    if (tmp.getX() == mX && tmp.getY() == mY) {
                        handler.removeObject(tmp.getID());
                    }
                }
            } else if (handler.State == 1) {
                handler.State = 0;
            } else if (handler.State == 2) {
                handler.State = 0;
                handler.removeObject(handler.Selected);
            }
        }
    }

    public boolean PlaceFree(int x, int y) {
        try {
            return !handler.area[x][y];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
