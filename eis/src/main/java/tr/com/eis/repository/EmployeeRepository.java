package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tr.com.eis.entity.Employee;
import tr.com.eis.entity.Task;

public interface  EmployeeRepository extends JpaRepository<Employee, Long>  {
	
	List<Employee> findAll();
	Optional<Employee> findById(Long id);
	Optional<Employee> findByRegNumber(String regNumber); 
	//employeenin tüm tasklarını getiren liste
	@Query("SELECT e FROM EMPLOYEE_TASK e WHERE LOWER(e.EMPLOYEE_ID) = LOWER(:id)")
    public List<Task> findAllTasks(@Param("id") Long id);
	
}  
