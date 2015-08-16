package Game.Objects.Game;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;

public class zSpawn extends Object {

    private final String imgLoc = "Zombie/Other/SpawnPoint.png";

    public zSpawn(int x, int y) {

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
        Draw.Draw(x, y, img);
    }

    public void update() {

    }
}