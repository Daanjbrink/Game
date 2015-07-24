package MapEditor;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    public int width, height;

    public Main(int width, int height) {
        this.width = width;
        this.height = height;

        new Window(this);

        this.createBufferStrategy(2);

        new Thread(this).start();
    }

    public static void main(String[] args) {
        new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

    public void run() {
        this.requestFocus();
        while (true)
            render();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        int x, y;
        for (x = 0; x <= width; x += 32)
            g.drawLine(x, 0, x, height);
        for (y = 0; y <= height; y += 32)
            g.drawLine(0, y, width, y);

        g.dispose();
        bs.show();
    }
}
