package Server;

import Utils.Log;
import Utils.LogLevel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver implements Runnable {

    private Packets packets;

    private DatagramSocket socket;

    public Receiver(Packets packets, DatagramSocket socket) {
        this.packets = packets;
        this.socket = socket;
    }

    public void run() {
        Log.log("Started Receiver at UDP port " + socket.getLocalPort(), LogLevel.INFO);
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
                packets.addPacket(recvPacket.getData());
                packets.Received();
            } catch (IOException e) {
                Log.log("Failed to receive UDP packet exception: " + e, LogLevel.ERROR);
            }
        }
    }
}
