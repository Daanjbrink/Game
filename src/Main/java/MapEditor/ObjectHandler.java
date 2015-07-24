package MapEditor;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    public boolean[][] area;
    LinkedList<Object> objects = new LinkedList<Object>();
    //0=nothing
    //1=new block
    //2=move
    int State = 0;
    int Selected = -1;
    Types type = Types.Wall;
    private Main main;

    public ObjectHandler(Main main) {
        this.main = main;
        this.area = new boolean[(int) Math.floor(main.width / 32) * 32 + 16][(int) Math.floor(main.height / 32) * 32 + 16];
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
