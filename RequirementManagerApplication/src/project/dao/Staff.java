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
@Table(name="STAFFS")
public class Staff {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Manager manager;
	private Role role;
	private Project project;
	
	public Staff(){
		
	}
	
	public Staff(int id, String firstName, String lastName, String email, Role role, Manager manager, Project project){
		this.id = id;
		this.firstName= firstName;
		this.lastName = lastName;
		this.email = email;
		this.manager = manager;
		this.role = role;
		this.project = project;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique = true)
	public int getId(){
		return id;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	@Column(name="FIRST_NAME", nullable=false, unique=false)
	public String getFirstName(){
		return firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName= lastName;
	}
	
	@Column(name="LAST_NAME", nullable=false, unique=false)
	public String getLastName(){
		return lastName;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	@Column(name="EMAIL", unique=true, nullable=true)
	public String getEmail(){
		return email;
	}
	
	public void setRole(Role role){
		this.role = role;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_ID", nullable=false)
	public Role getRole(){
		return role;
	}
	
	public void setManager(Manager manager){
		this.manager = manager;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MANAGER_ID", nullable=false)
	public Manager getManager(){
		return manager;
	}
	
	public void setProject(Project project){
		this.project = project;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROJECT_ID", nullable=false)
	public Project getProject(){
		return project;
	}
}
