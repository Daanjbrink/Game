package MapEditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    private ObjectHandler handler;

    public Keyboard(ObjectHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_1) {
            handler.State = 1;
        }
    }

}
