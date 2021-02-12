package com.training.assignments.tests;

import com.training.assignments.StudentAssignment12;
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
        studentAssignment12.setRollno(rollno);
        StudentAssignment12.setSchool("PMMIWS");

        logger.info("First Name: " + studentAssignment12.getName());
        Assertions.assertEquals(studentAssignment12.getName(), name,
                "Name doesn't match");

        logger.info("Lastname: " + studentAssignment12.getLastname());
        Assertions.assertEquals(studentAssignment12.getLastname(), lastname,
                "Lastname doesn't match");

        logger.info("Roll NO: " + studentAssignment12.getRollno());
        Assertions.assertEquals(studentAssignment12.getRollno(), rollno,
                "Roll No Doesn't Match");

        logger.info("School: " + studentAssignment12.getSchool());
        Assertions.assertEquals(StudentAssignment12.getSchool(), "PMMIWS",
                "School Name Doesn't match");
    }
}