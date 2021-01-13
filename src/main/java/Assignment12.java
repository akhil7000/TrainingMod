import java.io.*;
class student {
    String name;
    String lastname;
    int rollno;
    static String school="PMMIWS";

}
class studentdemo {
    public static void main(String args[])throws IOException {
        student obj = new student();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name "+"Last name "+"Roll number ");
        obj.name= rd.readLine();
        obj.lastname=rd.readLine();
        obj.rollno = Integer.parseInt(rd.readLine());
        System.out.println("Name: "+obj.name);
        System.out.println("Last name: "+obj.lastname);
        System.out.println("Roll no: "+obj.rollno);
        System.out.println("School: " + student.school);

    }
}