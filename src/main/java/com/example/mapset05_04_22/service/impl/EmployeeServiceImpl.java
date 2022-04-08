package com.example.mapset05_04_22.service.impl;

import com.example.mapset05_04_22.exception.EmployeeExistsException;
import com.example.mapset05_04_22.exception.EmployeeNotFoundException;
import com.example.mapset05_04_22.service.Employee;
import com.example.mapset05_04_22.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeesList;

    public EmployeeServiceImpl() {
        employeesList = new ArrayList<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (employeesList.contains(employee)) {
            throw new EmployeeExistsException();
        }
        employeesList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public  Employee remove(Employee employee) {
        if (!employeesList.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public  Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeesList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }


    @Override
    public Collection<Employee> getAll(){
        return  Set.copyOf(employeesList);
    }

}
