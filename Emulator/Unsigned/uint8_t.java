package Emulator.Unsigned;

public class uint8_t extends Unsigned {

    public uint8_t(int num) {
        super(0xff, num);
    }

    public uint8_t(Unsigned num) {
        super(0xff, num.get());
    }
}