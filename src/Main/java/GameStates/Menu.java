package GameStates;

import Engine.Main;
import Engine.Object;
import Engine.ObjectHandler;
import Objects.But_StartGame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

    private Main main;
    private ObjectHandler handler;

    private int ID;

    public Menu(Main main, int ID) {
        this.main = main;
        this.ID = ID;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        handler = new ObjectHandler();

        // Add buttons
        handler.addObject(new But_StartGame(8, 264));
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(new Image("src/Main/resources/Sprites/Other/Menu.png"), 0, 0);

        for (int i = 0; i < handler.objects.size(); i++) {
            Object tmp = handler.objects.get(i);
            tmp.render(g);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        // Make sure the screen is 640, 480
        if (container.getWidth() != 640 || container.getHeight() != 480) {
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
