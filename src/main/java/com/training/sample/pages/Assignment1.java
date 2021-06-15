package com.training.sample.pages;

public class Assignment1 {
    public static double intToDouble(int x) {
        return (double) x;
    }

    public static int doubleToInt(double d) {
        return (int) d;
    }

    public static float doubleToFloat(double d) {
        return (float) d;
    }

    public static double floatToDouble(float f) {
        return (double) f;
    }

    public static long byteToLong(byte b) {
        return (long) b;
    }

    public static byte longToByte(long L) {
        return (byte) L;
    }

    public static char[] stringToCharArray(String s) {
        char[] characters = s.toCharArray();
        return characters;
    }
}
