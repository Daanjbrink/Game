package Game.Objects.Game;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;
import org.lwjgl.input.Keyboard;

public class Player extends Object {

    private final String imgLoc = "Characters/Character 1/Character 1 phase 1.png";

    private boolean[] keyDown = new boolean[4];

    private int angle;

    public Player(int x, int y) {

        this.x = x;
        this.y = y;

        try {
            this.img = Vars.manager.get(imgLoc);
            this.width = img.getImageWidth();
            this.height = img.getImageHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        Draw.DrawRotated(x, y, img, angle);
    }

    public void update() {
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == Keyboard.KEY_W) {
                    this.setVelY(-2);
                    keyDown[0] = true;
                    angle = 0;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_A) {
                    this.setVelX(-2);
                    keyDown[1] = true;
                    angle = 270;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_S) {
                    this.setVelY(2);
                    keyDown[2] = true;
                    angle = 180;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_D) {
                    this.setVelX(2);
                    keyDown[3] = true;
                    angle = 90;
                }
            } else {
                if (Keyboard.getEventKey() == Keyboard.KEY_W) {
                    keyDown[0] = false;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_A) {
                    keyDown[1] = false;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_S) {
                    keyDown[2] = false;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_D) {
                    keyDown[3] = false;
                }
            }
        }

        if (!keyDown[0] && !keyDown[2]) this.setVelY(0);
        if (!keyDown[1] && !keyDown[3]) this.setVelX(0);

        x += velX;
        y += velY;
    }
}