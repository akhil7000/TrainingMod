package com.training.sample.pages;

public class Assignment1 {
    public static double intToDouble(int x) {
        double d = (double) x;
        System.out.println(d);
        return d;
    }

    public static int doubleToInt(double d) {
        int x = (int) d;
        System.out.println(x);
        return x;
    }

    public static float doubleToFloat(double d) {
        float f = (float) d;
        System.out.println(f);

        return f;
    }

    public static double floatToDouble(float f) {
        double d = (double) f;
        System.out.println(d);
        return d;
    }
    public static long byteToLong(byte b) {
        long l = (long) b;
        System.out.println(l);
        return l;
    }
    public static byte longToByte(long L){
        byte b = (byte) L;
        System.out.println(b);
        return b;
    }
    public static char[] stringToCharArray(String s){
        char[] characters=s.toCharArray();
        return characters;
    }
}