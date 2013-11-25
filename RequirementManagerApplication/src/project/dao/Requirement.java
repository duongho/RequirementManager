package project.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="REQUIREMENTS")
public class Requirement {

	private int id;
	private int type;
	private Project project;
	private String description;
	private Effort effort;
	
	
	public Requirement(){
		
	}
	
	public Requirement(int id, int type, Project project, String description, Effort effort){
		this.id = id;
		this.type = type;
		this.project = project;
		this.description = description;
		this.effort = effort;
	}
	
	public void setId(int id){
		this.id= id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	public int getId(){
		return id;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	//0 = NFR, 1= FR
	@Column(name="REQUIREMENT_TYPE", nullable=false, unique=false)
	public int getType(){
		return type;
	}
	
	public void setProject(Project project){
		this.project = project;
	}
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="PROJECT_ID", nullable=false)
	public Project getProject(){
		return project;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name="DESCRIPTION", nullable=false, unique=true)
	public String getDescription(){
		return description;
	}
	
	public void setEffort(Effort effort){
		this.effort = effort;
	}
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "requirement")
	public Effort getEffort(){
		return effort;
	}
}
