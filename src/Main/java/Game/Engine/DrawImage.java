package Game.Engine;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class DrawImage {

    public void Draw(int x, int y, Texture img) {
        Color.white.bind();
        img.bind();

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(x, y);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(x + img.getTextureWidth(), y);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(x + img.getTextureWidth(), y + img.getTextureHeight());

        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(x, y + img.getTextureHeight());
        GL11.glEnd();
    }

    public void DrawSquare(int x1, int y1, int x2, int y2) {
        Color.white.bind();
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor3f(0.5f, 0.5f, 1.0f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x2, y1);
        GL11.glVertex2f(x2, y2);
        GL11.glVertex2f(x1, y2);
        GL11.glEnd();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

}
