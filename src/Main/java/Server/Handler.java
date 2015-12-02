package Server;

import Utils.Log;
import Utils.LogLevel;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Handler {

    private Packets packets;

    private ArrayList<Player> clients = new ArrayList<>();

    private byte idCount;

    public Handler(Packets packets) {
        this.packets = packets;
    }

    public void ReadPacket() {
        DatagramPacket nPack = packets.getPacket();
        ByteBuffer buffer = ByteBuffer.wrap(nPack.getData());

        byte id = buffer.get();

        switch (id) {

            //New client
            case 0:
                byte character = buffer.get();
                Log.log("New client connected", LogLevel.INFO);

                //byte[] n = new byte[1000];
                //System.out.println("1: " + buffer.position() + " 2: " + buffer.remaining());
                //buffer.get(n, buffer.position()-1, buffer.remaining());
                //String name = new String(n);

                //System.out.println("NAME: " + name + " CHAR: " + character);

                clients.add(new Player(character, idCount));

                ByteBuffer bb = ByteBuffer.allocate(1);
                bb.put(idCount);
                bb.flip();
                byte[] sendBuf = new byte[bb.remaining()];
                bb.get(sendBuf);

                DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, nPack.getAddress(), nPack.getPort());
                try {
                    packets.socket.send(packet);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                idCount++;
                break;

            //Update
            case 1:
                byte pid = buffer.get();
                Log.log("Update", LogLevel.INFO);

                Player tmp;
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).getID() == pid) {
                        tmp = clients.get(i);

                        tmp.setX(buffer.getShort());
                        tmp.setY(buffer.getShort());
                        break;
                    }
                }

                System.out.println(clients.get(0).getX());
                System.out.println(clients.get(0).getY());
                break;
        }
    }
}
