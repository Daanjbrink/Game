package Game.Objects.Game;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;

public class Player extends Object {

    private final String imgLoc = "Characters/Character 1/Character 1 phase 1.png";

    private byte keys;
    private int spd = 2;

    private int dx, dy;

    // seconds * fps
    private float MaxStamina = 5 * 60, stamina = MaxStamina;

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
        Draw.DrawObject(this);
    }

    public void update() {
        dx = 0;
        dy = 0;

        boolean shoot = false;

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == Keyboard.KEY_W) {
                    keys ^= 1;
                    dy--;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_A) {
                    keys ^= 2;
                    dx--;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_S) {
                    keys ^= 4;
                    dy++;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_D) {
                    keys ^= 8;
                    dx++;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_LSHIFT) {
                    keys ^= 16;
                }
            } else {
                if (Keyboard.getEventKey() == Keyboard.KEY_W) {
                    keys ^= 1;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_A) {
                    keys ^= 2;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_S) {
                    keys ^= 4;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_D) {
                    keys ^= 8;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_SPACE) {
                    shoot = true;
                } else if (Keyboard.getEventKey() == Keyboard.KEY_LSHIFT) {
                    keys ^= 16;
                    spd = 2;
                }
            }
        }

        if ((keys & 16) > 0) {
            if (stamina > 0) {
                stamina--;
                spd = 5;
            } else {
                spd = 2;
            }
        } else if ((keys & 16) == 0) {
            if (stamina < MaxStamina) {
                stamina += .5;
            }
        }

        if (shoot) {
            /*double dx = (25 * Math.cos(Math.toRadians(angle)) - (-7) * Math.sin(Math.toRadians(angle)));
            double dy = (25 * Math.sin(Math.toRadians(angle)) + (-7) * Math.cos(Math.toRadians(angle)));*/
            // Math problems

            Vars.handler.addObject(new Bullet(x, y, angle));
        }

        byte Hspd = 0, Vspd = 0;

        if ((keys & 1) > 0) {
            dy--;
            Vspd -= spd;
        }
        if ((keys & 2) > 0) {
            dx--;
            Hspd -= spd;
        }
        if ((keys & 4) > 0) {
            dy++;
            Vspd += spd;
        }
        if ((keys & 8) > 0) {
            dx++;
            Hspd += spd;
        }

        if (dx == -1 && dy == 0) {
            angle = 270;
        } else if (dx == -1 && dy == -1) {
            angle = 315;
        } else if (dx == 0 && dy == -1) {
            angle = 0;
        } else if (dx == 1 && dy == -1) {
            angle = 45;
        } else if (dx == 1 && dy == 0) {
            angle = 90;
        } else if (dx == 1 && dy == 1) {
            angle = 135;
        } else if (dx == 0 && dy == 1) {
            angle = 180;
        } else if (dx == -1 && dy == 1) {
            angle = 225;
        }

        if ((keys & 1) == 0 && (keys & 4) == 0) this.setVelY(0);
        if ((keys & 2) == 0 && (keys & 8) == 0) this.setVelX(0);

        if (!collision(Hspd, 0)) {
            x += Hspd;
        }

        if (!collision(0, Vspd)) {
            y += Vspd;
        }
    }

    private boolean collision(int x1, int y1) {
        Rectangle NewRec = new Rectangle(x + x1, y + y1, width, height);

        for (int i = 0; i < Vars.handler.objects.size(); i++) {
            Object obj = Vars.handler.objects.get(i);

            if (obj != this) {
                if (NewRec.intersects(obj.getBounds())) {
                    return true;
                }
            }
        }

        return false;
    }
}