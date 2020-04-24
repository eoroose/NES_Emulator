package Emulator.Uint;

public class Uint {

    private static void show(long c) {
        System.out.println(c + " " + Long.toHexString(c) + " " + Long.toBinaryString(c));
    }

    public static int uint8(int num) {
        if (num <= 0x00) return 0x00;
        else if (num >= 0xff) return 0xff;
        return num & 0xff;
    }

    public static int uint16(int num) {
        if (num <= 0x0000) return 0x0000;
        else if (num >= 0xffff) return 0xffff;
        return num & 0xffff;
    }

    public static long uint32(long num) {
        if(num <= 0x00000000L) return 0x00000000L;
        else if (num >= 0xffffffffL) return 0xffffffffL;
        return num & 0xffffffffL;
    }

    public static int AND_8(int num1, int num2) {
        return (num1 & num2) & 0xff;
    }

    public static int OR_8(int num1, int num2) {
        return (num1 | num2) & 0xff;
    }

    public static int XOR_8(int num1, int num2) {
        return (num1 ^ num2) & 0xff;
    }

    public static int NOT_8(int num) {
        return (~num) & 0xff;
    }

    public static int LEFT_SHIFT_8(int num1, int num2) {
        return (num1 << num2) & 0xff;
    }

    public static int RIGHT_SHIFT_8(int num1, int num2) {
        return (num1 >> num2) & 0xff;
    }

    public static int AND_16(int num1, int num2) {
        return (num1 & num2) & 0xffff;
    }

    public static int OR_16(int num1, int num2) {
        return (num1 | num2) & 0xffff;
    }

    public static int XOR_16(int num1, int num2) {
        return (num1 ^ num2) & 0xffff;
    }

    public static int NOT_16(int num) {
        return (~num) & 0xffff;
    }

    public static int LEFT_SHIFT_16(int num1, int num2) {
        return (num1 << num2) & 0xffff;
    }

    public static int RIGHT_SHIFT_16(int num1, int num2) {
        return (num1 >> num2) & 0xffff;
    }

    public static long AND_32(long num1, long num2) {
        return (num1 & num2) & 0xffffffffL;
    }

    public static long OR_32(long num1, long num2) {
        return (num1 | num2) & 0xffffffffL;
    }

    public static long XOR_32(long num1, long num2) {
        return (num1 ^ num2) & 0xffffffffL;
    }

    public static long NOT_32(long num) {
        return (~num) & 0xffffffffL;
    }

    public static long LEFT_SHIFT_32(long num1, long num2) {
        return (num1 << num2) & 0xffffffffL;
    }

    public static long RIGHT_SHIFT_32(long num1, long num2) {
        return (num1 >> num2) & 0xffffffffL;
    }
}
