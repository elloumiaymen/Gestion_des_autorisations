package tn.iit.glid22.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid22.Dao.EnseignantDao;
import tn.iit.glid22.model.Enseignant;

import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class MajEnseignantController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        EnseignantDao enseignantDao = new EnseignantDao();
		enseignantDao.Update(id,nom, prenom,telephone, email);

		List<Enseignant> listEnseignant = enseignantDao.getAll();
		
		 request.setAttribute("listEnseignant", listEnseignant); // Set the listEnseignant as a request attribute

		    // Redirect to the bienvenue.jsp page
		 request.getRequestDispatcher("Index.jsp").forward(request, response);
    }
}
