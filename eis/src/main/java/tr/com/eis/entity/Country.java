package tr.com.eis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="eis_country")
public class Country extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444065737034697174L;
	private Long id;
	private String name;
	private String isoCode;
	private String phoneCode;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_country", sequenceName = "seq_country")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_country")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

		
}
