package com.mci.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mci.pma.dto.EmployeeProject;
import com.mci.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query(nativeQuery = true, value="SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) AS projectCount " + 
			"FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
}
