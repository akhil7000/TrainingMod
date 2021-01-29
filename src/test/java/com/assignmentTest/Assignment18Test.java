package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Assignment18Test {

    @Test
    public void testStudent() {
        String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
        String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
        String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
        ArrayList<Student> studentArray = new ArrayList<>();
        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setStudentInfo(studentArray, infoBarrack);
        studentInfo.setStudentInfo(studentArray, infoJoe);
        studentInfo.getStudentList(studentArray);
        studentInfo.setEditStudent(studentArray, "1", infoNewBarrack);
        studentInfo.getStudentInfo(studentArray, "1");
        studentInfo.setDeleteStudent(studentArray, "1");
        studentInfo.getStudentList(studentArray);
    }
}