package Server;

import java.net.DatagramSocket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Packets {

    ConcurrentLinkedQueue<byte[]> packets = new ConcurrentLinkedQueue<>();
    private DatagramSocket socket;
    private Receiver receiver = new Receiver(this, socket);
    private Handler handler = new Handler(this);

    public Packets(DatagramSocket socket) {
        this.socket = socket;

        new Thread(receiver).start();
    }

    public void Received() {
        handler.ReadPacket();
    }

    public void addPacket(byte[] data) {
        packets.add(data);
    }

    public byte[] getPacket() {
        return getPacket(true);
    }

    public byte[] getPacket(boolean remove) {
        if (packets.size() == 0) {
            return null;
        }
        return remove ? packets.poll() : packets.peek();
    }

}
