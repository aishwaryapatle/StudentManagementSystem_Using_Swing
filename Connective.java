package JDBCUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connective {

//	static String dbname = "StudentDB1";
//	static String url = "jdbc:mysql://localhost:3306/"+dbname;
//	static String uname = "root";
//	static String pass = "abc123";
	
	static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB1","root", "abc123");
		return con;
	}
}
