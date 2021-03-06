package Game.Engine;

import org.lwjgl.opengl.GL11;

public class Loader {

    public static void init() {
        initVideo();

        Vars.main.enterState(States.Menu);
    }

    private static void initVideo() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(0, 0, 0, 0);

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
