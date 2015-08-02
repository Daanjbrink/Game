package Game.Utils;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class Draw {

    public void Draw(int x, int y, Texture img) {
        Color.white.bind();
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

    public void FillRect(int x, int y, int width, int height, byte[] color) {
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

    public void DrawRect(int x, int y, int width, int height, byte[] color) {
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

}
