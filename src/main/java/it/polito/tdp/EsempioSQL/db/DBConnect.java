package it.polito.tdp.EsempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class DBConnect {

	public static Connection getConnection() throws SQLException {
		String jbdcURL ="jdbc:mysql://localhost/babs?user=root&password=ac14dg!";
		return DriverManager.getConnection(jbdcURL);
	}
	
}
