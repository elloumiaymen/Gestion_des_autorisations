package tn.iit.glid22.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.iit.glid22.Dao.EnseignantDao;
import tn.iit.glid22.model.Enseignant;


/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		EnseignantDao enseignantDao = new EnseignantDao();
		enseignantDao.Delete(id);
		
		
		List<Enseignant> listEnseignant = enseignantDao.getAll();
		
		 request.setAttribute("listEnseignant", listEnseignant); // Set the listEnseignant as a request attribute

		    // Redirect to the bienvenue.jsp page
		 request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
