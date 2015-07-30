package Game.Engine;

import Game.GameStates.Menu;
import Game.GameStates.Settings;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {

    public int width, height;

    public AssetManager manager;

    public States state;

    private Loader loader;
    private Menu menu;
    private Settings settings;

    public Main(int width, int height) {
        this.width = width;
        this.height = height;

        manager = new AssetManager();

        menu = new Menu(this);
        settings = new Settings(this);
        loader = new Loader(this, menu, settings);

        this.enterState(States.Loading);

        loader.init();

        GameLoop();
    }

    public static void main(String[] args) {
        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setVSyncEnabled(true);
            Display.setTitle("Game");
            Display.setResizable(false);
            Display.create();
            new Main(640, 480);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterState(States state) {
        this.state = state;
        switch (state) {
            case Menu:
                menu.init();
                break;
            case Settings:
                settings.init();
                break;
        }
    }

    private void GameLoop() {
        while (!Display.isCloseRequested()) {
            try {
                Thread.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            switch (state) {
                case Loading:
                    loader.render();
                    break;

                case Menu:
                    menu.update();
                    menu.render();
                    break;

                case Settings:
                    settings.update();
                    settings.render();
                    break;
            }

            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }
}