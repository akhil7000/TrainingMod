package com.assignmentTest;

import com.assignment.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Assignment18Test {

    @Test
    public void testStudentSystem() {
        ArrayList<Student> studentArL = new ArrayList<>();
        int option = 1;
        while (option < 7) {
            System.out.println("1: Add info");
            System.out.println("2: Edit info");
            System.out.println("3: View Student info");
            System.out.println("4: View All info");
            System.out.println("5. Delete student");
            System.out.println("6. Exit");

            switch (option) {
                case 1: {
                    setStudentInfo(studentArL);
                    break;
                }

                case 2: {
                    setEditStudent(studentArL);
                    break;
                }

                case 3: {
                    getStudentInfo(studentArL);
                    break;
                }

                case 4: {
                    getStudentList(studentArL);
                    break;
                }

                case 5: {
                    setDeleteStudent(studentArL);
                    break;
                }

                case 6: {
                    System.out.println("Exit");
                    System.exit(0);
                }

                default:
                    System.out.println("Enter Correct Option");
            }
            option++;
        }
    }

    public static void setStudentInfo(ArrayList<Student> studentArL) {
        Student student = new Student();

        System.out.println("id");
        student.setId("1");
        System.out.println("name");
        student.setName("Barrack Obama");
        System.out.println("address");
        student.setAddress("White House");
        System.out.println("class");
        student.setStudentClass("1");
        System.out.println("school");
        student.setSchool("PMMIWS");

        studentArL.add(student);
        System.out.println("Student information added");
    }

    public static void setEditStudent(ArrayList<Student> studentArL) {
        Student student = new Student();
        String index = "1";
        System.out.println("Enter Student id or name");
        Student s = studentArL.get(0);
        if (s.getId() == index || s.getName() == index) {
            System.out.println("Enter new values");

            System.out.println("id");
            student.setId("2");
            System.out.println("name");
            student.setName("Joe Biden");
            System.out.println("address");
            student.setAddress("New White House");
            System.out.println("class");
            student.setStudentClass("2");
            System.out.println("school");
            student.setSchool("Modern");

            studentArL.set(0, student);
            System.out.println("Student information had been updated");
        } else {
            System.out.println("There is no such student, please try again");
        }
    }


    public static void getStudentList(ArrayList<Student> studentArL) {
        if (studentArL.size() != 0) {
            for (int i = 0; i < studentArL.size(); i++) {
                Student student = studentArL.get(i);
                System.out.println(student.getId() + " " + student.getName() +
                        " " + student.getAddress() + " " + student.getStudentClass() +
                        " " + student.getSchool());
            }
        } else {
            System.out.println("There is no student information!!!");
        }
    }

    public static void getStudentInfo(ArrayList<Student> studentArL) {
        Student student = new Student();
        String index;

        System.out.println("Enter student id");
        index = "PMMIWS";
        for (int i = 0; i < studentArL.size(); i++) {
            student = studentArL.get(i);
            if (student.getId() == index || student.getName() == index
                    || student.getAddress() == index || student.getStudentClass() == index
                    || student.getSchool() == index) {
                System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress()
                        + " " + student.getStudentClass() + " " + student.getSchool());
            }
        }
    }

    public static void setDeleteStudent(ArrayList<Student> studentArL) {
        String id = "1";
        if (studentArL.size() == 0) {
            System.out.println("No Student Data Present");
        } else {
            System.out.println("Enter the student ID");
            for (int i = 0; i < studentArL.size(); i++) {
                Student s = studentArL.get(i);
                if (s.getId().equals(id)) {
                    studentArL.remove(i);
                    System.out.println("Student successfully removed");

                } else {
                    System.out.println("There is no such student, please try again");
                }
            }
        }
    }
}