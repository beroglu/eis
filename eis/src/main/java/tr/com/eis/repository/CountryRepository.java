package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.eis.entity.Country;

public interface  CountryRepository extends JpaRepository<Country, Long>  {
	
	List<Country> findAll();
	Optional<Country> findById(Long id);
	Optional<Country> findByName(String name);  
	Optional<Country> findByIsoCode(String code);
}
