package Game.Engine;

import java.util.LinkedList;

public class ObjectHandler {

    public LinkedList<Object> objects = new LinkedList<>();

    public void addObject(Object object) {
        objects.add(object);
    }

    public void removeObject(Object object) {
        objects.remove(object);
    }
}