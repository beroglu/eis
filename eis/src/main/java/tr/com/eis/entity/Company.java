package tr.com.eis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="eis_company")
public class Company extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444065737034697174L;
	private Long id;
	private String name;
	private String taxNumber;
	private Country country;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_company", sequenceName = "seq_company")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

		
}
