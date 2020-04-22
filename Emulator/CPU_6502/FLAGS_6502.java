package Emulator.CPU_6502;

import Emulator.Unsigned.uint8_t;

public enum FLAGS_6502 {
    C(new uint8_t(1<<0)),  // carry bit
    Z(new uint8_t(1<<1)),  // zero
    I(new uint8_t(1<<2)),  // disable interrupts
    D(new uint8_t(1<<3)),  // decimal mode
    B(new uint8_t(1<<4)),  // break
    U(new uint8_t(1<<5)),  // unused
    V(new uint8_t(1<<6)),  // overflow
    N(new uint8_t(1<<7));  // negative

    private final uint8_t operation;

    FLAGS_6502(uint8_t operation) {
        this.operation = operation;
    }

    public uint8_t getOperation() {
        return this.operation;
    }

}
