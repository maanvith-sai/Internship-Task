package com.maanvith.task.demo.service;

import com.maanvith.task.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee addEmployee(Employee emp);

    public Employee deleteEmployee(int id);

    public Employee getEmployee(int id);

    public Employee updateEmployee(int id, Employee emp);

}
