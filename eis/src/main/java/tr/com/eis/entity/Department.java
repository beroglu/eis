package tr.com.eis.entity;

public class Department extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -836413186604611410L;
	
	private Long id;
	private String name;
	private String defCode;
	private String definition;
	private Company company;
	private Employee manager;
	
	
	

}
