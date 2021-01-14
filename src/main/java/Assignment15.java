class FullNameOverload{
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
    FullNameOverload methodOverload = new FullNameOverload();
    System.out.println("Method 1 "+methodOverload.fullName("Barack"));
    System.out.println("Method 2 "+methodOverload.fullName("Barack","Obama"));
    System.out.println("Method 3 "+methodOverload.fullName("Barack","Obama","Hussein"));
}
}
