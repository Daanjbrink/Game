package MapEditor;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

import javax.swing.*;
import java.awt.*;

public class Menu {

    public int ShowMenu;
    public int HoverMenu;

    private Main main;
    private Functions func;

    public Menu(Main main, Functions func) {
        this.main = main;
        this.func = func;

        ShowMenu = -1;
        HoverMenu = -1;
    }

    public void update(Input inp) {

        if (inp.getAbsoluteMouseX() > 0 && inp.getAbsoluteMouseX() < 32
                && inp.getAbsoluteMouseY() > 0 && inp.getAbsoluteMouseY() < 24) {
            HoverMenu = 0;
            if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                ShowMenu = 0;
            }
        } else if (inp.getAbsoluteMouseX() > 0 && inp.getAbsoluteMouseX() < 48
                && inp.getAbsoluteMouseY() > 24 && inp.getAbsoluteMouseY() < 48 && ShowMenu == 0) {
            HoverMenu = 1;
            if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                int width = Integer.parseInt(JOptionPane.showInputDialog(null, "Width", "New", JOptionPane.PLAIN_MESSAGE));
                int height = Integer.parseInt(JOptionPane.showInputDialog(null, "Height", "New", JOptionPane.PLAIN_MESSAGE));
                func.New(width, height);
            }
        } else if (inp.getAbsoluteMouseX() > 0 && inp.getAbsoluteMouseX() < 48
                && inp.getAbsoluteMouseY() > 48 && inp.getAbsoluteMouseY() < 72 && ShowMenu == 0) {
            HoverMenu = 2;
            if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                func.Import();
            }
        } else if (inp.getAbsoluteMouseX() > 0 && inp.getAbsoluteMouseX() < 48
                && inp.getAbsoluteMouseY() > 72 && inp.getAbsoluteMouseY() < 96 && ShowMenu == 0) {
            HoverMenu = 3;
            if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                func.Export();
            }
        } else {
            HoverMenu = -1;
        }
    }

    public void render(Graphics g) {
        TrueTypeFont font = new TrueTypeFont(new Font("Times New Roman", Font.PLAIN, 16), false);


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
