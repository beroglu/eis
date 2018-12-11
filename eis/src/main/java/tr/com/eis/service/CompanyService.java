package tr.com.eis.service;

import java.util.List;
import java.util.Optional;

import tr.com.eis.entity.Company;
import tr.com.eis.entity.Country;

public interface CompanyService {
	
	List<Company> findAll();
	Optional<Company> findById(Long id);
	Company save(Company company);
	Company update(Company company);
	void delete(Company company);
	List<Company> findByCountry(Country country);
}
