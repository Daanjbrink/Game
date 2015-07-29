package Game.Engine;

import org.newdawn.slick.opengl.Texture;

public class PNGData {

    private String imgName;
    private Texture img;

    public PNGData(String name, Texture img) {
        setName(name);
        setImg(img);
    }

    public String getName() {
        return this.imgName;
    }

    private void setName(String name) {
        this.imgName = name;
    }

    public Texture getImg() {
        return this.img;
    }

    private void setImg(Texture img) {
        this.img = img;
    }

}
