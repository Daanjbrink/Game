package MapEditor;

import Game.Utils.DrawImage;
import org.lwjgl.input.Mouse;
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

    public void update() {

        if (Mouse.getX() > 0 && Mouse.getX() < 32
                && Mouse.getY() > 0 && Mouse.getY() < 24) {
            HoverMenu = 0;
            if (Mouse.isButtonDown(0)) {
                ShowMenu = 0;
            }
        } else if (Mouse.getX() > 0 && Mouse.getX() < 48
                && Mouse.getY() > 24 && Mouse.getY() < 48 && ShowMenu == 0) {
            HoverMenu = 1;
            if (Mouse.isButtonDown(0)) {
                int width = Integer.parseInt(JOptionPane.showInputDialog(null, "Width", "New", JOptionPane.PLAIN_MESSAGE));
                int height = Integer.parseInt(JOptionPane.showInputDialog(null, "Height", "New", JOptionPane.PLAIN_MESSAGE));
                func.New(width, height);
            }
        } else if (Mouse.getX() > 0 && Mouse.getX() < 48
                && Mouse.getY() > 48 && Mouse.getY() < 72 && ShowMenu == 0) {
            HoverMenu = 2;
            if (Mouse.isButtonDown(0)) {
                func.Import();
            }
        } else if (Mouse.getX() > 0 && Mouse.getX() < 48
                && Mouse.getY() > 72 && Mouse.getY() < 96 && ShowMenu == 0) {
            HoverMenu = 3;
            if (Mouse.isButtonDown(0)) {
                func.Export();
            }
        } else {
            HoverMenu = -1;
        }
    }

    public void render() {
        TrueTypeFont font = new TrueTypeFont(new Font("Times New Roman", Font.PLAIN, 16), false);

        new DrawImage().DrawSquare(0, 0, main.width, 24, 1);

        switch (ShowMenu) {
            case 0:
                new DrawImage().DrawSquare(0, 24, 48, 72, 1);
                break;
        }

        //0 = File
        //1 = File>New
        //2 = File>Import
        //3 = File>Export
        switch (HoverMenu) {
            case 0:
                new DrawImage().DrawSquare(0, 0, 32, 24, 0);
                break;
            case 1:
                new DrawImage().DrawSquare(0, 24, 48, 24, 0);
                break;
            case 2:
                new DrawImage().DrawSquare(0, 48, 48, 24, 0);
                break;
            case 3:
                new DrawImage().DrawSquare(0, 72, 48, 24, 0);
                break;
        }

        //0 = File
        /*switch (ShowMenu) {
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
        g.drawString("File", 5, 2);*/
    }
}