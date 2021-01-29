package com.assignment;

import com.assignment.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
import static com.assignment.StudentInformation.getStudentInfo;
import static com.assignment.StudentInformation.setStudentInfo;
import static com.assignment.StudentInformation.getStudentList;
import static com.assignment.StudentInformation.setEditStudent;
import static com.assignment.StudentInformation.setDeleteStudent;
*/

public class NewStudent {
    public static void switchCase() throws IOException {
        ArrayList<Student> studentArL = new ArrayList<>();
        System.out.println("1: Add info");
        System.out.println("2: Edit info");
        System.out.println("3: View Student info");
        System.out.println("4: View All info");
        System.out.println("5. Delete student");
        System.out.println("6. Exit");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option = Integer.parseInt(reader.readLine());
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

    }

    public static void setStudentInfo(ArrayList<Student> studentArL) throws IOException {
        Student student = new Student();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("id");
        student.setId(String.valueOf(reader.readLine()));
        System.out.println("name");
        student.setName(reader.readLine());
        System.out.println("address");
        student.setAddress(reader.readLine());
        System.out.println("class");
        student.setStudentClass(String.valueOf(reader.readLine()));
        System.out.println("school");
        student.setSchool(reader.readLine());

        studentArL.add(student);
        System.out.println("Student information added");
    }

    public static void setEditStudent(ArrayList<Student> studentArL) throws IOException {
        Student student = new Student();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Student id or name");
        String index = reader.readLine();

        for (int i = 0; i < studentArL.size(); i++) {
            Student s = studentArL.get(i);
            if (s.getId() == index || s.getName() == index) {
                System.out.println("Enter new values");

                System.out.println("id");
                student.setId(String.valueOf(reader.readLine()));
                System.out.println("name");
                student.setName(reader.readLine());
                System.out.println("address");
                student.setAddress(reader.readLine());
                System.out.println("class");
                student.setStudentClass(String.valueOf(reader.readLine()));
                System.out.println("school");
                student.setSchool(reader.readLine());

                studentArL.set(Integer.parseInt(index), student);
                System.out.println("Student information had been updated");
            } else {
                System.out.println("There is no such student, please try again");
            }
        }
    }

    public static void getStudentInfo(ArrayList<Student> studentArL) throws IOException {
        Student student = new Student();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String index;

        System.out.println("Enter student id");
        index = reader.readLine();

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

    public static void setDeleteStudent(ArrayList<Student> studentArL) {
        Scanner sc = new Scanner(System.in);

        if (studentArL.size() == 0) {
            System.out.println("No Student Data Present");
        } else {
            System.out.println("Enter the student ID");
            String id = sc.next();
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
