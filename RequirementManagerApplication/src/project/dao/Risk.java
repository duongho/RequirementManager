package project.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RISKS")
public class Risk {

	private int id;
	private int status;
	//0= resolve, 1 = non-resolve
	private String description;
	private String resolution;
	private Project project;
	
	public Risk(){
		
	}
	
	public Risk(int id, int status, String description, String resolution, Project project){
		this.id = id;
		this.status = status;
		this.description = description;
		this.resolution = resolution;
		this.project = project;
	}
	
	public void setId(int id){
		this.id  = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	public int getId(){
		return id;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	
	
	@Column(name="RESOLVE_STATUS", nullable=false, unique=false)
	public int getStatus(){
		return status;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name="DESCRIPTION", nullable=false, unique=false)
	public String getDescription(){
		return description;
	}
	
	public void setResolution(String resolution){
		this.resolution = resolution;
	}
	
	@Column(name="RESOLUTION", nullable=true, unique=false)
	public String getResolution(){
		return resolution;
	}

	public void setProject(Project project){
		this.project = project;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROJECT_ID", nullable=false, unique=false)
	public Project getProject(){
		return project;
	}
}
