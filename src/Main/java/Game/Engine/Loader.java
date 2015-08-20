package Game.Engine;

import Game.GameStates.Menu;
import Game.GameStates.Settings;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Loader {

    private Menu menu;
    private Settings settings;

    private Texture loadingTexture;

    public static void init() {
        initVideo();

        Vars.main.enterState(States.Menu);
    }

    private static void initVideo() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(255.0f, 255.0f, 255.0f, 255.0f);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 640, 480, 0, 1, -1);
        GL11.glViewport(0, 0, 640, 480);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public static void loadSprites(String[] sprites) {
        for (String str : sprites) {
            Vars.manager.loadPNG(str);
        }
    }
}
