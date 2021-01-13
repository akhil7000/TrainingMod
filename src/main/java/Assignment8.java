//Printing middle number
public class Assignment8 {
    public static void main(String[] args){
        int[] m = new int[500];
        for(int i=0; i<500; i++) {
            m[i]=i+1;
        }
        int a = (m.length)/2;
        System.out.println(m[a]);
    }
}