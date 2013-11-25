package project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.Project;
import project.database.Services;

/**
 * Servlet implementation class ProjectHomeServlet
 */
@WebServlet("/ProjectHomeServlet")
public class ProjectHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String projectID = request.getParameter("projectID");
		if (projectID != null && !projectID.trim().isEmpty()) {
			Project project = Services.getProjectByID(Integer
					.parseInt(projectID));
			if (project != null) {

				//the selected project
				request.setAttribute("selectedProject", project);
				
				//List of all projects
				List<Project> projects = Services.getProjects();
				request.setAttribute("projects", projects);
				
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
