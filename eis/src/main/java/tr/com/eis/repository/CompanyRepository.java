package tr.com.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.eis.entity.Company;
import tr.com.eis.entity.Country;

public interface  CompanyRepository extends JpaRepository<Company, Long>  {
	
	List<Company> findAll();
	Optional<Company> findById(Long id);
	Optional<Company> findByName(String name);  
	Optional<Company> findByTaxNumber(String taxNumber);  
	List<Company> findByCountry(Country country);
	
}
