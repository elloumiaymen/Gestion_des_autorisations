package tn.iit.glid22.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid22.Dao.UserDao;
import tn.iit.glid22.model.User;
 

/**
 * Servlet implementation class InscriptionController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Utilisateur user = new Utilisateur(request.getParameter("nom"), request.getParameter("prenom"),
//				request.getParameter("login"), request.getParameter("pwd"));
		ServletContext application = getServletContext();
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) application.getAttribute("listU");
		User user =  new User();
		user.setLogin(request.getParameter("login"));
		user.setPwd(request.getParameter("pwd"));
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		if (listUser == null)
			listUser = new ArrayList<>();
		listUser.add(user);
		application.setAttribute("listU", listUser);
		
		
		UserDao userDao = new UserDao();
		userDao.Save(user);	
		
		
		response.sendRedirect("Index.jsp");
	}

}
