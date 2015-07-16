package com.Malloten;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObj = handler.object.get(i);

            if (tmpObj.getID() == ID.Player) {
                if (key == KeyEvent.VK_UP) tmpObj.setSpdY(-3);
                if (key == KeyEvent.VK_LEFT) tmpObj.setSpdX(-3);
                if (key == KeyEvent.VK_RIGHT) tmpObj.setSpdX(3);
                if (key == KeyEvent.VK_DOWN) tmpObj.setSpdY(3);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObj = handler.object.get(i);

            if (tmpObj.getID() == ID.Player) {
                if (key == KeyEvent.VK_UP) tmpObj.setSpdY(0);
                if (key == KeyEvent.VK_LEFT) tmpObj.setSpdX(0);
                if (key == KeyEvent.VK_RIGHT) tmpObj.setSpdX(0);
                if (key == KeyEvent.VK_DOWN) tmpObj.setSpdY(0);
            }
        }
    }

}
