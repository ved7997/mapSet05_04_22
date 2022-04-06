package com.example.mapset05_04_22.service;

import java.util.Collection;

public abstract class EmployeeService {


    public abstract Employee add(String firstName, String lastName);
    public abstract Employee add(Employee employee);
    public abstract Employee remove(String firstName, String lastName);
    public abstract Employee remove(Employee employee);
    public abstract Employee find(String firstName, String lastName);

    public abstract Collection<Employee> getAll();

}

