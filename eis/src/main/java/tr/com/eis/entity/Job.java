package tr.com.eis.entity;

import java.util.Date;

public class Job extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3800189578322140499L;
	private Long id;
    private String definition;
	private String details;	//
	private Employee assignedTo;
	private int state;
	private Date startDate;
	private Date endDate;
	
	

}
