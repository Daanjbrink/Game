package Game.GameStates;

import Game.Engine.Main;
import Game.Engine.ObjectHandler;
import Game.Utils.Draw;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Settings extends GameState {

    final public String[] assets = {
            "Other/Menu.png"
    };

    private Main main;

    private ObjectHandler handler;

    private Texture background;

    public Settings(Main main) {
        this.main = main;

        this.handler = new ObjectHandler();
    }

    public void init() {
        try {
            if (main.width != 640 || main.height != 480)
                Display.setDisplayMode(new DisplayMode(640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }

        background = main.manager.get("Other/Menu.png");

        // Add buttons
    }

    public void render() {
        new Draw().Draw(0, -32, background);
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
