package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.eis.entity.Department;

public interface  DepartmentRepository extends JpaRepository<Department, Long>  {
	
	List<Department> findAll();
	Optional<Department> findById(Long id);
	Optional<Department> findByName(String name);  
	Optional<Department> findByDefCode(String code);
}
