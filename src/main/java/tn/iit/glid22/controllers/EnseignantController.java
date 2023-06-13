package tn.iit.glid22.controllers;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid22.Dao.EnseignantDao;
import tn.iit.glid22.model.Enseignant;

/**
 * Servlet implementation class EnseignantControlleur
 */
@WebServlet("/EnseignantController")
public class EnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnseignantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EnseignantDao enseignantDao = new EnseignantDao();
		ServletContext application = getServletContext();
		@SuppressWarnings("unchecked")
		List<Enseignant> listEnseignant = (List<Enseignant>) application.getAttribute("listEnseignant");
		if (listEnseignant == null) {
			listEnseignant = enseignantDao.getAll();
		}
		
		
	
		String search = request.getParameter("search");
		
		    if (search != null && !search.isEmpty()) {
		    	listEnseignant = listEnseignant.stream()
					      .filter(e -> e.getNom().contains(search) || e.getPrenom().contains(search) ||
					    		  e.getTelephone().contains(search)|| e.getEmail().contains(search))
					      .collect(Collectors.toList());
		    } 
		
		    
		    request.setAttribute("listEnseignant", listEnseignant); // Set the listEnseignant as a request attribute

		    // Redirect to the bienvenue.jsp page
		    request.getRequestDispatcher("Index.jsp").forward(request, response);
	}
}
