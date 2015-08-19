package Game.GameStates;

import Game.Engine.ObjectHandler;
import Game.Engine.Vars;
import Game.Objects.Settings.But_Fullscreen;
import Game.Objects.Settings.Text_Fullscreen;
import Game.Objects.Settings.Text_MaxVolume;
import Game.Utils.Draw;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Settings extends GameState {

    final public String[] assets = {
            "Other/Menu.png",
            "Text/Fullscreen.png",
            "Text/Checkbox checked.png",
            "Text/Checkbox unchecked.png",
            "Text/Max Volume.png",
            "Text/Slider balk.png"
    };

    private ObjectHandler handler;

    private Texture background;

    public Settings() {

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
        handler.addObject(new Text_Fullscreen(0, 240));
        handler.addObject(new But_Fullscreen(115, 235));
        handler.addObject(new Text_MaxVolume(16, 272));
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
