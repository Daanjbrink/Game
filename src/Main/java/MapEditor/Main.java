package MapEditor;

import Game.Objects.Game.Wall;
import Game.Utils.Draw;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.io.File;
import java.util.Scanner;

public class Main {

    public final String[] assets = {
            "Wall/Wall 1.png",
            "Zombie/Other/SpawnPoint.png"
    };

    public int width, height;
    public int camX = 0;
    public int camY = 0;
    public int camSpd = 10;
    public ObjectHandler handler;
    private int[] keys = new int[4];
    private Place place;
    private Menu menu;

    private boolean Imported;
    private boolean ShowMenu;

    public Main(int width, int height, boolean imported) {
        this.width = width;
        this.height = height;

        if (imported)
            this.Imported = true;
        ShowMenu = true;

        handler = new ObjectHandler(this);
        place = new Place(this, handler);
        menu = new Menu(this, new Functions(this, handler));

        new Loader(this, handler).init();

        init();
        GameLoop();
    }

    public static void main(String[] args) {
        Display.setVSyncEnabled(true);
        Display.setTitle("MapEditor");
        if (args.length == 0) {
            try {
                Display.setDisplayMode(new DisplayMode(640, 480));
                Display.create();
                new Main(640, 480, false);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args.length == 2) {
            try {
                Display.setDisplayMode(new DisplayMode(640, 480));
                Display.create();
                new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args.length == 3) {
            try {
                Display.setDisplayMode(new DisplayMode(640, 480));
                Display.create();
                new Main(Integer.parseInt(args[1]), Integer.parseInt(args[2]), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
                            handler.addObject(new Wall(x, y));
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

            Display.setTitle("Mouse X: " + Mouse.getX() + " Mouse Y: " + (Display.getHeight() - Mouse.getY()) + " camX:" + camX + " camY: " + camY);

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BITS);

            GL11.glPushMatrix();

            GL11.glTranslatef(-camX, -camY, 0);

            render();
            update();

            GL11.glPopMatrix();

            Display.update();
        }
        Display.destroy();
    }

    public void update() {
        place.Move(Mouse.getX(), (Display.getHeight() - Mouse.getY()));

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == Keyboard.KEY_LMENU)
                    ShowMenu = !ShowMenu;
                if (Keyboard.getEventKey() == Keyboard.KEY_1)
                    handler.State = 1;

                if (Keyboard.getEventKey() == Keyboard.KEY_W)
                    keys[0] = camSpd;
                if (Keyboard.getEventKey() == Keyboard.KEY_A)
                    keys[1] = camSpd;
                if (Keyboard.getEventKey() == Keyboard.KEY_S)
                    keys[2] = camSpd;
                if (Keyboard.getEventKey() == Keyboard.KEY_D)
                    keys[3] = camSpd;
            } else {
                if (Keyboard.getEventKey() == Keyboard.KEY_W)
                    keys[0] = 0;
                if (Keyboard.getEventKey() == Keyboard.KEY_A)
                    keys[1] = 0;
                if (Keyboard.getEventKey() == Keyboard.KEY_S)
                    keys[2] = 0;
                if (Keyboard.getEventKey() == Keyboard.KEY_D)
                    keys[3] = 0;
            }
        }

        camX += (keys[3] - keys[1]);
        camY += (keys[2] - keys[0]);

        if (camX >= (width - Display.getWidth()))
            camX = (width - Display.getWidth());
        if (camX < 0)
            camX = 0;
        if (camY >= (height - Display.getHeight()))
            camY = (height - Display.getHeight());
        if (camY < 0)
            camY = 0;

        if (ShowMenu)
            if (menu.update())
                return;

        if (Mouse.isButtonDown(0)) {
            menu.ShowMenu = -1;
            place.click(0);
        } else if (Mouse.isButtonDown(1)) {
            menu.ShowMenu = -1;
            place.click(1);
        }

        Functions.updateFPS();
    }

    public void render() {

        Draw.FillRect(0, 0, width, height, new byte[]{(byte) 255, (byte) 255, (byte) 255});

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
        for (y = 32; y <= height; y += 32) {
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex2f(0, y);
            GL11.glVertex2f(width, y);
            GL11.glEnd();
        }
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        if (ShowMenu)
            menu.render();
    }
}
