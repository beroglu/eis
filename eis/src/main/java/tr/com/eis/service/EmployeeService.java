package tr.com.eis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import tr.com.eis.entity.Company;
import tr.com.eis.entity.Country;
import tr.com.eis.entity.Employee;
import tr.com.eis.entity.Task;

public interface EmployeeService {
	
	List<Employee> findAll();
	Optional<Employee> findById(Long id);
	Optional<Employee> findByRegNumber(String regNumber); 
	List<Task> findAllTasks( Long id);
	Employee save(Employee employee);
	Employee update(Employee employee);
	void delete(Employee employee);
	
}
