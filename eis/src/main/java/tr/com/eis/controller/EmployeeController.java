package tr.com.eis.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.com.eis.entity.Company;
import tr.com.eis.entity.Employee;
import tr.com.eis.exception.ErrorResponse;
import tr.com.eis.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController  {
	public final Logger logger= LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;

	
	@RequestMapping(value="/employee",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Employee>> listAllEmployees(){
		List<Employee> companies=employeeService.findAll();
		return new ResponseEntity<List<Employee>>(companies,HttpStatus.OK);
				
	}
	
	@RequestMapping(value="employee/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findEmployeeById(@PathVariable("id") long id ){
		Optional<Employee> employee= employeeService.findById(id);
		if(employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(),HttpStatus.OK);			
		}
		else {
			
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("404","bu id ye ait kayıt bulunmamaktadır"),HttpStatus.NOT_FOUND);
		}
		
	}
		
	@RequestMapping(value="/employee", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		try {
			if(StringUtils.isBlank(employee.getFirstName())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("301", "firstname alanı boş olamaz"),HttpStatus.BAD_REQUEST);
			}	
			else if (StringUtils.isBlank(employee.getLastName())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("302", "tax number alanı boş olamaz"),HttpStatus.BAD_REQUEST);
			}
			else if (StringUtils.isBlank(employee.getRegNumber())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("302", "tax number alanı boş olamaz"),HttpStatus.BAD_REQUEST);
			}
						
			employeeService.save(employee);
			
		} catch (Exception e) {
			
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("500",e.getMessage()),HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
		
	}
	

	

}
