package com.training.assignments;

import java.util.Scanner;

public class Assignment1 {
    public double intToDouble(int x) {
        return (double) x;
    }

    public int doubleToInt(double x) {
        return (int) x;
    }

    public float doubleToFloat(double x) {
        return (float) x;
    }

    public double floatToDouble(float x) {
        return (double) x;
    }

    public long byteToLong(byte x) {
        return (long) x;
    }

    public byte longToByte(long x) {
        return (byte) x;
    }

    public char[] stringToChar(String s) {
        return s.toCharArray();
    }

    public static void main(String args[]) {
        Assignment1 a1 = new Assignment1();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the choice you want to select" + "\t 1.convert from int to double" + "\t 2.Double to int" +
                "\t 3.double to float" + "\t 4.float to double" + "\t 5.byte to double" + "\t 5.byte to long" + "\t lon to byte" + "" +
                "\t 6. long to byte" + "\t7.string to char");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please enter a integer to convert it to double");
                int value = sc.nextInt();
                System.out.println("The double value is " + a1.intToDouble(value));
                break;

            case 2:
                System.out.println("Please enter a double to convert it to integer");
                double d = sc.nextDouble();
                System.out.println("the integer value is " + a1.doubleToInt(d));
                break;

            case 3:
                System.out.println("Please enter a double to convert it to float");
                double d1 = sc.nextDouble();
                System.out.println("The float value is " + a1.doubleToFloat(d1));
                break;

            case 4:
                System.out.println("Please enter a float to convert it to double");
                float f = sc.nextFloat();
                System.out.println("The double value is " + a1.floatToDouble(f));
                break;

            case 5:
                System.out.println("Please enter a byte to convert it to long");
                byte b = sc.nextByte();
                System.out.println("The long value is " + a1.byteToLong(b));
                break;

            case 6:
                System.out.println("Please enter a long to convert it to byte");
                long l = sc.nextLong();
                System.out.println("The byte value is " + a1.longToByte(l));
                break;

            case 7:

                System.out.println("Please enter a string to convert it to char");
                String str = sc.next();
                char[] ch = a1.stringToChar(str);
                for (char c : ch) {
                    System.out.print("\t" + c);
                }
                break;
        }
    }
}