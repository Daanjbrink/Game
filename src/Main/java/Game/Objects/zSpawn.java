package Game.Objects;

import Game.Engine.Object;
import Game.Utils.AssetManager;
import Game.Utils.Draw;

public class zSpawn extends Object {

    private final String imgLoc = "Zombie/Other/SpawnPoint.png";

    public zSpawn(int x, int y, AssetManager manager) {

        this.x = x;
        this.y = y;

        try {
            this.img = manager.get(imgLoc);
            this.width = img.getImageWidth();
            this.height = img.getImageHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        Draw.Draw(x, y, img);
    }

    public void renderMP() {
        Draw.Draw(x, y, img);
    }

    public void update() {

    }
}