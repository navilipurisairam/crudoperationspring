package com.employee.crudactivity1.services;
import com.employee.crudactivity1.dao.EmployeeDAO;
import com.employee.crudactivity1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeServices{

    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){ employeeDAO=theEmployeeDAO;}
    @Transactional
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
    @Transactional
    public Employee findById(int id){
        return employeeDAO.findById(id);
    }
    @Transactional
    public void save(Employee employee){employeeDAO.save(employee);}
    @Transactional
    public void deleteById(int id){
        employeeDAO.deleteById(id);
    }

}
