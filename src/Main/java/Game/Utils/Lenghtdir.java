package Game.Utils;

public class Lenghtdir {

    public static double Lenghtdir_x(int length, double angle) {
        return (length * Math.cos(Math.toRadians(angle)));
    }

    public static double Lenghtdir_y(int length, double angle) {
        return (-length * Math.sin(Math.toRadians(angle)));
    }

}
