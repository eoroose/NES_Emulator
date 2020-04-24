package Emulator;

import Emulator.Bus.Bus;
import Emulator.CPU_6502.CPU_6502;
import Emulator.CPU_6502.FLAGS_6502;
import InputHandler.Keyboard;
import PixelEngine.PixelEngine;
import PixelString.PixelString;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.*;

public class Emulator {

    private final PixelEngine pixelEngine;
    private Bus nes;
    private Map<Integer, String> mapAsm;
    PixelString pixelString1, pixelString2, pixelString3,
                pixelString4, pixelString5, pixelString6,
                pixelString7, pixelString8, pixelString9;

    public Emulator(PixelEngine pixelEngine) {
        this.pixelEngine = pixelEngine;
        init();
    }

    public void init() {
        nes = new Bus();
        mapAsm = new HashMap<Integer, String>();
        //ram
        pixelString1 = new PixelString(pixelEngine, 2, 2, 1, "");
        pixelString2 = new PixelString(pixelEngine, 2, 182, 1, "");
        //flags
        pixelString3 = new PixelString(pixelEngine, 350, 2, 1, "STATUS:");
        pixelString3.setPixelColor(Color.WHITE);
        pixelString4 = new PixelString(pixelEngine, 398, 2, 1, "N  V  -  B  D  I  Z  C");
        pixelString4.setPixelColor(Color.RED);
        pixelString5 = new PixelString(pixelEngine, 398, 2, 1, "");
        //cpu
        pixelString6 = new PixelString(pixelEngine, 350, 12, 1, "");
        //code
        pixelString7 = new PixelString(pixelEngine, 350, 72, 1, "");
        pixelString8 = new PixelString(pixelEngine, 350, 72, 1, "");
        //instruction
        pixelString9 = new PixelString(pixelEngine, 50, 350, 1, "up = step instruction    r = reset    i = irq    n = nmi");
        pixelString9.setPixelColor(Color.GREEN);


        int[] ss = {0xA2, 0x0A, 0x8E, 0x00, 0x00, 0xA2, 0x03, 0x8E, 0x01, 0x00, 0xAC, 0x00, 0x00, 0xA9, 0x00, 0x18, 0x6D, 0x01, 0x00, 0x88, 0xD0, 0xFA, 0x8D, 0x02, 0x00, 0xEA, 0xEA, 0xEA};
        int nOffset = 0x8000;
        for (int s : ss) {
            nes.ram[nOffset++] = s;
        }
        nes.ram[0xfffc] = 0x00;
        nes.ram[0xfffd] = 0x80;

        mapAsm = nes.cpu.disassemble(0x0000,0xffff);

        nes.cpu.reset();
    }

    boolean first_time = true;
    long last = 0;
    long now = 0;
    long timer = 0;

    public void tick() {

        if(first_time) {
            last = System.nanoTime();
            first_time = false;
        }
        now = System.nanoTime();
        timer += now - last;
        last = now;
        if(timer >= 1000000000) {
        //if(Keyboard.keys[GLFW_KEY_UP]) {
            do {
                nes.cpu.clock();
            } while (!nes.cpu.complete());
            timer = 0;
        }
        if(Keyboard.keys[GLFW_KEY_R])
            nes.cpu.reset();
        if(Keyboard.keys[GLFW_KEY_I])
            nes.cpu.irq();
        if(Keyboard.keys[GLFW_KEY_N])
            nes.cpu.nmi();

        pixelString1.setPixelString(drawRam(0x0000, 16, 16));
        pixelString1.setPixelColor(Color.WHITE);
        pixelString1.showPixelString();

        pixelString2.setPixelString(drawRam(0x8000, 16, 16));
        pixelString2.setPixelColor(Color.WHITE);
        pixelString2.showPixelString();

        pixelString3.showPixelString();
        pixelString4.showPixelString();

        pixelString5.setPixelString(drawFlags());
        pixelString5.setPixelColor(Color.GREEN);
        pixelString5.showPixelString();

        pixelString6.setPixelString(drawCpu());
        pixelString6.setPixelColor(Color.WHITE);
        pixelString6.showPixelString();

        pixelString7.setPixelString(drawCode(26));
        pixelString7.setPixelColor(Color.WHITE);
        pixelString7.showPixelString();

        pixelString8.setPixelString(mapAsm.get(nes.cpu.pc));
        pixelString8.setPixelColor(Color.CYAN);
        pixelString8.showPixelString();

        pixelString9.showPixelString();
    }

    public String hex(int n) {
        if (n > 0xf)
            return Integer.toHexString(n);
        else
            return "0" + Integer.toHexString(n);
    }


    public String drawRam(int nAddr, int nRows, int nColumns) {
        String sOffset = "";
        for(int row = 0; row < nRows; row++) {
            if(nAddr < 0xff)
                sOffset += "$00" + hex(nAddr) + ":";
            else if(nAddr < 0xfff)
                sOffset += "$000" + hex(nAddr) + ":";
            else
                sOffset += "$" + hex(nAddr) + ":";

            for(int col = 0; col < nColumns; col++) {
                sOffset += " " + hex(nes.read(nAddr, true));
                nAddr++;
            }
            sOffset += "\n";
        }
        return sOffset;

    }

    public String drawFlags() {
        String sOffset = "";
        sOffset += (nes.cpu.status & FLAGS_6502.N.getOperation()) > 0 ? "N  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.V.getOperation()) > 0 ? "V  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.U.getOperation()) > 0 ? "-  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.B.getOperation()) > 0 ? "B  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.D.getOperation()) > 0 ? "D  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.I.getOperation()) > 0 ? "I  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.Z.getOperation()) > 0 ? "Z  " : "   ";
        sOffset += (nes.cpu.status & FLAGS_6502.C.getOperation()) > 0 ? "C  " : "   ";
        return sOffset;
    }

    public String drawCpu() {
        String sOffset = "";
        sOffset += "PC: $" + hex(nes.cpu.pc) + "\n";
        sOffset += "A: $" + hex(nes.cpu.a) + " [" + nes.cpu.a + "]\n";
        sOffset += "X: $" + hex(nes.cpu.x) + " [" + nes.cpu.x + "]\n";
        sOffset += "Y: $" + hex(nes.cpu.y) + " [" + nes.cpu.y + "]\n";
        sOffset += "Stack P: $" + hex(nes.cpu.stkp);
        return sOffset;
    }

    public String drawCode(int nLines) {
        String sOffset = "";
        boolean found = false;
        String it_a = mapAsm.get(nes.cpu.pc);
        int x = 0;
        for(Integer key : mapAsm.keySet()) {
            if(mapAsm.get(key).equals(it_a)) found = true;
            if(found) {
                sOffset += mapAsm.get(key) + "\n";
                if(x++ >= nLines) break;
            }
        }
        return sOffset;
    }

}