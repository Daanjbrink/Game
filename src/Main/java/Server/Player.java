package Server;

public class Player {

    //private String name;

    private short x, y;
    private short angle;

    private byte character, pid;

    public Player(byte character, byte pid) {
        //this.name = name;
        this.character = character;
        this.pid = pid;
    }

    public short getX() {
        return this.x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return this.y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public byte getID() {
        return pid;
    }

}
