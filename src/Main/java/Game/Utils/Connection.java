package Game.Utils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class Connection {

    public static DatagramSocket initConnection(String ip, int port) {
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress IP = InetAddress.getByName(ip);

            ByteBuffer buffer = ByteBuffer.allocate(30);
            buffer.put((byte) 0);
            buffer.flip();
            byte[] bb = new byte[buffer.remaining()];
            buffer.get(bb);

            DatagramPacket packet = new DatagramPacket(bb, bb.length, IP, port);
            socket.send(packet);

            return socket;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void Receive(DatagramSocket socket) {

    }

}
