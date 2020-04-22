package Emulator.Bus;

import Emulator.CPU_6502.CPU_6502;
import Emulator.Unsigned.*;

import java.util.Arrays;

public class Bus {

    //devices on bus
    public CPU_6502 cpu;
    public uint8_t[] ram = new uint8_t[64 * 1024];

    public Bus() {
        Arrays.fill(ram, new uint8_t(0x00));
        cpu.connectBus(this);
    }

    //bus read and write
    public void write(uint16_t addr, uint8_t data) {
        if(addr.get() >= 0x0000 && addr.get() <= 0xffff)
            ram[addr.get()].set(data.get());
    }

    public uint8_t read(uint16_t addr, boolean bReadOnly) {
        if(addr.get() >= 0x0000 && addr.get() <= 0xffff)
            return ram[addr.get()];
        return new uint8_t(0x00);
    }

    public uint8_t read(uint16_t addr) {
        return read(addr, false);
    }



}
