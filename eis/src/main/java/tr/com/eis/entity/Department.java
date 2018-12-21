package tr.com.eis.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="eis_department")
public class Department extends BaseEntity {

	
	private static final long serialVersionUID = -836413186604611410L;
	
	private Long id;
	private String name;
	private String defCode;
	private String definition;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "manager_id", nullable = false)
    private Employee manager;
	
	private Set<Company> companies = new HashSet<Company>(0);

	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEPARTMENT_COMPANY",
	joinColumns = { @JoinColumn(name = "DEPARTMENT_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "COMPANY_ID") })
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

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

	public String getDefCode() {
		return defCode;
	}

	public void setDefCode(String defCode) {
		this.defCode = defCode;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	
	

}
