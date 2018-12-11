package tr.com.eis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.com.eis.entity.Company;
import tr.com.eis.service.CompanyService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CompanyController  {
	public final Logger logger= LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/companies",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Company>> listAllCompanies(){
		List<Company> companies=companyService.findAll();
		return new ResponseEntity<List<Company>>(companies,HttpStatus.OK);
				
	}
	
	
	
	
}
