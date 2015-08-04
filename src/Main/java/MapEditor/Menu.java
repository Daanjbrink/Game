package MapEditor;

import Game.Utils.Draw;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
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

    public boolean update() {

        Display.setTitle("X: " + Mouse.getX() + " Y: " + (Display.getHeight() - Mouse.getY()));

        if (Mouse.getX() > main.camX && Mouse.getX() < (main.camX + 32)
                && (Display.getHeight() - Mouse.getY()) > 0 && (Display.getHeight() - Mouse.getY()) < 24) {
            HoverMenu = 0;
            if (Mouse.isButtonDown(0)) {
                ShowMenu = 0;
                return true;
            }
        } else if (Mouse.getX() > main.camX && Mouse.getX() < (main.camX + 48)
                && (main.height - Mouse.getY()) > 24 && (main.height - Mouse.getY()) < 48 && ShowMenu == 0) {
            HoverMenu = 1;
            if (Mouse.isButtonDown(0)) {
                try {
                    int width = Integer.parseInt(JOptionPane.showInputDialog(null, "Width", "New", JOptionPane.PLAIN_MESSAGE));
                    int height = Integer.parseInt(JOptionPane.showInputDialog(null, "Height", "New", JOptionPane.PLAIN_MESSAGE));
                    func.New(width, height);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (Mouse.getX() > main.camX && Mouse.getX() < (main.camX + 48)
                && (main.height - Mouse.getY()) > 48 && (main.height - Mouse.getY()) < 72 && ShowMenu == 0) {
            HoverMenu = 2;
            if (Mouse.isButtonDown(0)) {
                func.Import();
            }
        } else if (Mouse.getX() > main.camX && Mouse.getX() < (main.camX + 48)
                && (main.height - Mouse.getY()) > 72 && (main.height - Mouse.getY()) < 96 && ShowMenu == 0) {
            HoverMenu = 3;
            if (Mouse.isButtonDown(0)) {
                func.Export();
            }
        } else {
            HoverMenu = -1;
        }
        return false;
    }

    public void render() {
        TrueTypeFont font = new TrueTypeFont(new Font("Times New Roman", Font.PLAIN, 16), false);

        new Draw().FillRect(main.camX, main.camY, main.width, 24, new byte[]{(byte) 190, (byte) 190, (byte) 190});

        switch (ShowMenu) {
            case 0:
                new Draw().FillRect(main.camX, main.camY + 24, 48, 72, new byte[]{(byte) 190, (byte) 190, (byte) 190});
                break;
        }

        //0 = File
        //1 = File>New
        //2 = File>Import
        //3 = File>Export
        switch (HoverMenu) {
            case 0:
                new Draw().FillRect(main.camX, main.camY, 32, 24, new byte[]{(byte) 130, (byte) 130, (byte) 130});
                break;
            case 1:
                new Draw().FillRect(main.camX, main.camY + 24, 48, 24, new byte[]{(byte) 130, (byte) 130, (byte) 130});
                break;
            case 2:
                new Draw().FillRect(main.camX, main.camY + 48, 48, 24, new byte[]{(byte) 130, (byte) 130, (byte) 130});
                break;
            case 3:
                new Draw().FillRect(main.camX, main.camY + 72, 48, 24, new byte[]{(byte) 130, (byte) 130, (byte) 130});
                break;
        }

        //0 = File
        switch (ShowMenu) {
            case 0:
                font.drawString(3, main.camY + 26, "New...");
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glColor3d(0, 0, 0);
                GL11.glBegin(GL11.GL_LINES);
                GL11.glVertex2d(main.camX, main.camY + 48);
                GL11.glVertex2d(main.camX + 48, main.camY + 48);
                GL11.glEnd();
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                font.drawString(main.camX + 3, main.camY + 50, "Import");
                font.drawString(main.camX + 3, main.camY + 74, "Export");
                new Draw().DrawRect(0, main.camY + 24, 48, 72, new byte[]{(byte) 0, (byte) 0, (byte) 0});
                break;
        }

        /*g.setColor(Color.black);
        g.setFont(font);
        g.drawString("File", 5, 2);*/

        font.drawString(main.camX + 5, main.camY + 2, "File");
    }
}