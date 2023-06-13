package tn.iit.glid22.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.glid22.model.User;
 
import tn.iit.glid22.Dao.UserDao;
/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String log = request.getParameter("login");
		String mp = request.getParameter("pwd");
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		User currentUser = null;
		RequestDispatcher rd = null;
		String errorMessage;
	 	//List<Utilisateur> listUser = (List<Utilisateur>) application.getAttribute("listU");
	 	UserDao userDao = new UserDao();
	 	List<User> listUser=userDao.getAll(); 
	 	request.setAttribute("errorMessage","");
	  
		if (listUser == null) {
		 	 
			errorMessage=("Aucun utilisateur n'est inscrit !!");
			request.setAttribute("errorMessage",errorMessage );
			rd = application.getRequestDispatcher("/Login.jsp");
		} else {
			for (User utilisateur : listUser) {
				if (log.equals(utilisateur.getLogin()) && mp.equals(utilisateur.getPwd())) {
					currentUser = utilisateur;
					session.setAttribute("currentUser", currentUser);
					//rd = application.getRequestDispatcher("/bienvenue.jsp");/
					
					rd=application.getRequestDispatcher("/EnseignantController");
					break;
				}
			}
			if (currentUser == null) {
				
				errorMessage="Veuillez verifier vos parametres!!";
				request.setAttribute("errorMessage",errorMessage);
				
				rd = application.getRequestDispatcher("/Login.jsp");
			}
		}
		final String username = (currentUser.getNom()+" "+currentUser.getPrenom());
		request.setAttribute("username", username);
		rd.forward(request, response);
	}

}

