package com.assignment;

import java.lang.reflect.Array;

public class Assignment1 {
    public double getDoubleFromInt(int i) {
        double getDouble = i;
        return getDouble;
    }

    public int getIntFromDouble(double i) {
        int getInt = (int) i;
        return getInt;
    }

    public double getDoubleFromFloat(float f) {
        double getDouble = f;
        return getDouble;
    }

    public float getFloatFromDouble(double d) {
        float getFloat = (float) d;
        return getFloat;
    }

    public byte getByteFromLong(long l) {
        byte getByte = (byte) l;
        return getByte;
    }

    public long getLongFromByte(byte b) {
        long getLong = b;
        return getLong;
    }

    public char[] getCharacterArray(String name) {
        char[] cname = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            cname[i] = name.charAt(i);
        }
        return cname;
    }
}