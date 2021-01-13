class Name{

    static String fullName(String firstName)
    {
        return firstName;
    }
    static String fullName(String firstName, String lastName)
    {
        return firstName +" "+ lastName;
    }
    static String fullName(String firstName, String lastName, String middleName)
    {
        return firstName + " "+ lastName+" "+ middleName;
    }

}
public class Assignment15 {
    public static void main(String[] args){
        Name methodOverload = new Name();
        String x = methodOverload.fullName("Barack");
        String y = methodOverload.fullName("Barack","Obama");
        String z = methodOverload.fullName("Barack","Obama","Hussein");
        System.out.println("Method 1 "+x);
        System.out.println("Method 2 "+y);
        System.out.println("Method 3 "+z);


    }
}
