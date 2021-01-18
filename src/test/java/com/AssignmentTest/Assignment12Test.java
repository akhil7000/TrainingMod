package com.AssignmentTest;
import com.a.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import com.assignment

public class Assignment12Test {
    Student obj = new Student();
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter name "+"Last name "+"Roll number ");
    obj.name = rd.readLine();
    obj.lastname=rd.readLine();
    obj.rollno = Integer.parseInt(rd.readLine());

}



