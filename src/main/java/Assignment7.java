import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment7 {
    public static void main(String[] args) throws IOException {
        System.out.println("very good, good, bad, or very bad ?");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String go = obj.readLine();
        if (go.equals("very good")) {
            System.out.println("Go to heaven with dogs");
        }
        else if (go.equals("good")) {
            System.out.println("Go to heaven");
        }
        else {
            System.out.println("Go to hell");
        }
    }
}