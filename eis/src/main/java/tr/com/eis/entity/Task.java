package tr.com.eis.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="eis_task")
public class Task extends BaseEntity {

	private static final long serialVersionUID = -3800189578322140499L;
	private Long id;
    private String definition;
	private String details;	//
	private int stateOfTask;
	private Date startDate;
	private Date endDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public int getStateOfTask() {
		return stateOfTask;
	}
	public void setStateOfTask(int stateOfTask) {
		this.stateOfTask = stateOfTask;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	

}
