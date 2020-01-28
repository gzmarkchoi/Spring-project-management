package com.mci.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mci.pma.dto.ChartData;
import com.mci.pma.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();
}
