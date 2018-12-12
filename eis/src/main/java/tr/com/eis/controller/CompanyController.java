package tr.com.eis.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
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
import tr.com.eis.exception.ErrorResponse;
import tr.com.eis.service.CompanyService;
import tr.com.eis.service.CountryService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CompanyController  {
	public final Logger logger= LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	CompanyService companyService;
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/company",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Company>> listAllCompanies(){
		List<Company> companies=companyService.findAll();
		return new ResponseEntity<List<Company>>(companies,HttpStatus.OK);
				
	}
	
	@RequestMapping(value="company/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findCompanyById(@PathVariable("id") long id ){
		Optional<Company> company= companyService.findById(id);
		if(company.isPresent()) {
			return new ResponseEntity<Company>(company.get(),HttpStatus.OK);			
		}
		else {
			
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("404","bu id ye ait kayıt bulunmamaktadır"),HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
	@RequestMapping(value="/company", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCompany(@RequestBody Company company){
		try {
			if(StringUtils.isBlank(company.getName())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("301", "Name alanı boş olamaz"),HttpStatus.BAD_REQUEST);
			}	
			else if (StringUtils.isBlank(company.getTaxNumber())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("302", "tax number alanı boş olamaz"),HttpStatus.BAD_REQUEST);
			}
			else if(!(countryService.findById(company.getCountry().getId()).isPresent())) {
				
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("303", "bu country e ait kayıt bulunmamaktadır"),HttpStatus.NOT_FOUND);
			}
			
			companyService.save(company);
			
		} catch (Exception e) {
			
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("500",e.getMessage()),HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
		
		
	}
	
	
	
}
