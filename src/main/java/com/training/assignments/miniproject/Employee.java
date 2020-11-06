package com.training.assignments.miniproject;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    List<Employee> employeeList = new ArrayList<>();

    String name;
    String address;
    int salary;
    int id;

    public Employee(String name, String address, int salary, int id) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.id = id;
    }

    public Employee() {
    }

    public List<Employee> getCreatedEmployee() {
        employeeList.add(new Employee("Shri", "kandivali", 20000, 56));
        employeeList.add(new Employee("Ashish", "Malad", 25000, 84));
        employeeList.add(new Employee("Arnav", "Goregaon", 3000, 75));
        employeeList.add(new Employee("Paramveer", "Andheri", 40000, 420));
        return employeeList;
    }

    public List<Employee> getExistingEmployee() {
        employeeList.add(new Employee("Shri", "kandivali", 20000, 56));
        employeeList.add(new Employee("Ashish", "Malad", 25000, 84));
        employeeList.add(new Employee("Arnav", "Goregaon", 3000, 75));
        employeeList.add(new Employee("Paramveer", "Andheri", 40000, 420));
        return employeeList;
    }

    public List<Employee> getDeletedEmployee(int index) {
        employeeList.remove(index);
        return employeeList;
    }

    public List<Employee> getCloneDeletedEmployee(int index) {
        employeeList.remove(index);
        return employeeList;
    }

    public List<Employee> getUpdatedEmployee(int index) {
        Employee employee = employeeList.get(index);
        employee.setName("Ashwini");
        employee.setAddress("Lokhandwala");
        employee.setSalary(25000);
        return employeeList;
    }

    public List<Employee> getCloneUpdatedEmployee(int index) {
        Employee employee = employeeList.get(index);
        employee.setName("Ashwini");
        employee.setAddress("Lokhandwala");
        employee.setSalary(25000);
        return employeeList;
    }
}