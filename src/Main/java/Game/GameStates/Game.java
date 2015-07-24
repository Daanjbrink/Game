package Game.GameStates;

import Game.Engine.Main;
import Game.Engine.Object;
import Game.Engine.ObjectHandler;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

    private Main main;
    private ObjectHandler handler;

    private int ID;

    public Game(Main main, int ID) {
        this.main = main;
        this.ID = ID;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        handler = new ObjectHandler();

        // Add buttons
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for (int i = 0; i < handler.objects.size(); i++) {
            Object tmp = handler.objects.get(i);
            tmp.render(g);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        // Make sure the screen is 640, 480
        if (container.getWidth() != 640) {
            AppGameContainer appGc = (AppGameContainer) container;
            appGc.setDisplayMode(640, 480, false);
            return;
        }
        if (container.getHeight() != 480) {
            AppGameContainer appGc = (AppGameContainer) container;
            appGc.setDisplayMode(640, 480, false);
            return;
        }

        for (int i = 0; i < handler.objects.size(); i++) {
            Object tmp = handler.objects.get(i);
            tmp.update();
        }
    }

    public int getID() {
        return this.ID;
    }
}
