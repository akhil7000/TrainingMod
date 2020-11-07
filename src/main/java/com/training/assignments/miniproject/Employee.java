package com.training.assignments.miniproject;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    static List<Employee> employeeList = new ArrayList<>();
    static List<Employee> cloneEmployeeList = new ArrayList<>();

    String name;
    String address;
    int salary;
    int id;

    public Employee getCreateEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getCreatedEmployeeList() {
        return employeeList;
    }

    public Employee getCreateCloneEmployee(Employee employee) {
        cloneEmployeeList.add(employee);
        return employee;
    }

    public List<Employee> getCreatedCloneEmployeeList() {
        return cloneEmployeeList;
    }

    public List<Employee> getDeletedEmployee(int index) {
        employeeList.remove(index);
        return employeeList;
    }

    public List<Employee> getCloneDeletedEmployee(int index) {
        cloneEmployeeList.remove(index);
        return cloneEmployeeList;
    }

    public List<Employee> getUpdatedEmployee(Employee employee1, int index) {
        employeeList.add(index, employee1);
        return employeeList;
    }

    public List<Employee> getCloneUpdatedEmployee(Employee employee2, int index) {
        cloneEmployeeList.add(index, employee2);
        return cloneEmployeeList;
    }
}