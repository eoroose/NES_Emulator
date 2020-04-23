package Emulator.Unsigned;

public class uint32_t extends Unsigned{

    public uint32_t(int num) {
        super(0xffffffff, num);
    }

    public uint32_t(Unsigned num) {
        super(0xffffffff, num.get());
    }
}
