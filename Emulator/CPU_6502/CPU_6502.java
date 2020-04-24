package Emulator.CPU_6502;

import Emulator.Bus.Bus;

import java.util.HashMap;
import java.util.Map;

import static Emulator.CPU_6502.FLAGS_6502.*;

public class CPU_6502 {

    private Bus bus = null;
    private final Instruction_6502 instructions;

    public int a = 0x00;       //accumulator register
    public int x = 0x00;       //x register
    public int y = 0x00;       //y register
    public int stkp = 0x00;    //stack pointer (points to location on bus)
    public int status = 0x00;  //status register
    public int pc = 0x0000;    //program counter

    private int fetched = 0x00;
    private int addr_abs = 0x0000;
    private int addr_rel = 0x0000;
    private int opcode = 0x00;
    private int cycles = 0;

    private int temp = 0x0000;
    private int clock_count = 0;

    public CPU_6502() {
        instructions = new Instruction_6502(this);
    }

    public void connectBus(Bus bus) {
        this.bus = bus;
    }

    private int read(int a) {
        return bus.read(a, false);
    }

    private void write(int a, int d) {
        bus.write(a, d);
    }

    //convenience functions to access status register
    private int getFlag(FLAGS_6502 f) {
        if((status & f.getOperation()) > 0) return 1;
        return 0;
    }

    private void setFlag(FLAGS_6502 f, boolean v) {
        if(v) status |= f.getOperation();
        else status &= ~f.getOperation();
    }

    public void clock() {
        if(cycles == 0) {
            opcode = read(pc);
            setFlag(U, true);
            pc++;

            //get starting number of cycles
            cycles = instructions.lookup[opcode].cycles();

            int additional_cycle1 = instructions.lookup[opcode].addrMode();
            int additional_cycle2 = instructions.lookup[opcode].operate();

            cycles += additional_cycle1 & additional_cycle2;
            setFlag(U, true);
        }
        clock_count++;
        cycles--;
    }

    public void reset() {
        addr_abs = 0xfffc;
        int lo = read((addr_abs + 0));
        int hi = (read((addr_abs + 1)));
        pc = (hi << 8) | lo;

        a = 0;
        x = 0;
        y = 0;
        stkp = 0xfd;
        status = 0x00 | U.getOperation();

        addr_rel = 0x0000;
        addr_abs = 0x0000;
        fetched = 0x00;
        cycles = 8;
    }

    public void irq() {
        if(getFlag(I) == 0) {
            write(0x0100 + stkp, (pc >> 8) & 0x00ff);
            stkp--;
            write(0x0100 + stkp, pc & 0x00ff);
            stkp--;

            setFlag(B, false);
            setFlag(U, true);
            setFlag(I, true);
            write(0x0100 + stkp, status);
            stkp--;

            addr_abs = 0xfffe;
            int lo = read(addr_abs + 0);
            int hi = read(addr_abs + 1);
            pc = (hi << 8) | lo;
            cycles = 7;
        }
    }

    public void nmi() {
        write(0x0100 + stkp, (pc >> 8) & 0x00ff);
        stkp--;
        write(0x0100 + stkp, pc & 0x00ff);
        stkp--;

        setFlag(B, false);
        setFlag(U, true);
        setFlag(I, true);
        write(0x0100 + stkp, status);
        stkp--;

        addr_abs = 0xfffa;
        int lo = read(addr_abs + 0);
        int hi = read(addr_abs + 1);
        pc = (hi << 8) | lo;
        cycles = 8;
    }

    public int fetch() {
        if(!(instructions.lookup[opcode].addrMode() == IMP()))
            fetched = read(addr_abs);
        return  fetched;
    }

    //12 Addressing modes
    int IMP() {    // address mode: implied
        fetched = a;
        return 0;
    }

    int IMM() {    // address mode: immediate
        addr_abs = pc++;
        return 0;
    }

    int ZP0() {    // address mode: zero page
        addr_abs = read(pc);
        pc++;
        addr_abs &= 0x00ff;
        return 0;
    }

    int ZPX() {    // address mode: zero page with x offset
        addr_abs = read(pc) + x;
        pc++;
        addr_abs &= 0x00ff;
        return 0;
    }

    int ZPY() {    // address mode: zero page with y offset
        addr_abs = read(pc) + y;
        pc++;
        addr_abs &= 0x00ff;
        return 0;
    }

    int REL() {    // address mode: relative
        addr_rel = read(pc);
        pc++;
        if((addr_rel & 0x80) != 0)
            addr_rel |= 0xff00;
        return 0;
    }

    int ABS() {    // address mode: absolute
        int lo = read(pc);
        pc++;
        int hi = read(pc);
        pc++;
        addr_abs = (hi << 8) | lo;
        return 0;
    }

