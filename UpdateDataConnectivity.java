package JDBCUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataConnectivity {

	static public int updateStudent1(Student s) throws SQLException, ClassNotFoundException
	{
		Connection con = Connective.getConnection(); 
		PreparedStatement stmt = con.prepareStatement("UPDATE StudentDB1.stud SET name=? where roll = ?");
		stmt.setString(1, s.getName());
		stmt.setInt(2, s.getRoll());
		
		int x = stmt.executeUpdate();
		con.close();
		return x;
	}
	
	static public int updateStudent2(Student s) throws SQLException, ClassNotFoundException
	{
		Connection con = Connective.getConnection(); 
		PreparedStatement stmt = con.prepareStatement("UPDATE StudentDB1.stud SET adress=? where roll = ?");
		stmt.setString(1, s.getAddress());
		stmt.setInt(2, s.getRoll());
		
		int x = stmt.executeUpdate();
		con.close();
		return x;
	}
}
