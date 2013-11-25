package project.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PROJECTS")
public class Project {

	private int id;
	private Manager manager;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private float totalHours;
	
	private Set<Requirement> requirements =null;
	private Set<Staff> staffs =null;
	private Set<Risk> risks = null;
	
	public Project(){
		
	}
	
	public Project(int id, Manager manager, Set<Risk> risks, String name, String description, Date startDate, Date endDate, Set<Requirement> requirements, Set<Staff> staffs){
		this.id = id;
		this.manager = manager;
		this.name = name;
		this.risks = risks;
		this.description = description;
		this.startDate = startDate;
		this.endDate= endDate;
		this.requirements = requirements;
		this.staffs = staffs;
	}
	
	
	public void setManager(Manager manager){
		
		this.manager= manager;
	}
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="MANAGER_ID", nullable=false)
	public Manager getManager(){
		return manager;
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
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name="NAME", nullable=false, unique=true)
	public String getName(){
		return name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name="DESCRIPTION", nullable=false, unique=false)
	public String getDescription(){
		return description;
	}
	
	public void setRequirements(Set<Requirement> requirements){
		this.requirements = requirements;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="project")
	public Set<Requirement> getRequirements(){
		if(requirements==null){
			requirements = new HashSet<Requirement>(0);
		}
		return requirements;
	}
	
	public void setStaffs(Set<Staff> staffs){
		this.staffs = staffs;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="project")
	public Set<Staff> getStaffs(){
		if(staffs ==null){
			staffs = new HashSet<Staff> (0);
		}
		return staffs;
	}
	
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	
	@Column(name="START_DATE", nullable= false, unique=false)
	public Date getStartDate(){
		return startDate;
	}
	
	public void setEndDate(Date endDate){
		this.endDate =endDate;
	}
	
	@Column(name="END_DATE", nullable=true, unique=false)
	public Date getEndDate(){
		return endDate;
	}
	
	public void setTotalHours(float totalHours){
		this.totalHours = totalHours;
	}
	
	@Column(name="TOTAL_HOURS", nullable=true, unique=false)
	public float getTotalHours(){
		return totalHours;
	}
	
	public void setRisks(Set<Risk> risks){
		this.risks = risks;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="project")
	public Set<Risk> getRisks(){
		if(risks ==null){
			risks = new HashSet<Risk> (0);
		}
		return risks;
	}
}