    int ABX() {    // address mode: absolute with x offset
        int lo = read(pc);
        pc++;
        int hi = read(pc);
        pc++;
        addr_abs = (hi << 8) | lo;
        addr_abs += x;

        if((addr_abs & 0xff00) != (hi << 8))
            return 1;
        else
            return 0;
    }

    int ABY() {    // address mode: absolute with y offset
        int lo = read(pc);
        pc++;
        int hi = read(pc);
        pc++;
        addr_abs = (hi << 8) | lo;
        addr_abs += y;

        if((addr_abs & 0xff00) != (hi << 8))
            return 1;
        else
            return 0;
    }

    int IND() {    // address mode: indirect
        int ptr_lo = read(pc);
        pc++;
        int ptr_hi = read(pc);
        pc++;
        int ptr = (ptr_hi << 8) | ptr_lo;
        if(ptr_lo == 0x00ff)
            addr_abs = (read(ptr & 0xff00) << 8) | read(ptr + 0);
        else
            addr_abs = (read(ptr + 1) << 8) | read(ptr + 0);
        return 0;
    }

    int IZX() {    //address mode: indirect x
        int t = read(pc);
        pc++;
        int lo = read(t + x) & 0x00ff;
        int hi = read(t + x + 1) & 0x00ff;
        addr_abs = (hi << 8) | lo;
        return 0;
    }

    int IZY() {    //address mode: indirect y
        int t = read(pc);
        pc++;
        int lo = read(t & 0x00ff);
        int hi = read(t + 1) & 0x00ff;
        addr_abs = (hi << 8) | lo;
        addr_abs += y;

        if((addr_abs & 0xff00) != (hi << 8))
            return 1;
        else
            return 0;
    }

    //56 opcodes  + 1 illegal opcode (XXX)
    int ADC() {
        fetch();
        temp = a + fetched + getFlag(C);
        setFlag(C, temp > 255);
        setFlag(Z, (temp & 0x00ff) == 0);
        setFlag(V, (~(a ^ fetched) & (a ^ temp) & 0x0080) > 0);
        setFlag(N, (temp & 0x80) != 0);
        a = temp & 0x00ff;
        return 1;
    }

    int AND() {
        fetch();
        a &= fetched;
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 1;
    }

    int ASL() {
        fetch();
        temp = fetched << 1;
        setFlag(C, (temp & 0xff00) > 0);
        setFlag(Z, (temp & 0x00ff) == 0x00);
        setFlag(N, (temp & 0x80) != 0);
        if(instructions.lookup[opcode].addrMode() == IMP())
            a = temp & 0x00ff;
        else
            write(addr_abs, temp & 0x00ff);
        return 0;
    }

