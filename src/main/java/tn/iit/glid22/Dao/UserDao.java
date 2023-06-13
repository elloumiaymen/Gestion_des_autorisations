package tn.iit.glid22.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid22.model.User;
import tn.iit.glid22.utils.JDBCUtil;

public class UserDao {

	public void Save(User user) {
		String query = "insert into utilisateur values (0,'" + user.getNom() + "' , '" + user.getPrenom() + "' , '"
				+ user.getLogin() + "', '" + user.getPwd() + "'  )";

		try {

			JDBCUtil.getStmt().executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public void Delete(User user) {
//		 String query= "delete from  utilisateur where id ="+user.getId();			
//		 try {			 
//			 JDBCUtil.getStmt().executeUpdate(query);			 
//		 }
//		 catch(SQLException e )
//		 {
//			 e.printStackTrace();
//		 }
//		
//	}

//	public void Update(User user) {
//		 String query= "update  from  utilisateur where id ="+user.getId();
//			
//		 try {
//			 
//			 JDBCUtil.getStmt().executeUpdate(query);
//			 
//		 }
//		 catch(SQLException e )
//		 {
//			 e.printStackTrace();
//		 }
//		
//	}

	public List<User> getAll() { 
		 String query = "select * from  utilisateur ";
		 List<User> ListRes =new ArrayList<User>();
		 
		 try {			 
			ResultSet rs= JDBCUtil.getStmt().executeQuery(query);
			
		 
			while (rs.next())
			{
			 
				ListRes.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)) );
			}	
			 
		 }
		 catch(SQLException e )
		 {
			 e.printStackTrace();
		 }
		
			return ListRes;
	}

	public User findByLoginPwd(String login, String pwd) {
		String query = "select * from  utilisateur where login= '" + login + "' and pwd = '" + pwd + "'";
		User res = null;

		try {

			ResultSet rs = JDBCUtil.getStmt().executeQuery(query);
			if (rs.next()) {
				res = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;

	}

}
