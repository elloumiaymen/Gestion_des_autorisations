package tn.iit.glid22.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static Statement stmt;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection ctx = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEnseignant", "root", "");
			stmt = ctx.createStatement();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Statement getStmt() {
		return stmt;
	}
}
