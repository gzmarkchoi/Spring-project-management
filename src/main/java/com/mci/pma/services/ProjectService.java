package com.mci.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mci.pma.dao.ProjectRepository;
import com.mci.pma.dto.ChartData;
import com.mci.pma.entities.Project;

public class ProjectService {

	@Autowired
	ProjectRepository proRepo;

	public Project save(Project project) {
		return proRepo.save(project);
	}

	public List<Project> getAll() {
		return proRepo.findAll();
	}

	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
}
