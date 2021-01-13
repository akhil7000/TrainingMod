public class Assignment1 {
    public static void main(String[] args) {
        //int to double
        int i = 100;
        double d = i;

        //double to int
        double x =5d;
        int y = (int) x;

        //double to float
        double a =1000d;
        float b = (float) a;

        // float to double
        float l = 100.5F;
        double m = l;

        //byte to long
        byte p = 1;
        long q = p;

        //long to byte
        long r = 21546L;
        byte s = (byte) r;

        //string "rccl" to char[] name
        String name = "rccl";
        char [] cname = new char [name.length()];
        for (i=0;i<name.length();i++) {
        cname[i]=name.charAt(i);
        System.out.println(cname[i]);
        }
        System.out.println(cname);
    }
}