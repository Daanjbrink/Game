package Engine;

import java.util.LinkedList;

public class ObjectHandler {

    public LinkedList<Object> objects = new LinkedList<Object>();

    public void addObject(Object object) {
        objects.add(object);
        object.id = objects.size();
    }

}
