package tr.com.eis.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long creator;
	Date createdDate;
	Long updater;
	Date updatedDate;
	Boolean state;

	@Column(name = "creator_id")
	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updater_id")
	public Long getUpdater() {
		return updater;
	}

	public void setUpdater(Long updater) {
		this.updater = updater;
	}

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "state")
	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}