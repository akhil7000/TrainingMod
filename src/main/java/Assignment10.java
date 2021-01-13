import java.util.Arrays;

public class Assignment10 {
    public static void main(String[] args) {
        int[] intArray = new int[20];
        for (int i=0;i<10;i++)
        {
            intArray[i]=i+1;
        }
        for (int i : intArray) {
            if (i%2==1){
                System.out.println(i);
            }
        }
    }
}
