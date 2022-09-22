package JDBCUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataConnectivity {
	
	static public int insertStudent(Student s) throws SQLException, ClassNotFoundException
	{
		Connection con = Connective.getConnection(); 
		PreparedStatement stmt = con.prepareStatement("INSERT INTO StudentDB1.stud VALUES (?,?,?)");
		stmt.setInt(1, s.getRoll());
		stmt.setString(2, s.getName());
		stmt.setString(3, s.getAddress());
		
		int x = stmt.executeUpdate();
		con.close();
		return x;
	}	
}
