//Create a switch case with any 5 names of the company and their respective review.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment6 {
    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter company name");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String company = obj.readLine();

        switch (company) {
            case "Google":
                System.out.println("Monitors everything");
                break;
            case "Apple":
                System.out.println("Costlier than android");
                break;
            case "Facebook":
                System.out.println("Too much data tracking");
                break;
            case "Amazon":
                System.out.println("Will sell you anything");
                break;
            case "Microsoft":
                System.out.println("Nothing free but safer");
                break;
            default:
                System.out.println("Enter valid name");
        }
    }
}
