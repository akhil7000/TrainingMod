package com.training.assignments.miniproject;

import lombok.Data;

@Data
public class EmployeeManagement {
    String name;
    String address;
    int salary;
    int id;

    public EmployeeManagement(String name, String address, int salary, int id) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.id = id;
    }
}