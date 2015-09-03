package Game.GameStates;

import Game.Engine.Loader;
import Game.Engine.Vars;
import Game.Utils.Connection;
import Game.Utils.Draw;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import java.net.DatagramSocket;

public class Game extends GameState {

    final public String[] assets = {
            "Text/Ground.png",
            "Characters/Character 1/Character 1 phase 1.png",
            "Other/Bullet.png",
            "Wall/Wall 1.png"
    };

    private Texture background;


    private int camX = 0, camY = 0;

    private DatagramSocket server;

    public void init() {
        try {
            if (Vars.width != 640 || Vars.height != 480)
                Display.setDisplayMode(new DisplayMode(640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Loader.loadSprites(assets);
        background = Vars.manager.get("Text/Ground.png");

        server = Connection.initConnection("192.168.1.100", 501);
        if (server == null)
            System.exit(0);
    }

    private void addObjects() {

    }

    public void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(-camX, -camY, 0);

        Draw.DrawBackGround(0, 0, background, false);
        /*for (int i = 0; i < Vars.handler.objects.size(); i++) {
            Vars.handler.objects.get(i).render();
        }*/

        GL11.glPopMatrix();
    }

    public void update() {
        Connection.Receive(server);

        /*for (int i = 0; i < Vars.handler.objects.size(); i++) {
            Vars.handler.objects.get(i).update();
        }*/
    }
}
