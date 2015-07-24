package MapEditor;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    LinkedList<Object> objects = new LinkedList<Object>();
    //0=nothing
    //1=new block
    //2=move
    int State = 0;
    int Selected = -1;
    Types type = Types.Wall;
    private Main main;
    public boolean[][] area = new boolean[main.width / 32][main.height / 32];

    public ObjectHandler(Main main) {
        this.main = main;
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            Object tmp = objects.get(i);
            tmp.render(g);
        }
    }

    public void addObject(Object obj) {
        objects.add(obj);
        obj.setID(objects.size() - 1);
    }

    public void removeObject(int id) {
        objects.remove(objects.get(id));
    }
}
