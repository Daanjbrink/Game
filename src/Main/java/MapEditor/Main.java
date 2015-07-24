package MapEditor;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    public int width, height;

    private ObjectHandler handler;
    private Place place;

    public Main(int width, int height) {
        this.width = width;
        this.height = height;

        new Window(this);

        handler = new ObjectHandler(this);
        place = new Place(handler);

        this.addMouseListener(new Mouse(place));
        this.addMouseMotionListener(new Mouse(place));
        this.addKeyListener(new Keyboard(handler));

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

        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        handler.render(g);
        place.render(g);

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
