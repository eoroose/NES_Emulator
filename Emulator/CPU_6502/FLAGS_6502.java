package Emulator.CPU_6502;

public enum FLAGS_6502 {
    C(1<<0),  // carry bit
    Z(1<<1),  // zero
    I(1<<2),  // disable interrupts
    D(1<<3),  // decimal mode
    B(1<<4),  // break
    U(1<<5),  // unused
    V(1<<6),  // overflow
    N(1<<7);  // negative

    private final int operation;

    FLAGS_6502(int operation) {
        this.operation = operation;
    }

    public int getOperation() {
        return this.operation;
    }

}
