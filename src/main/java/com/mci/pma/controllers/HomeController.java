package com.mci.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mci.pma.dao.EmployeeRepository;
import com.mci.pma.dao.ProjectRepository;
import com.mci.pma.dto.ChartData;
import com.mci.pma.dto.EmployeeProject;
import com.mci.pma.entities.Project;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;

	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

		model.addAttribute("versionNumber", ver);

		List<Project> listProjects = proRepo.findAll();
		model.addAttribute("projectsList", listProjects);

		List<ChartData> projectData = proRepo.getProjectStatus();
		// convert projectData object into a Json structure for Javascript uses
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCount", jsonString);

		List<EmployeeProject> employeesProjectsCount = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectsCount", employeesProjectsCount);

		return "main/home";
	}
}
