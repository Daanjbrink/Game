package MapEditor;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Menu {

    public int ShowMenu;
    private Main main;
    private Color FileMenu;

    public Menu(Main main) {
        this.main = main;

        FileMenu = Color.lightGray;

        ShowMenu = -1;
    }

    public void update(GameContainer gc) {
        Input input = gc.getInput();

        if (input.getAbsoluteMouseX() > 0 && input.getAbsoluteMouseX() < 32
                && input.getAbsoluteMouseY() > 0 && input.getAbsoluteMouseY() < 32) {
            FileMenu = Color.gray;
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                ShowMenu = 0;
            }
        } else {
            if (FileMenu != Color.lightGray) FileMenu = Color.lightGray;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, main.width, 24);

        g.setColor(FileMenu);
        g.fillRect(0, 0, 32, 24);

        //0 = File
        switch (ShowMenu) {
            case 0:
                g.setColor(Color.lightGray);
                g.fillRect(0, 24, 32, 74);
                break;
        }
    }
}
