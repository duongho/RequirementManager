package project.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EFFORTS")
public class Effort {

	private int id;
	private Requirement requirement;
	private Date dateStarted;
	//0 = on-going, 1= completed
	private int status;
	private float previousTotalHours;
	private float newTotalHours;
	private float reportedHours;
	private Date dateReported;
	
	public Effort(){
		
	}
	
	public Effort(int id, Requirement requirement, Date dateStarted, Date dateReported, int status, float previousTotalHours, float newTotalHours, float reportedHours){
		this.id = id;
		this.requirement = requirement;
		this.dateStarted = dateStarted;
		this.dateReported = dateReported;
		this.status = status;
		this.previousTotalHours = previousTotalHours;
		this.newTotalHours = newTotalHours;
		this.reportedHours = reportedHours;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	public int getId(){
		return id;
	}
	
	public void setRequirement(Requirement requirement){
		this.requirement = requirement;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="REQUIREMENT_ID")
	public Requirement getRequirement(){
		return requirement;
	}
	
	public void setDateStarted(Date dateStarted){
		this.dateStarted = dateStarted;
	}
	
	@Column(name="DATE_STARTED", nullable=false, unique=false)
	public Date getDateStarted(){
		return dateStarted;
	}
	
	public void setDateReported(Date dateReported){
		this.dateReported = dateReported;
	}
	
	@Column(name="DATE_REPORTED", nullable=false, unique=false)
	public Date getDateReported(){
		return dateReported;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	
	@Column(name="STATUS", nullable=false, unique=false)
	public int getStatus(){
		return status;
	}
	
	public void setPreviousTotalHours(float previousTotalHours){
		this.previousTotalHours = previousTotalHours;
	}
	
	@Column(name="PREVIOUS_TOTAL_HOURS", nullable=false, unique=false)
	public float getPreviousTotalHours(){
		return previousTotalHours;
	}
	
	public void setNewTotalHours(float newTotalHours){
		this.newTotalHours = newTotalHours;
	}
	
	@Column(name="NEW_TOTAL_HOURS", nullable= false, unique=false)
	public float getNewTotalHours(){
		return newTotalHours;
	}
	
	public void setReportedHours(float reportedHours){
		this.reportedHours = reportedHours;
	}
	
	@Column(name="REPORTED_HOURS", nullable=false, unique=false)
	public Float getReportedHours(){
		return reportedHours;
	}
}
