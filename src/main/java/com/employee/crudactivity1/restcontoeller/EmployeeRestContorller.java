package com.employee.crudactivity1.restcontoeller;
import com.employee.crudactivity1.entity.Employee;
import com.employee.crudactivity1.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestContorller {
    private EmployeeServices employeeServices;
    @Autowired
    public EmployeeRestContorller(EmployeeServices theEmployeeService){
        employeeServices=theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeServices.findAll();
    }
    @GetMapping("/employees/{EmployeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee theEmployee= employeeServices.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Student id is not found :"+employeeId);
        }
        return theEmployee;

    }
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        employeeServices.save(theEmployee);
        return theEmployee;

    }
    @PutMapping("/employees")
    public Employee updateStudent(@RequestBody Employee theEmployee){
        employeeServices.save(theEmployee);
        return theEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteStudent(@PathVariable int employeeId){
        Employee tempEmployee= employeeServices.findById(employeeId);
        if(tempEmployee==null){
            throw new RuntimeException("Employee not found id:"+employeeId);
        }
        employeeServices.deleteById(employeeId);
        return "Deleted employee with id :" +employeeId;

    }


}

