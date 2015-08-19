package Game.Engine;

import Game.GameStates.Menu;
import Game.GameStates.Settings;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Loader {

    private Menu menu;
    private Settings settings;

    private Texture loadingTexture;

    public Loader(Menu menu, Settings settings) {
        this.menu = menu;
        this.settings = settings;

        try {
            loadingTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Sprites/Other/Loading.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        loadingTexture.bind();

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(0, 0);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(loadingTexture.getTextureWidth(), 0);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(loadingTexture.getTextureWidth(), loadingTexture.getTextureHeight());

        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(0, loadingTexture.getTextureHeight());
        GL11.glEnd();
    }

    public void init() {
        initVideo();
        initTexture();

        Vars.main.enterState(States.Menu);
    }

    private void initVideo() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glViewport(0, 0, Vars.width, Vars.height);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Vars.width, Vars.height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    private void initTexture() {
        for (String str : menu.assets) {
            Vars.manager.loadPNG(str);
        }
        for (String str : settings.assets) {
            Vars.manager.loadPNG(str);
        }
    }
}
