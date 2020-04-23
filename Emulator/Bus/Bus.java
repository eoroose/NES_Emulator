package Emulator.Bus;

import Emulator.CPU_6502.CPU_6502;

import java.util.Arrays;

public class Bus {

    //devices on bus
    public CPU_6502 cpu = new CPU_6502();
    public int[] ram = new int[64 * 1024];

    public Bus() {
        Arrays.fill(ram,0x00);
        cpu.connectBus(this);
    }

    //bus read and write
    public void write(int addr, int data) {
        if(addr >= 0x0000 && addr <= 0xffff)
            ram[addr] = data;
    }

    public int read(int addr, boolean bReadOnly) {
        if(addr >= 0x0000 && addr <= 0xffff)
            return ram[addr];
        return 0x00;
    }

    public int read(int addr) {
        return read(addr, false);
    }



}
