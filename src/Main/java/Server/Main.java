package Server;

import java.net.DatagramSocket;
import java.util.Scanner;

public class Main {

    DatagramSocket socket;

    public Main(int port) {
        System.out.println("Starting server on port: " + port);

        try {
            socket = new DatagramSocket(port);
            socket.setSoTimeout(1000);
        } catch (Exception e) {
            System.out.println("Error opening socket on " + port);
            e.printStackTrace();
            new Scanner(System.in).nextLine();
            System.exit(0);
        }

        new Thread(new Receiver(socket)).start();
    }

    public static void main(String[] args) {
        new Main(Integer.parseInt(args[0]));
    }
}
