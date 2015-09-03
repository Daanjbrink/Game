package Server;

import Utils.Log;
import Utils.LogLevel;

import java.net.DatagramSocket;
import java.util.Scanner;

public class Main {

    DatagramSocket socket;

    public Main(int port) {
        Log.enableAllLevels();
        Log.disableLevel(LogLevel.NONE);
        Log.log("Starting server on port: " + port, LogLevel.INFO);

        try {
            socket = new DatagramSocket(port);
        } catch (Exception e) {
            Log.log("Error opening socket on " + port, LogLevel.ERROR);
            e.printStackTrace();
            new Scanner(System.in).nextLine();
            System.exit(0);
        }

        new Packets(socket);
    }

    public static void main(String[] args) {
        new Main(Integer.parseInt(args[0]));
    }
}
