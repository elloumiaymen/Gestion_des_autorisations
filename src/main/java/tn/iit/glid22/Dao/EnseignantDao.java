package tn.iit.glid22.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid22.model.Enseignant;
import tn.iit.glid22.utils.JDBCUtil;

public class EnseignantDao {

	public void Save(Enseignant enseignant) {
		String querry = "insert into enseignant values (0,'" + enseignant.getNom() + "' , '" + enseignant.getPrenom()
				+ "' , '" + enseignant.getTelephone() + "', '" + enseignant.getEmail() + "'  )";

		try {
			JDBCUtil.getStmt().executeUpdate(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(int enseignant) {
		String query = "delete from enseignant where id =" + enseignant;
		try {
			JDBCUtil.getStmt().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update(String enseignant, String nom, String prenom, String tel, String email) {
		String query = "UPDATE Enseignant SET nom = '" + nom + "', prenom = '" + prenom + "', telephone = '" + tel
				+ "', email = '" + email + "' WHERE id = '" + enseignant + "'";
		try {

			JDBCUtil.getStmt().executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Enseignant> getAll() {
		String query = "SELECT * FROM enseignant";
		List<Enseignant> resultList = new ArrayList<>();

		try {
			ResultSet rs = JDBCUtil.getStmt().executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String telephone = rs.getString(4);
				String email = rs.getString(5);

				Enseignant enseignant = new Enseignant(id, nom, prenom, telephone, email);
				resultList.add(enseignant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	public Enseignant findByID(int id) {
		String query = "select * from  enseignant where id=" + id;
		Enseignant res = null;

		try {

			ResultSet rs = JDBCUtil.getStmt().executeQuery(query);
			if (rs.next()) {
				res = new Enseignant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}
