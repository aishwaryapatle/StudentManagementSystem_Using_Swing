package JDBCUI;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteDataConnectivity {

	static public int deleteStudent(Student s) throws SQLException, ClassNotFoundException
	{
		Connection con = Connective.getConnection(); 
		PreparedStatement stmt = con.prepareStatement("DELETE FROM StudentDB1.stud where roll = ?");
		stmt.setInt(1, s.getRoll());
		
		int x = stmt.executeUpdate();
		con.close();
		return x;
	}
	
}
