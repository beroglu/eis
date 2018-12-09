package tr.com.eis.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tr.com.eis.entity.Country;
import tr.com.eis.repository.CountryRepository;
import tr.com.eis.service.CountryService;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

	private final CountryRepository repository;

	@Inject
	public CountryServiceImpl(final CountryRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Country> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Country> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	@Override
	public Country save(Country country) {
		if (repository.findByIsoCode(country.getIsoCode()).isPresent()) {
			return null;
		} else {
			return repository.save(country);
		}
	}

	@Transactional
	@Override
	public Country update(Country country) {
		if (isExist(country.getId())) {
			return repository.save(country);
		} else {
			return null;
		}
	}

	@Transactional
	@Override
	public void delete(Country country) {
		country.setState(false);
		repository.save(country);
	}

	boolean isExist(Long countryId) {
		if (repository.exists(countryId)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Optional<Country> findByIsoCode(String code) { 
		return repository.findByIsoCode(code);
	}
}
