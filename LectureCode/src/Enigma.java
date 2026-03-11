class Unknown {
    private static int stat;
    private int x; // 10

    public Unknown(int start) {
        stat = start;
        x = start;
    }

    public void boost() {
        stat++;
        x++;
    }

    public int getX() {
        return x;
    }

    public int getStat() {
        return stat;
    }

}

public class Enigma {
    private int y;
    private Unknown u1;
    private Unknown u2;

    public Enigma(int y) {
        this.y = y;
        u1 = new Unknown(10);
        u2 = new Unknown(20);
    }

    public void boost() {
        u1.boost();
        u2.boost();
        y++;
    }

    public int getY() {
        return y;
    }

    public int getUnknown() {
        return u1.getX() + u1.getStat() + u2.getStat() + u2.getX();
    }

    public static void main() {
        Enigma e = new Enigma(5);
        System.out.println(e.getY());
        System.out.println(e.getUnknown());
        e.boost();
        System.out.println(e.getY());
        System.out.println(e.getUnknown()); // 11 + 22 + 22 + 21   =>  76
    }


}