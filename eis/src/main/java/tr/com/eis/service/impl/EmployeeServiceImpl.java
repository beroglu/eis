package tr.com.eis.service.impl;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import tr.com.eis.entity.Employee;
import tr.com.eis.entity.Task;
import tr.com.eis.repository.EmployeeRepository;
import tr.com.eis.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;

	@Inject
	public EmployeeServiceImpl(final EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<Employee> findByRegNumber(String regNumber) {
		
		return repository.findByRegNumber(regNumber);
	}

	@Override
	public List<Task> findAllTasks(Long id) {
	
		return repository.findAllTasks(id);
	}

	@Override
	public Employee save(Employee employee) {
		if (repository.findByRegNumber(employee.getRegNumber()).isPresent()) {
			return null;
		} else {
			return repository.save(employee);
		}
	}

	@Override
	public Employee update(Employee employee) {
		if (isExist(employee.getId())) {
			return repository.save(employee);
		} else {
			return null;
		}
	}

	private boolean isExist(Long id) {
		if (repository.exists(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void delete(Employee employee) {
		employee.setState(false);
		repository.save(employee);
		
	}



}
