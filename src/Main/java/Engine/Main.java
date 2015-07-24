package Engine;

import GameStates.Game;
import GameStates.Loading;
import GameStates.Menu;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    public static final int StateLoading = 0;
    public static final int StateMenu = 1;
    public static final int StateGame = 2;

    public Main() {
        super("Game");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appGc = new AppGameContainer(new Main());
            appGc.setDisplayMode(512, 128, false);
            appGc.setShowFPS(false);
            appGc.setVSync(true);
            appGc.setTargetFrameRate(60);
            appGc.setIcon("src/Main/resources/Sprites/Other/Icon.png");
            appGc.start();
        } catch (Exception e) {

        }
    }

    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new Loading(this, StateLoading));
        this.addState(new Menu(this, StateMenu));
        this.addState(new Game(this, StateGame));
        this.enterState(StateLoading);
    }
}
