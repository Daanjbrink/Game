package MapEditor;

import Game.Engine.Object;
import Game.Objects.Wall;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

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
            handler.Selected.setX(mX);
            handler.Selected.setY(mY);
        }
    }

    public void click(int button) {
        //1 = left mouse button
        //2 = middle mouse button
        //3 = right mouse button
        if (button == 1) {
            if (handler.State == 0) {
                for (int i = 0; i < handler.objects.size(); i++) {
                    Object tmp = handler.objects.get(i);
                    if (tmp.getX() == mX && tmp.getY() == mY) {
                        handler.Selected = tmp;
                        handler.area[mX][mY] = false;
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
                handler.Selected = null;
                handler.State = 0;
            }
        }

        if (button == 2) {
            if (handler.State == 0) {
                for (int i = 0; i < handler.objects.size(); i++) {
                    Object tmp = handler.objects.get(i);
                    if (tmp.getX() == mX && tmp.getY() == mY) {
                        System.out.println("Selected object id: " + tmp.getID());
                    }
                }
            }
        }

        if (button == 3) {
            if (handler.State == 0) {
                if (PlaceFree(mX, mY)) return;
                for (int i = 0; i < handler.objects.size(); i++) {
                    Object tmp = handler.objects.get(i);
                    if (tmp.getX() == mX && tmp.getY() == mY) {
                        handler.removeObject(tmp);
                        handler.area[mX][mY] = false;
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
                        Image img = new Image("src/Main/resources/Sprites/Wall/Wall 1.png");
                        g.drawImage(img, mX - 16, mY - 16, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}