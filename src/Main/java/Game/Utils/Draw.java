package Game.Utils;

import Game.Engine.Object;
import Game.Engine.Vars;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Draw {

    public static void Draw(float x, float y, Texture img) {
        img.bind();

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(x, y);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(x + img.getTextureWidth(), y);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(x + img.getTextureWidth(), y + img.getTextureHeight());

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(x, y + img.getTextureHeight());
        GL11.glEnd();
    }

    public static void DrawBackGround(int x, int y, Texture img, boolean stretch) {
        img.bind();

        if (!stretch) {
            for (int i = 0; i < Vars.gameWidth; i += img.getTextureWidth()) {
                for (int j = 0; j < Vars.gameHeight; j += img.getTextureHeight()) {
                    GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2f(0, 0);
                    GL11.glVertex2f(x + i, y + j);

                    GL11.glTexCoord2f(1, 0);
                    GL11.glVertex2f(x + img.getTextureWidth() + i, y + j);

                    GL11.glTexCoord2f(1, 1);
                    GL11.glVertex2f(x + img.getTextureWidth() + i, y + img.getTextureHeight() + j);

                    GL11.glTexCoord2f(0, 1);
                    GL11.glVertex2f(x + i, y + img.getTextureHeight() + j);
                    GL11.glEnd();
                }
            }
        } else {
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(x, y);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(x + Vars.gameWidth, y);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(x + Vars.gameWidth, y + Vars.gameHeight);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(x, y + Vars.gameHeight);
            GL11.glEnd();
        }
    }

    public static void DrawObject(Object object) {
        GL11.glPushMatrix();

        /*GL11.glTranslatef(object.getX() + object.getWidth() / 2, object.getY() + object.getHeight() / 2, 0);
        GL11.glRotatef(object.getAngle(), 0, 0, 1);
        GL11.glScalef(object.getScaleX(), object.getScaleY(), 0);
        GL11.glTranslatef(-object.getX() - object.getWidth() / 2, -object.getY() - object.getHeight() / 2, 0);*/

        GL11.glTranslatef(object.getX(), object.getY(), 0);
        GL11.glRotatef(object.getAngle(), 0, 0, 1);
        GL11.glScalef(object.getScaleX(), object.getScaleY(), 0);
        GL11.glTranslatef(-object.getX(), -object.getY(), 0);

        object.getImg().bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(object.getX(), object.getY());

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(object.getX() + object.getWidth(), object.getY());

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(object.getX() + object.getWidth(), object.getY() + object.getHeight());

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(object.getX(), object.getY() + object.getHeight());
        GL11.glEnd();

        GL11.glPopMatrix();
    }

    public static void DrawRotated(float x, float y, Texture img, int angle) {
        GL11.glPushMatrix();

        GL11.glTranslatef(x + img.getTextureWidth() / 2, y + img.getTextureHeight() / 2, 0);
        GL11.glRotatef(angle, 0, 0, 1);
        GL11.glTranslatef(-x + img.getTextureWidth() / 2, -y + img.getTextureHeight() / 2, 0);

        img.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(x, y);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(x + img.getTextureWidth(), y);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(x + img.getTextureWidth(), y + img.getTextureHeight());

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(x, y + img.getTextureHeight());
        GL11.glEnd();

        GL11.glPopMatrix();
    }

    public static void FillRect(int x, int y, int width, int height, byte[] color) {
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor3ub(color[0], color[1], color[2]);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x + width, y);
        GL11.glVertex2f(x + width, y + height);
        GL11.glVertex2f(x, y + height);
        GL11.glEnd();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public static void DrawRect(int x, int y, int width, int height, byte[] color) {
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor3ub(color[0], color[1], color[2]);

        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x + width, y);

        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x, y + height);

        GL11.glVertex2f(x + width, y);
        GL11.glVertex2f(x + width, y + height);

        GL11.glVertex2f(x, y + height);
        GL11.glVertex2f(x + width, y + height);
        GL11.glEnd();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public static void DrawLine(int x, int y, int x2, int y2) {
        GL11.glPushMatrix();

        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor3f(0, 0, 0);
        GL11.glBegin(GL11.GL_LINE_STRIP);

        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x2, y2);

        GL11.glEnd();

        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glPopMatrix();
    }
}
