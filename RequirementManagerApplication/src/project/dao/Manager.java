package project.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "MANAGERS")
public class Manager{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private Set<Project> projects = null;
	private Set<Staff> staffs =null;

	public Manager() {
	}
	
	public Manager(int id, String firstName, String lastName, Set<Staff> staffs,String email, Set<Project> projects, String userName, String password){
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.projects = projects;
		this.userName = userName;
		this.password = password;
		this.staffs = staffs;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	public int getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="FIRST_NAME", unique=false, nullable=false)
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="LAST_NAME", unique=false, nullable=false)
	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="EMAIL", unique=true, nullable=true)
	public String getEmail() {
		return email;
	}
	
	public void setProjects(Set<Project> projects){
		this.projects = projects;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="manager")
	public Set<Project> getProjects(){
		if(projects==null){
			projects = new HashSet<Project>(0);
		}
		return projects;
	}
	
	public void setStaffs(Set<Staff> staffs){
		this.staffs= staffs;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="manager")
	public Set<Staff> getStaffs(){
		if(staffs ==null){
			staffs = new HashSet<Staff>(0);
		}
		return staffs;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	@Column(name="USERNAME", nullable=false, unique=true)
	public String getUserName(){
		return userName;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	@Column(name="PASSWORD", nullable=false, unique=false)
	public String getPassword(){
		return password;
	}

}
