package Emulator.Unsigned;

public abstract class Unsigned {

    private final int max;
    private int num;

    public Unsigned(int max, int num) {
        this.max = max;
        this.num = num;
        check();
    }

    private void check() {
        if (num < 0) num = 0;
        if (num > max) num = max;
    }

    public int get() {
        return num;
    }

    public void set(int value) {
        this.num = value;
        check();
    }

    public void set(Unsigned value) {
        this.num = value.get();
        check();
    }

    public void INCREMENT(int value) {
        num += value;
        check();
    }

    public void DECREMENT(int value) {
        num -= value;
        check();
    }

    public void AND_EQUALS(int value) {
        num &= value;
        check();
    }

    public void OR_EQUALS(int value) {
        num |= value;
        check();
    }

    public  void XOR_EQUALS(int value) {
        num ^= value;
        check();
    }

    public static int ADD(Unsigned... a) {
        int value = a[0].get();
        for(int x = 1; x < a.length; x++)
            value += a[x].get();
        return value;
    }

    public static int SUBTRACT(Unsigned... a) {
        int value = a[0].get();
        for(int x = 1; x < a.length; x++)
            value -= a[x].get();
        return value;
    }

}
