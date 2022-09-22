package JDBCUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchingF {
	
	static public void SearchFrameCode()
	{
		//Swing
		JFrame frame4 = new JFrame("Search");
		JOptionPane pane = new JOptionPane();
		
		//search
		JLabel label4 = new JLabel("Search data");
		label4.setBounds(260,50,150,25);
		label4.setFont(new Font("Times New Roman", Font.BOLD,17));

		
		JLabel searchId = new JLabel("Roll Number");
		searchId.setBounds(200,100,100,25);
		
		JTextField searchIdText = new JTextField();
		searchIdText.setBounds(300,100,100,25);
		
		JLabel searchName = new JLabel("Name");
		searchName.setBounds(200,140,100,25);
		
		JTextField searchNameText = new JTextField();
		searchNameText.setBounds(300,140,100,25);
		
		JLabel searchSal = new JLabel("Address");
		searchSal.setBounds(200,180,100,25);
		
		JTextField searchSalText = new JTextField();
		searchSalText.setBounds(300,180,100,25);
		
		JButton search = new JButton("Search");
		search.setBounds(250, 230, 100, 25);
	
		JButton back3 = new JButton("Back to Home");
		back3.setBounds(10, 345, 120, 25);
		
		searchNameText.setEditable(false);
		searchSalText.setEditable(false);
		
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection x = Connective.getConnection();
					
					PreparedStatement stmt = x.prepareStatement("SELECT * FROM StudentDB1.stud WHERE roll = ?");
					System.out.println("\nStatement created");
					stmt.setInt(1, Integer.parseInt(searchIdText.getText()));
					
					ResultSet rs = stmt.executeQuery();
						if(rs.next())
						{
							String s1 = rs.getString(2);
							String s2 = rs.getString(3);
							//Sets Records in TextFields.
							searchNameText.setText(s1);
							searchSalText.setText(s2);
						}
					} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		
		back3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Home h = new Home();
				frame4.dispose();	
			}
		});
		frame4.setContentPane(new JLabel(new ImageIcon("D:\\Images\\img1.jpg")));
		frame4.setLayout(new FlowLayout());
		
		
		frame4.add(label4);
		frame4.add(searchId);
		frame4.add(searchIdText);
		frame4.add(searchName);
		frame4.add(searchNameText);
		frame4.add(searchSal);
		frame4.add(searchSalText);
		frame4.add(search);
		frame4.add(back3);

		frame4.setSize(564, 420);
		frame4.setLayout(null);
		frame4.setVisible(true);
	}
}
