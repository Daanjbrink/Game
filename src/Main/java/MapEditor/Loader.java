package MapEditor;

import org.lwjgl.opengl.GL11;

public class Loader {

    private Main main;

    public Loader(Main main) {

        this.main = main;
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

        GL11.glViewport(0, 0, main.width, main.height);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, main.width, 0, main.height, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    private void initTexture() {
        for (String str : main.assets) {
            main.manager.loadPNG(str);
        }
    }

}
