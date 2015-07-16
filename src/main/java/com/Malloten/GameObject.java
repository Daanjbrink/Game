package com.Malloten;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int spdX, spdY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpdX() {
        return spdX;
    }

    public void setSpdX(int spdX) {
        this.spdX = spdX;
    }

    public int getSpdY() {
        return spdY;
    }

    public void setSpdY(int spdY) {
        this.spdY = spdY;
    }
}
