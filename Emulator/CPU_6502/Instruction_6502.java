package Emulator.CPU_6502;

import Emulator.Unsigned.*;

public class Instruction_6502 {

    public interface Instruction {
        String name();
        uint8_t operate();
        uint8_t addrMode();
        uint8_t cycles();
    }

    public final Instruction[] lookup;

    public Instruction_6502(CPU_6502 cpu) {

        lookup = new Instruction[] {
                new Instruction() {		//0
                    @Override public String name() {return "BRK";}
                    @Override public uint8_t operate() {return cpu.BRK();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//1
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//2
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//3
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//4
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//5
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//6
                    @Override public String name() {return "ASL";}
                    @Override public uint8_t operate() {return cpu.ASL();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//7
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//8
                    @Override public String name() {return "PHP";}
                    @Override public uint8_t operate() {return cpu.PHP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//9
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//10
                    @Override public String name() {return "ASL";}
                    @Override public uint8_t operate() {return cpu.ASL();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//11
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//12
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//13
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//14
                    @Override public String name() {return "ASL";}
                    @Override public uint8_t operate() {return cpu.ASL();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//15
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//16
                    @Override public String name() {return "BPL";}
                    @Override public uint8_t operate() {return cpu.BPL();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//17
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//18
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//19
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//20
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//21
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//22
                    @Override public String name() {return "ASL";}
                    @Override public uint8_t operate() {return cpu.ASL();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//23
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//24
                    @Override public String name() {return "CLC";}
                    @Override public uint8_t operate() {return cpu.CLC();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//25
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//26
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//27
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//28
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//29
                    @Override public String name() {return "ORA";}
                    @Override public uint8_t operate() {return cpu.ORA();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//30
                    @Override public String name() {return "ASL";}
                    @Override public uint8_t operate() {return cpu.ASL();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//31
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//32
                    @Override public String name() {return "JSR";}
                    @Override public uint8_t operate() {return cpu.JSR();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//33
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//34
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//35
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//36
                    @Override public String name() {return "BIT";}
                    @Override public uint8_t operate() {return cpu.BIT();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//37
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//38
                    @Override public String name() {return "ROL";}
                    @Override public uint8_t operate() {return cpu.ROL();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//39
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//40
                    @Override public String name() {return "PLP";}
                    @Override public uint8_t operate() {return cpu.PLP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//41
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//42
                    @Override public String name() {return "ROL";}
                    @Override public uint8_t operate() {return cpu.ROL();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//43
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//44
                    @Override public String name() {return "BIT";}
                    @Override public uint8_t operate() {return cpu.BIT();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//45
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//46
                    @Override public String name() {return "ROL";}
                    @Override public uint8_t operate() {return cpu.ROL();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//47
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//48
                    @Override public String name() {return "BMI";}
                    @Override public uint8_t operate() {return cpu.BMI();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//49
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//50
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//51
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//52
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//53
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//54
                    @Override public String name() {return "ROL";}
                    @Override public uint8_t operate() {return cpu.ROL();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//55
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//56
                    @Override public String name() {return "SEC";}
                    @Override public uint8_t operate() {return cpu.SEC();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//57
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//58
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//59
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//60
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//61
                    @Override public String name() {return "AND";}
                    @Override public uint8_t operate() {return cpu.AND();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//62
                    @Override public String name() {return "ROL";}
                    @Override public uint8_t operate() {return cpu.ROL();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//63
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//64
                    @Override public String name() {return "RTI";}
                    @Override public uint8_t operate() {return cpu.RTI();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//65
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//66
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//67
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//68
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//69
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//70
                    @Override public String name() {return "LSR";}
                    @Override public uint8_t operate() {return cpu.LSR();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//71
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//72
                    @Override public String name() {return "PHA";}
                    @Override public uint8_t operate() {return cpu.PHA();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//73
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//74
                    @Override public String name() {return "LSR";}
                    @Override public uint8_t operate() {return cpu.LSR();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//75
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//76
                    @Override public String name() {return "JMP";}
                    @Override public uint8_t operate() {return cpu.JMP();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//77
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//78
                    @Override public String name() {return "LSR";}
                    @Override public uint8_t operate() {return cpu.LSR();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//79
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//80
                    @Override public String name() {return "BVC";}
                    @Override public uint8_t operate() {return cpu.BVC();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//81
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//82
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//83
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//84
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//85
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//86
                    @Override public String name() {return "LSR";}
                    @Override public uint8_t operate() {return cpu.LSR();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//87
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//88
                    @Override public String name() {return "CLI";}
                    @Override public uint8_t operate() {return cpu.CLI();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//89
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//90
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//91
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//92
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//93
                    @Override public String name() {return "EOR";}
                    @Override public uint8_t operate() {return cpu.EOR();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//94
                    @Override public String name() {return "LSR";}
                    @Override public uint8_t operate() {return cpu.LSR();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//95
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//96
                    @Override public String name() {return "RTS";}
                    @Override public uint8_t operate() {return cpu.RTS();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//97
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//98
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//99
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//100
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//101
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//102
                    @Override public String name() {return "ROR";}
                    @Override public uint8_t operate() {return cpu.ROR();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//103
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//104
                    @Override public String name() {return "PLA";}
                    @Override public uint8_t operate() {return cpu.PLA();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//105
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//106
                    @Override public String name() {return "ROR";}
                    @Override public uint8_t operate() {return cpu.ROR();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//107
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//108
                    @Override public String name() {return "JMP";}
                    @Override public uint8_t operate() {return cpu.JMP();}
                    @Override public uint8_t addrMode() {return cpu.IND();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//109
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//110
                    @Override public String name() {return "ROR";}
                    @Override public uint8_t operate() {return cpu.ROR();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//111
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//112
                    @Override public String name() {return "BVS";}
                    @Override public uint8_t operate() {return cpu.BVS();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//113
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//114
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//115
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//116
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//117
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//118
                    @Override public String name() {return "ROR";}
                    @Override public uint8_t operate() {return cpu.ROR();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//119
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//120
                    @Override public String name() {return "SEI";}
                    @Override public uint8_t operate() {return cpu.SEI();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//121
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//122
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//123
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//124
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//125
                    @Override public String name() {return "ADC";}
                    @Override public uint8_t operate() {return cpu.ADC();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//126
                    @Override public String name() {return "ROR";}
                    @Override public uint8_t operate() {return cpu.ROR();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//127
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//128
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//129
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//130
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//131
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//132
                    @Override public String name() {return "STY";}
                    @Override public uint8_t operate() {return cpu.STY();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//133
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//134
                    @Override public String name() {return "STX";}
                    @Override public uint8_t operate() {return cpu.STX();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//135
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//136
                    @Override public String name() {return "DEY";}
                    @Override public uint8_t operate() {return cpu.DEY();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//137
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//138
                    @Override public String name() {return "TXA";}
                    @Override public uint8_t operate() {return cpu.TXA();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//139
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//140
                    @Override public String name() {return "STY";}
                    @Override public uint8_t operate() {return cpu.STY();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//141
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//142
                    @Override public String name() {return "STX";}
                    @Override public uint8_t operate() {return cpu.STX();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//143
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//144
                    @Override public String name() {return "BCC";}
                    @Override public uint8_t operate() {return cpu.BCC();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//145
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//146
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//147
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//148
                    @Override public String name() {return "STY";}
                    @Override public uint8_t operate() {return cpu.STY();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//149
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//150
                    @Override public String name() {return "STX";}
                    @Override public uint8_t operate() {return cpu.STX();}
                    @Override public uint8_t addrMode() {return cpu.ZPY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//151
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//152
                    @Override public String name() {return "TYA";}
                    @Override public uint8_t operate() {return cpu.TYA();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//153
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//154
                    @Override public String name() {return "TXS";}
                    @Override public uint8_t operate() {return cpu.TXS();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//155
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//156
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//157
                    @Override public String name() {return "STA";}
                    @Override public uint8_t operate() {return cpu.STA();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//158
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//159
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//160
                    @Override public String name() {return "LDY";}
                    @Override public uint8_t operate() {return cpu.LDY();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//161
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//162
                    @Override public String name() {return "LDX";}
                    @Override public uint8_t operate() {return cpu.LDX();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//163
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//164
                    @Override public String name() {return "LDY";}
                    @Override public uint8_t operate() {return cpu.LDY();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//165
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//166
                    @Override public String name() {return "LDX";}
                    @Override public uint8_t operate() {return cpu.LDX();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//167
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//168
                    @Override public String name() {return "TAY";}
                    @Override public uint8_t operate() {return cpu.TAY();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//169
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//170
                    @Override public String name() {return "TAX";}
                    @Override public uint8_t operate() {return cpu.TAX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//171
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//172
                    @Override public String name() {return "LDY";}
                    @Override public uint8_t operate() {return cpu.LDY();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//173
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//174
                    @Override public String name() {return "LDX";}
                    @Override public uint8_t operate() {return cpu.LDX();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//175
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//176
                    @Override public String name() {return "BCS";}
                    @Override public uint8_t operate() {return cpu.BCS();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//177
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//178
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//179
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//180
                    @Override public String name() {return "LDY";}
                    @Override public uint8_t operate() {return cpu.LDY();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//181
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//182
                    @Override public String name() {return "LDX";}
                    @Override public uint8_t operate() {return cpu.LDX();}
                    @Override public uint8_t addrMode() {return cpu.ZPY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//183
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//184
                    @Override public String name() {return "CLV";}
                    @Override public uint8_t operate() {return cpu.CLV();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//185
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//186
                    @Override public String name() {return "TSX";}
                    @Override public uint8_t operate() {return cpu.TSX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//187
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//188
                    @Override public String name() {return "LDY";}
                    @Override public uint8_t operate() {return cpu.LDY();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//189
                    @Override public String name() {return "LDA";}
                    @Override public uint8_t operate() {return cpu.LDA();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//190
                    @Override public String name() {return "LDX";}
                    @Override public uint8_t operate() {return cpu.LDX();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//191
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//192
                    @Override public String name() {return "CPY";}
                    @Override public uint8_t operate() {return cpu.CPY();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//193
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//194
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//195
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//196
                    @Override public String name() {return "CPY";}
                    @Override public uint8_t operate() {return cpu.CPY();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//197
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//198
                    @Override public String name() {return "DEC";}
                    @Override public uint8_t operate() {return cpu.DEC();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//199
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//200
                    @Override public String name() {return "INY";}
                    @Override public uint8_t operate() {return cpu.INY();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//201
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//202
                    @Override public String name() {return "DEX";}
                    @Override public uint8_t operate() {return cpu.DEX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//203
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//204
                    @Override public String name() {return "CPY";}
                    @Override public uint8_t operate() {return cpu.CPY();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//205
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//206
                    @Override public String name() {return "DEC";}
                    @Override public uint8_t operate() {return cpu.DEC();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//207
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//208
                    @Override public String name() {return "BNE";}
                    @Override public uint8_t operate() {return cpu.BNE();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//209
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//210
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//211
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//212
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//213
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//214
                    @Override public String name() {return "DEC";}
                    @Override public uint8_t operate() {return cpu.DEC();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//215
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//216
                    @Override public String name() {return "CLD";}
                    @Override public uint8_t operate() {return cpu.CLD();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//217
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//218
                    @Override public String name() {return "NOP";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//219
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//220
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//221
                    @Override public String name() {return "CMP";}
                    @Override public uint8_t operate() {return cpu.CMP();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//222
                    @Override public String name() {return "DEC";}
                    @Override public uint8_t operate() {return cpu.DEC();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//223
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//224
                    @Override public String name() {return "CPX";}
                    @Override public uint8_t operate() {return cpu.CPX();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//225
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.IZX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//226
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//227
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//228
                    @Override public String name() {return "CPX";}
                    @Override public uint8_t operate() {return cpu.CPX();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//229
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(3);}
                },
                new Instruction() {		//230
                    @Override public String name() {return "INC";}
                    @Override public uint8_t operate() {return cpu.INC();}
                    @Override public uint8_t addrMode() {return cpu.ZP0();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//231
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//232
                    @Override public String name() {return "INX";}
                    @Override public uint8_t operate() {return cpu.INX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//233
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.IMM();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//234
                    @Override public String name() {return "NOP";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//235
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//236
                    @Override public String name() {return "CPX";}
                    @Override public uint8_t operate() {return cpu.CPX();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//237
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//238
                    @Override public String name() {return "INC";}
                    @Override public uint8_t operate() {return cpu.INC();}
                    @Override public uint8_t addrMode() {return cpu.ABS();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//239
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//240
                    @Override public String name() {return "BEQ";}
                    @Override public uint8_t operate() {return cpu.BEQ();}
                    @Override public uint8_t addrMode() {return cpu.REL();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//241
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.IZY();}
                    @Override public uint8_t cycles() {return new uint8_t(5);}
                },
                new Instruction() {		//242
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//243
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(8);}
                },
                new Instruction() {		//244
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//245
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//246
                    @Override public String name() {return "INC";}
                    @Override public uint8_t operate() {return cpu.INC();}
                    @Override public uint8_t addrMode() {return cpu.ZPX();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//247
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(6);}
                },
                new Instruction() {		//248
                    @Override public String name() {return "SED";}
                    @Override public uint8_t operate() {return cpu.SED();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//249
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.ABY();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//250
                    @Override public String name() {return "NOP";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(2);}
                },
                new Instruction() {		//251
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//252
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.NOP();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//253
                    @Override public String name() {return "SBC";}
                    @Override public uint8_t operate() {return cpu.SBC();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(4);}
                },
                new Instruction() {		//254
                    @Override public String name() {return "INC";}
                    @Override public uint8_t operate() {return cpu.INC();}
                    @Override public uint8_t addrMode() {return cpu.ABX();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
                new Instruction() {		//255
                    @Override public String name() {return "???";}
                    @Override public uint8_t operate() {return cpu.XXX();}
                    @Override public uint8_t addrMode() {return cpu.IMP();}
                    @Override public uint8_t cycles() {return new uint8_t(7);}
                },
        };
    }

}
