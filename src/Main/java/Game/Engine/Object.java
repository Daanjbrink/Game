package Game.Engine;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public abstract class Object {

    protected int x, y, velX, velY, width, height, id;
    protected Texture img;

    public abstract void render();

    public abstract void renderMP();

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

    public Object getType() {
        return this;
    }

    public boolean isClicked() {
        return (Mouse.getX() > x && Mouse.getX() < (x + width)
                && (Vars.height - Mouse.getY()) > y && (Vars.height - Mouse.getY()) < (y + height));
    }
}