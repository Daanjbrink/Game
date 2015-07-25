package MapEditor;

import org.newdawn.slick.*;

public class Main extends BasicGame {

    public int width, height;

    public Main(String name, int width, int height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appGc;
            appGc = new AppGameContainer(new Main("Map editor", Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            appGc.setDisplayMode(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false);
            appGc.setShowFPS(false);
            appGc.setVSync(true);
            appGc.setTargetFrameRate(60);
            appGc.start();
        } catch (Exception e) {

        }

        try {
            AppGameContainer appGc;
            appGc = new AppGameContainer(new Main("Map editor", 640, 480));
            appGc.setDisplayMode(640, 480, false);
            appGc.setShowFPS(false);
            appGc.setVSync(true);
            appGc.setTargetFrameRate(60);
            appGc.start();
        } catch (Exception e) {

        }

    }

    public void init(GameContainer gc) throws SlickException {
    }

    public void update(GameContainer gc, int i) throws SlickException {
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.black);
        int x, y;
        for (x = 0; x <= width; x += 32)
            g.drawLine(x, 0, x, height);
        for (y = 0; y <= height; y += 32)
            g.drawLine(0, y, width, y);
    }
}