package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver extends Thread {

    private DatagramSocket socket;

    public Receiver(DatagramSocket socket) {
        this.socket = socket;

        Receive();
    }

    public void Receive() {
        while (true) {
            try {
                Thread.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] receiveBuffer = new byte[100];

            DatagramPacket recvPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            try {
                socket.receive(recvPacket);
            } catch (IOException e) {
                //e.printStackTrace();
            }

            System.out.println("Next");
        }
    }

}
