package com.hanniel.springboot.cruddemo.rest;

import com.hanniel.springboot.cruddemo.entity.Employee;
import com.hanniel.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeesId}")
    public String delete(@PathVariable int employeesId){
        Employee tempEmployee = employeeService.findById(employeesId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeesId);
        }
        employeeService.deleteById(employeesId);

        return "Deleted employee id - " + employeesId;
    }

}
