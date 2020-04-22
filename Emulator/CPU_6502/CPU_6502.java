package Emulator.CPU_6502;

import Emulator.Bus.Bus;
import Emulator.Unsigned.*;
import static Emulator.CPU_6502.FLAGS_6502.*;

public class CPU_6502 {

    private Bus bus = null;
    private final Instruction_6502 instructions;

    public uint8_t a = new uint8_t(0x00);       //accumulator register
    public uint8_t x = new uint8_t(0x00);       //x register
    public uint8_t y = new uint8_t(0x00);       //y register
    public uint8_t stkp = new uint8_t(0x00);    //stack pointer (points to location on bus)
    public uint8_t status = new uint8_t(0x00);  //status register
    public uint16_t pc = new uint16_t(0x00);    //program counter

    public uint8_t fetched = new uint8_t(0x00);
    public uint16_t addr_abs = new uint16_t(0x0000);
    public uint16_t addr_rel = new uint16_t(0x0000);
    public uint8_t opcode = new uint8_t(0x00);
    public uint8_t cycles = new uint8_t(0x00);

    public CPU_6502() {
        instructions = new Instruction_6502(this);
    }

    public void connectBus(Bus bus) {
        this.bus = bus;
    }

    private uint8_t read(uint16_t a) {
        return bus.read(a, false);
    }

    private void write(uint16_t a, uint8_t d) {
        bus.write(a, d);
    }

    //convenience functions to access status register
    private uint8_t getFlag(FLAGS_6502 f) {
        if((status.get() & f.getOperation().get()) > 0) return new uint8_t(1);
        return new uint8_t(0);
    }

    private void setFlag(FLAGS_6502 f, boolean v) {
        if(v) status.set(status.get() | f.getOperation().get());
        else status.set(status.get() & ~f.getOperation().get());
    }

    public void clock() {}

    public void reset() {}

    public void irq() {}

    public void nmi() {}

    public uint8_t fetch() {
        if(!( instructions.lookup[opcode.get()].addrMode().get() == IMP().get() ))
            fetched = read(addr_abs);
        return  fetched;
    }

    //12 Addressing modes
    uint8_t IMP() {    // address mode: implied
        fetched.set(a);
        return new uint8_t(0);
    }

    uint8_t IMM() {    // address mode: immediate
        addr_abs.set(pc);
        pc.INCREMENT(1);
        return new uint8_t(0);
    }

    uint8_t ZP0() {    // address mode: zero page
        addr_abs.set(read(pc));
        pc.INCREMENT(1);
        addr_abs.AND_EQUALS(0x00ff);
        return new uint8_t(0);
    }

    uint8_t ZPX() {    // address mode: zero page with x offset
        addr_abs.set(Unsigned.ADD(read(pc), x));
        pc.INCREMENT(1);
        addr_abs.AND_EQUALS(0x00ff);
        return new uint8_t(0);
    }

    uint8_t ZPY() {    // address mode: zero page with y offset
        addr_abs.set(Unsigned.ADD(read(pc), y));
        pc.INCREMENT(1);
        addr_abs.AND_EQUALS(0x00ff);
        return new uint8_t(0);
    }

    uint8_t REL() {    // address mode: relative
        addr_rel.set(read(pc));
        pc.INCREMENT(1);
        if((addr_rel.get() & 0x80) > 0)
            addr_rel.OR_EQUALS(0xff00);
        return new uint8_t(0);
    }

    uint8_t ABS() {    // address mode: absolute
        uint16_t lo = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t hi = new uint16_t(read(pc));
        pc.INCREMENT(1);
        addr_abs.set((hi.get() << 8) | lo.get());
        return new uint8_t(0);
    }

    uint8_t ABX() {    // address mode: absolute with x offset
        uint16_t lo = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t hi = new uint16_t(read(pc));
        pc.INCREMENT(1);
        addr_abs.set((hi.get() << 8) | lo.get());
        addr_abs.INCREMENT(x.get());

        if( (addr_abs.get() & 0xff00) != (hi.get() << 8))
            return new uint8_t(1);
        else
            return new uint8_t(0);
    }

    uint8_t ABY() {    // address mode: absolute with y offset
        uint16_t lo = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t hi = new uint16_t(read(pc));
        pc.INCREMENT(1);
        addr_abs.set((hi.get() << 8) | lo.get());
        addr_abs.INCREMENT(y.get());

        if( (addr_abs.get() & 0xff00) != (hi.get() << 8))
            return new uint8_t(1);
        else
            return new uint8_t(0);
    }

