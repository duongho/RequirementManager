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
@Table(name="ROLES")
public class Role {

	private int id;
	private String roleType;
	private String description;
	
	private Set<Staff> staffs = null;
	
	public Role(){
		
	}
	
	public Role(int id, String roleType, String description, Set<Staff> staffs){
		this.id = id;
		this.roleType = roleType;
		this.description = description;
		this.staffs = staffs;
	}


	public void setId(int id){
		this.id =id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	public int getId(){
		return id;
	}
	
	public void setRoleType(String roleType){
		this.roleType = roleType;
	}
	
	@Column(name="ROLE_TYPE", nullable=false, unique=true)
	public String getRoleType(){
		return roleType;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name="DESCRIPTION", nullable=false, unique=true)
	public String getDescription(){
		return description;
	}
	
	public void setStaffs(Set<Staff> staffs){
		this.staffs = staffs;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="role")
	public Set<Staff> getStaffs(){
		if(staffs ==null){
			staffs = new HashSet<Staff> (0);
		}
		return staffs;
	}
}