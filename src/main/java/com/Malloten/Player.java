package com.Malloten;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y) {
        super(x, y, ID.Player);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);
    }
}
