package com.mci.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mci.pma.dao.EmployeeRepository;
import com.mci.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping
	public String displayEmployees(Model model) {
		Iterable<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {

		Employee anEmployee = new Employee();
		// attribute name must be the same in the html th:object="${employee}"
		model.addAttribute("employee", anEmployee);

		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		// this should handle saving to the DB
		empRepo.save(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/new";
	}
}
