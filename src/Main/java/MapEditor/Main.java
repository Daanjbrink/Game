package MapEditor;

import org.newdawn.slick.*;

public class Main extends BasicGame {

    public int width, height;

    private ObjectHandler handler;
    private Place place;
    private Menu menu;

    public Main(String name, int width, int height) {
        super(name);
        this.width = width;
        this.height = height;

        handler = new ObjectHandler(this);
        place = new Place(handler);
        menu = new Menu(this);

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

        menu.update(gc);

        Input input = gc.getInput();

        place.Move(input.getAbsoluteMouseX(), input.getAbsoluteMouseY());

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            menu.ShowMenu = -1;
            place.click(1);
        } else if (input.isMousePressed(Input.MOUSE_MIDDLE_BUTTON)) {
            menu.ShowMenu = -1;
            place.click(2);
        } else if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
            menu.ShowMenu = -1;
            place.click(3);
        }

        if (input.isKeyDown(Input.KEY_1)) {
            //handler.type = Types.Wall;
            handler.State = 1;
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        handler.render(g);
        place.render(g);

        g.setColor(Color.black);
        int x, y;
        for (x = 0; x <= width; x += 32)
            g.drawLine(x, 24, x, height);
        for (y = 24; y <= height; y += 32)
            g.drawLine(0, y, width, y);

        menu.render(g);
    }
}