package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    public void testStudent()
    {
        Student student=new Student();
        student.setName("Naviya");
        student.setLastName("Dayanand");
        student.setRollNo(1);
        Student.setSchoolName("CJCS");

        Assertions.assertEquals("Naviya",student.getName());
        Assertions.assertEquals("Dayanand",student.getLastName());
        Assertions.assertEquals(1,student.getRollNo());
        Assertions.assertEquals("CJCS",Student.getSchoolName());

    }
}