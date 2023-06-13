package tn.iit.glid22.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid22.Dao.AutorisationDao;
import tn.iit.glid22.Dao.EnseignantDao;
import tn.iit.glid22.model.Autorisation;
import tn.iit.glid22.model.Enseignant;

@WebServlet("/AutorisationController")
public class AutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutorisationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		int id = 0; // Default value or an appropriate value in case of an empty string

		if (idParam != null && !idParam.isEmpty()) {
			id = Integer.parseInt(idParam);
		}

		ServletContext application = getServletContext();
		EnseignantDao enseignantDao = new EnseignantDao();
		Enseignant enseignant = enseignantDao.findByID(id);
		application.setAttribute("currentEnseignant", enseignant);
		AutorisationDao autorisationDao = new AutorisationDao();
		List<Autorisation> listAutorisation = autorisationDao.getAllByEnseignant(id);
		application.setAttribute("listAutorisation", listAutorisation);

		int sum = 0;
		for (Autorisation autorisation : listAutorisation) {
			sum += autorisation.getNb_heure();
		}
		application.setAttribute("sum", sum);

		int anneeActuelle = LocalDate.now().getYear();
		application.setAttribute("anneeActuelle", anneeActuelle);

		// int nbr = autorisationDao.getnbHrRestante(id, anneeActuelle);
		Calendar cal = Calendar.getInstance(Locale.FRANCE);
		int weekNum = cal.get(Calendar.WEEK_OF_YEAR);
		int nbHrRestante = (52 * 4) - ((weekNum * 4)+nbr);
		application.setAttribute("nbHrRestante", nbHrRestante);

		response.sendRedirect("Autorisation.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutorisationDao autorisationDao = new AutorisationDao();

		String idParam = request.getParameter("id");
		int id = 0; // Default value or an appropriate value in case of an empty string
		LocalDate dateAutorisation = LocalDate.parse(request.getParameter("date"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int numeroSemaine = dateAutorisation.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
		int nbr = autorisationDao.getnbHr(id, numeroSemaine);
		if (idParam != null && !idParam.isEmpty()) {
			id = Integer.parseInt(idParam);
		}
		String nbHrParam = request.getParameter("nb_heure");
		int nbHr = 0; // Default value or an appropriate value in case of an empty string

		if (nbHrParam != null && !nbHrParam.isEmpty()) {
			nbHr = Integer.parseInt(nbHrParam);
		}
	
		

		EnseignantDao enseignantDao = new EnseignantDao();
		String description = request.getParameter("description"); // Get the description from the form
		Autorisation autorisation = new Autorisation(id, nbHr, description, dateAutorisation); // Use the retrieved
																									// description


		if (nbr + nbHr > 4) {
			String message = "Attention, le nombre d'heures réalisées dans cette semaine dépasse 4 heures.";
			request.setAttribute("message", message);
		} else {
			autorisationDao.Save(autorisation);
		}

		// Retrieve the updated list of enseignants
		List<Enseignant> listEnseignant = enseignantDao.getAll();
		request.setAttribute("listEnseignant", listEnseignant);

		// Redirect to the bienvenue.jsp page
		request.getRequestDispatcher("Autorisation.jsp").forward(request, response);
	}
}
