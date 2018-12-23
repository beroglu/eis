package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.eis.entity.Company;
import tr.com.eis.entity.Country;
import tr.com.eis.entity.Title;

public interface  TitleRepository extends JpaRepository<Title, Long>  {
	
	List<Title> findAll();
	Optional<Title> findById(Long id);

	
}
