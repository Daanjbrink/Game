package MapEditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
    private Place place;

    public Mouse(Place place) {
        this.place = place;
    }

    public void mouseMoved(MouseEvent e) {
        place.Move(e.getPoint().x, e.getPoint().y);
    }

    public void mousePressed(MouseEvent e) {
        place.click(e);
    }
}
