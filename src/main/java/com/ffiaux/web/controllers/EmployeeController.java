package com.ffiaux.web.controllers;

import com.ffiaux.db.DepartmentRepository;
import com.ffiaux.db.EmployeeRepository;
import com.ffiaux.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ffiaux on 25/05/2016.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("employers", employeeRepository.findAll());

        return "employee/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("employee", new Employee());

        return "employee/add";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute Employee e, Model model) {
        e.setDepartment(departmentRepository.findAll().get(0));
        employeeRepository.save(e);

        return this.list(model);
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeRepository.findOne(id));

        return "employee/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute Employee e, @RequestParam String id, Model model) {
        Employee _e = employeeRepository.findOne(id);
        _e.setFirstName(e.getFirstName());
        _e.setLastName(e.getLastName());
        _e.setAge(e.getAge());
        _e.setEmail(e.getEmail());
        _e.setPhoneNumber(e.getPhoneNumber());
        _e.setSalary(e.getSalary());

        employeeRepository.save(_e);

        return this.list(model);
    }

}