    int BCC() {
        if(getFlag(C) == 0) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BCS() {
        if(getFlag(C) == 1) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BEQ() {
        if(getFlag(Z) == 1) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BIT() {
        fetch();
        temp = a & fetched;
        setFlag(Z, (temp & 0x00ff) == 0x00);
        setFlag(N, (fetched & (1 << 7)) != 0);
        setFlag(V, (fetched & (1 << 6)) != 0);
        return 0;
    }

    int BMI() {
        if(getFlag(N) == 1) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BNE() {
        if(getFlag(Z) == 0) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BPL() {
        if(getFlag(N) == 0) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BRK() {
        pc++;
        setFlag(I, true);
        write(0x0100 + stkp, (pc >> 8) & 0x00ff);
        stkp--;
        write(0x0100 + stkp, pc & 0x00ff);
        stkp--;

        setFlag(B, true);
        write(0x0100 + stkp, status);
        stkp--;
        setFlag(B, false);

        pc =  read(0xfffe) | read(0xffff) << 8;
        return 0;
    }

    int BVC() {
        if(getFlag(V) == 0) {
            cycles++;
            addr_abs = pc + addr_rel;
            if( (addr_abs & 0xff00) != (pc & 0xff00) )
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int BVS() {
        if(getFlag(V) == 1) {
            cycles++;
            addr_abs = pc + addr_rel;
            if((addr_abs & 0xff00) != (pc & 0xff00))
                cycles++;
            pc = addr_abs;
        }
        return 0;
    }

    int CLC() {
        setFlag(C, false);
        return 0;
    }

    int CLD() {
        setFlag(D, false);
        return 0;
    }

    int CLI() {
        setFlag(I, false);
        return 0;
    }

    int CLV() {
        setFlag(V, false);
        return 0;
    }

    int CMP() {
        fetch();
        temp = a - fetched;
        setFlag(C, a >= fetched);
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        return 1;
    }

    int CPX() {
        fetch();
        temp = x - fetched;
        setFlag(C, x >= fetched);
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        return 0;
    }

    int CPY() {
        fetch();
        temp = y - fetched;
        setFlag(C, y >= fetched);
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        return 0;
    }

    int DEC() {
        fetch();
        temp = fetched - 1;
        write(addr_abs, (temp & 0x00ff));
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        return 0;
    }

    int DEX() {
        x--;
        setFlag(Z, x == 0x00);
        setFlag(N, (x & 0x80) != 0);
        return 0;
    }

    int DEY() {
        y--;
        setFlag(Z, y == 0x00);
        setFlag(N, (y & 0x80) != 0);
        return 0;
    }

    int EOR() {
        fetch();
        a ^= fetched;
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 1;
    }

    int INC() {
        fetch();
        temp = fetched + 1;
        write(addr_abs, (temp & 0x00ff));
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        return 0;
    }

    int INX() {
        x++;
        setFlag(Z, x == 0x00);
        setFlag(N, (x & 0x80) != 0);
        return 0;
    }

    int INY() {
        y++;
        setFlag(Z, y == 0x00);
        setFlag(N, (y & 0x80) != 0);
        return 0;
    }

    int JMP() {
        pc = addr_abs;
        return 0;
    }

    int JSR() {
        pc--;
        write(0x0100 + stkp, (pc >> 8) & 0x00ff);
        stkp--;
        write(0x0100 + stkp, pc & 0x00ff);
        stkp--;
        pc = addr_abs;
        return 0;
    }

    int LDA() {
        fetch();
        a = fetched;
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 1;
    }

    int LDX() {
        fetch();
        x = fetched;
        setFlag(Z, x == 0x00);
        setFlag(N, (x & 0x80) != 0);
        return 1;
    }

    int LDY() {
        fetch();
        y = fetched;
        setFlag(Z, y == 0x00);
        setFlag(N, (y & 0x80) != 0);
        return 1;
    }

    int LSR() {
        fetch();
        setFlag(C, (fetched & 0x0001) != 0);
        temp = fetched >> 1;
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        if(instructions.lookup[opcode].addrMode() == IMP())
            a = temp & 0x00ff;
        else
            write(addr_abs, temp & 0x00ff);
        return 0;
    }

    int NOP() {
        switch (opcode) {
            case 0x1c:
            case 0x3c:
            case 0x5c:
            case 0x7c:
            case 0xdc:
            case 0xfc:
                return 1;
        }
        return 0;
    }

    int ORA() {
        fetch();
        a |= fetched;
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 1;
    }

    int PHA() {
        write(0x0100 + stkp, a);
        stkp--;
        return 0;
    }

    int PHP() {
        write(0x0100 + stkp, status | B.getOperation() | U.getOperation());
        setFlag(B, false);
        setFlag(U, false);
        stkp--;
        return 0;
    }

    int PLA() {
        stkp++;
        a = read(0x0100 + stkp);
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 0;
    }

    int PLP() {
        stkp++;
        status = read(0x0100 + stkp);
        setFlag(U, true);
        return 0;
    }

    int ROL() {
        fetch();
        temp = (fetched << 1) | getFlag(C);
        setFlag(C, (temp & 0xff00) != 0);
        setFlag(Z, (temp & 0x00ff) == 0x0000);
        setFlag(N, (temp & 0x0080) != 0);
        if(instructions.lookup[opcode].addrMode() == IMP())
            a = temp & 0x00ff;
        else
            write(addr_abs, temp & 0x00ff);
        return 0;
    }

    int ROR() {
        fetch();
        temp = (getFlag(C) << 1) | (fetched >> 1);
        setFlag(C, (fetched & 0x01) != 0);
        setFlag(Z, (temp & 0x00ff) == 0x00);
        setFlag(N, (temp & 0x0080) != 0);
        if(instructions.lookup[opcode].addrMode() == IMP())
            a = temp & 0x00ff;
        else
            write(addr_abs, temp & 0x00ff);
        return 0;
    }

    int RTI() {
        stkp++;
        status = read(0x0100 + stkp);
        status &= ~B.getOperation();
        status &= ~U.getOperation();

        stkp++;
        pc = read(0x0100 + stkp);
        stkp++;
        pc |= read(0x0100 + stkp) << 8;
        return 0;
    }

    int RTS() {
        stkp++;
        pc = read(0x0100 + stkp);
        stkp++;
        pc |= read(0x0100 + stkp) << 8;
        pc++;
        return 0;
    }

    int SBC() {
        fetch();
        int value = fetched ^ 0x00ff;
        temp = a + value + getFlag(C);
        setFlag(C, (temp & 0xff00) != 0);
        setFlag(Z, (temp & 0x00ff) == 0);
        setFlag(V, ((temp ^ a) & (temp ^ value) & 0x0080) != 0);
        setFlag(N, (temp & 0x0080) != 0);
        a = temp & 0x00ff;
        return 1;
    }

    int SEC() {
        setFlag(C, true);
        return 0;
    }
    int SED() {
        setFlag(D, true);
        return 0;
    }

    int SEI() {
        setFlag(I, true);
        return 0;
    }

    int STA() {
        write(addr_abs, a);
        return 0;
    }

    int STX() {
        write(addr_abs, x);
        return 0;
    }

    int STY() {
        write(addr_abs, y);
        return 0;
    }

    int TAX() {
        x = a;
        setFlag(Z, x == 0x00);
        setFlag(N, (x & 0x80) != 0);
        return 0;
    }

    int TAY() {
        y = a;
        setFlag(Z, y == 0x00);
        setFlag(N, (y & 0x80) != 0);
        return 0;
    }

    int TSX() {
        x = stkp;
        setFlag(Z, x == 0x00);
        setFlag(N, (x & 0x80) != 0);
        return 0;
    }

    int TXA() {
        a = x;
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 0;
    }

    int TXS() {
        stkp = x;
        return 0;
    }

    int TYA() {
        a = y;
        setFlag(Z, a == 0x00);
        setFlag(N, (a & 0x80) != 0);
        return 0;
    }

    int XXX() {
        return 0;
    }

    //helper functions
    public boolean complete() {
        return cycles == 0;
    }


    public String hex(int n) {
        return Integer.toHexString(n);
    }

    public Map<Integer, String> disassemble(int nStart, int nStop) {
        int addr = nStart;
        int value = 0x00;
        int lo = 0x00;
        int hi = 0x00;
        Map<Integer, String> mapLines = new HashMap<Integer, String>();
        int line_addr = 0;

        while(addr <= nStop) {
            line_addr = addr;
            String sInst = "$" + hex(addr) + ": ";
            int opcode = bus.read(addr, true);
            addr++;
            sInst += instructions.lookup[opcode].name() + " ";

            if(instructions.lookup[opcode].addrMode() == IMP()) {
                sInst += " {IMP}";
            }
            else if(instructions.lookup[opcode].addrMode() == IMM()) {
                value = bus.read(addr, true);
                addr++;
                sInst += "$" + hex(value) + " {IMM}";
            }
            else if(instructions.lookup[opcode].addrMode() == ZP0()) {
                lo = bus.read(addr, true);
                addr++;
                hi = 0x00;
                sInst += "$" + hex(lo) + " {ZP0}";
            }
            else if(instructions.lookup[opcode].addrMode() == ZPX()) {
                lo = bus.read(addr, true);
                addr++;
                hi = 0x00;
                sInst += "$" + hex(lo) + ", X {ZPX}";
            }
            else if(instructions.lookup[opcode].addrMode() == ZPY()) {
                lo = bus.read(addr, true);
                addr++;
                hi = 0x00;
                sInst += "$" + hex(lo) + ", Y {ZPY}";
            }
            else if(instructions.lookup[opcode].addrMode() == IZX()) {
                lo = bus.read(addr, true);
                addr++;
                hi = 0x00;
                sInst += "($" + hex(lo) + ",X) {IZX}";
            }
            else if(instructions.lookup[opcode].addrMode() == IZY()) {
                lo = bus.read(addr, true);
                addr++;
                hi = 0x00;
                sInst += "($" + hex(lo) + ",Y) {IZY}";
            }
            else if(instructions.lookup[opcode].addrMode() == ABS()) {
                lo = bus.read(addr, true);
                addr++;
                hi = bus.read(addr, true);
                addr++;
                sInst += "$" + hex((hi << 8) | lo) + " {ABS}";
            }
            else if(instructions.lookup[opcode].addrMode() == ABX()) {
                lo = bus.read(addr, true);
                addr++;
                hi = bus.read(addr, true);
                addr++;
                sInst += "$" + hex((hi << 8) | lo) + ", X {ABX}";
            }
            else if(instructions.lookup[opcode].addrMode() == ABY()) {
                lo = bus.read(addr, true);
                addr++;
                hi = bus.read(addr, true);
                addr++;
                sInst += "$" + hex((hi << 8) | lo) + ", Y {ABY}";
            }
            else if(instructions.lookup[opcode].addrMode() == IND()) {
                lo = bus.read(addr, true);
                addr++;
                hi = bus.read(addr, true);
                addr++;
                sInst += "($" + hex((hi << 8) | lo) + ") {IND}";
            }
            else if(instructions.lookup[opcode].addrMode() == REL()) {
                value = bus.read(addr, true);
                addr++;
                sInst += "$" + hex(value) + " [$" + hex(addr + value) + "] {REL}";
            }
            mapLines.put(line_addr, sInst);
        }
        return  mapLines;
    }
}
