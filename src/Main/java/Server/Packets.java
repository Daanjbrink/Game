package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Packets {

    ConcurrentLinkedQueue<DatagramPacket> packets = new ConcurrentLinkedQueue<>();

    DatagramSocket socket;

    private Receiver receiver;
    private Handler handler = new Handler(this);

    public Packets(DatagramSocket socket) {
        this.socket = socket;

        receiver = new Receiver(this, socket);

        new Thread(receiver).start();
    }

    public void Received() {
        handler.ReadPacket();
    }

    public void addPacket(DatagramPacket packet) {
        packets.add(packet);
    }

    public DatagramPacket getPacket() {
        return getPacket(true);
    }

    public DatagramPacket getPacket(boolean remove) {
        if (packets.size() == 0) {
            return null;
        }
        return remove ? packets.poll() : packets.peek();
    }

}
