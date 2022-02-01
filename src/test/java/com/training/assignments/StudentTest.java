package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    public void testStudent()
    {
        Student student=new Student();
        String name="Naviya";
        String lastName="Dayanand";
        Integer rollNo=1;
        String SchoolName="CJCS";

        student.setName(name);
        student.setLastName(lastName);
        student.setRollNo(rollNo);
        student.setSchoolName(SchoolName);

        Assertions.assertEquals(name,student.getName(),"Name doesn't match");
        Assertions.assertEquals(lastName,student.getLastName(),"Lastname don't match");
        Assertions.assertEquals(rollNo,student.getRollNo(),"Rollno don't match");
        Assertions.assertEquals(SchoolName,Student.getSchoolName(),"Schoolname don't match");

    }
}