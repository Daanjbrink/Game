package MapEditor;

import org.lwjgl.opengl.GL11;

public class Loader {

    private Main main;
    private ObjectHandler handler;

    public Loader(Main main, ObjectHandler handler) {
        this.main = main;
        this.handler = handler;
    }

    public void init() {
        initVideo();
        initTexture();
    }

    private void initVideo() {
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

    private void initTexture() {
        for (String str : main.assets) {
            handler.manager.loadPNG(str);
        }
    }

}
