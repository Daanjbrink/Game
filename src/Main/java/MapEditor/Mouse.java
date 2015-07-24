package MapEditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private ObjectHandler handler;
    private Place place;

    public Mouse(ObjectHandler handler, Place place) {
        this.handler = handler;
        this.place = place;
    }

    public void mouseMoved(MouseEvent e) {
        place.Move(e.getPoint().x, e.getPoint().y);
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            place.click();
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            handler.type = null;
            handler.State = 0;
        }
    }

}
