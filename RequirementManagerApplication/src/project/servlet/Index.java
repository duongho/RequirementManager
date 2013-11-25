package project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import project.dao.Project;
import project.database.Services;
import project.utility.HibernateUtil;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Project> projects = Services.getProjects();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		for (Project p : projects) {
			p.setTotalHours(Services.computeTotalHours(p.getId()));
			session.saveOrUpdate(p);
		}
		session.getTransaction().commit();
		session.close();

		request.setAttribute("projects", projects);

		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
