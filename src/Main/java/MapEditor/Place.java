package MapEditor;

import Game.Engine.Object;

public class Place {

    public int mX, mY;

    private Main main;
    private ObjectHandler handler;

    public Place(Main main, ObjectHandler handler) {
        this.main = main;
        this.handler = handler;
    }

    public void Move(int x, int y) {

        this.mX = Math.round((x + main.camX) / 32) * 32;
        this.mY = Math.round((y + main.camY) / 32) * 32;

        if (handler.State == 2) {
            handler.Selected.setX(mX);
            handler.Selected.setY(mY);
        }
    }

    public void click(int button) {
        System.err.println("CLick");
        //0 = left mouse button
        //1 = right mouse button
        if (button == 0) {
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
                /*switch (handler.type) {
                    case Wall:
                        handler.area[mX][mY] = true;
                        handler.addObject(new Wall(mX, mY, handler.manager));
                        break;
                    case Spawn:
                        handler.area[mX][mY] = true;
                        handler.addObject(new zSpawn(mX, mY, handler.manager));
                        break;
                }*/
                return;
            } else if (handler.State == 2) {
                if (!PlaceFree(mX, mY)) return;
                handler.area[mX][mY] = true;
                handler.Selected = null;
                handler.State = 0;
            }
        }

        if (button == 1) {
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
        return !handler.area[x][y];
    }

    public void render() {
        if (handler.State == 0) return;

        if (handler.State == 1) {
            try {
                /*Class[] cArg = new Class[3];
                cArg[0] = int.class;
                cArg[1] = int.class;
                cArg[2] = AssetManager.class;
                java.lang.Object tmp = handler.type.getDeclaredConstructor().newInstance();
                switch (handler.type) {
                    case Wall:
                        //tmp = new Wall(mX, mY, handler.manager);
                        tmp.setX(mX);
                        tmp.setY(mY);
                        tmp.renderMP();
                        break;
                    case Spawn:
                        //tmp = new zSpawn(mX, mY, handler.manager);
                        tmp.setX(mX);
                        tmp.setY(mY);
                        tmp.renderMP();
                        break;
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}