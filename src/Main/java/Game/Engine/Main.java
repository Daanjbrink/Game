package Game.Engine;

import Game.GameStates.Game;
import Game.GameStates.GameState;
import Game.GameStates.Menu;
import Game.GameStates.Settings;
import Game.Utils.AssetManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {

    public AssetManager manager;

    public States state;

    private GameState room;

    public Main(int width, int height) {
        Vars.main = this;

        Vars.width = width;
        Vars.height = height;

        Vars.manager = new AssetManager();

        this.enterState(States.Loading);

        Loader.init();

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
                room = new Menu();
                room.init();
                break;
            case Settings:
                room = new Settings();
                room.init();
                break;
            case Game:
                room = new Game();
                room.init();
                break;
        }
    }

    private void GameLoop() {
        while (!Display.isCloseRequested()) {

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            room.update();
            room.render();

            Display.update();
        }
        Display.destroy();
    }
}