    uint8_t IND() {    // address mode: indirect
        uint16_t ptr_lo = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t ptr_hi = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t ptr = new uint16_t((ptr_hi.get() << 8) | ptr_lo.get());
        if(ptr_lo.get() == 0x00ff)
            addr_abs.set(
                    (read(new uint16_t(ptr.get() & 0xff00)).get() << 8) |
                    read(new uint16_t(ptr)).get());
        else
            addr_abs.set(
                    (read(new uint16_t(ptr.get() + 1)).get() << 8) |
                            read(new uint16_t(ptr)).get());
        return new uint8_t(0);
    }

    uint8_t IZX() {    //address mode: indirect x
        uint16_t t = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t lo = new uint16_t(read(new uint16_t(
                (t.get() + x.get()) & 0x00ff)));
        uint16_t hi = new uint16_t(read(new uint16_t(
                (t.get() + x.get() + 1) & 0x00ff)));
        addr_abs.set((hi.get() << 8) | lo.get());
        return new uint8_t(0);
    }

    uint8_t IZY() {    //address mode: indirect y
        uint16_t t = new uint16_t(read(pc));
        pc.INCREMENT(1);
        uint16_t lo = new uint16_t(read(new uint16_t(
                t.get() & 0x00ff)));
        uint16_t hi = new uint16_t(read(new uint16_t(
                (t.get() + 1) & 0x00ff)));
        addr_abs.set((hi.get() << 8) | lo.get());
        addr_abs.INCREMENT(y.get());

        if( (addr_abs.get() & 0xff00) != (hi.get() << 8) )
            return new uint8_t(1);
        else
            return new uint8_t(0);
    }

    //56 opcodes  + 1 illegal opcode (XXX)
    uint8_t ADC() {
        fetch();
        uint16_t temp = new uint16_t(Unsigned.ADD(a, fetched, getFlag(C)));
        setFlag(C, temp.get() > 255);
        setFlag(Z, (temp.get() & 0x00ff) == 0);
        setFlag(V, (~(a.get() ^ fetched.get()) & (a.get() ^ temp.get()) & 0x0080) > 0);
        setFlag(N, (temp.get() & 0x80) > 0);
        a.set(temp.get() & 0x00ff);
        return new uint8_t(1);
    }

    uint8_t AND() {
        fetch();
        a.AND_EQUALS(fetched.get());
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(1);
    }

    uint8_t ASL() {
        fetch();
        uint16_t temp = new uint16_t(fetched.get() << 1);
        setFlag(C, (temp.get() & 0xff00) > 0);
        setFlag(Z, (temp.get() & 0x00ff) == 0x00);
        setFlag(N, (temp.get() & 0x80) > 0);
        if(instructions.lookup[opcode.get()].addrMode().get() == IMP().get())
            a.set(temp.get() & 0x00ff);
        else
            write(addr_abs, new uint8_t(temp.get() & 0x00ff));
        return new uint8_t(0);
    }

