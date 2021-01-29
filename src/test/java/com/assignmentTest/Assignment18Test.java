package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class Assignment18Test {


    @Test
    public void testStudent() {
        String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
        String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
        String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
        ArrayList<Student> studentArray = new ArrayList<>();
        StudentInfo stu = new StudentInfo();
        stu.setStudentInfo(studentArray, infoBarrack);
        stu.setStudentInfo(studentArray, infoJoe);
        stu.getStudentList(studentArray);
        stu.setEditStudent(studentArray, "1", infoNewBarrack);
        stu.getStudentInfo(studentArray, "1");
        stu.setDeleteStudent(studentArray, "1");
        stu.getStudentList(studentArray);
    }
}