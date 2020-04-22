package Emulator.Unsigned;

public class uint16_t extends Unsigned{

    public uint16_t(int num) {
        super(0xffff, num);
    }

    public uint16_t(Unsigned num) {
        super(0xffff, num.get());
    }
}
