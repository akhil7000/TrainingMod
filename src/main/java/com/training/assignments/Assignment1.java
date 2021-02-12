package com.training.assignments;

public class Assignment1 {
    public double getDoubleFromInt(int i) {
        return (double) i;
    }

    public int getIntFromDouble(double d) {
        return (int) d;
    }

    public double getDoubleFromFloat(float f) {
        return (double) f;
    }

    public float getFloatFromDouble(double d) {
        return (float) d;
    }

    public byte getByteFromLong(long l) {
        return (byte) l;
    }

    public long getLongFromByte(byte b) {
        return (long) b;
    }

    public char[] getCharacterArray(String name) {
        char[] cname = new char[name.length()];
        for (int index = 0; index < name.length(); index++) {
            cname[index] = name.charAt(index);
        }
        return cname;
    }
}