    uint8_t BCC() {
        if(getFlag(C).get() == 0) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BCS() {
        if(getFlag(C).get() == 1) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BEQ() {
        if(getFlag(Z).get() == 1) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BIT() {
        fetch();
        uint16_t temp = new uint16_t(a.get() & fetch().get());
        setFlag(Z, (temp.get() & 0x00ff) == 0x00);
        setFlag(N, (fetched.get() & (1 << 7)) > 0);
        setFlag(V, (fetched.get() & (1 << 6)) > 0);
        return new uint8_t(0);
    }

    uint8_t BMI() {
        if(getFlag(N).get() == 1) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BNE() {
        if(getFlag(Z).get() == 0) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BPL() {
        if(getFlag(N).get() == 0) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BRK() {
        pc.INCREMENT(1);
        setFlag(I, true);
        write(new uint16_t(0x0100 + stkp.get()), new uint8_t((pc.get() >> 8) & 0x00ff));
        stkp.DECREMENT(1);
        write(new uint16_t(0x0100 + stkp.get()), new uint8_t(pc.get() & 0x00ff));
        stkp.DECREMENT(1);

        setFlag(B, true);
        write(new uint16_t(0x0100 + stkp.get()), status);
        stkp.DECREMENT(1);
        setFlag(B, false);

        pc.set( (read(new uint16_t(0xfffe))).get() | read(new uint16_t(0xffff)).get() << 8 );
        return new uint8_t(0);
    }

    uint8_t BVC() {
        if(getFlag(V).get() == 0) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t BVS() {
        if(getFlag(V).get() == 1) {
            cycles.INCREMENT(1);
            addr_abs.set(Unsigned.ADD(pc, addr_rel));
            if( (addr_abs.get() & 0xff00) != (pc.get() & 0xff00) )
                cycles.INCREMENT(1);
            pc.set(addr_abs);
        }
        return new uint8_t(0);
    }

    uint8_t CLC() {
        setFlag(C, false);
        return new uint8_t(0);
    }

    uint8_t CLD() {
        setFlag(D, false);
        return new uint8_t(0);
    }

    uint8_t CLI() {
        setFlag(I, false);
        return new uint8_t(0);
    }

    uint8_t CLV() {
        setFlag(V, false);
        return new uint8_t(0);
    }

    uint8_t CMP() {
        fetch();
        uint16_t temp = new uint16_t(Unsigned.SUBTRACT(a, fetched));
        setFlag(C, a.get() >= fetched.get());
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        return new uint8_t(1);
    }

    uint8_t CPX() {
        fetch();
        uint16_t temp = new uint16_t(Unsigned.SUBTRACT(x, fetched));
        setFlag(C, x.get() >= fetched.get());
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        return new uint8_t(0);
    }

    uint8_t CPY() {
        fetch();
        uint16_t temp = new uint16_t(Unsigned.SUBTRACT(y, fetched));
        setFlag(C, y.get() >= fetched.get());
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        return new uint8_t(0);
    }

    uint8_t DEC() {
        fetch();
        uint16_t temp = new uint16_t(fetched.get() - 1);
        write(addr_abs, new uint8_t(temp.get() & 0x00ff));
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        return new uint8_t(0);
    }

    uint8_t DEX() {
        x.DECREMENT(1);
        setFlag(Z, x.get() == 0x00);
        setFlag(N, (x.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t DEY() {
        y.DECREMENT(1);
        setFlag(Z, y.get() == 0x00);
        setFlag(N, (y.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t EOR() {
        fetch();
        a.XOR_EQUALS(fetched.get());
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t INC() {
        fetch();
        uint16_t temp = new uint16_t(fetched.get() + 1);
        write(addr_abs, new uint8_t(temp.get() & 0x00ff));
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        return new uint8_t(0);
    }

    uint8_t INX() {
        x.INCREMENT(1);
        setFlag(Z, x.get() == 0x00);
        setFlag(N, (x.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t INY() {
        y.INCREMENT(1);
        setFlag(Z, y.get() == 0x00);
        setFlag(N, (y.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t JMP() {
        pc.set(addr_abs);
        return new uint8_t(0);
    }

    uint8_t JSR() {
        pc.DECREMENT(1);
        write(new uint16_t(0x0100 + stkp.get()), new uint8_t((pc.get() >> 8) & 0x00ff));
        stkp.DECREMENT(1);
        write(new uint16_t(0x0100 + stkp.get()), new uint8_t(pc.get() & 0x00ff));
        stkp.DECREMENT(1);
        pc.set(addr_abs);
        return new uint8_t(0);
    }

    uint8_t LDA() {
        fetch();
        a.set(fetched);
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(1);
    }

    uint8_t LDX() {
        fetch();
        x.set(fetched);
        setFlag(Z, x.get() == 0x00);
        setFlag(N, (x.get() & 0x80) > 0);
        return new uint8_t(1);
    }

    uint8_t LDY() {
        fetch();
        y.set(fetched);
        setFlag(Z, y.get() == 0x00);
        setFlag(N, (y.get() & 0x80) > 0);
        return new uint8_t(1);
    }

    uint8_t LSR() {
        fetch();
        setFlag(C, (fetched.get() & 0x0001) > 0);
        uint16_t temp = new uint16_t(fetched.get() >> 1);
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        if(instructions.lookup[opcode.get()].addrMode().get() == IMP().get())
            a.set(temp.get() & 0x00ff);
        else
            write(addr_abs, new uint8_t(temp.get() & 0x00ff));
        return new uint8_t(0);
    }

    uint8_t NOP() {
        switch (opcode.get()) {
            case 0x1c:
            case 0x3c:
            case 0x5c:
            case 0x7c:
            case 0xdc:
            case 0xfc:
                return new uint8_t(1);
        }
        return new uint8_t(0);
    }

    uint8_t ORA() {
        fetch();
        a.OR_EQUALS(fetched.get());
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(1);
    }

    uint8_t PHA() {
        write(new uint16_t(0x0100 + stkp.get()), a);
        stkp.DECREMENT(1);
        return new uint8_t(0);
    }

    uint8_t PHP() {
        write(new uint16_t(0x0100 + stkp.get()),
              new uint8_t(status.get() | B.getOperation().get() | U.getOperation().get()));
        setFlag(B, false);
        setFlag(U, false);
        stkp.DECREMENT(1);
        return new uint8_t(0);
    }

    uint8_t PLA() {
        stkp.INCREMENT(1);
        a.set(read(new uint16_t(0x0100 + stkp.get())));
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t PLP() {
        stkp.INCREMENT(1);
        status.set(read(new uint16_t(0x0100 + stkp.get())));
        setFlag(U, true);
        return new uint8_t(0);
    }

    uint8_t ROL() {
        fetch();
        uint16_t temp = new uint16_t((fetched.get() << 1) | getFlag(C).get());
        setFlag(C, (temp.get() & 0xff00) > 0);
        setFlag(Z, (temp.get() & 0x00ff) == 0x0000);
        setFlag(N, (temp.get() & 0x0080) > 0);
        if(instructions.lookup[opcode.get()].addrMode().get() == IMP().get())
            a.set(temp.get() & 0x00ff);
        else
            write(addr_abs, new uint8_t(temp.get() & 0x00ff));
        return new uint8_t(0);
    }

    uint8_t ROR() {
        fetch();
        uint16_t temp = new uint16_t((getFlag(C).get() << 1) | (fetched.get() >> 1));
        setFlag(C, (fetched.get() & 0x01) > 0);
        setFlag(Z, (temp.get() & 0x00ff) == 0x00);
        setFlag(N, (temp.get() & 0x0080) > 0);
        if(instructions.lookup[opcode.get()].addrMode().get() == IMP().get())
            a.set(temp.get() & 0x00ff);
        else
            write(addr_abs, new uint8_t(temp.get() & 0x00ff));
        return new uint8_t(0);
    }

    uint8_t RTI() {
        stkp.INCREMENT(1);
        status.set(read(new uint16_t(0x0100 + stkp.get())));
        status.AND_EQUALS(~B.getOperation().get());
        status.AND_EQUALS(~U.getOperation().get());

        stkp.INCREMENT(1);
        pc.set(read(new uint16_t(0x0100 + stkp.get())));
        stkp.INCREMENT(1);
        pc.OR_EQUALS(read(new uint16_t(0x0100 + stkp.get())).get() << 8);
        return new uint8_t(0);
    }

    uint8_t RTS() {
        stkp.INCREMENT(1);
        pc.set(read(new uint16_t(0x0100 + stkp.get())));
        stkp.INCREMENT(1);
        pc.OR_EQUALS(read(new uint16_t(0x0100 + stkp.get())).get() << 8);
        return new uint8_t(0);
    }

    uint8_t SBC() {
        fetch();
        uint16_t value = new uint16_t(fetched.get() ^ 0x00ff);
        uint16_t temp = new uint16_t(Unsigned.ADD(a, value, getFlag(C)));
        setFlag(C, (temp.get() & 0xff00) > 0);
        setFlag(Z, (temp.get() & 0x00ff) == 0);
        setFlag(V, ((temp.get() ^ a.get()) & (temp.get() ^ value.get()) & 0x0080) > 0);
        setFlag(N, (temp.get() & 0x0080) > 0);
        a.set(temp.get() & 0x00ff);
        return new uint8_t(1);
    }

    uint8_t SEC() {
        setFlag(C, true);
        return new uint8_t(0);
    }
    uint8_t SED() {
        setFlag(D, true);
        return new uint8_t(0);
    }

    uint8_t SEI() {
        setFlag(I, true);
        return new uint8_t(0);
    }

    uint8_t STA() {
        write(addr_abs, a);
        return new uint8_t(0);
    }

    uint8_t STX() {
        write(addr_abs, x);
        return new uint8_t(0);
    }

    uint8_t STY() {
        write(addr_abs, y);
        return new uint8_t(0);
    }

    uint8_t TAX() {
        x.set(a);
        setFlag(Z, x.get() == 0x00);
        setFlag(N, (x.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t TAY() {
        y.set(a);
        setFlag(Z, y.get() == 0x00);
        setFlag(N, (y.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t TSX() {
        x.set(stkp);
        setFlag(Z, x.get() == 0x00);
        setFlag(N, (x.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t TXA() {
        a.set(x);
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t TXS() {
        stkp.set(x);
        return new uint8_t(0);
    }

    uint8_t TYA() {
        a.set(y);
        setFlag(Z, a.get() == 0x00);
        setFlag(N, (a.get() & 0x80) > 0);
        return new uint8_t(0);
    }

    uint8_t XXX() {
        return new uint8_t(0);
    }
}
