package JDBCUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Display {
	
	public static void show() {
	
		JFrame frame5 = new JFrame("Show");
		frame5.getContentPane().setLayout(null);
		
		JButton back5 = new JButton("Back to Home");
		back5.setBounds(10, 345, 120, 25);
		
		DefaultListModel model = new DefaultListModel();
		Statement s = null;
	
		try {
			Connection x= Connective.getConnection();
			s = x.createStatement();
			String sql = "SELECT * FROM  StudentDB1.stud";
			
			ResultSet rs = s.executeQuery(sql);
			while((rs!=null) && (rs.next())){		
				model.addElement(rs.getString("roll") + " - " + rs.getString("name")+ " - " + rs.getString("adress"));
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		back5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				Home h = new Home();
				frame5.dispose();	
			}
		});
	    
		// Label Result
		final JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(150, 150, 250, 200);
		frame5.getContentPane().add(lblResult);
	    
	    // Scroll Pane
	    JScrollPane scrollPane = new JScrollPane();
	    
	    final JList list = new JList(model);
	    list.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent evt) {
	            lblResult.setText(list.getSelectedValue().toString());
	        }
	    });
	    
	    frame5.setContentPane(new JLabel(new ImageIcon("D:\\Images\\img1.jpg")));
		frame5.setLayout(new FlowLayout());
		
	    scrollPane.setViewportView(list);
	    scrollPane.setBounds(180, 100, 200, 100);
	    frame5.getContentPane().add(scrollPane);
	    frame5.add(back5);
	    frame5.setSize(564, 420);
		frame5.setLayout(null);
		frame5.setVisible(true);

	}
}
