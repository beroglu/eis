package tr.com.eis.entity;

import java.util.Date;
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
@Table(name="eis_employee")
public class Employee extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4569293425173066771L;
	
	private Long   id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date   hireDate;
	private String regNumber;
	private Double salary;
	private Set<Task> tasks = new HashSet<Task>(0);
	


	@OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "title_id", nullable = false)
	private Title  title;
	 
	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "department_id", nullable = false)
	private Department  department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Double getSalary() {
		return salary;
	}

	
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_TASK",
	joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "TASK_ID") })
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	

}
