package MapEditor;

import Game.Objects.Wall;
import org.newdawn.slick.*;

import java.io.File;
import java.util.Scanner;

public class Main extends BasicGame {

    public int width, height;

    private ObjectHandler handler;
    private Place place;
    private Menu menu;
    private Functions func;

    private boolean Imported;

    public Main(String name, int width, int height, boolean imported) {
        super(name);
        this.width = width;
        this.height = height;

        if (imported)
            this.Imported = true;

        handler = new ObjectHandler(this);
        place = new Place(handler);
        func = new Functions();
        menu = new Menu(this, func);

    }

    public static void main(String[] args) {
        for (String str : args) {
            System.out.println(str);
        }
        if (args.length == 0) {
            try {
                AppGameContainer appGc;
                appGc = new AppGameContainer(new Main("Map editor", 640, 480, false));
                appGc.setDisplayMode(640, 480, false);
                appGc.setShowFPS(false);
                appGc.setVSync(true);
                appGc.setTargetFrameRate(60);
                appGc.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args.length == 2) {
            try {
                AppGameContainer appGc;
                appGc = new AppGameContainer(new Main("Map editor", Integer.parseInt(args[0]), Integer.parseInt(args[1]), false));
                appGc.setDisplayMode(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false);
                appGc.setShowFPS(false);
                appGc.setVSync(true);
                appGc.setTargetFrameRate(60);
                appGc.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args.length == 3) {
            //if(args[0] == "-Import"){
            try {
                AppGameContainer appGc;
                appGc = new AppGameContainer(new Main("Map editor", Integer.parseInt(args[1]), Integer.parseInt(args[2]), true));
                appGc.setDisplayMode(Integer.parseInt(args[1]), Integer.parseInt(args[2]), false);
                appGc.setShowFPS(false);
                appGc.setVSync(true);
                appGc.setTargetFrameRate(60);
                appGc.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //}
        }
    }

    public void init(GameContainer gc) throws SlickException {
        if (Imported) {
            try {
                Scanner reader = new Scanner(new File("map.txt"));

                if (reader.hasNextLine())
                    reader.nextLine();

                while (reader.hasNextLine()) {
                    int x, y;

                    String[] tmp = reader.nextLine().split(" ");
                    x = Integer.parseInt(tmp[0]);
                    y = Integer.parseInt(tmp[1]);

                    System.out.println(tmp[0]);
                    System.out.println(tmp[1]);
                    System.out.println(tmp[2]);

                    switch (tmp[2]) {
                        case "Wall":
                            handler.addObject(new Wall(x, y));
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input input = gc.getInput();

        place.Move(input.getAbsoluteMouseX(), input.getAbsoluteMouseY());

        menu.update(input);

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