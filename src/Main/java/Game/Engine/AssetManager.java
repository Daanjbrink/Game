package Game.Engine;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.util.ArrayList;

public class AssetManager {

    ArrayList<PNGData> PNGassets = new ArrayList<>();

    public void loadPNG(String filename) {
        for (int i = 0; i < PNGassets.size(); i++) {
            if (filename.equals(PNGassets.get(i).getName())) {
                return;
            }
        }
        try {
            PNGassets.add(new PNGData(filename, TextureLoader.getTexture("PNG",
                    ResourceLoader.getResourceAsStream("Sprites/" + filename))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Texture get(String filename) {
        for (int i = 0; i < PNGassets.size(); i++) {
            if (filename.equals(PNGassets.get(i).getName())) {
                return PNGassets.get(i).getImg();
            }
        }
        return null;
    }
}
