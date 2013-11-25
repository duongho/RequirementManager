package project.database;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import project.dao.Manager;
import project.utility.HibernateUtil;

public abstract class SessionManager {

	private static Map<HttpSession, Manager> loggedInUsers = new HashMap<HttpSession, Manager>(
			0);

	public static synchronized void addLoggedInUserToList(HttpSession session,
			Manager manager) {

		try {
			if (manager != null && session != null) {
				if (!isUserInList(manager)) {
					loggedInUsers.put(session, manager);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean isUserInList(Manager manager) {

		boolean b = false;
		try {
			if (loggedInUsers.containsValue(manager)) {
				b = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return b;
	}

	public static boolean isSessionExist(HttpSession session) {
		boolean b = false;

		if (loggedInUsers.containsKey(session)) {
			b = true;
		}
		return b;
	}

	public static synchronized void removeUserFromLoggedInList(
			HttpSession session) {
		try {
			if (isSessionExist(session)) {
				Iterator<Entry<HttpSession, Manager>> iterator = loggedInUsers
						.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<HttpSession, Manager> entry = iterator.next();
					if (entry.getKey().equals(session)) {
						iterator.remove();
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static synchronized void removeUserFromLoggedInList(Manager manager) {
		try {
			if (isUserInList(manager)) {
				Iterator<Entry<HttpSession, Manager>> iterator = loggedInUsers
						.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<HttpSession, Manager> entry = iterator.next();
					if (entry.getValue().equals(manager)) {
						iterator.remove();
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static Manager getManager(String userName, String password) {

		Manager m = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session
					.createQuery("from Manager where userName= :userName and password= :password");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			List<Manager> managerList = query.list();

			if (managerList != null && !managerList.isEmpty()
					&& managerList.size() == 1) {
				m = managerList.get(0);
			}

			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return m;

	}

}
