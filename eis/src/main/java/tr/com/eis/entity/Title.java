package tr.com.eis.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="eis_title")
public class Title extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4902071486871066776L; 
	private Long id;
    private String name;
    private Double minSalary;
    private Double maxSalary;
    private String definition;
    private String defCode;
	private Set<Company> companies = new HashSet<Company>(0);

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
	public Double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public Double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getDefCode() {
		return defCode;
	}
	public void setDefCode(String defCode) {
		this.defCode = defCode;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TITLE_COMPANY",
	joinColumns = { @JoinColumn(name = "TITLE_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "COMPANY_ID") })
	 public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

}
