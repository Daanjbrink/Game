package Game.Objects.Game;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;

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
        x += velX;
        y += velY;
    }
}