package tr.com.eis.service;

import java.util.List;
import java.util.Optional;

import tr.com.eis.entity.Country;

public interface CountryService {
	List<Country> findAll();
	Optional<Country> findById(Long id);
	Country save(Country country);
	Country update(Country country);
	void delete(Country country);
	Optional<Country> findByIsoCode(String code);
}
