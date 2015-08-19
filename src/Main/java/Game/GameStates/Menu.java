package Game.GameStates;

import Game.Engine.ObjectHandler;
import Game.Engine.Vars;
import Game.Objects.Menu.But_Exit;
import Game.Objects.Menu.But_Settings;
import Game.Objects.Menu.But_StartGame;
import Game.Utils.Draw;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Menu extends GameState {

    final public String[] assets = {
            "Other/Menu.png",
            "Text/Play.png",
            "Text/Settings.png",
            "Text/Exit.png"
    };

    private ObjectHandler handler;

    private Texture background;

    public Menu() {
        this.handler = new ObjectHandler();
    }

    public void init() {
        try {
            if (Vars.width != 640 || Vars.height != 480)
                Display.setDisplayMode(new DisplayMode(640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }

        background = Vars.manager.get("Other/Menu.png");

        // Add objects
        handler.addObject(new But_StartGame(8, 250));
        handler.addObject(new But_Settings(8, 280));
        handler.addObject(new But_Exit(8, 310));
    }

    public void render() {
        Draw.Draw(0, 0, background);
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
