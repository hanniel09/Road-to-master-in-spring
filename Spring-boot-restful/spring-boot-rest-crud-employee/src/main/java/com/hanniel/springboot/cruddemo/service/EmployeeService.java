package com.hanniel.springboot.cruddemo.service;

import com.hanniel.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

}
