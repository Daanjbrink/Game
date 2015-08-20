package Game.GameStates;

import Game.Engine.Loader;
import Game.Engine.ObjectHandler;
import Game.Engine.Vars;
import Game.Objects.Game.Player;
import Game.Utils.Draw;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Game extends GameState {

    final public String[] assets = {
            "Text/Ground.png",
            "Characters/Character 1/Character 1 phase 1.png"
    };
    private int camX = 0, camY = 0;
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

        Loader.loadSprites(assets);

        background = Vars.manager.get("Text/Ground.png");

        // Add objects
        handler.addObject(new Player(32, 32));
    }

    public void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(-camX, -camY, 0);

        Draw.DrawBackGround(0, 0, background, false);
        for (int i = 0; i < handler.objects.size(); i++) {
            handler.objects.get(i).render();
        }

        GL11.glPopMatrix();
    }

    public void update() {
        for (int i = 0; i < handler.objects.size(); i++) {
            handler.objects.get(i).update();
        }
    }
}
