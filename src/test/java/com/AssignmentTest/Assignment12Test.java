package com.AssignmentTest;

import com.assignment.StudentAssignment12;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment12Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testStudentInfo() {
        StudentAssignment12 studentAssignment12 = new StudentAssignment12();
        String name = "Barrack", lastname = "Obama";
        int rollno = 1;

        studentAssignment12.setName(name);
        studentAssignment12.setLastname(lastname);
        studentAssignment12.setRollno(1);

        logger.info("First Name: " + studentAssignment12.getName());
        Assertions.assertTrue(studentAssignment12.getName() == name,
                "Name doesn't match");
        logger.info("Lastname: " + studentAssignment12.getLastname());
        Assertions.assertTrue(studentAssignment12.getLastname() == lastname,
                "Lastname doesn't match");
        logger.info("Roll NO: " + studentAssignment12.getRollno());
        Assertions.assertTrue(studentAssignment12.getRollno() == rollno,
                "Roll No Doesn't Match");
        logger.info("School: " + studentAssignment12.getSchool());
        Assertions.assertTrue(studentAssignment12.getSchool() == "Pratap Singh Morarji Memorial Inner Wheel School",
                "School Name Doesn't match");
    }
}