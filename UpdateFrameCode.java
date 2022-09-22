package JDBCUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateFrame {

	public static void UpdateFrameCode()
	{
		//Swing
		JFrame frame5 = new JFrame("Update");
		JOptionPane pane = new JOptionPane();
		frame5.setContentPane(new JLabel(new ImageIcon("D:\\Images\\img1.jpg")));
		frame5.setLayout(new FlowLayout());
				
		//Update
		JLabel label1 = new JLabel("Update Data");
		label1.setBounds(260,50,150,25);
		label1.setFont(new Font("Times New Roman", Font.BOLD,17));
	
		JLabel updateId = new JLabel("Roll Number");
		updateId.setBounds(200,100,100,25);
		
		JTextField updateIdText = new JTextField();
		updateIdText.setBounds(300,100,100,25);
		
		JLabel comboId = new JLabel("<html>What do you<br>want to update?</html>");
		comboId.setBounds(200,140,100,27);
		frame5.add(comboId);
		
		String updateElements [] = {"Name", "Address"};
		
		final JComboBox cb = new JComboBox(updateElements);
		cb.setBounds(300,140,100,25);
		frame5.add(cb); 
		
		JButton submit = new JButton("Submit");
		submit.setBounds(250, 190, 100, 25);
		frame5.add(submit);
		
		JLabel updateName = new JLabel("Name");
		updateName.setBounds(200,230,100,25);
		updateName.setVisible(false);
		
		JTextField updateNameText = new JTextField();
		updateNameText.setBounds(300,230,100,25);
		updateNameText.setVisible(false);
		
		JLabel updateAdd = new JLabel("Address");
		updateAdd.setBounds(200,230,100,25);
		updateAdd.setVisible(false);
		
		JTextField updateAddText = new JTextField();
		updateAddText.setBounds(300,230,100,25);
		updateAddText.setVisible(false);
		
		JButton update = new JButton("Update");
		update.setBounds(250, 270, 100, 25);
		update.setVisible(false);
		
		JButton back4 = new JButton("Back to Home");
		back4.setBounds(10, 345, 120, 25);
		
		String s1 = "Name";
		String s2 = "Address";
	
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String data = (String) cb.getItemAt(cb.getSelectedIndex());
				if(data.equals(s1))
				{
					updateName.setVisible(true);
					updateNameText.setVisible(true);
					updateAdd.setVisible(false);
					updateAddText.setVisible(false);
					update.setVisible(true);
				}
				else if(data.equals(s2))
				{
					updateName.setVisible(false);
					updateNameText.setVisible(false);
					updateAdd.setVisible(true);
					updateAddText.setVisible(true);
					update.setVisible(true);
				}
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Update Statement
				String data = (String) cb.getItemAt(cb.getSelectedIndex());

				if(data.equals(s1))
				{
					Student s = new Student(Integer.parseInt(updateIdText.getText()),updateNameText.getText());
					try {
						int x = UpdateDataConnectivity.updateStudent1(s);
						if(x>0)
						{
							pane.showMessageDialog(frame5, "Data Successfully Updated!");
							pane.setBounds(160, 250, 100, 25);
							updateIdText.setText(null);
							updateNameText.setText(null);
							updateAddText.setText(null);	
						}
						else
						{
							pane.showMessageDialog(frame5, "Data is not Updated!");
						}
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(data.equals(s2))
				{
					Student s = new Student(updateAddText.getText(), Integer.parseInt(updateIdText.getText()));
					try {
						int x = UpdateDataConnectivity.updateStudent2(s);
						if(x>0)
						{
							pane.showMessageDialog(frame5, "Data Successfully Updated!");
							pane.setBounds(160, 250, 100, 25);
							updateIdText.setText(null);
							updateNameText.setText(null);
							updateAddText.setText(null);	
						}
						else
						{
							pane.showMessageDialog(frame5, "Data is not Updated!");
						}
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
		back4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Home h = new Home();
				frame5.dispose();	
			}
		});
		
		
		
		frame5.add(label1);
		frame5.add(updateId);
		frame5.add(updateIdText);
		frame5.add(updateName);
		frame5.add(updateNameText);
		frame5.add(updateAdd);
		frame5.add(updateAddText);
		frame5.add(update);
		frame5.add(back4);
		
		
		
		frame5.setSize(564, 420);
		frame5.setLayout(null);
		frame5.setVisible(true);

	}
}
