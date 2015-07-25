package MapEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.ArrayList;

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
        try {
            new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } catch (Exception e) {
            new Main(640, 480);
        }
    }

    public void run() {
        this.requestFocus();
        while (true){
            Thread.sleep(3);
            render();
        }
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

    public void New() {
        String width = JOptionPane.showInputDialog("Width");
        String height = JOptionPane.showInputDialog("Height");

        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar")) return;
            ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());
            command.add(width);
            command.add(height);

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Import() {

    }

    public void Export() {

    }
}
