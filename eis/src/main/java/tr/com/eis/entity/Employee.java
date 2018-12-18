package tr.com.eis.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "title_id", nullable = false)
	private Title  title;
	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "department_id", nullable = false)
	private Department  department;
	 
	
	

}
