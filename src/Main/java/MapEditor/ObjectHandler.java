package MapEditor;

import Game.Engine.Object;

import java.util.LinkedList;

public class ObjectHandler {

    public boolean[][] area;
    LinkedList<Object> objects = new LinkedList<>();

    //0=nothing
    //1=new block
    //2=move
    int State = 0;
    Object Selected = null;
    Types type = Types.Wall;
    int count;

    public ObjectHandler(Main main) {
        this.area = new boolean[(int) Math.floor(main.width / 32) * 32 + 16][(int) Math.floor(main.height / 32) * 32 + 16];

        count = 0;
    }

    public void render() {
        for (int i = 0; i < objects.size(); i++) {
            Object tmp = objects.get(i);
            tmp.renderMP();
        }
    }

    public void addObject(Object obj) {
        objects.add(obj);
        obj.setID(count);
        count++;
    }

    public void removeObject(Object object) {
        objects.remove(object);
    }
}