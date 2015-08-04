package MapEditor;

import Game.Utils.AssetManager;
import Game.Utils.Draw;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.io.File;
import java.util.Scanner;

public class Main {

    public final String[] assets = {
            "Wall/Wall 1.png"
    };

    public int width, height;

    public AssetManager manager;

    private ObjectHandler handler;
    private Place place;
    private Menu menu;

    private boolean Imported;

    public Main(int width, int height, boolean imported) {
        this.width = width;
        this.height = height;

        this.manager = new AssetManager();

        if (imported)
            this.Imported = true;

        handler = new ObjectHandler(this);
        place = new Place(handler);
        menu = new Menu(this, new Functions());

        new Loader(this).init();

        init();
        GameLoop();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            try {
                Display.setDisplayMode(new DisplayMode(640, 472));
                Display.setVSyncEnabled(true);
                Display.setTitle("MapEditor");
                Display.create();

                new Main(640, 472, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args.length == 2) {
            try {
                Display.setDisplayMode(new DisplayMode(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                Display.setVSyncEnabled(true);
                Display.setTitle("MapEditor");
                Display.create();

                new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args.length == 3) {
            //if(args[0] == "-Import"){
            try {
                Display.setDisplayMode(new DisplayMode(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                Display.setVSyncEnabled(true);
                Display.setTitle("MapEditor");
                Display.create();

                new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //}
        }
    }

    public void init() {
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
                            //handler.addObject(new Wall(x, y));
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void GameLoop() {
        while (!Display.isCloseRequested()) {
            try {
                Thread.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BITS);

            update();
            render();

            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }

    public void update() {
        place.Move(Mouse.getX(), Mouse.getY());

        if (menu.update())
            return;

        if (Mouse.isButtonDown(0)) {
            menu.ShowMenu = -1;
            place.click(1);
        } else if (Mouse.isButtonDown(1)) {
            menu.ShowMenu = -1;
            place.click(2);
        } else if (Mouse.isButtonDown(2)) {
            menu.ShowMenu = -1;
            place.click(3);
        }

        /*if (input.isKeyDown(Input.KEY_1)) {
            //handler.type = Types.Wall;
            handler.State = 1;
        }
        if (input.isKeyDown(Input.KEY_2)) {
            System.out.println(handler.objects.size());
        }
        if (input.isKeyDown(Input.KEY_3)) {
            System.out.println("X: " + input.getAbsoluteMouseX());
            System.out.println("Y: " + input.getAbsoluteMouseY());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    public void render() {

        new Draw().FillRect(0, 0, width, height, new byte[]{(byte) 255, (byte) 255, (byte) 255});

        handler.render();
        place.render();

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3d(0, 0, 0);
        int x, y;
        for (x = 0; x <= width; x += 32) {
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex2f(x, height);
            GL11.glVertex2f(x, 0);
            GL11.glEnd();
        }
        for (y = 24; y <= height; y += 32) {
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex2f(0, y);
            GL11.glVertex2f(width, y);
            GL11.glEnd();
        }
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        menu.render();
    }
}
