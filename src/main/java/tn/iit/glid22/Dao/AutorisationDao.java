package tn.iit.glid22.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid22.model.Autorisation;
import tn.iit.glid22.utils.JDBCUtil;

public class AutorisationDao {

	public void Save(Autorisation autorisation) {
		String query = "INSERT INTO autorisation VALUES (0, '" + autorisation.getId_enseignant() + "', '"
				+ autorisation.getNb_heure() + "', '" + autorisation.getDescription() + "','" + autorisation.getDate()
				+ "')";

		try {

			JDBCUtil.getStmt().executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Delete(Autorisation autorisation) {
		String query = "DELETE FROM autorisation WHERE id =" + autorisation.getId();
		try {
			JDBCUtil.getStmt().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update(Autorisation autorisation) {
		String query = "UPDATE autorisation SET id_enseignant = " + autorisation.getId_enseignant() + ", date = '"
				+ autorisation.getDate() + "', nb_heure = " + autorisation.getNb_heure() + ", description = '"
				+ autorisation.getDescription() + "' WHERE id =" + autorisation.getId();

		try {

			JDBCUtil.getStmt().executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Autorisation> getAll() {
		String query = "SELECT * FROM autorisation";
		List<Autorisation> listaut = new ArrayList<>();

		try {
			ResultSet reset = JDBCUtil.getStmt().executeQuery(query);
			while (reset.next()) {
				LocalDate dateAutorisation = LocalDate.parse(reset.getString(5),
						DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				listaut.add(
						new Autorisation(reset.getInt(1), reset.getInt(2), reset.getInt(3), reset.getString(4), dateAutorisation));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaut;
	}

	public List<Autorisation> getAllByEnseignant(int id_enseignant) {
		String query = "SELECT * FROM autorisation INNER JOIN enseignant ON enseignant.id=autorisation.id_enseignant WHERE enseignant.id="
				+ id_enseignant;
		List<Autorisation> listaut = new ArrayList<>();

		try {
			ResultSet reset = JDBCUtil.getStmt().executeQuery(query);
			while (reset.next()) {
				LocalDate dateAutorisation = LocalDate.parse(reset.getString(5),
						DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				listaut.add(
						new Autorisation(reset.getInt(1), reset.getInt(2), reset.getInt(3), reset.getString(4), dateAutorisation));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaut;
	}

	public int getnbHr(int id_enseignant, int weekDate) {
		String query = "SELECT SUM(nb_heure) FROM autorisation WHERE id_enseignant=" + id_enseignant
				+ " AND WEEK(date)=" + weekDate;
		int res = 0;

		try {
			ResultSet reset = JDBCUtil.getStmt().executeQuery(query);
			while (reset.next()) {
				res = reset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public int getNbHeureRestante(int id_enseignant, int year) {
		String query = "SELECT SUM(nb_heure) FROM autorisation WHERE id_enseignant=" + id_enseignant
				+ " AND YEAR(date)=" + year;
		int res = 0;

		try {
			ResultSet reset = JDBCUtil.getStmt().executeQuery(query);
			while (reset.next()) {
				res = reset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}
