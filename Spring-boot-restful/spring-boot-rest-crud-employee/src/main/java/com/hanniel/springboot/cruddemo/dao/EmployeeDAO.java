package com.hanniel.springboot.cruddemo.dao;

import com.hanniel.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
