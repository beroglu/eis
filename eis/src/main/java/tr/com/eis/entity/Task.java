package tr.com.eis.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="eis_task")
public class Task extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3800189578322140499L;
	private Long id;
    private String definition;
	private String details;	//
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "employee_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	private Employee assignedTo;
	private int state;
	private Date startDate;
	private Date endDate;
	
	

}
