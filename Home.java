package JDBCUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Swing
		JFrame frame = new JFrame("Student Management System");	
		
		JLabel label = new JLabel("MENU");
		label.setBounds(245, 50, 100, 25);
		label.setFont(new Font("Times New Roman", Font.BOLD,17));
		
		JButton insert = new JButton("Insert");
		insert.setBounds(220, 90, 100, 25);
		
		JButton update = new JButton("Update");
		update.setBounds(220, 130, 100, 25);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(220, 170, 100, 25);
		
		JButton search = new JButton("Search");
		search.setBounds(220, 210, 100, 25);
		
		JButton show = new JButton("Show");
		show.setBounds(220, 250, 100, 25);
		
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertFrame.InsertFrameCode();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteFrame.DeleteFrameCode();
			}
		});
		
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.show();
			}
		});
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateFrame.UpdateFrameCode();
			}
		});
		
		search.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchingF.SearchFrameCode();
			}
		});
		
		
		
		frame.setContentPane(new JLabel(new ImageIcon("D:\\Images\\img1.jpg")));
		frame.setLayout(new FlowLayout());
	
		frame.add(label);
		frame.add(insert);
		frame.add(update);
		frame.add(delete);
		frame.add(search);
		frame.add(show);
		
		frame.setSize(564, 380);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		//frame.getContentPane().setBackground(Color.gray);
			
	}
}
