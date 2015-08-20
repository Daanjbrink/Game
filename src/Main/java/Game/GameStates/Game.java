package Game.GameStates;

import Game.Engine.ObjectHandler;
import Game.Engine.Vars;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Game extends GameState {

    final public String[] assets = {

    };

    private ObjectHandler handler;

    private Texture background;

    public Game() {
        this.handler = new ObjectHandler();
    }

    public void init() {
        try {
            if (Vars.width != 640 || Vars.height != 480)
                Display.setDisplayMode(new DisplayMode(640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        for (int i = 0; i < handler.objects.size(); i++) {
            handler.objects.get(i).render();
        }
    }

    public void update() {
        for (int i = 0; i < handler.objects.size(); i++) {
            handler.objects.get(i).update();
        }
    }
}
