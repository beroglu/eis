package tr.com.eis.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.DateTimeAtCompleted;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import tr.com.eis.entity.Country;
import tr.com.eis.exception.ErrorResponse;
import tr.com.eis.service.CountryService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CountryController {

	//public final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	CountryService countryService;

	@RequestMapping(value = "/country", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> listAllCountries() { 
		List<Country> countries = countryService.findAll();
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findCountryById(@PathVariable("id") long id) { 
		//logger.info("findCountryById methoduna country/{} ile geldi. Tarih: {}",id,new Date());
		Optional<Country> country = countryService.findById(id);
		if(country.isPresent()) { // doluysa
			return new ResponseEntity<Country>(country.get(), HttpStatus.OK);
		}else {  
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("404", "Bu id ile ülke bulunamadı."), HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public ResponseEntity<?> findCountryByIdWithRequestParam(@RequestParam(name="id",defaultValue="5",required=false) long id) { 
		Optional<Country> country = countryService.findById(id);
		if(country.isPresent()) { // doluysa
			return new ResponseEntity<Country>(country.get(), HttpStatus.OK);
		}else { 
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("404", "Bu id ile ülke bulunamadı."), HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(value = "/country", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCountry(@RequestBody Country country) { 
		try {
			if(StringUtils.isBlank(country.getName())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "Name alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			}else if (StringUtils.isBlank(country.getPhoneCode())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "PhoneCode alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			}else if(StringUtils.isBlank(country.getIsoCode())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "IsoCode alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			} 
			countryService.save(country);			
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("500", e.getMessage()), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/country", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCountry(@RequestBody Country country) { 
		try {
			
			if(StringUtils.isBlank(country.getName())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "Name alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			}else if (StringUtils.isBlank(country.getPhoneCode())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "PhoneCode alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			}else if(StringUtils.isBlank(country.getIsoCode())) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "IsoCode alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			}else if(StringUtils.isBlank(country.getId()+"")) {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("400", "Id alanı boş olamaz."), HttpStatus.BAD_REQUEST);
			}  
			
			Optional<Country> countryOptional = countryService.findById(country.getId());
			
			if(countryOptional.isPresent()) {
				if(countryOptional.get().getIsoCode().equals(country.getIsoCode())) {
					countryService.update(country);
				}else {
					Optional<Country> countryByIsoCode = countryService.findByIsoCode(country.getIsoCode());
					if(countryByIsoCode.isPresent()) {
						return new ResponseEntity<ErrorResponse>(new ErrorResponse("404", "Bu isoCode ait ülke mevcuttur."), HttpStatus.CONFLICT);				
					}else{
						countryService.update(country);
					}
				}
			}else{
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("404", "Bu id ile ülke bulunamadı."), HttpStatus.NOT_FOUND);				
			}
			
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("500", e.getMessage()), HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/country", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCountry(@RequestParam(name="id",required=true) long id) {  
		try {
			Optional<Country> countryOptional = countryService.findById(id); 
			if(countryOptional.isPresent()) {
				countryService.delete(countryOptional.get());		
			}else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("404", "Bu id ile ülke bulunamadı."), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("500", e.getMessage()), HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);	
      }
	
}
