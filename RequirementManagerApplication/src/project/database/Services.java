package project.database;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import project.dao.Effort;
import project.dao.Manager;
import project.dao.Project;
import project.dao.Requirement;
import project.dao.Risk;
import project.dao.Role;
import project.dao.Staff;
import project.utility.HibernateUtil;

public abstract class Services {

	@SuppressWarnings("unchecked")
	public static List<Project> getProjects() {

		List<Project> projects = null;

		try {

			Session session = project.utility.HibernateUtil.getSessionFactory()
					.openSession();
			session.beginTransaction();

			projects = session.createQuery("from Project").list();

			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (projects == null) {
			projects = Collections.emptyList();
		}

		return projects;
	}

	public static float computeTotalHours(int projectID) {

		float totalHours = 0;

		try {

			Project p = getProjectByID(projectID);
			if (p != null) {
				Set<Requirement> requirements = p.getRequirements();
				if (!requirements.isEmpty()) {

					for (Requirement r : requirements) {
						Effort e = r.getEffort();
						totalHours += e.getNewTotalHours();
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return totalHours;
	}

	public static Requirement getRequirementByID(int requirementID) {
		Requirement r = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			r = (Requirement) session.get(Requirement.class, requirementID);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return r;
	}
	
	
	public static Role getRoleByID(int roleID) {
		Role r = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			r = (Role) session.get(Role.class, roleID);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return r;
	}
	
	
	public static Project getProjectByID(int projectID) {
		Project p = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			p = (Project) session.get(Project.class, projectID);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return p;
	}

	public static Manager getManagerByID(int managerID) {
		Manager m = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			m = (Manager) session.get(Manager.class, managerID);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return m;
	}

	public static void createProject(String name, String description,
			Date startDate, Manager manager) {
		try {


				Project project = new Project();
				project.setName(name);
				project.setDescription(description);
				project.setStartDate(startDate);
				project.setManager(manager);

				persistObjectInDB(project);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void createRequirement(int type, String description,
			Project project) {
		try{
			Requirement r = new Requirement();
			r.setDescription(description);
			r.setType(type);
			r.setProject(project);
			
			persistObjectInDB(r);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void createStaff(String firstName, String lastName, String email, Manager manager, Role role, Project project){
		
		try{
			Staff s = new Staff();
			s.setFirstName(firstName);
			s.setLastName(lastName);
			s.setEmail(email);
			s.setManager(manager);
			s.setProject(project);
			s.setRole(role);
			
			persistObjectInDB(s);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public static void createRisk(int status, String description, String resolution, Project project){
		try{
			
			Risk risk = new Risk();
			risk.setStatus(status);
			risk.setDescription(description);
			risk.setResolution(resolution);
			risk.setProject(project);
			
			persistObjectInDB(risk);
		}catch(Exception ex){
			
		}
	}
	
	public static void createEffort(Requirement requirement, int status, float reportedHours){
		
		try{
			Effort e = new Effort();
			e.setRequirement(requirement);
			e.setDateStarted(new Date());
			e.setDateReported(new Date());
			e.setStatus(status);
			e.setReportedHours(reportedHours);
			e.setNewTotalHours(e.getReportedHours());
			e.setPreviousTotalHours(e.getReportedHours());
			
			persistObjectInDB(e);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void createRole(String roleType, String description){
		try{
			
			Role role = new Role();
			role.setRoleType(roleType);
			role.setDescription(description);
			
			persistObjectInDB(role);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static void persistObjectInDB(Object object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(object);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void createManager(String firstName, String lastName, String email, String userName, String password){
		
		try{
			Manager manager = new Manager();
			manager.setEmail(email);
			manager.setFirstName(firstName);
			manager.setLastName(lastName);
			manager.setEmail(email);
			manager.setUserName(userName);
			manager.setPassword(password);
			
			persistObjectInDB(manager);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
