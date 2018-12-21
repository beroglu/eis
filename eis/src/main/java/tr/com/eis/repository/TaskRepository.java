package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.eis.entity.Task;

public interface  TaskRepository extends JpaRepository<Task, Long>  {
	
	List<Task> findAll();
	Optional<Task> findById(Long id);
	Optional<Task> findByName(String name);  
	Optional<Task> findByIsoCode(String code);
}
