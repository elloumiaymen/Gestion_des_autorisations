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
 * Servlet implementation class MajEnseignantController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EnseignantDao enseignantDao = new EnseignantDao();
	    
		Enseignant enseignant = new Enseignant(request.getParameter("nom"), request.getParameter("prenom"), 
				request.getParameter("telephone"), request.getParameter("Email"));
		enseignantDao.Save(enseignant);
		
		List<Enseignant> listEnseignant = enseignantDao.getAll();
		
		 request.setAttribute("listEnseignant", listEnseignant); // Set the listEnseignant as a request attribute

		    // Redirect to the bienvenue.jsp page
		 request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
