package Game.Engine;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Object {

    protected int x, y, velX, velY, width, height, id;
    protected Image img;

    public abstract void render(Graphics g);

    public abstract void renderMP(Graphics g);

    public abstract void update();

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelX() {
        return this.velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return this.velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getID() {
        return this.id;

    }

    public void setID(int id) {
        this.id = id;
    }

}
