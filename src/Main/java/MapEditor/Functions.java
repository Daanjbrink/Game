package MapEditor;

import Game.Engine.Object;
import org.lwjgl.Sys;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

    private static int fps;
    private static long lastFPS = getTime();
    private Main main;
    private ObjectHandler handler;

    public Functions(Main main, ObjectHandler handler) {
        this.main = main;
        this.handler = handler;
    }

    public static void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            //Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    public void New(int width, int height) {
        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar"))
                return;
            ArrayList<String> command = new ArrayList<>();
            command.add(javaBin);
            command.add("-jar");
            command.add("-Djava.library.path=lib/");
            command.add(currentJar.getPath());
            command.add(Integer.toString(width));
            command.add(Integer.toString(height));

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Import() {
        try {
            String width = "", height = "";

            Scanner reader = new Scanner(new File("map.txt"));

            if (reader.hasNextLine()) {
                String[] wh = reader.nextLine().split(" ");
                width = wh[0];
                height = wh[1];
            }

            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar"))
                return;
            ArrayList<String> command = new ArrayList<>();
            command.add(javaBin);
            command.add("-jar");
            command.add("-Djava.library.path=lib/");
            command.add(currentJar.getPath());
            command.add("-Import");
            command.add(width);
            command.add(height);

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Export() {
        try {

            PrintWriter writer = new PrintWriter("map.txt", "UTF-8");
            writer.println(main.width + " " + main.height);

            for (int i = 0; i < handler.objects.size(); i++) {
                Object obj = handler.objects.get(i);
                //writer.println(obj.getX() + " " + obj.getY() + " " + obj.getType().toString().replace("class Game.Objects.", ""));
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}