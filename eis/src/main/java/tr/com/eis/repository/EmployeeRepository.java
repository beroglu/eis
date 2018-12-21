package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.eis.entity.Employee;

public interface  EmployeeRepository extends JpaRepository<Employee, Long>  {
	
	List<Employee> findAll();
	Optional<Employee> findById(Long id);
	Optional<Employee> findByRegNumber(String regNumber); 
	//employeenin tüm tasklarını getiren liste??

	
	
}
