package Game.Objects.Game;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;
import org.lwjgl.util.Rectangle;

public class Bullet extends Object {

    private final String imgLoc = "Other/Bullet.png";

    private int spd = 20;

    public Bullet(int x, int y, int angle) {

        this.x = x;
        this.y = y;

        this.angle = angle;

        if (angle == 0) {
            this.setVelY(-spd);
        } else if (angle == 45) {
            this.setVelY(-spd);
            this.setVelX(spd);
        } else if (angle == 90) {
            this.setVelX(spd);
        } else if (angle == 135) {
            this.setVelY(spd);
            this.setVelX(spd);
        } else if (angle == 180) {
            this.setVelY(spd);
        } else if (angle == 225) {
            this.setVelY(spd);
            this.setVelX(-spd);
        } else if (angle == 270) {
            this.setVelX(-spd);
        } else if (angle == 315) {
            this.setVelY(-spd);
            this.setVelX(-spd);
        }

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
        if (collision(velX, velY)) {
            Vars.handler.removeObject(this);
        }

        x += velX;
        y += velY;
    }

    private boolean collision(int x1, int y1) {
        Rectangle NewRec = new Rectangle(x + x1, y + y1, width, height);

        for (int i = 0; i < Vars.handler.objects.size(); i++) {
            Object obj = Vars.handler.objects.get(i);
            System.out.println(obj.getClass().getSimpleName());
            if (obj != this || !obj.getClass().getSimpleName().equals("Player")) {
                if (NewRec.intersects(obj.getBounds())) {
                    return true;
                }
            }
        }
        return false;
    }
}