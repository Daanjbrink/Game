package Server;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Handler {

    private Packets packets;

    private ArrayList<Player> clients = new ArrayList<>();

    public Handler(Packets packets) {
        this.packets = packets;
    }

    public void ReadPacket() {
        ByteBuffer buffer = ByteBuffer.wrap(packets.getPacket());

        byte id = buffer.get();

        switch (id) {
            case 0:
                byte character = buffer.get();

                byte[] n = new byte[buffer.remaining()];
                buffer.get(n, buffer.position(), buffer.remaining());
                String name = new String(n);

                clients.add(new Player(name, character));
                break;
        }
    }
}
