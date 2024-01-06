package com.maanvith.task.demo.service;

import com.maanvith.task.demo.entity.Employee;
import com.maanvith.task.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return emp;

    }

    @Override
    public Employee updateEmployee(int id, Employee emp) {
        Employee empp = employeeRepository.findById(id).get();
        empp.setName(emp.getName());
        empp.setId(emp.getId());
        empp.setEmail(emp.getEmail());
        empp.setPhoneNumber(emp.getPhoneNumber());
        empp.setLevel(emp.getLevel());

        return empp;
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
}
//@Service
//public class EmployeeServiceImplementation implements EmployeeService {
//
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImplementation(EmployeeRepository theEmployeeRepository) {
//        employeeRepository = theEmployeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(int theId) {
//        Optional<Employee> result = employeeRepository.findById(theId);
//
//        Employee theEmployee = null;
//
//        if (result.isPresent()) {
//            theEmployee = result.get();
//        }
//        else {
//            // we didn't find the employee
//            throw new RuntimeException("Did not find employee id - " + theId);
//        }
//
//        return theEmployee;
//    }
//
//    @Override
//    public Employee save(Employee theEmployee) {
//        return employeeRepository.save(theEmployee);
//    }
//
//    @Override
//    public void deleteById(int theId) {
//        employeeRepository.deleteById(theId);
//    }
//}