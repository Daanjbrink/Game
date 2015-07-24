package GameStates;

import Engine.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Loading extends BasicGameState {

    private Main main;
    private int ID;

    public Loading(Main main, int ID) {
        this.main = main;
        this.ID = ID;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // Initialize game

        main.enterState(Main.StateMenu);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        // Loading image
        g.drawImage(new Image("src/Main/resources/Sprites/Other/Loading.png"), 0, 0);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    public int getID() {
        return this.ID;
    }
}
