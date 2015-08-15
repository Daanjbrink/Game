package Game.Engine;

import Game.GameStates.Menu;
import Game.GameStates.Settings;
import Game.Utils.AssetManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {

    public AssetManager manager;

    public States state;

    private Loader loader;
    private Menu menu;
    private Settings settings;

    public Main(int width, int height) {
        Vars.main = this;

        Vars.width = width;
        Vars.height = height;

        Vars.manager = new AssetManager();

        menu = new Menu();
        settings = new Settings();
        loader = new Loader(menu, settings);

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

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BITS);

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
        }
        Display.destroy();
    }
}