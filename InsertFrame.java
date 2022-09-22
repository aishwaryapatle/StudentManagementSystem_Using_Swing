package JDBCUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertFrame {

	static public void InsertFrameCode()
	{
		//Swing
		JFrame frame2 = new JFrame("Insert");
		JOptionPane pane = new JOptionPane();
		
		//Insert
		JLabel label = new JLabel("Insert Data");
		label.setBounds(260,50,150,25);
		label.setFont(new Font("Times New Roman", Font.BOLD,17));

		JLabel id = new JLabel("Roll Number");
		id.setBounds(200,100,100,25);
		
		JTextField idText = new JTextField();
		idText.setBounds(300,100,100,25);
		
		JLabel name = new JLabel("Name");
		name.setBounds(200,140,100,25);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(300,140,100,25);
		
		JLabel add = new JLabel("Address");
		add.setBounds(200,180,100,25);
		
		JTextField addText = new JTextField();
		addText.setBounds(300,180,100,25);
		
		JButton insert1 = new JButton("Insert");
		insert1.setBounds(250, 230, 100, 25);
		
		JButton back1 = new JButton("Back to Home");
		back1.setBounds(10, 345, 120, 25);
		
		insert1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student s = new Student(Integer.parseInt(idText.getText()), nameText.getText(), addText.getText());
				
				try {
					int x = InsertDataConnectivity.insertStudent(s);
					if(x>0)
					{
						pane.showMessageDialog(frame2, "Data Successfully Inserted!");
						pane.setBounds(160, 250, 100, 25);
						idText.setText(null);
						nameText.setText(null);
						addText.setText(null);	
					}
					else
					{
						pane.showMessageDialog(frame2, "Data is not Inserted!");
					}
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		
		back1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Home h = new Home();
				frame2.dispose();	
			}
		});
		frame2.setContentPane(new JLabel(new ImageIcon("D:\\Images\\img1.jpg")));
		frame2.setLayout(new FlowLayout());
		
		frame2.add(label);
		frame2.add(id);
		frame2.add(idText);
		frame2.add(name);
		frame2.add(nameText);
		frame2.add(add);
		frame2.add(addText);
		frame2.add(insert1);
		frame2.add(back1);
		
		frame2.setSize(564, 420);
		frame2.setLayout(null);
		frame2.setVisible(true);
	}			
}
