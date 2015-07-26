package MapEditor;

import org.newdawn.slick.Color;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.Font;

public class Menu {

    public int ShowMenu;
    private int HoverMenu;

    private Main main;
    private Color FileMenu;

    public Menu(Main main) {
        this.main = main;

        FileMenu = Color.lightGray;

        ShowMenu = -1;
        HoverMenu = -1;
    }

    public void update(GameContainer gc) {
        Input input = gc.getInput();

        if (input.getAbsoluteMouseX() > 0 && input.getAbsoluteMouseX() < 32
                && input.getAbsoluteMouseY() > 0 && input.getAbsoluteMouseY() < 24) {
            HoverMenu = 0;
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                ShowMenu = 0;
            }
        } else if (input.getAbsoluteMouseX() > 0 && input.getAbsoluteMouseX() < 48
                && input.getAbsoluteMouseY() > 24 && input.getAbsoluteMouseY() < 48 && ShowMenu == 0) {
            HoverMenu = 1;
            /*if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                ShowMenu = 0;
            }*/
        } else if (input.getAbsoluteMouseX() > 0 && input.getAbsoluteMouseX() < 48
                && input.getAbsoluteMouseY() > 48 && input.getAbsoluteMouseY() < 72 && ShowMenu == 0) {
            HoverMenu = 2;
        } else if (input.getAbsoluteMouseX() > 0 && input.getAbsoluteMouseX() < 48
                && input.getAbsoluteMouseY() > 72 && input.getAbsoluteMouseY() < 96 && ShowMenu == 0) {
            HoverMenu = 3;
        } else {
            HoverMenu = -1;
        }
    }

    public void render(Graphics g) {
        Font awtfont = new Font("Times New Roman", Font.PLAIN, 16);
        TrueTypeFont font = new TrueTypeFont(awtfont, false);


        g.setColor(Color.lightGray);
        g.fillRect(0, 0, main.width, 24);

        switch (ShowMenu) {
            case 0:
                g.setColor(Color.lightGray);
                g.fillRect(0, 24, 48, 72);
                break;
        }

        //0 = File
        //1 = File>New
        //2 = File>Import
        //3 = File>Export
        switch (HoverMenu) {
            case 0:
                g.setColor(Color.gray);
                g.fillRect(0, 0, 32, 24);
                break;
            case 1:
                g.setColor(Color.gray);
                g.fillRect(0, 24, 48, 24);
                break;
            case 2:
                g.setColor(Color.gray);
                g.fillRect(0, 48, 48, 24);
                break;
            case 3:
                g.setColor(Color.gray);
                g.fillRect(0, 72, 48, 24);
                break;
        }

        //0 = File
        switch (ShowMenu) {
            case 0:
                g.setColor(Color.black);
                g.setFont(font);
                g.drawString("New...", 3, 26);

                g.setColor(Color.black);
                g.drawLine(0, 48, 48, 48);

                g.setColor(Color.black);
                g.setFont(font);
                g.drawString("Import", 3, 50);

                g.setColor(Color.black);
                g.setFont(font);
                g.drawString("Export", 3, 74);

                g.setColor(Color.black);
                g.drawRect(0, 24, 48, 72);
                break;
        }

        g.setColor(Color.black);
        g.setFont(font);
        g.drawString("File", 5, 2);
    }
}
