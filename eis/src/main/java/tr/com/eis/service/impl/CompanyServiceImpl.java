package tr.com.eis.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tr.com.eis.entity.Company;
import tr.com.eis.entity.Country;
import tr.com.eis.repository.CompanyRepository;
import tr.com.eis.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository repository;

	@Inject
	public CompanyServiceImpl(final CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Company> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Company> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Company save(Company company) {
		if(repository.findByTaxNumber(company.getTaxNumber()).isPresent() ) {
			return null;
		}
		else {
			
		return repository.save(company);
		}
	}

	@Override
	@Transactional
	public Company update(Company company) {
		if(repository.findById(company.getId()).isPresent()) {
			return repository.save(company);
		} 
		else {
		return null;
		}
	}

	@Override
	public void delete(Company company) {
        company.setState(false);
		repository.save(company);
	}

	@Override
	public List<Company> findByCountry(Country country) {
		return repository.findByCountry(country);
	}

}
