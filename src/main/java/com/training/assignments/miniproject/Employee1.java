package com.training.assignments.miniproject;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Employee1 {
    static List<Employee1> employeeList = new ArrayList<>();
    static List<Employee1> cloneEmployeeList = new ArrayList<>();

    String name;
    String address;
    int salary;
    int id;

    public Employee1(String name, String address, int salary, int id) {
        this.name=name;
        this.address=address;
        this.salary=salary;
        this.id=id;
    }

    public Employee1() {
    }
    public void createEmployee(String name, String address, int salary, int id) {
        employeeList.add(new Employee1(name, address, salary, id));
    }

    public List<Employee1> getEmployee() {
        return employeeList;
    }

//    public Employee1 getCreateEmployee(Employee1 employee) {
//        employeeList.add(employee);
//        return employee;
//    }
//
//    public List<Employee1> getCreatedEmployeeList() {
//        return employeeList;
//    }
//
//    public Employee1 getCreateCloneEmployee(Employee1 employee) {
//        cloneEmployeeList.add(employee);
//        return employee;
//    }
//
//    public List<Employee1> getCreatedCloneEmployeeList() {
//        return cloneEmployeeList;
//    }


}