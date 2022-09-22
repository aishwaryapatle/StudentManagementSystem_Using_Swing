package JDBCUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteFrame {

	static public void DeleteFrameCode()
	{
		//Swing
		JFrame frame3 = new JFrame("Delete");
		JOptionPane pane = new JOptionPane();
		
		//Delete
		JLabel label2 = new JLabel("Delete Data");
		label2.setBounds(260,80,150,25);
		label2.setFont(new Font("Times New Roman", Font.BOLD,17));

		JLabel deleteId = new JLabel("Roll Number");
		deleteId.setBounds(200,130,100,25);
		
		JTextField deleteIdText = new JTextField();
		deleteIdText.setBounds(300,130,100,25);
	
		JButton delete = new JButton("Delete");
		delete.setBounds(250, 170, 100, 25);
		
		JButton back2 = new JButton("Back to Home");
		back2.setBounds(10, 345, 120, 25);
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student s = new Student(Integer.parseInt(deleteIdText.getText()));
				
				try {
					int x = DeleteDataConnectivity.deleteStudent(s);
					if(x>0)
					{
						pane.showMessageDialog(frame3, "Data Successfully Deleted!");
						deleteIdText.setText(null);
					}
					else{
						pane.showMessageDialog(frame3, "Data is not Deleted!");
					}
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		
		back2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Home h = new Home();
				frame3.dispose();	
			}
		});
		frame3.setContentPane(new JLabel(new ImageIcon("D:\\Images\\img1.jpg")));
		frame3.setLayout(new FlowLayout());
		
		frame3.add(label2);
		frame3.add(deleteId);
		frame3.add(deleteIdText);
		frame3.add(delete);
		frame3.add(back2);
		
		frame3.setSize(564, 420);
		frame3.setLayout(null);
		frame3.setVisible(true);

	}
}
