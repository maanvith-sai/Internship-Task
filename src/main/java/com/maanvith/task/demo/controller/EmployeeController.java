package com.maanvith.task.demo.controller;


import com.maanvith.task.demo.entity.Employee;
import com.maanvith.task.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/list")
    public String listEmployees(Model model){
        //get employees from db
        List<Employee> theEmployees = employeeService.getEmployees();
        model.addAttribute("employees", theEmployees);
        //add that to the spring model
        return "employees/employee-list";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee theEmployee){
        employeeService.addEmployee(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee e = new Employee();
        model.addAttribute("employee",e);
        return "employees/employee-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId")int theId, Model model){
        Employee employee1= employeeService.getEmployee(theId);
        model.addAttribute("employee",employee1);
        return "employees/employee-form";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int theId){
        employeeService.deleteEmployee(theId);
        return "redirect:/employees/list";
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

}

