package Game.Objects.Settings;

import Game.Engine.Object;
import Game.Engine.Vars;
import Game.Utils.Draw;
import org.lwjgl.input.Mouse;

public class But_Fullscreen extends Object {

    private final String imgChecked = "Text/Checkbox checked.png";
    private final String imgUnChecked = "Text/Checkbox unchecked.png";

    public But_Fullscreen(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.img = Vars.manager.get((Vars.fullscreen ? imgChecked : imgUnChecked));
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
        while (Mouse.next()) {
            if (!Mouse.getEventButtonState()) {
                if (Mouse.getEventButton() == 0) {
                    if (isClicked()) {
                        Vars.fullscreen = !Vars.fullscreen;
                        this.img = Vars.manager.get((Vars.fullscreen ? imgChecked : imgUnChecked));
                    }
                }
            }
        }
    }
}