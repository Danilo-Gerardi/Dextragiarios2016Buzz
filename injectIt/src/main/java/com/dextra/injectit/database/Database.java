package com.dextra.injectit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Database() {
	}

	private static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static ResultSet execute(String sql) {
		Connection conn = getConnection();
		
		Statement s = null;
		try {
			s = conn.createStatement();
			if (s.execute(sql)) {
				return s.getResultSet();
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (s != null) {
					s.close();
				}
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static ResultSet selectName(String name) throws SQLException{
		name+="%";
	Connection conn = getConnection();
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE name LIKE ?");
	stmt.setString(1, name);
	ResultSet rs = stmt.executeQuery();
	
	conn.close();
	return rs;
	}

}
